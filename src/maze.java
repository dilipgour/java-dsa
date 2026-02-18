void main() {
  // int [][] maze = new int[3][3];
    //System.out.println(countPath(2,2));
// printPath(3,3,"");

    boolean[][] maze = {
            { true,  true,  true  },
            { true, true,  true  },
            { true,  true,  true  }
    };
   boolean[][] board = new boolean[4][4];


    //printPathDig(3,3,"");
   // mazeObstacle(0,0,"",maze);
    //allPath(0,0,"",maze);

    //queens(board,0);
    nKnigts(board,0,0,4);
}

int countPath(int r,int c){
    if(r==0||c==0){
        return 1;
    }
   int left = countPath(r-1,c);
    int right = countPath(r,c-1);
    return left+right;
}

void printPath(int r,int c,String path){
    if(r==1&&c==1){
        System.out.println(path);
        return;
    }
    if(r>1) printPath(r-1,c,path+"R");
    if(c>1)printPath(r,c-1,path+"D");
}

void printPathDig(int r,int c,String path){
    if(r==1&&c==1){
        System.out.println(path);
        return;
    }
    if(r>1&&c>1) printPathDig(r-1,c-1,path+"T");
    if(r>1) printPathDig(r-1,c,path+"R");
    if(c>1)printPathDig(r,c-1,path+"D");
}

void mazeObstacle(int r,int c,String path,boolean[][] maze){
    if(r== maze.length-1&&c==maze[0].length-1){
        System.out.println(path);
        return;
    }
    if(!maze[r][c]){
        return;
    }
    if(c<maze[0].length-1&&r< maze.length-1){
     mazeObstacle(r+1, c+1, path+"T", maze);
        
    }
    if(r<maze.length-1){
        mazeObstacle(r+1,c,path+"D",maze);
    }
    if(c<maze[0].length-1){
        mazeObstacle(r,c+1,path+"R",maze);
    }

}

void allPath(int r,int c,String path,boolean[][] maze){
    if(r==maze.length-1 && c==maze[0].length-1){
        System.out.println(path);
        return ;
    }
    if(!maze[r][c]) return;

    maze[r][c]=false;
    if(c<maze.length-1){
        allPath(r,c+1,path+"R",maze);
    }
    if(r<maze.length-1){
        allPath(r+1,c,path+"D",maze);
    }
    if(c>0){
        allPath(r,c-1,path+"L",maze);
    }
    if(r>0){
        allPath(r-1,c,path+"U",maze);
    }
    maze[r][c]=true;
}


//int queens(boolean [][]board, int row){
//    if(row==board.length){
//        display(board);
//        return 1;
//    }
//
//    int count = 0;
//
//    for(int col=0;col< board.length;col++){
//        if(isSafe(board,row,col)){
//            board[row][col]=true;
//            count += queens(board,row+1);
//            board[row][col]=false;
//        }
//    }
//    return count;
//}
//
//
//boolean isSafe(boolean[][] board, int row,int col){
//    for (int i = 1; i < row; i++) {
//        if(board[i][col]){
//            return false;
//        }
//
//    }
//
//    int maxLeft = Math.min(row,col);
//
//    for (int i = 1; i <= maxLeft; i++) {
//        if(board[row-i][col-i]){
//            return false;
//        }
//
//    }
//
//    int maxRight = Math.min(row,board.length-col-1);
//
//    for (int i = 0; i <=maxRight ; i++) {
//if(board[row-i][col+i]){
//    return false;
//}
//    }
//    return true;
//}
//


void display(boolean[][] board){

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if(board[i][j]){
                System.out.printf("Q ");
            }else{
                System.out.printf("X ");
            }

        }
        System.out.println();

    }
}



void queens(boolean [][]board,int row){
    if(row==board.length){
        display(board);
        System.out.println();
        return;
    }

    for (int col = 0; col < board.length ; col++) {


        if(isSafe(board,row,col)){
            board[row][col]=true;
            queens(board,row+1);
            board[row][col]=false;
        }


    }
}

boolean isSafe(boolean[][] board,int row,int col){
    for (int i = 0; i <row ; i++) {
        if(board[i][col]){
            return false;
        }

    }


    int maxLeft = Math.min(row,col);

    for (int i = 1; i <= maxLeft; i++) {
        if(board[row-i][col-i]){
            return false;
        }

    }

    int maxRight = Math.min(row, board.length-col-1);

    for (int i = 0; i <=maxRight; i++) {
        if(board[row-i][col+i]){
            return false;
        }

    }
return true;


}

void nKnigts(boolean [][]board, int row,int col , int target){
    if(target==0){
        displayK(board);
        System.out.println(

        );
        return;
    }

    if(row== board.length-1&&col== board.length){
return;
    }

    if(col==board.length){
        nKnigts(board,row+1,0,target);
        return;
    }

    if(isSafeK(board,row,col)){
        board[row][col]=true;
        nKnigts(board,row,col+1,target-1);
        board[row][col]=false;
    }
    nKnigts(board,row,col+1,target);
}

boolean isSafeK(boolean[][] board, int row, int col) {

    if(isValid(board,row-2,col-1)){
        if(board[row-2][col-1]){
            return false;
        }
    }

    if(isValid(board,row-2,col+1)){
        if(board[row-2][col+1]){
            return false;
        }
    }

    if(isValid(board,row+2,col-1)){
        if(board[row+2][col-1]){
            return false;
        }
    }

    if(isValid(board,row+2,col+1)){
        if(board[row+2][col+1]){
            return false;
        }
    }


    if(isValid(board,row+1,col-2)){
        if(board[row+1][col-2]){
            return false;
        }
    }

    if(isValid(board,row-1,col-2)){
        if(board[row-1][col-2]){
            return false;
        }
    }

    if(isValid(board,row+1,col+2)){
        if(board[row+1][col+2]){
            return false;
        }
    }

    if(isValid(board,row-1,col+2)){
        if(board[row-1][col+2]){
            return false;
        }
    }

    return true;
}

boolean isValid(boolean[][]board,int row,int col){
    if(row>0&&row<board.length&&col>0&&col<board.length){
        return true;
    }
    return false;
}

void displayK(boolean[][] board){

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if(board[i][j]){
                System.out.printf("K ");
            }else{
                System.out.printf("X ");
            }

        }
        System.out.println();

    }
}
