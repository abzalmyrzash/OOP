public class Main {
    static int[] repeatElements(int[] a)
    {
        int[] b = new int[2 * a.length];
        for(int i = 0; i < a.length; i++)
        {
            b[i*2] = b[i*2 + 1] = a[i];
        }

        return b;
    }
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = repeatElements(a);

        //===================================================

        System.out.print("a = [");

        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]);
            System.out.print((i < a.length-1) ? ", " : "]\n");
        }

        //===================================================

        System.out.print("b = [");

        for(int i = 0; i < b.length; i++)
        {
            System.out.print(b[i]);
            System.out.print((i < b.length-1) ? ", " : "]\n");
        }

        //===================================================
    }
}
