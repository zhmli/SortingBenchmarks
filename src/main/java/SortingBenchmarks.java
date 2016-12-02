/**
 * Created by lizhuomeng on 2016/12/1.
 */

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;

import Sorting.HeapSort;
import Sorting.MergeSort;
import Sorting.QuickSort;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class SortingBenchmarks extends SimpleBenchmark {

    private static final int SIZE = 100000;
    private static final int MAX_VALUE = 80000;
    private int[] values;

    @Override
    protected void setUp() throws Exception {
        values = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = generator.nextInt(MAX_VALUE);
        }
    }

    public void timeHeapSort(int reps) {
        for (int i = 0; i < reps; i++) {
            HeapSort.sort(values);
        }
    }

    public void timeMergeSort(int reps) {
        for (int i = 0; i < reps; i++) {
            MergeSort.sort(values);
        }
    }

    public void timeQuickSort(int reps) {
        for (int i = 0; i < reps; i++) {
            QuickSort.sort(values);
        }
    }

    public void timeArraysSort(int reps) {
        for (int i = 0; i < reps; i++) {
            Arrays.sort(values);
        }
    }

    public static void main(String... args) {

        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("free memory: " + format.format(freeMemory / 1024) + "    ");
        sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "  ");
        sb.append("max memory: " + format.format(maxMemory / 1024) + "  ");
        sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "    ");

        System.out.println(sb.toString());
        System.out.println();

        Runner.main(SortingBenchmarks.class, new String[0]);

        sb.append("free memory: " + format.format(freeMemory / 1024) + "    ");
        sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "  ");
        sb.append("max memory: " + format.format(maxMemory / 1024) + "  ");
        sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "    ");

        System.out.println(sb.toString());
        System.out.println();
    }
}
