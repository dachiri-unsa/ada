package lab03.ejercicio05.sort;

import java.util.Comparator;
import java.util.List;

@FunctionalInterface
public interface SortAlgorithm {
    <T> void sort(List<T> datos, Comparator<T> comparator);
}
