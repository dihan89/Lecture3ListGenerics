
import java.util.*;



class A implements Comparable<A> {
    protected int value;
    A(int n) {
        value = n;
    }

    public void printHelloWorld() {
        System.out.println("Hello, world! (class A) " + value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        A other = (A) obj;
        return (other.value == this.value) ? true : false;
    }
    @Override
    public int compareTo(A other){
        return this.value - other.value;
    }
    public int getValue() {
        return value;
    }
}

class B extends A{
    B(int n){
        super(n);
    }

    @Override
    public void printHelloWorld(){
        System.out.println("Hello, world! (class B) " + value);
    }
}

class C extends B{
    C(int n){
        super(n);
    }
    @Override
    public void printHelloWorld() {
        System.out.println("Hello, world! (class C) " + value);
    }
}



public class Lecture3ListGenerics {
    public static void printList(List<? extends A> list) {
        for (A elem : list) {
            elem.printHelloWorld();
        }
        ;
    }

    public static void testLimit() {
        List<A> listA= new ArrayList<A>(){{
            add(new A(2));
            add(new A(2));
            add(new A(1));
            add(new A(4));
            add(new B(10));
            add(new C(100 ));
            add(new C(3 ));
            add(new A(5 ));
            add(new C(8 ));
            add(new B(1 ));
        }};


        List<A> rangeList1 = CollectionUtils.<A>limit(listA, 5);
        System.out.println("List after method \'limit\'");
        rangeList1.forEach(System.out::println);
    }

    public static void testRemoveAll() {
        List<A> listA = new ArrayList<A>(){{
            add(new A(2));
            add(new A(2));
            add(new A(1));
            add(new A(4));
            add(new B(10));
            add(new C(100 ));
            add(new C(3 ));
            add(new A(5 ));
            add(new C(8 ));
            add(new B(1 ));
        }};
        List<A> listB = new ArrayList<A>(){{
            add(new A(2));
            add(new A(1));
            add(new A(4));
            add(new B(10));
            add(new C(3 ));
            add(new A(5 ));
            add(new C(8 ));
            add(new B(1 ));
        }};
        CollectionUtils.removeAll(listA, listB);
        listA.forEach(System.out::println);
    }


    public static void testRange() {
        List<A> listA= new ArrayList<A>(){{
            add(new A(2));
            add(new A(2));
            add(new A(1));
            add(new A(4));
            add(new B(10));
            add(new C(100 ));
            add(new C(3 ));
            add(new A(5 ));
            add(new C(8 ));
            add(new B(1 ));
        }};

        List<A> rangeList1 = CollectionUtils.<A>range(listA, new B(2), new C(8));
        System.out.println("List after method \'range\'");
        rangeList1.forEach(System.out::println);

        List<A> rangeList2 = CollectionUtils.<A>range(listA, new C(8), new B(2),
                                            Comparator.comparing(elem -> -elem.getValue()));
        System.out.println("List after method \'range 2\'");
        rangeList1.forEach(System.out::println);
    }

    public static void main(String[] args) {
             A a1 = new A(1);
             A a2 = new A(2);
             A a3 = new A(3);
             B b1 = new B(1);
             B b2 = new B(2);
             B b3 = new B(3);
             C c1 = new C(1);
             C c2 = new C(2);
             C c3 = new C(3);
             List<A> listA= new ArrayList<A>(){{
                add(b1);
                add(a3);
                add(c2);
             }};
             List<C> listC = new ArrayList<C>(){{
                 add(c2);
                 add(c3);
             }};
            List<B> listB = new ArrayList<B>(){{
            add(b2);
            add(b3);
            }};
            printList(listA);
            List<B> listBn = CollectionUtils.<B>newArrayList();
            CollectionUtils.<B>add(listA, b3);
            System.out.println(CollectionUtils.<B>containsAll(listC, listA));
            System.out.println("Contains Any: ");
            System.out.println(CollectionUtils.<B>containsAny(listB, listA));
            System.out.println(CollectionUtils.<B>containsAny(listC, listA));
            CollectionUtils.<B>addAll(listC, listA);
            System.out.println("Contains All: ");
            System.out.println(CollectionUtils.<B>containsAll(listC, listA));
            printList(listC);
            System.out.println(a1.equals(b1));
            System.out.println(c1.equals(new C(1)));

            testRange();
            testLimit();
            System.out.println("listA");
            listA.forEach(System.out::println);
            int index = listA.indexOf(new A(3));
            System.out.println("----");
            System.out.println("IndexOf(3) = " + index);
            testRemoveAll();
    }
}