package oop.hanoi;

public class Move
{
    private int from, to;

    public Move(int from, int to)
    {
        if (from < 0 || from > 2 || to < 0 || to > 2 || from == to)
        {
            throw new IllegalArgumentException("Invalid move from " + from + " to " + to);
        }
        this.from = from;
        this.to = to;
    }

    public int getFrom()
    {
        return from;
    }

    public int getTo()
    {
        return to;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof Move))
        {
            return false;
        }
        Move other = (Move) o;
        return this.from == other.from && this.to == other.to;
    }

    public String toString()
    {
        return from + " => " + to;
    }
}
