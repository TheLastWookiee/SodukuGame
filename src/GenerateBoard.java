import java.util.Random;
import java.lang.*;

public class GenerateBoard {
    /**
     * Got this soduku generator from geeksforgeeks and fitted it to my code
     * https://www.geeksforgeeks.org/program-sudoku-generator/
     */
    // Size of puzzle
    private static int N;


    int SRN;
    // Amount of digits to remove
    private static int K;

    GenerateBoard(int N, int K) {
        this.N = N;
        this.K = K;

        // Compute square root of N
        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();

        Sudoku.sudokuBoard = new int[N][N];
    }
    public void fillValues(){
        fillDiagonal();
        fillRemaining(0,SRN);
        removeKDigits();

    }
    void fillDiagonal(){
        for(int i =0;i<N; i=i+SRN){
            fillBox(i,i);
        }
    }
    boolean unUsedInBox(int rowStart, int colStart, int num)
    {
        for (int i = 0; i<SRN; i++)
            for (int j = 0; j<SRN; j++)
                if (Sudoku.sudokuBoard[rowStart+i][colStart+j]==num)
                    return false;

        return true;
    }
    void fillBox(int row,int col)
    {
        int num;
        for (int i=0; i<SRN; i++)
        {
            for (int j=0; j<SRN; j++)
            {
                do
                {
                    num = randomGenerator(N);
                }
                while (!unUsedInBox(row, col, num));

                Sudoku.sudokuBoard[row+i][col+j] = num;
            }
        }
    }
    int randomGenerator(int num)
    {
        return (int) Math.floor((Math.random()*num+1));
    }
    boolean CheckIfSafe(int i,int j,int num)
    {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i-i%SRN, j-j%SRN, num));
    }

    // check in the row for existence
    boolean unUsedInRow(int i,int num)
    {
        for (int j = 0; j<N; j++)
            if (Sudoku.sudokuBoard[i][j] == num)
                return false;
        return true;
    }

    // check in the row for existence
    boolean unUsedInCol(int j,int num)
    {
        for (int i = 0; i<N; i++)
            if (Sudoku.sudokuBoard[i][j] == num)
                return false;
        return true;
    }

    // A recursive function to fill remaining
    // matrix
    boolean fillRemaining(int i, int j)
    {
        //  System.out.println(i+" "+j);
        if (j>=N && i<N-1)
        {
            i = i + 1;
            j = 0;
        }
        if (i>=N && j>=N)
            return true;

        if (i < SRN)
        {
            if (j < SRN)
                j = SRN;
        }
        else if (i < N-SRN)
        {
            if (j==(int)(i/SRN)*SRN)
                j =  j + SRN;
        }
        else
        {
            if (j == N-SRN)
            {
                i = i + 1;
                j = 0;
                if (i>=N)
                    return true;
            }
        }

        for (int num = 1; num<=N; num++)
        {
            if (CheckIfSafe(i, j, num))
            {
                Sudoku.sudokuBoard[i][j] = num;
                if (fillRemaining(i, j+1))
                    return true;

                Sudoku.sudokuBoard[i][j] = 0;
            }
        }
        return false;
    }

    // Remove the K no. of digits to
    // complete game
    public void removeKDigits()
    {
        int count = K;
        while (count != 0)
        {
            int cellId = randomGenerator(N*N)-1;

            // System.out.println(cellId);
            // extract coordinates i  and j
            int i = (cellId/N);
            int j = cellId%N;
            if (j != 0)
                j = j - 1;

            // System.out.println(i+" "+j);
            if (Sudoku.sudokuBoard[i][j] != 0)
            {
                count--;
                Sudoku.sudokuBoard[i][j] = 0;
            }
        }
    }
}

