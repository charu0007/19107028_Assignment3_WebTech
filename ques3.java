import java.util.*;
public class ques3 {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a string: ");
       String s1 = sc.nextLine();
       char arr[] = s1.toCharArray();
       Arrays.sort(arr);
       String s2 = new String(arr);
       System.out.println("New String: " + s2);
    }
 }
