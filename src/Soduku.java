import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Soduku {
    static int[][] sudokuBoard = {
            {5, 3, 4, 0, 7, 8, 9, 1, 2},
            {6, 7, 0, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 0, 7},
            {8, 0, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 0, 3, 7, 9, 0},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 0, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 0, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    static void display() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuBoard[i][j] + " ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }

            System.out.print("\n");
            if (i == 2 || i == 5) {
                System.out.print("------+-------+------" + "\n");
            }
        }
    }

    //I have done the validSoduku leetcode problem before so I pretty much did the same thing here, there can not be multiple integers in a set so this is a easy way of checking for duplicates
    boolean isSolved() {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> block = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = sudokuBoard[i][j];
                if (num != 0) {
                    if (!row.add(sudokuBoard[i][j]) || !col.add(sudokuBoard[i][j])) {
                        return false;
                    }
                    if (!block.add(sudokuBoard[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3])) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    static boolean isValueValid(int num) {
        if (num <= 9 && num >= 1) {
            return true;

        } else return false;
    }
        boolean isRowColumnValid(int row, int col, int[][] sod){
            if (row <= 9 && row >= 1 && col <= 9 && col >= 1) {
                if(sod[row][col] == 0){
                    return true;

                }

            }
            return false;
        }
        boolean isEntryCorrect(int num, int[][] sod, int row, int col){
            for (int j = 0; j < 9; j++) {
                if (sod[row][j] == num) {
                    return false; // Number already exists in the row
                }
            }

            // Check the column
            for (int i = 0; i < 9; i++) {
                if (sod[i][col] == num) {
                    return false; // Number already exists in the column
                }
            }

            // Check the 3x3 block
            int blockStartRow = (row / 3) * 3;
            int blockStartCol = (col / 3) * 3;
            for (int i = blockStartRow; i < blockStartRow + 3; i++) {
                for (int j = blockStartCol; j < blockStartCol + 3; j++) {
                    if (sod[i][j] == num) {
                        return false; // Number already exists in the block
                    }
                }
            }

            return true; // Entry is correct
        }

        }


