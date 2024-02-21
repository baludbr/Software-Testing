package practice;
import java.util.*;

class Point{
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    private int x;
    private int y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Line{
    private int k;
    private int b;

    public Line(int k, int b){
        this.k=k;
        this.b=b;
    }

    public Point intersection(Line oth){
        if(k==oth.k){
            return null;
        }

        int x=(oth.b-b)/(k-oth.k);
        int y=k*x+b;

        return new Point(x,y);
    }
}

public class Intersection {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k1=s.nextInt();
        int b1=s.nextInt();

        //2
        int k2=s.nextInt();
        int b2=s.nextInt();

        Line line1=new Line(k1,b1);
        Line line2=new Line(k2,b2);

        Point intersectionpoint=line1.intersection(line2);

        if(intersectionpoint!=null){
            System.out.println(intersectionpoint);
        }
        else{
            System.out.println("Lines are parallel, no intersection point");
        }
    }
}
