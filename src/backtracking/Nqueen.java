package backtracking;

public class Nqueen {

	static final int N=4;
	
	public static void main(String[] args) {
		Nqueen q = new Nqueen();
		int[][] board = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(q.solveNq(board,0) == true) {
			printSolvedNq(board);
		}else {
			System.out.println("This NQ can't be solved");
		}
			
	}

	private boolean solveNq(int[][] board, int col) {
		if(col >= N) {
			return true;
		}
		
		// check the row for given col
		for(int i=0;i<N;i++) {
			if(isSafe(board, i, col)) {
				board[i][col]=1;
				if(solveNq(board, col+1)== true) {
					return true;
				}
				board[i][col]=0;
			}
		}
		return false;
	}

	private static void printSolvedNq(int[][] board) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private boolean isSafe(int[][] board, int row, int col) {
		// taking from column wise so no need to check for  same column
		
		//1. check for same row left side only
		for(int i = 0 ; i<col;i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		//2. left side upper diagonal
		for(int i=row, j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		//3. left side lower diagonal
		for(int i=row, j=col; j>=0 && i<N;j--,i++) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}

}
