import java.util.Scanner;

public class Substring {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String str = sc.next();

      if (!sc.hasNext()) {
        System.out.println("** MISSING LENGTH OF SUBSTRING **");
        return;
      }
      int len = sc.nextInt();

      String substrHead = substrHeadRec(str, len);
      String substrTail = substrTailRec(str, len);

      System.out.println("head recursive substring: \"" + substrHead + "\"");
      System.out.println("tail recursive substring: \"" + substrTail + "\"");

      if (!substrHead.equals(substrTail)) {
        System.out.println("** SUBSTRINGS DO NOT MATCH **");
        return;
      }
    }
  }

  public static String substrHeadRec(String str, int len) {
    // FILL IN (recursion then work)
    return ( str.length() < len ) ? substrHeadRec(str,len)+"*" : str;
  }

  public static String substrTailRec(String str, int len) {
    // FILL IN (work then recursion)
    return "";
  }
}
