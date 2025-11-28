package OOPS.Inheritance;
public class BoxPrice extends BoxWeight{
    double price;


    BoxPrice(){
        this.price=-1;
        super();
    }

    BoxPrice(BoxPrice other){
        super(other);
        this.cost=other.cost;
    }

    public BoxPrice(double l,double h,double w,double weight,double cost){
        super(l,w,h,weight);
        this.cost=cost;
    }
}