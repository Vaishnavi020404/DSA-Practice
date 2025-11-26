package OOPS.Inheritance;
public class Box {
    private double l;
    double h;
    double w;

    // default constructor
    public Box() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    // cube constructor
    public Box(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    // parameterized constructor
    public Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    // getter (optional)
    public double getLength() {
        return l;
    }
}
