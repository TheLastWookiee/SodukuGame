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
//Original
    /*{5, 3, 4, 0, 7, 8, 9, 1, 2},
            {6, 7, 0, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 0, 7},
            {8, 0, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 0, 3, 7, 9, 0},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 0, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 0, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}*/
    //Solved
    /*{5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}*/
    static void display() {
        //runs a for loop through the columns and rows and displays the array sudokuBoard
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
    static boolean isSolved() {
        //this function stores hash sets as integers with a unique string for the rows, columns, and block values which makes it so that there are no repeats.
        Set seen = new HashSet<>();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                int number = sudokuBoard[i][j];
                //the block code works by specifying the area/3 of the columns and rows
                    if (!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j) || !seen.add(number + " in block " + i / 3 + "-" + j / 3) || number ==0) {
                        return false;
                    }
                }
            }


        return true;
    }
//just a basic method that checks that the value is between 1 and 9
    static boolean isValueValid(int num) {
        if (num <= 9 && num >= 1) {
            return true;

        } else return false;
    }
    //checks that there is a 0 where the rows and columns are specified.
    //the values are subtracted by 1 to make it so it lines up with user input data
        static boolean isRowColumnValid(int row, int col){
            if (row <= 9 && row >= 1 && col <= 9 && col >= 1) {
                if(sudokuBoard[row-1][col-1] == 0){
                    return true;

                }

            }
            return false;
        }
        //checks if entry is correct. It checks if there are duplicates first in the rows and the columns.
        static boolean isEntryCorrect(int num, int row, int col){
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard[row-1][j] == num) {

                    return false; // Number already exists in the row
                }
            }

            // Check the column
            for (int i = 0; i < 9; i++) {
                if (sudokuBoard[i][col-1] == num) {

                    return false; // Number already exists in the column
                }
            }

            // Check the 3x3 block
            int blockStartRow = ((row - 1) / 3) * 3;
            int blockStartCol = ((col - 1) / 3) * 3;
            for (int i = blockStartRow; i < blockStartRow + 3; i++) {
                for (int j = blockStartCol; j < blockStartCol + 3; j++) {
                    if (sudokuBoard[i][j] == num) {

                        return false; // Number already exists in the block
                    }
                }
            }

            return true; // Entry is correct
        }



        }


