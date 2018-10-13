public class StarTriangle {
    private int width;
    public StarTriangle(int w)
    {
        width = w;
    }

    @Override public String toString()
    {
        String s = "";
        for(int i = 1; i <= width; i++)
        {
            for(int j = 0; j < i; j++)
                s += "[*]";
            if(i < width) s += "\n";
        }
        return s;
    }
}