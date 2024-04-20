package oop.proxy.caching;

public class Proxy implements ProxyAdminInterface, FunctionInterface
{
    private final FunctionInterface proxy;

    private double result;

    public Proxy(FunctionInterface proxy)
    {
        this.proxy = proxy;
        result = -1;
    }

    @Override
    public void clearCache()
    {
        result = -1;
    }

    @Override
    public double f(double x)
    {
        if (result == -1)
        {
            result = proxy.f(x);
            return result;
        }
        return result;

    }
}
