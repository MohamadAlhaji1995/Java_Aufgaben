package oop.numbers;

public class QuestionMachine
{
    public static int findNumber(int low, int high, AnswerMachine machine)
    {
        if (low > high)
        {
            throw new IllegalArgumentException("Der untere Grenzwert muss kleiner oder gleich dem oberen Grenzwert sein.");
        }
        if (machine == null)
        {
            throw new IllegalArgumentException("AnswerMachine darf nicht null sein.");
        }

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            GuessResult result = machine.guessNumber(mid);
            switch (result)
            {
                case HIT:
                    return mid;
                case TOO_LOW:
                    low = mid + 1;
                    break;
                case TOO_HIGH:
                    high = mid - 1;
                    break;
                case NO_ANSWER:
                    return Integer.MIN_VALUE; // Rückgabe eines Werts außerhalb
                                              // des Bereichs
            }
        }

        return Integer.MIN_VALUE; // Keine Zahl gefunden
    }

    public static void main(String[] args)
    {
        // Festlegen der Zahl, die "erraten" werden soll
        int targetNumber = 42;
        // Erstellen einer instanziierten AnswerMachine
        AnswerMachine testMachine = new AnswerMachine()
        {
            @Override
            public GuessResult guessNumber(int number)
            {
                if (number == targetNumber)
                {
                    return GuessResult.HIT;
                }
                else if (number < targetNumber)
                {
                    return GuessResult.TOO_LOW;
                }
                else
                {
                    return GuessResult.TOO_HIGH;
                }
            }
        };

        // Versuch, die Zahl zu erraten
        int low = 1;
        int high = 100;
        try
        {
            int foundNumber = QuestionMachine.findNumber(low, high, testMachine);
            if (foundNumber != Integer.MIN_VALUE)
            {
                System.out.println("Die erratene Zahl ist: " + foundNumber);
            }
            else
            {
                System.out.println("Keine gültige Antwort erhalten oder Bereich erschöpft.");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Ungültige Parameter: " + e.getMessage());
        }
    }
}
