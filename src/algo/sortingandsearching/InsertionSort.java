package algo.sortingandsearching;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by sherxon on 2016-12-16.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
// In case of an almost sorted small array, use this
// swapping and shifting are the same complexity , takes constant time
public class InsertionSort {

    // sorts by shifting
    public static <T extends Comparable> void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    T temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    // sorts by swapping
    public static <T extends Comparable> void sortBySwap(T[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            T ii = a[i];

            while (j > 0 && a[j - 1].compareTo(ii) > 0) a[j] = a[--j];

            if (j != i) a[j] = ii;
        }
    }

    //比sortSimple1要快,数据交换很浪费性能?
    public static void sortSimple2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j=i;
            int temp = a[i];
            for (; j > 0 && temp <a[j-1]; j--) {
                    a[j]= a[j - 1];
            }
            a[j] = temp;
        }
    }

    static void sortSimple3(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int current = a[i];
            while (j > 0 && current < a[j - 1])
                a[j] = a[--j];
            a[j] = current;
        }
    }
    //simple version,  easy to understand.
    public static void sortSimple1(int[] a) {

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) { //swap
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else break;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = getInts();
        Instant start = Instant.now();
        //sortSimple1(a);
        //sortSimple2(a);
        //sortSimple3(a);
        SelectionSort.sortSimple1(a);
        Instant end = Instant.now();
        Duration between = Duration.between(start,end);
        System.out.println(Arrays.toString(a));
        System.out.println(between);
    }

    public static int[] getInts() {
        int[] a= new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] =100000-i;
        }
        return a;
    }

     void test2() {
        Integer[] a = getIntegers();
        Instant start = Instant.now();
        sortBySwap(a);
        Instant end = Instant.now();
        Duration between = Duration.between(start,end);
        System.out.println(Arrays.toString(a));
        System.out.println(between);
    }

    private static Integer[] getIntegers() {
        Integer[] a= new Integer[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] =100000-i;
        }
        return a;
    }
}
