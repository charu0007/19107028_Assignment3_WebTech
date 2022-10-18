import java.util.*;
public class ques4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int n = sc.nextInt();
        System.out.println(n);
        while(n!=1){
            if(n%2==0) n/=2;
            else n = n*3+1;
            System.out.println(n);
        }
    }
}
