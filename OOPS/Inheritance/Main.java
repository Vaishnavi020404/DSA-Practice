package OOPS.Inheritance;
public class Main {
    public static void main(String[] args) {

        BoxWeight box3 = new BoxWeight();
        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);

        //  This will NOT work
        // System.out.println(box3.l);

        // This works
        System.out.println("Weight of box3: " + box3.weight);

        // This works
        System.out.println("Length of box4 (via getter): " + box4.getLength());

        //  This will NOT work
        // System.out.println(box4.l);
    }
}
