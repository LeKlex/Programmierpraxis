/**
 * AsciiStack
 *
 * Represents a Stack within a Node class to handle multiple image versions
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class AsciiStack {

    /**
     * Head-Element of Stack
     */
    private AsciiStackNode head;

    /**
     * Constructor
     */
    public AsciiStack() {
        //Init head element with null
        this.head = null;
    }

    /**
     * Returns if stack is empty
     * @return
     */
    public boolean empty() {
        return (head == null);
    }

    /**
     * Returns head element and removes it
     * @return
     */
    public AsciiImage pop() {
        if (!empty()) {
            AsciiImage retImg = head.getImage();
            head = head.getNext();
            return retImg;
        }
        return null;
    }

    /**
     * Returns head element
     * @return
     */
    public AsciiImage peek() {
        return head.getImage();
    }

    /**
     * Add new element
     * @param img
     */
    public void push(AsciiImage img) {
        //chain old head as next-element of new head element
        head = new AsciiStackNode(img, head);
    }

    /**
     * Returns stack size
     * @return Stack size
     */
    public int size() {
        return (empty()) ? 0 : head.size();
    }

    /**
     * Node Elements of Stack
     */
    private class AsciiStackNode {

        /**
         * Contains the ref. to Image
         */
        final private AsciiImage img;

        /**
         * Contains ref. to next entry
         */
        private AsciiStackNode next = null;

        /**
         * Constructor
         * @param image Image to store
         * @param next Next node element
         */
        public AsciiStackNode(AsciiImage image, AsciiStackNode next) {
            this.img = image;
            this.next = next;
        }

        /**
         * Returns the image
         * @return
         */
        public AsciiImage getImage() {
            return img;
        }

        /**
         * Returns the next element
         * @return
         */
        public AsciiStackNode getNext() {
            return next;
        }

        /**
         * Count recursive
         * @return size of stack
         */
        public int size() {
            //Return count of all subnodex +1 for actual node
            return ((getNext() != null ) ? getNext().size() : 0) + 1;
        }
    }

}