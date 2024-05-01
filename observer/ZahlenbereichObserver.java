package oop.interfaces.observer;

public class ZahlenbereichObserver
{
    private final ChangeObserver co;

    private Zahlenbereich zb;

    public ZahlenbereichObserver(ChangeObserver co)
    {
        this.co = co;
    }

    public ZahlenbereichObserver(ChangeObserver co, int von, int bis)
    {
        this.co = co;
        this.zb = new Zahlenbereich(von, bis);
    }

    public void setZahlenbereich(int von, int bis)
    {
        Zahlenbereich vb = new Zahlenbereich(von, bis);
        this.zb = vb;
    }

    public boolean istInZahlenbereich(int number)
    {
        return this.zb.istInZahlenbereich(number);
    }

    public boolean equalZahlenbereich(int von, int bis)
    {
        return (zb.getVon() == von && zb.getBis() == bis);
    }

    public ChangeObserver getCo()
    {
        return co;
    }

    public Zahlenbereich getZb()
    {
        return zb;
    }

    public int getVon()
    {
        return this.zb.getVon();
    }

    public int getBis()
    {
        return this.zb.getBis();
    }

}
