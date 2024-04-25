package oop.retries;

public class OverloadException extends Exception
{

    public OverloadException(String nachrichten)
    {

        super(nachrichten);

    }

    public OverloadException()
    {

        super();

    }
}