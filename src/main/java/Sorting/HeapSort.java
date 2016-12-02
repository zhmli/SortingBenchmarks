package Sorting;

/**
 * Created by lizhuomeng on 2016/12/1.
 */
import java.util.Arrays;

public class HeapSort extends BaseSort{

    public static void sort(int[] values) {
        buildMaxHeap(values);
        int heapSize = values.length;
        for (int i = values.length - 1; i >= 0; i--) {
            swap(values, 0, i);
            maxHeapify(values, --heapSize, 0);
        }
    }

    private static void buildMaxHeap(int[] values) {
        int mid = (values.length) / 2;
        for (int i = mid; i >= 0; i--) {
            maxHeapify(values, values.length, i);
        }
    }

    private static void maxHeapify(int[] values, int heapSize, int index) {
        int l = left(index);
        int r = right(index);
        int largest = index;

        if (l < heapSize && values[l] > values[index]) {
            largest = l;
        }

        if (r < heapSize && values[r] > values[largest]) {
            largest = r;
        }

        if (largest != index) {
            swap(values, largest, index);
            maxHeapify(values, heapSize, largest);
        }
    }

    private static int left(int index) {
        return (index * 2) + 1;
    }

    private static int right(int index) {
        return (index * 2) + 2;
    }

}
