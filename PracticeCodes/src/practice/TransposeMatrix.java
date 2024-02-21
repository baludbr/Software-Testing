package practice;
import java.util.*;
public class TransposeMatrix {
    public static int[][] transpose(int[][] m) {
        int r=m.length;
        int c=m[0].length;

        int[][] t=new int[c][r];

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                t[j][i]=m[i][j];
            }
        }

        return t;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        int[][] t=transpose(m);
        printMatrix(t);

        scanner.close();
    }

    public static void printMatrix(int[][] m) {
        for (int[] i:m) {
            for (int j:i)
                System.out.print(j+" ");
            System.out.println();
        }
    }
}
