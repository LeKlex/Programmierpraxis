import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {
      int number = sc.nextInt();

      if (number >= 0) {
        System.out.println(number + " in base 2 notation: "
            + formatAsBase2(number));
      }
    }
  }
  	public static String formatAsBase2(int n) {
  		String bits = "";
  		if (n>0) 
  			return formatAsBase2(n/2)+(n%2);
  		return "";	 
  	}
  	
  	
  public static String formatAsBase2x(int n) {
    if (n > 7) {
      return "(too big)";
    }

    String bits = "";

    if (n >= 4) {
      if (n % 2 == 0) {
        bits = "0" + bits;
      } else {
        bits = "1" + bits;
      }

      n = n / 2;
    }

    if (n >= 2) {
      if (n % 2 == 0) {
        bits = "0" + bits;
      } else {
        bits = "1" + bits;
      }

      n = n / 2;
    }

    if (n % 2 == 0) {
      bits = "0" + bits;
    } else {
      bits = "1" + bits;
    }

    return bits;
  }
}
