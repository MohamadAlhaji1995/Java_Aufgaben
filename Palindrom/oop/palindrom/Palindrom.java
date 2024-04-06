package oop.palindrom;

public class Palindrom
{

    public static boolean check(String str)
    {
        if (str == null)
        {
            return false;
        }

        int i = 0;
        int j = str.length() - 1;

        while (i < j)
        {

            if (str.charAt(i) != str.charAt(j))
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args)
    {
        String str1 = "plaalp";
        System.out.println(check(str1));

        String str2 = "java";
        System.out.println(check(str2));
    }
}
