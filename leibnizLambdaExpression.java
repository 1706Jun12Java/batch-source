import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }
 public static PerformOperation isOdd() {
    PerformOperation po = (a)-> (a%2 !=0);
     return po;
 }

 public static PerformOperation isPrime() {
    PerformOperation po = (a)-> (isPrimeHM(a));
     return po;
 }

  public static PerformOperation isPalindrome() {
    PerformOperation po = (a)-> (isPali(a));
     return po;
 }

  // Helper method for prime
  private static boolean isPrimeHM(int num) {
      if((num ==2 || num==3) || (num%2 != 0 && num%3 != 0 && num > 1)) {
          return true;
      }
      else {
          return false;
      }
  }

  // Helper method for palindrome
  private static boolean isPali(int num) {
      String currentStr = "" + num;
      String reverseStr = new StringBuilder(currentStr).reverse().toString();
      if(currentStr.equals(reverseStr)) {
          return true;
      }
      else {
          return false;
      }
  }
}

public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}