package oop.wordnumerals;

import java.util.LinkedList;

public class WordNumeralFormat
{
    public static String toString(int value)
    {
        String rest = "";
        String zahl = "";

        boolean test = false;

        if (value < 0)
        {
            test = true;
            value = -value;

        }
        do
        {

            int number1 = value % 10;
            if (number1 == 0)
            {
                zahl = "null";
            }
            else if (number1 == 1)
            {
                zahl = "eins";
            }

            else if (number1 == 2)
            {
                zahl = "zwei";
            }

            else if (number1 == 3)
            {
                zahl = "drei";
            }
            else if (number1 == 4)
            {
                zahl = "vier";
            }
            else if (number1 == 5)
            {
                zahl = "fuenf";
            }
            else if (number1 == 6)
            {
                zahl = "sechs";
            }
            else if (number1 == 7)
            {
                zahl = "sieben";
            }
            else if (number1 == 8)
            {
                zahl = "acht";
            }
            else if (number1 == 9)
            {
                zahl = "neun";
            }

            if (rest != null)

            {
                rest = zahl + " " + rest;

            }
            else
            {
                rest = zahl;

            }

            value /= 10;
        }

        while (value != 0);
        // }

        if (test)
        {
            rest = "- " + rest;

        }

        rest = (String) rest.subSequence(0, rest.length() - 1);
        return rest;

    }

    public static int parse(String x)
    {
        String[] words = x.split(" ");
        int zahl = 0;
        boolean testNegativ = false;
        int num = 0;
        LinkedList<String> strtonum = new LinkedList<>();
        strtonum.add(0, "null");
        strtonum.add(1, "eins");
        strtonum.add(2, "zwei");
        strtonum.add(3, "drei");
        strtonum.add(4, "vier");
        strtonum.add(5, "fuenf");
        strtonum.add(6, "sechs");
        strtonum.add(7, "sieben");
        strtonum.add(8, "acht");
        strtonum.add(9, "neun");
        strtonum.add(10, "-");
        int number = 1;

        if (words[0].equals(strtonum.get(10)))
        {

            testNegativ = true;

        }

        for (int i = words.length - 1; i >= 0; i--)

        {

            if (words[i].equals(strtonum.get(10)) && i == 0)
            {
                return -zahl;
            }
            else if (words[i].equals(strtonum.get(0)))
            {
                num = 0 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(1)))
            {
                num = 1 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(2)))
            {
                num = 2 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(3)))
            {
                num = 3 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(4)))
            {
                num = 4 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(5)))
            {
                num = 5 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(6)))
            {
                num = 6 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(7)))
            {

                num = 7 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(8)))
            {
                num = 8 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;

            }
            else if (words[i].equals(strtonum.get(9)))
            {
                num = 9 * number;
                if (zahl + num < 0)
                {
                    throw new NumberFormatException();
                }
                zahl += num;
                number *= 10;
            }
            else
            {
                throw new NumberFormatException();
            }

        }

        return testNegativ ? zahl : zahl;

    }

    public static void main(String[] args)
    {
        System.out.println(WordNumeralFormat.toString(43));
        System.out.println(parse("null null zwei eins vier sieben vier"));

    }
}
