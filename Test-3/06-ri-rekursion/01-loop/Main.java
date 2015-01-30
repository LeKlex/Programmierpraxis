

public class Main {

  public static final int N = 10;
  public static int sum;
  public static int level;

  public static void main(String[] args) {
    // loop: work, next
    reset();
    for (int i = 0; i < N; i = next(i)) {
      work(i);
    }
    printResult();

    // tail recursion: work, next
    reset();  // level=0, sum=0
    workThenNext(0);
    printResult();

    // head recursion: next, work
    reset();
    nextThenWork(0);
    printResult();
  }

    public static void workThenNext(int i) {
    	level++;
    	if ( i < N ) {
    		work(i);
    		workThenNext(next(i));
    	}
    	level--;
    }

  public static void nextThenWork(int i) {
    level++;
    	if ( i < N ) {
    		nextThenWork(next(i));
    		work(i);
    	}
    level--;
  }

  public static int next(int i) {
    System.out.println(padding() + "next(" + i + ")");
    return i + 1;
  }

  public static void work(int i) {
    System.out.println(padding() + "work(" + i + ")");
    sum += i;
  }

  public static void reset() {
    level = 0;
    sum = 0;
  }

  public static String padding() {
    String pad = "";
    for (int i = 1; i < level; i++) {
      pad += "  ";
    }
    return pad;
  }

  public static void printResult() {
    System.out.println("sum = " + sum + "\n");
  }
}
