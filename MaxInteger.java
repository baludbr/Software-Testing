package practice;
import java.util.*;
public class MaxInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int max = max(s);
        System.out.println(max);
    }

    public static int max(Scanner s){
        int max=Integer.MIN_VALUE;
        while(true){
            int num=s.nextInt();
            if(num==0){
                break;
            }
            if(num>max){
                max=num;
            }
        }
        return max;
    }
}