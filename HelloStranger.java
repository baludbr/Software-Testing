package practice;
import java.util.Scanner;

public class HelloStranger {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int c=s.nextInt();
        s.nextLine();
        if (c==0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (c<0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            for (int i=0;i<c;i++) {
                String n=s.next();
                if (!n.isEmpty()) {
                    System.out.println("Hello, " + n);
                }
            }
        }
    }
}