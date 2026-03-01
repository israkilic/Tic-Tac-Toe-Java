// Name Surname İsra Kılıç
// ID 64230065

import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        
       Scanner input=new Scanner(System.in); 
        int strategy = 1; // should be 1 or 2
        System.out.println("TicTacToe with strategy " + strategy);
        // create board
        char[][] board=createBoard();
        
        
        // actual game/turn mechanisim should be here as a loop
        while(true){
            printBoard(board);
            
            while(true){
                System.out.println("Enter row and column:");
                int row=input.nextInt();
                int col=input.nextInt();
                
                if(isValid(row-1,col-1,board)){
                    makePlayerMove(row-1,col-1,board);
                    break; //move is done so stop.
                }else{
                    System.out.println("Invalid move! Try again.");
                }
            }
            if(isWin(board)=='X'){
                printBoard(board);
                System.out.println("Congrats! You won.");
                break;//Game is over,so break the loop
            }
            if(isFull(board)){
                printBoard(board);
                System.out.println("It's tie");
                break;//Game is over so break the loop
                
            }
            System.out.println("Computer is playing...");
            makeProgramMove(board,strategy);
            
            if(isWin(board) == 'O') {
                printBoard(board);
                System.out.println("Computer wins!");
                break;
            }
            if(isFull(board)) {
                printBoard(board);
                System.out.println("Its tie !");
                break;
            }
        }
    }

    public static char[][] createBoard(){
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        return board;
    }

    public static boolean isFull(char[][] board){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '_') {
                    return false;
                            }
            }
        } 
        return true;
    }

    public static void printBoard(char[][] board){
          for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); 
        
     }
    }

    public static char isWin(char[][] board){
     if(board[0][0] != '_' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) return board[0][0];
        if(board[1][0] != '_' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) return board[1][0];
        if(board[2][0] != '_' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) return board[2][0];

       
        if(board[0][0] != '_' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) return board[0][0];
        if(board[0][1] != '_' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) return board[0][1];
        if(board[0][2] != '_' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) return board[0][2];

     
        if(board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
        if(board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];

        return '_'; 
    }
    
    public static boolean isValid(int rowIndex, int columnIndex, char[][] board){
       if(rowIndex < 0) return false;
        if(rowIndex > 2) return false;

       
        if(columnIndex < 0) return false;
        if(columnIndex > 2) return false;

        
        if(board[rowIndex][columnIndex]!= '_') {
            return false;
        }

        
        return true;
    }

    public static void makePlayerMove(int rowIndex, int columnIndex, char[][] board){

        board[rowIndex][columnIndex] = 'X';
    }

    public static void makeProgramMove(char[][] board, int strategy){
           if(strategy == 1) {
            makeRandomMove(board);
        }else{
            int winResult = makeWinMove(board);
            if(winResult == 1) {
                return; 
            }
            int blockResult = makeBlockMove(board);
            if(blockResult == 1) {
                return; 
            }

           
            makeRandomMove(board);
    }
    }
    public static int makeRandomMove(char[][] board){
        if(isFull(board)) {
        return -1;
    }
        while (true) {     
            int row = (int)(Math.random() * 3);
            int col = (int)(Math.random() * 3);

            if (isValid(row, col, board)) {
                board[row][col] = 'O';
                return 1;
    }
        }
    }
    public static int makeWinMove(char[][] board){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               
                if(board[i][j] == '_') {
                    board[i][j] = 'O';
                    
                if(isWin(board) == 'O') {
                 return 1; 
                }else {
                board[i][j] = '_';
    }
    }
          }
      }
             return -1;
     }
        
    
    public static int makeBlockMove(char[][]board){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '_') {
                     board[i][j] = 'X'; 
                    
                if(isWin(board) == 'X') {
                board[i][j] = 'O'; 
                return 1;
                 } else {
                board[i][j] = '_';
                    }
                }
            }
        }
        return -1;
    }
}
