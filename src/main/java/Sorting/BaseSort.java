package Sorting;

/**
 * Created by lizhuomeng on 2016/12/1.
 */
public abstract class BaseSort {
    protected static void swap(int[] v, int from, int to) {
        int temp = v[from];
        v[from] = v[to];
        v[to] = temp;
    }
}
