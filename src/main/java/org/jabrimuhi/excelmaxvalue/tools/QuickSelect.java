package org.jabrimuhi.excelmaxvalue.tools;

import java.util.List;
import java.util.Random;

public class QuickSelect {

    public static Integer quickSelect(List<Integer> list, int left, int right, int k) {
        if (left == right) {
            return list.get(left);
        }

        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        pivotIndex = partition(list, left, right, pivotIndex);

        if (k == pivotIndex) {
            return list.get(k);
        } else if (k < pivotIndex) {
            return quickSelect(list, left, pivotIndex - 1, k);
        } else {
            return quickSelect(list, pivotIndex + 1, right, k);
        }
    }

    private static int partition(List<Integer> list, int left, int right, int pivotIndex) {
        int pivotValue = list.get(pivotIndex);
        swap(list, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i) < pivotValue) {
                swap(list, storeIndex, i);
                storeIndex++;
            }
        }
        swap(list, right, storeIndex);
        return storeIndex;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
