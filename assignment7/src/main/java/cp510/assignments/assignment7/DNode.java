package cp510.assignments.assignment7;

/**
 * The DNode class for UW java 510 assignment 7.
 * 
 * The Dnode class is an encapuslating class that creates nodes (objects) to be
 * incorporated into a circular, doubly linked list. This class is mainly
 * concerned with the individual nodes and their respective forward (flink) and
 * backward (blink) links, position in a linked list, as well as the data
 * contained within the node itself. It works in tandem with the DList subclass
 * that handles operations concerned with the assembled list.
 * 
 * @author Toby Peterson.
 */
public class DNode {

    /**
     * flink. This field is a reference to next item in list, or self if
     * unenqueued.
     */
    private DNode flink;

    /**
     * blink. This is a reference to previous item in list, or self if
     * unenqueued.
     */
    private DNode blink;

    /**
     * data. This field is a reference to the data stored in the node.
     */
    private Object data;

    /**
     * The default constructor for DNode. It sets the data property to null, and
     * initializes this object to the unenqueued state.
     */
    public DNode() {
        this(null);
    };

    /**
     * The parameterized constructor for DNode. It takes in the data for the
     * newly instantiated node. It also sets the flink and blink to itself, thus
     * making it into an unenqueued state.
     * 
     * @param data The data that the newly-instantiated object should contain.
     */
    public DNode(Object data) {
        flink = this;
        blink = this;
        setData(data);

    };

    /**
     * The getData method for DNode. This is the way to get the data from the
     * node.
     * 
     * @return Object The data contained within the node.
     */
    public Object getData() {
        return this.data;
    }

    /**
     * The setData method for DNode. This is the method used to set the data for
     * the node.
     * 
     * @param data The data contained within the node object.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * The isEnqueued method for DNode. This method returns a boolean stating
     * whether or not the node is enqueued as part of a list.
     * 
     * @return boolean
     */
    public boolean isEnqueued() {
        boolean result = this != flink;
        return result;
    };

    /**
     * The addAfter method for DNode. This method adds a node to a circular,
     * doubly-linked list. It specifically adds the node after this node.
     * 
     * @param node The node to be placed after this node.
     * @throws IllegalArgumentException The exception thrown if the selected
     *                                  node is not enqueued.
     */
    public void addAfter(DNode node) throws IllegalArgumentException {
        if (node.isEnqueued()) {
            throw new IllegalArgumentException();
        }
        node.blink = this;
        node.flink = this.flink;
        node.flink.blink = node;
        this.flink = node;
    };

    /**
     * The addBefore method for DNode. This method adds a node to a circular,
     * doubly-linked list. It specifically adds the node before this node.
     * 
     * @param node The node to be placed before this node.
     * @throws IllegalArgumentException The exception thrown if the selected
     *                                  node is not enqueued.
     */
    public void addBefore(DNode node) throws IllegalArgumentException {
        if (node.isEnqueued()) {
            throw new IllegalArgumentException();
        }
        blink.addAfter(node);
    };

    /**
     * The getNext method for DNode. It returns the next node in the list if
     * enqueued. If not enqueued, returns this.
     * 
     * @return DNode
     */
    public DNode getNext() {
        if (this.isEnqueued()) {
            return flink;
        }
        return this;
    };

    /**
     * The getPrevious method for DNode. It returns the previous node in the
     * list if enqueued. If not enqueued, returns this.
     * 
     * @return DNode
     */
    public DNode getPrevious() {
        if (this.isEnqueued()) {
            return blink;
        }
        return this;
    };

    /**
     * The remove method for DNode. It removes this node from the queue that
     * contains it, if any. It is not a mistake if this node is not enqueued.
     * Returns this.
     * 
     * @return this
     */
    public DNode remove() {
        this.blink.flink = this.flink;
        this.flink.blink = this.blink;
        this.flink = this;
        this.blink = this;
        return this;
    };
}