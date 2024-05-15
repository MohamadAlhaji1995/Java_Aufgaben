package oop.minesweeper;

import java.util.Arrays;

public class Game
{
    private boolean[][] mineField;

    private int[][] board;

    private boolean gameStarted;

    public Game()
    {
        this.gameStarted = false;
    }

    public void startGame(boolean[][] mines)
    {
        if (mines == null || mines.length == 0 || mines[0].length == 0)
        {
            throw new IllegalArgumentException("Invalid mine field configuration.");
        }

        int rows = mines.length;
        int cols = mines[0].length;
        this.mineField = new boolean[rows][cols];
        this.board = new int[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            if (mines[i].length != cols)
            {
                throw new IllegalArgumentException("Mine field must be rectangular.");
            }
            this.mineField[i] = Arrays.copyOf(mines[i], cols);
            Arrays.fill(this.board[i], -1);
        }

        this.gameStarted = true;
    }

    public MoveResult move(int row, int col)
    {
        if (!gameStarted)
        {
            return MoveResult.NOT_STARTED;
        }

        if (board[row][col] != -1)
        {
            return MoveResult.USELESS;
        }

        if (mineField[row][col])
        {
            for (int i = 0; i < mineField.length; i++)
            {
                for (int j = 0; j < mineField[0].length; j++)
                {
                    if (mineField[i][j])
                    {
                        board[i][j] = 9;
                    }
                }
            }
            return MoveResult.LOST;
        }
        else
        {
            uncover(row, col);
            if (checkWin())
            {
                return MoveResult.WON;
            }
            else
            {
                return MoveResult.CONTINUE;
            }
        }
    }

    private void uncover(int row, int col)
    {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != -1)
        {
            return;
        }

        int mineCount = countMines(row, col);
        board[row][col] = mineCount;

        if (mineCount == 0)
        {
            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    if (i != 0 || j != 0)
                    {
                        uncover(row + i, col + j);
                    }
                }
            }
        }
    }

    private int countMines(int row, int col)
    {
        int count = 0;
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                int newRow = row + i, newCol = col + j;
                if (newRow >= 0 && newRow < mineField.length && newCol >= 0 && newCol < mineField[0].length)
                {
                    if (mineField[newRow][newCol])
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean checkWin()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == -1 && !mineField[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getBoard()
    {
        return this.board;
    }

    public static void main(String[] args)
    {
        boolean[][] mines =
        {
            { false, false, false, false },
            { false, true, false, false },
            { false, false, false, false },
            { false, false, false, false } };

        Game game = new Game();
        game.startGame(mines);

        System.out.println("Initial Board:");
        printBoard(game.getBoard());

        // Sicherer Zug
        MoveResult result = game.move(0, 0);
        System.out.println("After move at (0,0) - Result: " + result);
        printBoard(game.getBoard());

        // Gefährlicher Zug
        result = game.move(1, 1);
        System.out.println("After move at (1,1) - Result: " + result);
        printBoard(game.getBoard());
    }

    private static void printBoard(int[][] board)
    {
        for (int[] row : board)
        {
            for (int cell : row)
            {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
