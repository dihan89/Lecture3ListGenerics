import java.util.Comparator;

public class NegativeComparator <T extends A> implements Comparator<T> {

    public int compare(T elem1, T elem2) {
        return (elem2.value - elem1.value);
    }
}
