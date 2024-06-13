package activities;

import java.util.Arrays;

public class Activity4 {

    static void ascendingSort(int[] array) {
        int size = array.length, i;

        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    public static void main(String[] args){
        int[] a={2,5,8,1,3};
        System.out.println("Before Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(a));
        ascendingSort(a);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(a));
    }
}
