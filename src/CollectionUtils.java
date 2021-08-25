import java.util.*;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    
    public static  <T>List<T> newArrayList() {
        return new ArrayList<T>();
     }
    

    public static<T> void add(List<? super T> consumer, T value) {
        consumer.add(value);
     }
    
    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> source) {
        source.forEach(removeFrom::remove);
    }
    
    public static<T> boolean containsAll(List<? extends T> source, List<? super T> consumer) {
        for(T elem: source){
            if (!consumer.contains(elem))
                return false;
        }
        return true;
     }
    
    public static<T> boolean containsAny(List<? extends T> source, List<? super T> consumer) {
        for(T elem: source){
            if (consumer.contains(elem))
                return true;
        }
        return false;
     }
    
 public static <T extends Comparable<T>> List range(List<? extends T> list, T min, T max) {
        List<T> newList = new ArrayList<>();
        list.forEach(elem ->  {
                    if (elem.compareTo(min) >= 0 && elem.compareTo(max) <= 0)
                    newList.add(elem);
        });
        return newList;
 }

 public static <T> List range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
       List<T> newList = new ArrayList<>();
       list.forEach(elem ->  {
           if (comparator.compare(elem, min) <= 0 && comparator.compare(elem, max) >= 0)
               newList.add(elem);
       });
       return newList;
    }

    public static<T> int indexOf(List<? super T> source, T elem) {
        if (source == null)
            return -1;
        var it = source.listIterator();
        int indexOf = -1;
            while (it.hasNext()){
                indexOf++;
                if (it.next().equals(elem))
                    return indexOf;
        }
        return -1;
    }

    public static <T>List<T> limit(List<T> source, int size) {
        return source.subList(0, Math.min(size, source.size()));
    }
}
    