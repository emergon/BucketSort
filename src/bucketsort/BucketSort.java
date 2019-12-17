/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class BucketSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] data = {4, 3, 4, 5, 6, 9, 1, 5, 3, 3, 45, 23, 45, 11, 77, 45, 23};
        int[] data2 = {4, 3, 4, 5, 6, 9, 1, 5, 3, 3, 45, 23, 45, 11, 77, 45, 23};
        sort(data2, 77);
        //int size = data.length;
        //BucketSort bs = new BucketSort();
        //sort(data, 3);
        //bs.bucketSort(data, size);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data2));
    }

    private static final int DEFAULT_BUCKET_SIZE = 5;

    public static void sort(Integer[] array) {
        sort(array, DEFAULT_BUCKET_SIZE);
    }

    public static void sort(Integer[] array, int bucketSize) {
        if (array.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        Integer minValue = array[0];
        Integer maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Initialise buckets
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Distribute input array values into buckets
        for (int i = 0; i < array.length; i++) {
            buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
        }

        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            InsertionSort.sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }
    }

//    public static void bucketSort(int[] array, int size) {
//        int max = (Arrays.stream(array).max().getAsInt());
//        System.out.println("max===" + max);
//        int[] bucket = new int[max + 1];
//        for (int i = 0; i <= max; i++) {
//            bucket[i] = 0;
//        }
//        for (int i = 0; i < size; i++) {
//            bucket[array[i]]++;
//        }
//        for (int i = 0, j = 0; i <= max; i++) {
//            while (bucket[i] > 0) {
//                array[j++] = i;
//                bucket[i]--;
//            }
//        }
//    }
    public static void sort(int[] a, int maxVal) {
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
        System.out.println("bucket11:"+Arrays.toString(bucket));
        System.out.println("aaaaa111:"+Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
System.out.println("bucket22:"+Arrays.toString(bucket));
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            System.out.println("i:" + i);
            System.out.println("bucket[i]="+bucket[i]);
            for (int j = 0; j < bucket[i]; j++) {
                System.out.println("i:" + i + ",j:" + j);
                System.out.println("outPos:"+outPos);
                a[outPos++] = i;

            }
        }
    }
}

class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T item = array[i];
            int indexHole = i;
            while (indexHole > 0 && array[indexHole - 1].compareTo(item) > 0) {
                array[indexHole] = array[--indexHole];
            }
            array[indexHole] = item;
        }
    }
}
