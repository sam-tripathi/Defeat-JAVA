public class Solver {

    public static boolean checkRow(SudokuClass test, int i, int j){
        for (int col=0; col<9; col++){
            if (col == j) continue;
            if(test.sudoku[i][col] == test.sudoku[i][j] && test.sudoku[i][col] != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(SudokuClass test, int i, int j){
        for (int row=0; row<9; row++){
            if (row == i) continue;
            if(test.sudoku[row][j] == test.sudoku[i][j] && test.sudoku[row][j] != 0){
                return false;
            }
        }
        return true;
    }

    public static int[] getBox(int i, int j){
        if (i == 0 || i == 1 || i == 2){
            if (j == 0 || j == 1 || j == 2){
                return new int[] {0,0};
            }
            else if(j == 3 || j == 4 || j == 5){
                return new int[] {0, 3};
            }
            else{
                return new int[] {0, 6};
            }
        }
        else if (i == 3 || i == 4 || i == 5){
            if (j == 0 || j == 1 || j == 2){
                return new int[] {3,0};
            }
            else if(j == 3 || j == 4 || j == 5){
                return new int[] {3, 3};
            }
            else{
                return new int[] {3, 6};
            }
        }else{
            if (j == 0 || j == 1 || j == 2){
                return new int[] {6,0};
            }
            else if(j == 3 || j == 4 || j == 5){
                return new int[] {6, 3};
            }
            else{
                return new int[] {6, 6};
            }
        }
    }

    public static boolean checkBox(SudokuClass test, int i, int j){
        int[] startingPt = getBox(i, j);
        for(int row = startingPt[0]; row < startingPt[0] + 3; row++){
            for(int col = startingPt[1]; col < startingPt[1] + 3; col++){
                if (row == i && col == j) continue;
                if(test.sudoku[row][col] == test.sudoku[i][j] && test.sudoku[row][col] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(SudokuClass test){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if (checkRow(test, i, j) && checkColumn(test, i, j) && checkBox(test, i, j)){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(int cell){
        if (cell >= 1 && cell <= 9) return false;
        return true;
    }
    
    public static void solve(SudokuClass test, int i, int j) {
        if (i == 8 && j == 9) {
            test.show();
            return;
        }

        if(j >= 9 && i < 8){
            solve(test, i+1,  0);
            return;
        }

        if(isEmpty(test.sudoku[i][j])){
            for(int val = 1; val <= 9; val++){
                test.sudoku[i][j] = val;
                if (checkRow(test, i, j) && checkColumn(test, i, j) && checkBox(test, i, j)) {
                    solve(test, i, j+1);
                }
                test.sudoku[i][j] = 0;
            }
        } else {
            solve(test, i, j+1);
        }
    }

    public static void updateResult(int[][] result, int[][] solution) {
    	for (int i=0; i<9; i++) {
    		for (int j=0; j<9; j++) {
    			solution[i][j] = result[i][j];
    		}
    	}
    }

    public static boolean solveAndGetFirstSolution(SudokuClass test, int i, int j, int[][] solution) { 	
    	if (i == 8 && j == 9) {
            updateResult(test.sudoku, solution);
            return true;
        }

        if(j >= 9 && i < 8){
        	if (solveAndGetFirstSolution(test, i+1,  0, solution)) {
        		return true;
        	}
            return false;
        }

        if(isEmpty(test.sudoku[i][j])){
            for(int val = 1; val <= 9; val++){
                test.sudoku[i][j] = val;
                if (checkRow(test, i, j) && checkColumn(test, i, j) && checkBox(test, i, j)) {
                    if (solveAndGetFirstSolution(test, i, j+1, solution)) {
                    	return true;
                    }
                }
                test.sudoku[i][j] = 0;
            }
        } else {
        	if (solveAndGetFirstSolution(test, i, j+1, solution)) {
        		return true;
        	}
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        new GUI();
    }
}