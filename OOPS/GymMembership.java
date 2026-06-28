// 28/6/2,Finished 3 weeks in office,start of july and the 4th week in july.
package OOPS;
import java.util.*;

public class GymMembership {
    public static void main(String[] args) {

        ArrayList<Member> Members=new ArrayList<>();

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of members:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){

            System.out.println("Enter the name of member:");
            String name=sc.next();
            System.out.println("Enter the memberId of member:");
            String memberId=sc.next();
            System.out.println("Enter the age of member:");
            int age=sc.nextInt();
            System.out.println("Enter the membershipType of member:");
            String membershipType=sc.next();
            System.out.println("Enter the monthlyFee of member:");
            double monthlyFee=sc.nextDouble();

            members.add(new Member(name,memberId,age,membershipType,monthlyFee));

            //OR
            //Member m=new Member(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.nextDouble());

            System.out.println("Enter the type of memebership to get the members: ");
            getMembersByType(sc.next());


        }
        


        
    }    
}

class Member{
    String name;
    int memberId;
    double age;
    String membershipType;
    double monthlyFee;

    //constructor

    Member(String name,String memberId,int age,String membershipType,double monthlyFee){
        this.name=name;
        this.memberId=memberId;
        this.age=age;
        this.membershipType=membershipType;
        this.monthlyFee=monthlyFee;
    }

    String getName(){
        return name;
    }

    int getMemberId(){
        return memberId;
    }

    double getAge(){
        return age;
    }

    String getMembershipType(){
        return membershipType;
    }

    double getMonthlyFee(){
        return monthlyFee;
    }
    
}


class Gym{
    
    void getMembersByType(String membershipType){
        for(Members mem:Members){
            if(membershipType.equalsIgnoreCase(mem.getMembershipType())){
                System.out.println(mem.getName()+ "(" + mem.getMemberId() + ")" );
            }
        }
        
    } 
    
    int getTotalRevenue(){
        int sum=0;
        for(Members mem:Members){
            sum+=mem.getMonthlyFee();
        }
        return sum;
    }

    double getAverageAge(){
        double avg=0;
        for(Members mem:Members){
            avg+=mem.getMonthlyFee();
        }
        return avg/Members.size();
        
        
    }
    
    int getOldestMember(){
        int oldest=0;
        for(Members mem:Members){
            if(mem.getAge()>oldest){
            oldest=mem.getAge();
        }0
        }

        return oldest;
    }     


}