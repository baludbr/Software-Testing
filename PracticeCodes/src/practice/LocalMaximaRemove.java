package practice;

import java.util.*;

public class LocalMaximaRemove {
    public static int[] removeLocalMaxima(int[] array) {
        int[] result = new int[array.length];
        int resultIndex = 0;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] <= array[i - 1] || array[i] <= array[i + 1]) {
                result[resultIndex++] = array[i];
            }
        }
        if (array[0] <= array[1]) {
            result[resultIndex++] = array[0];
        }
        if (array[array.length - 1] <= array[array.length - 2]) {
            result[resultIndex++] = array[array.length - 1];
        }

        return Arrays.copyOf(result, resultIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }
        int[] outputArray = removeLocalMaxima(inputArray);

        System.out.print("Input array: [");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]);
            if (i < inputArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.print("Output array: [");
        for (int i = 0; i < outputArray.length; i++) {
            System.out.print(outputArray[i]);
            if (i < outputArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}