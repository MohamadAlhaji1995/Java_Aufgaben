package oop.retries;

public class VideoPlayer
{

    public static void main(String[] args)
    {

        Video v = new Video();

        System.out.println("Play: " + playWithRetries(v, 5));

    }

    public static boolean playWithRetries(Video video, int maxAnz)
    {

        boolean player = false;
        int zaehler = 0;

        if (maxAnz < 0)
        {
            maxAnz = 0;
        }

        if (video == null && maxAnz > 0)
        {
            throw new NullPointerException();
        }

        if (video == null)
        {
            return false;
        }
        while (!player && zaehler < maxAnz)
        {

            System.out.println("Versuch Number: " + (zaehler + 1));

            try
            {

                video.play();

                player = true;

            }
            catch (OverloadException e)
            {

            }

            zaehler++;

        }

        return player;

    }

}