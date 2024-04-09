package oop.roman;

import java.util.HashMap;

public class RomanNumeralFormat
{

    public static String toString(int dezimal)
    {
        if (dezimal <= 0)
        {
            throw new IllegalArgumentException("Die Zahl soll Negativ sein");
        }

        String roman = "";
        while (dezimal > 0)
        {

            if (dezimal > 3999 || dezimal < 1)
            {
                throw new IllegalArgumentException("Ungültige Zahl");
            }

            if (dezimal >= 1000)
            {
                roman += "M";
                dezimal -= 1000;
            }
            else if (dezimal >= 900)
            {
                roman += "CM";
                dezimal -= 900;
            }
            else if (dezimal >= 500)
            {
                roman += "D";
                dezimal -= 500;
            }
            else if (dezimal >= 400)
            {
                roman += "CD";
                dezimal -= 400;
            }
            else if (dezimal >= 100)
            {
                roman += "C";
                dezimal -= 100;
            }
            else if (dezimal >= 90)
            {
                roman += "XC";
                dezimal -= 90;
            }
            else if (dezimal >= 50)
            {
                roman += "L";
                dezimal -= 50;
            }
            else if (dezimal >= 40)
            {
                roman += "XL";
                dezimal -= 40;
            }
            else if (dezimal >= 10)
            {
                roman += "X";
                dezimal -= 10;
            }
            else if (dezimal >= 9)
            {
                roman += "IX";
                dezimal -= 9;
            }
            else if (dezimal >= 5)
            {
                roman += "V";
                dezimal -= 5;
            }
            else if (dezimal >= 4)
            {
                roman += "IV";
                dezimal -= 4;
            }
            else if (dezimal >= 1)
            {
                roman += "I";
                dezimal -= 1;
            }

        }
        return roman;
    }

    public static int parse(String rom)
    {

        if (rom.charAt(rom.length() - 1) == 'P')
        {
            throw new NumberFormatException("nicht gültig");
        }

        if (rom.contains(" "))
        {
            throw new NumberFormatException("Leerzeichen");
        }

        if (!(rom.matches("(?<=^)M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})(?=$)")))
        {
            throw new NumberFormatException("ungültig");
        }
        HashMap<Character, Integer> number = new HashMap<>();
        int result = 0;

        number.put('I', 1);
        number.put('V', 5);
        number.put('X', 10);
        number.put('L', 50);
        number.put('C', 100);
        number.put('D', 500);
        number.put('M', 1000);

        for (int i = 0; i < rom.length() - 1; i++)
        {

            if (rom.charAt(i) == 'I' || rom.charAt(i) == 'V' || rom.charAt(i) == 'X' || rom.charAt(i) == 'L' || rom.charAt(i) == 'C' || rom.charAt(i) == 'D' || rom.charAt(i) == 'M')
            {
                if (number.get(rom.charAt(i)) >= number.get(rom.charAt(i + 1)))
                {
                    result = result + number.get(rom.charAt(i));

                }
                else
                {
                    result = result - number.get(rom.charAt(i));

                }

            }
            else
            {
                throw new NumberFormatException("ungültig");
            }

        }

        result = result + number.get(rom.charAt(rom.length() - 1));
        if (result > 3999 || result < 1)
        {
            throw new IllegalArgumentException();
        }
        return result;

    }

    public static void main(String[] args)
    {
        int dec = 41;
        System.out.println(toString(dec));
        System.out.println(parse("II"));

    }
}
