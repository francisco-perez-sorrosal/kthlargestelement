package com.softwarepieces.algorithms.kthlargestelement;

import com.softwarepieces.algorithms.kthlargestelement.Main.KTHLargestElementFinder;
import com.softwarepieces.algorithms.kthlargestelement.Main.QuickSort;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by fperezsorrosal on 8/5/16.
 */
public class KTHLargestElementFinderTest {

    @Test
    public void testFindKthLargest() throws Exception {

        // Element under test
        KTHLargestElementFinder kthLargestElementFinder = new KTHLargestElementFinder();

        int[] input1 = {1};
        assertEquals(kthLargestElementFinder.findKthLargest(input1, input1.length), 1);

        int[] input2 = {-1, 100};
        assertEquals(kthLargestElementFinder.findKthLargest(input2, 1), 100);
        assertEquals(kthLargestElementFinder.findKthLargest(input2, input2.length), -1);

        int[] input3 = {0, -1, -10};
        assertEquals(kthLargestElementFinder.findKthLargest(input3, 1), 0);
        assertEquals(kthLargestElementFinder.findKthLargest(input3, input3.length - 1), -1);
        assertEquals(kthLargestElementFinder.findKthLargest(input3, input3.length), -10);

        int[] input4 = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        assertEquals(kthLargestElementFinder.findKthLargest(input4, 1), 99);
        assertEquals(kthLargestElementFinder.findKthLargest(input4, 2), 75);
        assertEquals(kthLargestElementFinder.findKthLargest(input4, input4.length - 1), 2);
        assertEquals(kthLargestElementFinder.findKthLargest(input4, input4.length), 2);

    }

    @Test
    public void testQuickSort() throws Exception {

        // Element under test
        QuickSort sorter = new QuickSort();

        int[] input1 = {1};
        sorter.sort(input1, 0, input1.length - 1);
        assertEquals(input1, input1);

        int[] input2 = {-1, 100};
        sorter.sort(input2, 0, input1.length - 1);
        assertEquals(input2, input2);

        int[] input3 = {0, -1, -10};
        sorter.sort(input3, 0, input3.length - 1);
        assertEquals(input3, new int[] {-10, -1, 0});

        int[] input4 = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sorter.sort(input4, 0, input4.length - 1);
        assertEquals(input4, new int[] {2, 2, 12, 20, 24, 45, 53, 56, 56, 75, 99});

    }

}