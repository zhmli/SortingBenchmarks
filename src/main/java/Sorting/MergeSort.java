package Sorting;

/**
 * Created by lizhuomeng on 2016/12/1.
 */
import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] v) {
        mergeSort(v, 0, v.length);
    }

    private static void mergeSort(int[] v, int low, int hi) {
        if (low < hi - 1) {
            int mid = (low + hi) / 2;
            mergeSort(v, low, mid);
            mergeSort(v, mid, hi);
            merge(v, low, mid, hi);
        }
    }

    private static void merge(int[] v, int low, int mid, int hi) {
        int[] temp = new int[hi - low];
        int i = low;
        int j = mid;
        int k = 0;

        while (i < mid && j < hi) {
            if (v[i] <= v[j]) {
                temp[k++] = v[i++];
            } else {
                temp[k++] = v[j++];
            }
        }

        while (i < mid) {
            temp[k++] = v[i++];
        }
        while (j < hi) {
            temp[k++] = v[j++];
        }

        for (i = 0; i < temp.length; i++) {
            v[low + i] = temp[i];
        }
    }


}
