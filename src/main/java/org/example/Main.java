package org.example;

//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//        Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//        и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//        Если длины массивов не равны, необходимо как-то оповестить пользователя.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {18, 2, 9, 6};
        int[] arr2 = {3, 2, 0, 2};

        System.out.println(Arrays.toString(difference(arr, arr2)));
        System.out.println(Arrays.toString(division(arr, arr2)));

//        arithmeticException(5);
//        indexOutOfBounds(arr);
//        numberFormat();
    }

    public static void arithmeticException(int num) {
        System.out.println(num/0);
    }

    public static void indexOutOfBounds(int arr[]) {
        System.out.println(arr[arr.length]);
    }

    public static void numberFormat() {
        String str = "a";
        int x = Integer.parseInt(str);
    }

    public static int[] difference(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разной длины");
        } else {
            int[] tempArr = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                tempArr[i] = arr1[i] - arr2[i];
            }
            return tempArr;
        }
    }

//    * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//    каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
//    Если длины массивов не равны, необходимо как-то оповестить пользователя.
//        Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

    public static int[] division(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разной длины");
        } else {
            int[] tempArr = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                if(arr2[i] == 0) {
                    tempArr[i] = 0;
                    throw new RuntimeException("Не могу делить на 0");
                } else {
                    tempArr[i] = arr1[i] / arr2[i];
                }
            }
            return tempArr;
        }
    }
}

