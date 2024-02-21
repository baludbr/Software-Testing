package practice;

import java.util.*;

public class MaxMethod2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=s.nextInt();
        }
        int res = MaxMethod2.max(nums);
        int expected = s.nextInt();
        System.out.println(res==expected);
    }

    static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            if(num>max){
                max=num;
            }
        }

        return max;
    }
}