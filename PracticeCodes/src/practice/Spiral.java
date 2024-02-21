package practice;
public class Spiral {
    public static int[][] spiral(int rows, int columns) {
        int[][] result = new int[rows][columns];
        int value = 1;
        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[top][i] = value++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = value++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = value++;
                }
                bottom--;

                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result[i][left] = value++;
                    }
                    left++;
                }
            }
        }
            return result;
    }

        public static void main(String args[]){
            int rows = 3, columns = 4;
            int[][] result = spiral(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(result[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }