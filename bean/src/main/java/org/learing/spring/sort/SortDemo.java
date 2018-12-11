package org.learing.spring.sort;

public class SortDemo {

    //插入：希尔
    public static void shellSort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[j] < temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        shellSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }


    }
}
