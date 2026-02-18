
void main(){
    int[][] board = {
            {0,0,0,4,0,3,0,0,0},
            {4,0,0,5,7,6,3,0,0},
            {5,0,0,0,1,0,0,7,0},
            {0,0,0,0,0,0,9,0,0},
            {0,1,0,0,0,0,6,0,8},
            {0,7,0,2,0,0,0,0,1},
            {0,0,0,0,6,0,0,0,0},
            {3,8,9,0,0,0,4,0,0},
            {0,0,0,0,0,8,0,9,0}
    };
long start  = System.nanoTime();

    if(sudoku(board)) display(board);

    long end = System.nanoTime();
    double timeMs = (end - start) / 1_000_000.0;


    System.out.println(timeMs);
}

void display(int[][] board){
    for (int i = 0; i <board.length ; i++) {
        for (int j = 0; j < board.length ; j++) {
            System.out.printf(board[i][j]+" ");

        }
        System.out.println();

    }
}

boolean sudoku(int[][] board){
    int row=-1;
    int col=-1;

    boolean emptyLeft = false;

    for (int i = 0; i <board.length; i++) {
        for (int j = 0; j < board.length; j++) {
            if(board[i][j]==0){
                row = i;
                col = j;
                emptyLeft = true;
            }
        }
        if(emptyLeft){
           break;
        }
    }

    if(!emptyLeft) return true;

    for (int i = 1; i < 10; i++) {
        if(isSafe(board,row,col,i)) {
            board[row][col] = i;
            if (sudoku(board)) {
                return true;
            } else {
                board[row][col] = 0;

            }

        }

    }


    return false;


}

boolean isSafe(int[][] board, int row, int col,int n){
    for (int i = 0; i < board.length; i++) {
        if(board[row][i]==n) {
            return  false;
        }

    }

    for (int i = 0; i < board.length; i++) {
        if(board[i][col]==n) {
            return  false;
        }

    }
    int rowStart = row - row%3;
    int colStart = col - col%3;

    for (int i = rowStart; i <rowStart+3 ; i++) {
        for (int j = colStart; j <colStart+3 ; j++) {
            if(board[row][col]==n){
                return false;
            }

        }
    }

    return true;

}