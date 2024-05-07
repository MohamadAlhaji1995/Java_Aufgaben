package oop.caesar;

public class Encryption
{
    public static String encode(String text, int key)
    {
        // Umwandeln des Strings in Kleinbuchstaben
        text = text.toLowerCase();

        // Modulo 26 des Schlüssels, um die Rotation zu normalisieren
        key = key % 26;
        if (key < 0)
        {
            key += 26; // Negative Schlüssel werden zu positiven äquivalenten
                       // Schlüsseln
        }

        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray())
        {
            if (c >= 'a' && c <= 'z')
            {
                // Verschiebung des Buchstabens innerhalb der Grenzen von 'a'
                // bis 'z'
                int shifted = (c - 'a' + key) % 26;
                encrypted.append((char) ('a' + shifted));
            }
            else
            {
                // Nicht-Buchstaben-Zeichen unverändert lassen
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args)
    {
        // Beispiel für die Nutzung der encode-Methode
        String result = encode("Mohamad", 2);
        System.out.println(result); 
    }

}
