

public class ABStrings {
    public static void main(String[] args){
        generate(2,"");      

    }

    static void generate(int n,String current){
        if(current.length()==n){
            System.out.println(current);
            return;
        }
        generate(n,current+"A");
        generate(n,current+"B");
        generate(n, current+"C");
    }
}
