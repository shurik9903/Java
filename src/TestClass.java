import java.sql.SQLOutput;
import java.util.Scanner;

class Figure{

    Figure(){}

    void Print(){
        System.out.println("Area"+ getClass().getName() + " = " + Area());
    }

    double Area(){
        return 0;
    }
}

class Cube extends Figure{

    private double a,b;

    Cube(){
        this.a = 0;
        this.b = 0;
    }

    Cube(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    double Area() {
        return a * b;
    }

    void SetValue(double a, double b){
        this.a = a;
        this.b = b;
    }
}

class Circle extends Figure{
    private static double pi = 3.14;
    private double r;

    Circle(){
        this.r = 0;
    }

    Circle(double r){
        this.r = r;
    }

    @Override
    double Area() {
        return pi * (r * r);
    }

    void SetValue(double r){
        this.r = r;
    }
}

class Cone extends Circle{

    private double h;

    Cone(){
        super();
        this.h = 0;
    }

    Cone(double r, double h){
        super(r);
        this.h = h;
    }

    @Override
    double Area() {
        return 1.0/3.0 * super.Area() * h;
    }

    void SetValue(double r, double h){
        this.h = h;
        super.SetValue(r);
    }
}

class Cube3D extends Cube{
    private double z;

    Cube3D(){
        super();
        this.z = 0;
    }

    Cube3D(double a, double b, double z){
        super(a,b);
        this.z = z;
    }

    @Override
    double Area() {
        return z*super.Area();
    }

    void SetValue(double a, double b, double z){
        super.SetValue(a,b);
        this.z = z;
    }
}

public class TestClass {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Figure F;

        end: while (true) {
            System.out.println("Enter to figure: \n" +
                    "1. Cube \n" +
                    "2. Cube3D \n" +
                    "3. Circle \n" +
                    "4. Cone \n" +
                    "0. Exit");

            int k = scan.nextInt();

            switch (k) {
                case 1:
                    F = new Cube(5, 5);
                    F.Print();
                    break;
                case 2:
                    F = new Cube3D(3, 3, 10);
                    F.Print();
                    break;
                case 3:
                    F = new Circle(10);
                    F.Print();
                    break;
                case 4:
                    F = new Cone(5, 20);
                    F.Print();
                    break;
                case 0:
                    break end;
                default:
            }
        }
    }
}
