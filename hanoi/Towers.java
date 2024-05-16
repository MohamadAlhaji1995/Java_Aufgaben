package oop.hanoi;

import java.util.ArrayList;
import java.util.List;

public class Towers
{

    public static List<Move> computeMoves(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("Height of tower must be at least 1.");
        }
        List<Move> moves = new ArrayList<>();
        moveTower(n, 0, 2, 1, moves);
        return moves;
    }

    private static void moveTower(int n, int from, int to, int aux, List<Move> moves)
    {
        if (n == 1)
        {
            moves.add(new Move(from, to));
        }
        else
        {
            moveTower(n - 1, from, aux, to, moves);
            moves.add(new Move(from, to));
            moveTower(n - 1, aux, to, from, moves);
        }
    }

    public static void main(String[] args)
    {
        // Beispielaufrufe
        List<Move> movesForOneDisk = computeMoves(1);
        System.out.println("Moves for 1 disk: " + movesForOneDisk);

        List<Move> movesForTwoDisks = computeMoves(2);
        System.out.println("Moves for 2 disks: " + movesForTwoDisks);

        List<Move> movesForThreeDisks = computeMoves(3);
        System.out.println("Moves for 3 disks: " + movesForThreeDisks);
    }
}
