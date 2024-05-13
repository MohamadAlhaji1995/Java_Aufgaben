package oop.isbn;

public class Isbn
{
    public static String generateIsbn10(String input)
    {
        input = input.replaceAll("-", "");
        if (input.length() != 9)
        {
            throw new IllegalArgumentException("Input must contain exactly 9 digits after removing hyphens.");
        }

        int sum = 0;
        for (int i = 0; i < 9; i++)
        {
            int digit = Character.getNumericValue(input.charAt(i));
            sum += digit * (10 - i);
        }

        int checkDigit = 11 - (sum % 11);
        String checkDigitStr = (checkDigit == 10) ? "X" : String.valueOf(checkDigit % 11);

        return input.substring(0, 1) + "-" + input.substring(1, 4) + "-" + input.substring(4, 9) + "-" + checkDigitStr;
    }

    public static String generateIsbn13(String input)
    {
        input = input.replaceAll("-", "");
        if (input.length() != 12)
        {
            throw new IllegalArgumentException("Input must contain exactly 12 digits after removing hyphens.");
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 12; i++)
        {
            int digit = Character.getNumericValue(input.charAt(i));
            if (i % 2 == 0)
            {
                sum1 += digit; // Odd index: 0, 2, 4, ..., 10
            }
            else
            {
                sum2 += digit; // Even index: 1, 3, 5, ..., 11
            }
        }

        int total = sum1 + (sum2 * 3);
        int checkDigit = (10 - (total % 10)) % 10;

        return input.substring(0, 1) + "-" + input.substring(1, 4) + "-" + input.substring(4, 6) + "-" + input.substring(6, 12) + "-" + checkDigit;
    }

    public static void main(String[] args)
    {

        try
        {
            String isbn10 = Isbn.generateIsbn10("3-446-45118");
            System.out.println("Generated ISBN-10: " + isbn10);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        try
        {
            String isbn13 = Isbn.generateIsbn13("978-0-306-40615");
            System.out.println("Generated ISBN-13: " + isbn13);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
