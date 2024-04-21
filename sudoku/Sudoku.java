package oop.sudoku;

public class Sudoku
{
    public static int[][] GRID_TO_SOLVE;

    private final int[][] boord;

    public static final int EMPTY = 0;

    public static final int SIZE = 9;

    public Sudoku(int[][] boord)
    {

        this.boord = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                this.boord[i][j] = boord[i][j];
            }
        }
    }

    private boolean isInRow(int row, int numbr)
    {

        for (int i = 0; i < SIZE; i++)
        {
            if (boord[row][i] == numbr)
            {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int number)
    {

        for (int i = 0; i < SIZE; i++)
        {
            if (boord[i][col] == number)
            {
                return true;
            }

        }
        return false;
    }

    private boolean isInBox(int row, int col, int number)
    {

        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++)
        {
            for (int j = c; j < c + 3; j++)
            {
                if (boord[i][j] == number)
                {
                    return true;
                }

            }

        }
        return false;

    }

    private boolean isOk(int row, int col, int number)
    {

        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }

    public boolean solve()
    {

        for (int row = 0; row < SIZE; row++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                if (boord[row][col] == EMPTY)
                {
                    for (int number = 1; number <= SIZE; number++)
                    {
                        if (isOk(row, col, number))
                        {
                            boord[row][col] = number;
                            if (solve())
                            {
                                return true;
                            }
                            else
                            {
                                boord[row][col] = EMPTY;

                            }
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display()
    {

        for (int i = 0; i < SIZE; i++)
        {

            for (int j = 0; j < SIZE; j++)
            {
                System.out.print("|" + boord[i][j]);

            }
            System.out.println("|");
        }
        System.out.println("____________________");
    }

    public static void main(String[] args)
    {
        int[][] GRID_TO_SOLVE =
        {
            { 9, 0, 0, 1, 0, 0, 0, 0, 5 },
            { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
            { 8, 0, 0, 0, 4, 0, 0, 0, 0 },
            { 0, 0, 5, 0, 9, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 8, 0, 0, 0, 0 },
            { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 2, 6, 0, 0, 9 },
            { 2, 0, 0, 3, 0, 0, 0, 0, 6 },
            { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };
        ;

        Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
        System.out.println("Sudoku ");
        sudoku.display();
        if (sudoku.solve())
        {
            System.out.println("Die Lösung ist:");
            sudoku.display();
        }

        else
        {
            System.out.println("Fehler hat kein lösung");
        }
    }

}
