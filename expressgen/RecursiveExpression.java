package oop.expressgen;

public class RecursiveExpression
{

    public static String generateExpression(int n)
    {
        // Rekursionsanker für die Basisfälle
        if (n == 0)
            return "0";
        if (n == 1)
            return "1";
        if (n == 2)
            return "2";

        // Behandlung negativer Zahlen
        if (n < 0)
        {
            return "-" + generateExpression(-n);
        }

        // Rekursionslogik für positive Zahlen
        if (n % 2 == 0)
        {
            // Gerade Zahl: Multiplikation mit 2
            return "2 * " + generateExpression(n / 2);
        }
        else
        {
            // Ungerade Zahl: Multiplikation mit 2 und Addition von 1
            return "(" + generateExpression(n - 1) + " + 1)";
        }
    }

    public static void main(String[] args)
    {
        // Einige Testausgaben
        System.out.println("generateExpression(0) => " + generateExpression(0));
        System.out.println("generateExpression(1) => " + generateExpression(1));
        System.out.println("generateExpression(2) => " + generateExpression(2));
        System.out.println("generateExpression(3) => " + generateExpression(3));
        System.out.println("generateExpression(4) => " + generateExpression(4));
        System.out.println("generateExpression(5) => " + generateExpression(5));
        System.out.println("generateExpression(6) => " + generateExpression(6));
        System.out.println("generateExpression(7) => " + generateExpression(7));
        System.out.println("generateExpression(8) => " + generateExpression(8));
        System.out.println("generateExpression(9) => " + generateExpression(9));
        System.out.println("generateExpression(10) => " + generateExpression(10));
        System.out.println("generateExpression(11) => " + generateExpression(11));
        System.out.println("generateExpression(12) => " + generateExpression(12));
        System.out.println("generateExpression(-22) => " + generateExpression(-22));
        System.out.println("generateExpression(-21) => " + generateExpression(-21));
    }
}
