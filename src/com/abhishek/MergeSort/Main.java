package com.abhishek.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int intArray[] = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(Arrays.toString(intArray));
        mergeSort(intArray, 0, intArray.length);
        System.out.println(Arrays.toString(intArray));
    }
    //20, 35, -15, 7, 55, 1, -22
    public static void mergeSort(int intArray[], int startIndex, int endIndex) {
        if (endIndex - startIndex < 2) {
            return;
        }
        int midIndex = (startIndex + endIndex) / 2;
        mergeSort(intArray, startIndex, midIndex);
        mergeSort(intArray, midIndex, endIndex);
        merge(intArray, startIndex, midIndex, endIndex);
    }
    //20, 35, -15, 7, 55, 1, -22
    //0,  1,   2,  3,  4,   5,   6  7
    //  ----------, S,      M,       E--
    //[-15, 20, 35, 7, 55, -22, 1]
    private static void merge(int[] intArray, int startIndex, int midIndex, int endIndex) {
        int i = startIndex;
        int j = midIndex;
        int tempIndex = 0;
        int tempArray[] = new int[endIndex - startIndex];
        while (i < midIndex && j < endIndex) {
            tempArray[tempIndex++] = intArray[i] > intArray[j] ? intArray[j++] : intArray[i++];
        }
        System.arraycopy(intArray, i, intArray, startIndex + tempIndex, midIndex - i);
        System.arraycopy(tempArray, 0, intArray, startIndex, tempIndex);

    }
}
