package oop.interfaces.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable
{
    private int value;

    private final List<ZahlenbereichObserver> observers;

    public Observable(int initialValue)
    {
        value = initialValue;
        observers = new ArrayList<ZahlenbereichObserver>();
    }

    public Observable()
    {
        this(0);
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        if (this.value != value)
        {
            int oldValue = this.value;
            int newValue = value;
            this.value = value;
            for (ZahlenbereichObserver obs : observers)
            {
                if (obs.getZb().istInZahlenbereich(newValue))
                {
                    obs.getCo().valueHasChanged(oldValue, newValue);
                }
            }
        }
    }

    public void addChangeObserver(ChangeObserver obs, int von, int bis)
    {
        if (obs == null || von > bis)
        {
            throw new IllegalArgumentException();

        }
        for (ZahlenbereichObserver in : observers)
        {
            if (obs == in.getCo())
            {
                if (in.equalZahlenbereich(von, bis))
                {
                    return;
                }
                else
                {
                    ZahlenbereichObserver o = new ZahlenbereichObserver(obs, von, bis);
                    this.observers.add(o);
                    return;
                }
            }
        }
        ZahlenbereichObserver l = new ZahlenbereichObserver(obs, von, bis);
        this.observers.add(l);
        return;
    }

    public void removeChangeObserver(ChangeObserver obs, int von, int bis)
    {
        for (ZahlenbereichObserver in : observers)
        {
            if (in.getCo() == obs)
            {
                if (in.equalZahlenbereich(von, bis))
                {
                    observers.remove(in);
                    return;
                }

            }
        }
    }

}
