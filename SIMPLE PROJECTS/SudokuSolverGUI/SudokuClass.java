import java.util.*;
public class SudokuClass{
    int[][] sudoku = new int[9][9];
    
    Scanner scn = new Scanner(System.in);
    void input(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sudoku[i][j] = scn.nextInt();
            }
        }
    }

    void show(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    SudokuClass(){};

    SudokuClass(int[][] sudoku){
        this.sudoku = sudoku;
    }
}