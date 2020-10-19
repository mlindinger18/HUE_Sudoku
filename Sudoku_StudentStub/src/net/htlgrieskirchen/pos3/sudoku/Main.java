package net.htlgrieskirchen.pos3.sudoku;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        int[][] input = ss.readSudoku(new File("1_sudoku_level1.csv"));
        System.out.println(">--- ORIGINAL ---");
        //Array printen
        int[][] output = ss.solveSudoku(input);
        System.out.println(">--- SOLUTION ---");
        //Array printen
        System.out.println(">----------------");
        System.out.println("SOLVED    = " + ss.checkSudoku(output));
        System.out.println(">----------------");
    }
}
