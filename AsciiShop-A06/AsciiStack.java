import java.util.Arrays;

/**
 * Class Ascii Point (Unit AsciiShop 6)
 *
 * Class represents a Stack with dynamic size, and will be used for "undo"
 * actions on AsciiImage.
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class AsciiStack {

    /**
     * Increment for capacity
     */
    private final int increment;

    /**
     * Array of AsciiImage, used as internal Stack
     */
    private AsciiImage[] stack;

    /**
     * Actual stack position
     */
    private Integer stackPos = -1;

    /**
     * Standard Constructor with increment
     *
     * @param increment int
     */
    public AsciiStack(int increment) {
        this.increment = increment;
        //Create new Stack with "increment" size
        this.stack = new AsciiImage[increment];
    }

    /**
     * Returns the capacity of the stack
     *
     * @see #stack
     * @return int stack capacity
     */
    public int capacity() {
        return stack.length;
    }

    /**
     * Returns if the stack is empty or not
     *
     * @return boolean
     */
    public boolean empty() {
        return (stackPos == -1);
    }

    /**
     * Peaks the top element of stack and returns it. Stack will be unchanged!
     * @return AsciiImage  NULL on empty stack
     */
    public AsciiImage peak() {
        return empty() ? null : stack[stackPos];
    }

    /**
     * Pops the top element of stack and returns it. Element will be removed from Stack!
     * @return AsciiImage  NULL on empty stack
     */
    public AsciiImage pop() {
        AsciiImage element = peak(); //Load element from top
        if (null != element) stackPositionClear(stackPos--); //clear top element and decrease position
        capacityDecrease(); //Try decreasing size
        return element;
    }

    /**
     * Push a new AsciiImage element on {@link #stack}
     * @param image AsciiImage
     */
    public void push(AsciiImage image) {
        capacityIncrease(); //Increase if stack is too small
        stack[++stackPos] = image; //put on stack and increase position
    }

    /**
     * Clears a stack position
     * @param position int
     */
    private void stackPositionClear(Integer position) {
        stack[position] = null;
    }

    /**
     * Increase {@link #stack} by size of {@link #increment}
     */
    private void capacityIncrease() {
        if(capacity() < size() + 1) {
            stack = Arrays.copyOf(stack, capacity() + increment);
        }
    }

    /**
     * Tries to decrease {@link #stack} by size of {@link #increment}
     */
    private void capacityDecrease() {
        //If the difference is gt than an increment, we can reduce the stack size
        if (capacity() - size() > increment) {
            stack = Arrays.copyOf(stack, stack.length - increment);
        }
    }

    /**
     * Returns count of elements on {@link #stack}
     *
     * @return int
     */
    public int size() {
        //Prevent returning -1
        return (stackPos < 0 ) ? 0 : stackPos + 1;
    }

}
