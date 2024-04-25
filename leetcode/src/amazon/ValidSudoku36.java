package amazon;

public class ValidSudoku36 {
	
    public boolean isValidSudoku(char[][] board) {
        // mark if the number has appeared in row, col and box
    	boolean[][] rows = new boolean[9][10];
    	boolean[][] cols = new boolean[9][10];
    	boolean[][] boxes = new boolean[9][10];
    	
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] == '.') continue;
    			int num = board[i][j] - '0';
    			if (rows[i][num] || cols[j][num] || boxes[i/3*3 + j/3][num]) return false;
    			rows[i][num] = true;
    			cols[j][num] = true;
    			boxes[i/3*3+j/3][num] = true;
    		}
    	}
    	return true;
    	
    }
	

	public static void main(String[] args) {
		System.out.println(new ValidSudoku36().isValidSudoku(new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}}));
		

	}

}
