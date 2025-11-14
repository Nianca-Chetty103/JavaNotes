/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author nianc
 */
public class BucketSort {

   public void sort(Integer[] arr) {
        if (arr.length == 0) {   // corrected: arr.length
            return;
        }

        // Find the maximum value
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int numBuckets = 10;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>(numBuckets);

        // Initialize buckets
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new LinkedList<>());
        }

        // Distribute values into buckets
        for (int value : arr) {
            int bucketIndex = (int)((double)value / (maxValue) * (numBuckets - 1)); 
            buckets.get(bucketIndex).add(value);
        }

        // Sort each bucket and merge back to array
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

}
