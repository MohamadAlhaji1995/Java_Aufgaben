package oop.kakuro;

import java.util.ArrayList;
import java.util.List;

public class SumPartition
{
    public static List<int[]> computeSummands(int sum, int count)
    {
        List<int[]> results = new ArrayList<>();
        // Nur positive Summen und Anzahlen sind erlaubt
        if (sum > 0 && count > 0)
        {
            compute(sum, count, 1, new int[count], 0, results);
        }
        return results;
    }

    private static void compute(int remainingSum, int remainingCount, int start, int[] current, int index, List<int[]> results)
    {
        if (remainingCount == 0)
        {
            // Wenn keine Summanden mehr benötigt werden und die verbleibende
            // Summe 0 ist, gültige Kombination gefunden
            if (remainingSum == 0)
            {
                results.add(current.clone());
            }
            return;
        }
        if (remainingSum <= 0)
        {
            return;
        }

        // Iteriere über alle möglichen Werte für den aktuellen Summanden
        for (int i = start; i <= 9; i++)
        {
            if (remainingSum - i >= 0)
            { // Stelle sicher, dass die verbleibende Summe nicht negativ wird
                current[index] = i;
                compute(remainingSum - i, remainingCount - 1, i + 1, current, index + 1, results);
            }
        }
    }

    public static void main(String[] args)
    {
        List<int[]> result = computeSummands(10, 3);
        for (int[] arr : result)
        {
            System.out.print("Kombination: ");
            for (int num : arr)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
