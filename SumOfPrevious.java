package practice;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfPrevious {
    public static boolean[] getSumCheckArray(int[] nums) {
        int n = nums.length;
        boolean[] result = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                result[i] = true;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        int[] nums = new int[length];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean[] result = getSumCheckArray(nums);

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Output array: " + Arrays.toString(result));

        scanner.close();
    }
}
