package Problem2;

/*
A class can implement multiple interfaces, but can only extend one class.
So you can't have a class extend multiple abstract classes.

Interfaces are limited to public static final fields and abstract methods,
whereas abstract classes can have any field/method modifiers.
 */

public class SampleClass
        extends AbstractClass, AnotherAbstract //can't extend more than one class
        implements Comparable, AnotherInterface{ //can implement multiple interfaces
    public int compareTo(Object o){return 0;}
    public void doSomething(){}
}
