package net.htlgrieskirchen.pos3.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/* Please enter here an answer to task four between the tags:
 * <answerTask4>
 *    Hier sollte die Antwort auf die Aufgabe 4 stehen.
 * </answerTask4>
 */
public class SudokuSolver implements ISodukoSolver {

    public SudokuSolver() {
        //initialize if necessary
    }

    @Override
    public final int[][] readSudoku(File file) {
        int[][] arr = new int[0][0];
        try {
            arr = Files.lines(file.toPath())
                    .map(s -> s.split(";"))
                    .map(s -> new int[]{Integer.parseInt(s[0]),
                Integer.parseInt(s[1]),
                Integer.parseInt(s[2]),
                Integer.parseInt(s[3]),
                Integer.parseInt(s[4]),
                Integer.parseInt(s[5]),
                Integer.parseInt(s[6]),
                Integer.parseInt(s[7]),
                Integer.parseInt(s[8])})
                    .toArray(value -> new int[9][9]);

        } catch (IOException e) {
            System.out.println("Exception gefangen");
        }
        return arr;
    }

    @Override
    public boolean checkSudoku(int[][] rawSudoku) {
        boolean var = true;
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    if (rawSudoku[i][j] == rawSudoku[i][j + 1]) {
                        var = false;
                    }

                }

            }
            for (int i2 = 0; i2 < 9; i2++) {
                for (int j2 = 0; j2 < 8; j2++) {
                    if (rawSudoku[j2][i2] == rawSudoku[j2 + 1][i2]) {
                        var = false;
                    }

                }

            }
            for (int i3 = 0; i3 < 9; i3 += 3) {
                for (int j3 = 0; j3 < 9; j3 += 3) {
                    for (int pos = 0; pos < 8; pos++) {
                        for (int pos2 = pos + 1; pos2 < 9; pos2++) {
                            if (rawSudoku[i3 + pos % 3][j3 + pos / 3] == rawSudoku[i3 + pos2 % 3][j3 + pos2 / 3]) {
                                var = false;
                            }
                        }
                    }
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Exception gefangen");
        }
        return var;
    }

    @Override
    public int[][] solveSudoku(int[][] rawSudoku) {
        return null;

    }

    @Override
    public int[][] solveSudokuParallel(int[][] rawSudoku) {
        return null;
        // implement this method

    }

    public long benchmark(int[][] rawSudoku) {
        for (int i = 0; i <= 10; i++) {
            readSudoku(new File("1_sudoku_level1.csv"));
            checkSudoku(rawSudoku);
            solveSudoku(rawSudoku);
        }
        long ds_zeit = System.currentTimeMillis() / 10;
        return ds_zeit;
    }
    /*
    public long benchmarkParallel(int[][] rawSudoku) {

    }
     */
}
