package AdvancedAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRoom_Greedy {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        arr.add(Arrays.asList(1, 3));
        arr.add(Arrays.asList(1, 2));
        arr.add(Arrays.asList(0, 6));
        arr.add(Arrays.asList(8, 9));
        arr.add(Arrays.asList(4, 7));
        arr.add(Arrays.asList(11, 12));

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).get(1) > arr.get(i + 1).get(1)) {
                sort(arr);
            }
        }

        int endTime = arr.get(index).get(1);
        result.add(arr.get(index));
        index++;

        while (index < arr.size()) {
            if (arr.get(index).get(0) > endTime) {
                result.add(arr.get(index));
                index++;
            } else {
                index++;
            }
        }

        display(result);


    }

    private static void display(List<List<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    private static void sort(List<List<Integer>> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).get(1) > arr.get(i + 1).get(1)) {
                swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(List<List<Integer>> arr, int i, int j) {
        List<Integer> temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
