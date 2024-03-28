import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAlgorithms {

    // This method now returns a sorted list instead of void
    public static <T> List<T> quickSort(List<T> originalList, Comparator<T> comparator) {
        List<T> sortedList = new ArrayList<>(originalList); // Create a copy of the original list
        quickSortHelper(sortedList, 0, sortedList.size() - 1, comparator);
        return sortedList; // Return the sorted copy
    }

    private static <T> void quickSortHelper(List<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(list, low, high, comparator);

            quickSortHelper(list, low, pi - 1, comparator);
            quickSortHelper(list, pi + 1, high, comparator);
        }
    }

    private static <T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
