public class Data {
    private double avg, max; //average and largest
    private int n; //number of elements

    public Data() {
        avg = 0; n = 0;
    }

    public void addValue(double x)
    {
        if(n == 0) max = x;
        else if(x > max) max = x;
        avg += x;
        n++;
    }

    public double getAvg()
    {
        return avg / n;
    }

    public double getMax()
    {
        return max;
    }

    public boolean empty()
    {
        return n == 0;
    }
}
