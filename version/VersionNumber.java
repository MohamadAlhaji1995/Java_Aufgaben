package oop.version;

public class VersionNumber
{
    public static int compare(String v1, String v2)
    {
        exptionStartWithPunkt(v1, v2);
        String[] parts1 = v1.split("\\.");
        String[] parts2 = v2.split("\\.");

        exptionLaenge0(v1, v2);

        int len = parts1.length > parts2.length ? parts2.length : parts1.length;
        for (int i = 0; i < len; i++)
        {
            exptionLeereString(parts1, parts2, i);

            if (Integer.parseInt(parts1[i]) > Integer.parseInt(parts2[i]))
            {
                return 1;
            }
            else if (Integer.parseInt(parts1[i]) < Integer.parseInt(parts2[i]))
            {
                return -1;
            }
            else
            {
                System.out.println("Stelle Number: " + i);
                continue;

            }

        }

        if (parts1.length > parts2.length)
        {
            for (int i = parts2.length; i < parts1.length; i++)
            {
                if (parts1[i].equals("0"))
                {
                    continue;
                }
                else
                {
                    return 1;
                }
            }
        }
        return parts2Enthaelt0(parts1, parts2);

    }

    private static int parts2Enthaelt0(String[] parts1, String[] parts2)
    {
        if (parts1.length < parts2.length)
        {
            for (int i = parts1.length; i < parts2.length; i++)
            {
                if (parts2[i].equals("0"))
                {
                    continue;
                }
                else
                {
                    return -1;
                }
            }
        }

        return 0;
    }

    private static void exptionLeereString(String[] parts1, String[] parts2, int i)
    {
        if (parts1[i].equals("") || parts2[i].equals("") || parts1[i].length() == 0 || parts2[i].length() == 0)
        {
            throw new NumberFormatException("String ist Leer !!!");
        }

        if (Integer.parseInt(parts1[i]) < 0 || Integer.parseInt(parts2[i]) < 0)
        {
            throw new NumberFormatException("String ist Leer !!!");
        }
    }

    private static void exptionLaenge0(String v1, String v2)
    {
        if (v1.length() == 0 || v2.length() == 0)
        {
            throw new NumberFormatException("Die leange ist 0");
        }
    }

    private static void exptionStartWithPunkt(String v1, String v2)
    {
        if (v1.startsWith(".") || v2.startsWith("."))
        {
            throw new NumberFormatException("Darf nicht mit Punkt anfangen !!!");
        }
    }

    public static void main(String[] args)
    {
        System.out.println(compare("2.3.4.0.0.0.0.1", "2.3.4"));

    }

}
