package practice;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        double a=s.nextDouble();
        double b=s.nextDouble();
        double c=s.nextDouble();
        System.out.println(solveQuadraticEquation(a, b, c));
    }

    public static String solveQuadraticEquation(double a, double b, double c) {
        double discriminant=b*b-4*a*c;
        if (discriminant>0) {
            double x1=(-b+Math.sqrt(discriminant))/(2 * a);
            double x2=(-b - Math.sqrt(discriminant))/(2 * a);
            return x1+" "+x2;
        } else if (discriminant==0) {
            double x = -b/(2 * a);
            return String.valueOf(x);
        } else {
            return "no roots";
        }
    }
}