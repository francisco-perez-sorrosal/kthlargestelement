package com.softwarepieces.algorithms.kthlargestelement;

import java.util.Arrays;

/**
 * Created by @fperezsorrosal on 8/5/16.
 */
public class Main {

    static class KTHLargestElementFinder {

        int findKthLargest(int[] array, int kth) {

            return prunedQuickSort(array, 0, array.length - 1, kth - 1);

        }

        private int prunedQuickSort(int[] array, int firstIdx, int lastIdx, int kth) {

            int i = firstIdx;
            int j = lastIdx;

            // Determine pivot element (middle index element in this case)
            int pivot;
            if (array.length == 1 || array.length % 2 == 0) {
                pivot = array[(firstIdx + (lastIdx - firstIdx) / 2)];
            } else {
                pivot = array[(firstIdx + (lastIdx - firstIdx) / 2 + 1)]; // Central element
            }

            // Scan left and right sides of the pivot and swap if necessary
            while (i <= j) {

                while (array[i] > pivot) {
                    i++;
                }

                while (array[j] < pivot) {
                    j--;
                }

                if (i <= j) {
                    swap(array, i++, j--); // Post eval increment
                }

            }

            // Recursive calls
            if (firstIdx < j && kth <= j) { // Look on the left side
                return prunedQuickSort(array, firstIdx, j, kth);
            } else {
                if (i < lastIdx && kth >= i) { // Look on the right side
                    return prunedQuickSort(array, i, lastIdx, kth);
                } else { // firstIdx == j == kth || i == lastIdx == kth <-- this is the guy
                    return array[kth];
                }
            }

        }

    }

    static class QuickSort {

        void sort(int[] array, int firstIdx, int lastIdx) {

            int i = firstIdx;
            int j = lastIdx;

            // Determine pivot element and value (middle index element in this case)
            int pivot = array[firstIdx+(lastIdx-firstIdx)/2];

            while (i <= j) {

                // Sort in ascending order
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(array, i++, j--);
                }
            }

            // Recursive calls to sort each side of the array
            if (firstIdx < j)
                sort(array, firstIdx, j);
            if (i < lastIdx)
                sort(array, i, lastIdx);
        }

    }

    static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void main(String[] args) {

        KTHLargestElementFinder kthLargestElementFinder = new KTHLargestElementFinder();
        int[] input = { 3, 2, 45, 20, 56, 75, 2, 56, 99, 53, 102, 0, -1, 98, 98};
        System.out.println(kthLargestElementFinder.findKthLargest(input, 1));

        QuickSort quickSort = new QuickSort();
        quickSort.sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

    }

}
