package oop.proxy.caching;

public class FunctionImplementation implements FunctionInterface, FunctionAdminInterface
{
    double[] coefficients;

    @Override
    public void setCoefficients(double[] coefficients)
    {
        if (coefficients == null || coefficients.length == 0)
        {
            f(0);
        }
        else
        {
            this.coefficients = coefficients.clone();
        }
    }

    @Override
    public double[] getCoefficients()
    {
        if (coefficients == null)
        {
            return new double[0];
        }
        return coefficients.clone();
    }

    private double hn(double coefficients[], double x, int y)
    {
        double hoher;
        if (y > 0)
        {
            hoher = hn(coefficients, x, y - 1);
        }
        else
        {
            return coefficients[y];
        }

        return hoher * x + coefficients[y];
    }

    @Override
    public double f(double x)
    {
        if (coefficients == null)
        {
            return 0;
        }
        double res = 0;
        for (int i = 0; i < coefficients.length; i++)
        {
            res += coefficients[i] * Math.pow(x, coefficients.length - (i + 1));
        }
        return res;
    }

    public static void main(String[] args)
    {
        FunctionImplementation obj = new FunctionImplementation();
        obj.setCoefficients(new double[]
        { 2, 1.5, 0, -1.5, 0.5 });
        obj.getCoefficients();

    }

}
