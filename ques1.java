import java.util.*;
public class ques1 {
    
    public static int compare(String string1, String string2){

        for(int i = 0; i < string1.length() && i < string2.length(); i++){ //iterate in the strings

            if((int)string1.charAt(i) == (int)string2.charAt(i)){
                continue;
            }
            else{
                if((int)string1.charAt(i) > (int)string2.charAt(i)) return 1;//return 1 if greater
                 else return -1;
            }
        }
        if(string1.length() == string2.length()){
            return 0;
        }if(string1.length() > string2.length()){
            return 1;
        }if(string1.length() < string2.length()){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args){
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First String: ");
        String string1 = sc.nextLine();
        System.out.println("Enter Second String: ");
        String string2 = sc.nextLine();
        System.out.println(compare(string1, string2));
}
}