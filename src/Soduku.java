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


    void isSolved() {







    }
    //boolean isValueValid(){}
    //boolean isRowColumnValid(){}
    //boolean isEntryCorrect(){}

}