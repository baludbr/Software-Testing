package practice;
import java.util.*;

public class MaxMethod {
    public static OptionalInt max(int[] a) {
        if (a.length == 0) {
            return OptionalInt.empty();
        }
        int max=a[0];
        for (int i=1;i<a.length;i++) {
            if (a[i]>max){
                max=a[i];
            }
        }
        return OptionalInt.of(max);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++) a[i]=s.nextInt();
        OptionalInt result=max(a);
        if (result.isPresent()) {
            System.out.println("Maximum value: "+result.getAsInt());
        } else {
            System.out.println("Array is empty or null.");
        }
    }
}