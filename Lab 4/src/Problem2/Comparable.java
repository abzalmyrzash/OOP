package Problem2;
/*
Interface fields are all public static final
and methods are all public abstract
 */
public interface Comparable {
    private int x = 2; //must be public (and static final)
    int y = 3;

    int compareTo(Object o);

    private static void blabla(); //must be public and non-static

}
