package oop.matrix;

import java.util.Arrays;

public class Operation
{

    public static int[][] transpose(int[][] matr)
    {

        exception(matr);
        int laenge = matr[0].length;
        for (int i = 1; i < matr.length; i++)
        {
            exception1(matr, laenge, i);
        }
        int[][] resultMt = new int[matr[0].length][matr.length];
        for (int zeile = 0; zeile < matr.length; zeile++)
        {

            for (int spalte = 0; spalte < matr[0].length; spalte++)
            {

                resultMt[spalte][zeile] = matr[zeile][spalte];
            }

        }
        return resultMt;

    }

    private static void exception1(int[][] matr, int laenge, int i)
    {
        if (matr[i].length != laenge)
        {
            throw new IllegalArgumentException("Ungueltige Matrix");
        }
        else if (matr.equals(null))
        {
            throw new IllegalArgumentException("Ungueltige Matrix");

        }
        else if (matr[i].length == 0)
        {
            throw new IllegalArgumentException("Ungueltige Matrix");

        }
        else if (matr[i].equals(null))
        {
            throw new IllegalArgumentException("Ungueltige Matrix");

        }

        else
        {
            return;
        }
    }

    public static int[][] rotateClockwise(int[][] matr)
    {
        if (matr == null || matr.length == 0)
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < matr.length; i++)
        {
            if (matr[i] == null || matr[i].length == 0)
            {
                throw new IllegalArgumentException();
            }
            int k = 0;
            while (k < matr.length - 1)
            {
                if (matr[k].length != matr[k + 1].length)
                {
                    throw new IllegalArgumentException();
                }
                k++;
            }
        }
        int[][] resultMr = new int[matr[0].length][matr.length];
        int laenge = matr.length - 1;

        for (int i = 0; i < matr.length; i++, laenge--)
        {

            for (int j = 0; j < matr[i].length; j++)
            {
                resultMr[j][laenge] = matr[i][j];
            }
        }
        return resultMr;
    }

    public static int[][] rotateCounterClockwise(int[][] matr)
    {
        exception(matr);
        int laenge = matr[0].length;
        for (int i = 1; i < matr.length; i++)
        {
            exception1(matr, laenge, i);
        }
        int[][] resultMl = new int[matr[0].length][matr.length];

        for (int i = 0; i < resultMl.length; i++)
        {
            for (int j = 0; j < resultMl[0].length; j++)
            {
                resultMl[i][j] = matr[j][matr[j].length - i - 1];
            }
        }

        return resultMl;

    }

    private static void exception(int[][] matr)
    {
        if (matr == null)
        {
            throw new IllegalArgumentException("Ungueltige Matrix");
        }
        else if (matr.length == 0)
        {
            throw new IllegalArgumentException("Ungueltige Matrix");

        }
        else if (Arrays.stream(matr).anyMatch(i -> i == null))
        {
            throw new IllegalArgumentException("Ungueltige Matrix");

        }
    }

    public static void main(String[] args)
    {

        int matrix[][] =
        {
            { 1, 2, 3, 4, 5 },
            { 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15 } };
        int[][] ergenbiss = transpose(matrix);
        for (int i = 0; i < ergenbiss.length; i++)
        {
            for (int j = 0; j < ergenbiss[i].length; j++)
            {
                System.out.print(ergenbiss[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**********************");
        int[][] ergenbis = rotateClockwise(matrix);
        for (int i = 0; i < ergenbis.length; i++)
        {
            for (int j = 0; j < ergenbis[i].length; j++)
            {
                System.out.print(ergenbis[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**********************");
        int[][] ergenbi = rotateCounterClockwise(matrix);
        for (int i = 0; i < ergenbi.length; i++)
        {
            for (int j = 0; j < ergenbi[i].length; j++)
            {
                System.out.print(ergenbi[i][j] + " ");
            }
            System.out.println();
        }
    }
}
