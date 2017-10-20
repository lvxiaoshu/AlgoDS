package algo.sortingandsearching;

import java.util.Arrays;

import static algo.sortingandsearching.InsertionSort.getInts;

/**
 * Created by sherxon on 2016-12-18.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
//Selection Sort is preferred when memory writes are more expensive than reads, as it makes only O(n) writes
public class SelectionSort {


    public static <T extends Comparable> void sort(T[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) // find min
                if(a[minIndex].compareTo(a[j])>0)
                    minIndex=j;

            if(minIndex!=i){ // swap
                T temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }
        }
    }
    // simple, easy to understand
    public static void sortSimple1(int[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length; j++) // find min
                if(a[minIndex]>a[j])
                    minIndex=j;

            if(minIndex!=i){ // swap
                int temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }

        }
    }
    public static void sortSimple2(int[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = 0; j < a.length; j++) {
                if (a[j]<a[minIndex])
                    minIndex=j;
            }
            if(minIndex!=i) { // swap
                a[i] = a[minIndex] ^ a[i];
                a[minIndex] = a[minIndex] ^ a[i];//a[i]的值赋给a[minIndex]
                a[i] = a[minIndex] ^ a[i];////a[minIndex]的值赋给a[i]
            }
        }
    }
    public static void main(String[] args) {
        int[] a = getInts();
        sortSimple1(a);
        System.out.println(Arrays.toString(a));
    }
}
