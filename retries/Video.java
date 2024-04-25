package oop.retries;

public class Video
{

    // Server Überlastungs Wahrscheinlichkeit
    public static final double OVERLOAD_PROBABILITY = 0.95;

    public static final int PLAY_TIME = 2; // Sekunden

    private void waitSomeTime(int seconds)
    {

        try
        {

            Thread.sleep(seconds * 1000L);

        }
        catch (InterruptedException e)
        {
        }
    }

    public void play() throws OverloadException
    {

        if (Math.random() < OVERLOAD_PROBABILITY)
        {
            // mit Wahrscheinlichkeit OVERLOAD_PROBABILITY
            // wird eine Überlast simuliert
            throw new OverloadException();
        }

        // ansonsten wird das Abspielen eines Videos simuliert
        waitSomeTime(PLAY_TIME);
    }

}