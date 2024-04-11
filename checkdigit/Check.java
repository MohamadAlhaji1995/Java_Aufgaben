package oop.checkdigit;

public class Check
{

    public static long transformToCheckedNumber(long number)
    {
        long nr = number;
        long summe = 0;
        while (nr > 0)
        {
            summe += nr % 10;
            nr = nr / 10;
        }
        double s = 2305843009213693951.0;

        if (number >= s)
        {
            throw new IllegalArgumentException("Ungültige Zahl !!");

        }
        else if (number < 0)
        {
            throw new IllegalArgumentException("!!");

        }

        long result = summe;
        if (result % 10 == 0)
        {

            return number * 10;
        }
        else
        {
            long number2 = number;
            long y = 0;
            while (true)
            {
                if (result % 10 == 0)
                {
                    break;
                }
                else
                {
                    y++;
                    result++;
                }

            }
            if ((number2 * 10) + y <= number2)
            {
                throw new IllegalArgumentException();

            }

            return (number2 * 10) + y;

        }

    }

    public static long transformToUncheckedNumber(long number)
    {
        long nr = number;
        long summe = 0;
        while (nr > 0)
        {
            summe += nr % 10;
            nr = nr / 10;
        }
        long result = summe;
        if (number >= Long.MAX_VALUE || number < 0 || result % 10 != 0)
        {
            throw new IllegalArgumentException("Ungueltige Zahl !!");

        }
        else
        {
            return number / 10;
        }

    }

    public static void main(String[] args)
    {
        System.out.println(transformToCheckedNumber(1));
        System.out.println("********************************");
        System.out.println(transformToUncheckedNumber(555555));

    }
}
