import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        String remakeA = a.replace(" ", "");
        String remakeB = b.replace(" ", "");
            
        System.out.print(remakeA);
        System.out.print(remakeB);
    }
}