package oop.interfaces.observer;

public class Zahlenbereich
{
    private final int von;

    private final int bis;

    public Zahlenbereich(int von, int bis)
    {
        this.von = von;

        this.bis = bis;

    }

    public int getVon()
    {
        return von;
    }

    public int getBis()
    {
        return bis;
    }

    public boolean istInZahlenbereich(int number)
    {
        return (number >= von && number <= bis);
    }

}
