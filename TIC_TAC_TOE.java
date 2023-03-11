package Java_Projects.TicTacToe;
import java.util.*;
public class TIC_TAC_TOE {
    private  static String [][] Board;
    private static String player1_Symbol;
    private static String player2_Symbol;
    private static String player1_name;
    private static String player2_name;
    private static String player;
    private static Scanner sc;

// Constructor which intializes the board
    public TIC_TAC_TOE(){
        sc=new Scanner(System.in);
        Board=new String [][]{{"-","-","-"},{"-","-","-"},{"-","-","-"}};
        System.out.println("enter player1 name");
        player1_name=sc.next();
        System.out.println("enter player2 name");
        player2_name=sc.next();
    }

// This function will print the board
    private static void PrintBoard(){
        for(String[] row :Board){
            System.out.println("-------");
            System.out.print("|");
            for(String row_elements:row){
                System.out.print(row_elements+"|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

// symbolSelection for players;
    private static void symbolSelection(){
        System.out.println("Enter player1 Symbol(\"X\",\"O\")");
        player1_Symbol=sc.next();
        while(true){
            if (player1_Symbol.equals("X") || player1_Symbol.equals("O")){
               break;
            }
            else{
                System.out.println("enter either X or O");
                player1_Symbol=sc.next();
            }
        }
        if(player1_Symbol=="X"){
            player2_Symbol="O";
        }
        else{
            player2_Symbol="X";
        }
    }
// start of the game
    private static void startTheGame(){
        System.out.println("Who wants to play first \"X\" or\"O\" ");
        String chance=sc.next();
        String input;
        // knowing who wants to play first
        if(chance.equals("X")){
             input="X";
        }
        else{
            input="O";
        }
        if(input==player1_Symbol){
            player=player1_name;
        }
        else{
            player=player2_name;
        }
        System.out.println("Enter the postions where you want to insert your Symbol (Like 2 2,0 1,e.t.c)");
        int places=0;
        while(places<9){
            //verifying the positions
            int row,col;
            while(true){
                System.out.println("its your turn :"+player);
                row=sc.nextInt();
                col=sc.nextInt();
                try{
                    if((row<0 || row >2) || (col<0 || col>2) || (Board[row][col]!="-") || (Board[row][col]=="X") || (Board[row][col]=="O")){
                        System.out.println("Please enter valid position");
                    }
                    else{
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println("enter only valid integer format only");
                }
            }

            // assigning the value
            if(input.equals("X")){
                    Board[row][col]="x";
                    places++;
                    input="O";
            }
            else{
                Board[row][col]="O";
                places++;
                input="X";
            }

            //changing player name
            if(player==player1_name){
                player=player2_name;
            }
            else{
                player=player1_name;
            }

            PrintBoard();
            if(ValidateBoard()){
                Winner(input);
                return;
            } 
        }
        System.out.println("its a tie");
    }

// finding who won the game
    private static void Winner(String input){
       
        if(player1_Symbol.equals(input)){
            System.out.println("Game over ."+player2_name+" won the game" );
        }
        else{
            System.out.println("Game over ."+player1_name+"player1 won the game" );
        }
    }
// validating if there is a winner.
    private static boolean ValidateBoard() {
        // upper row
        if (Board[0][0]==Board[0][1] && Board[0][1]==Board[0][2] && Board[0][0]!="-"){
            return true;
        }
        //left cross 
        else if (Board[0][0]==Board[1][1] && Board[1][1]==Board[2][2] && Board[0][0]!="-"){
            return true;
        }
        //left column
        else if (Board[0][0]==Board[1][0] && Board[1][0]==Board[2][0] && Board[0][0]!="-"){
            return true;
        }
        //right column
        else if (Board[0][2]==Board[1][2] && Board[1][2]==Board[2][2] && Board[0][2]!="-"){
            return true;
        }
        //bottom row
        else if (Board[2][0]==Board[2][1] && Board[2][1]==Board[2][2] && Board[2][0]!="-"){
            return true;
        }
        //right cross
        else if(Board[0][2]==Board[1][1] && Board[1][1]==Board[2][0] && Board[2][0]!="-"){
            return true;
        }
        else{
            return false;
        }
    }

    //The main Function
    public static void main(String[] args) {
        new TIC_TAC_TOE();
        symbolSelection();
        startTheGame();
    }
    
}
