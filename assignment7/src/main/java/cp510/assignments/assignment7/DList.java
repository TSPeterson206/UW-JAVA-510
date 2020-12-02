package cp510.assignments.assignment7;

/**
 * The DList class for UW java 510 assignment 7.
 * 
 * The DList class is an encapuslating class that handles the operations for a
 * circular, doubly-linked list. This class is mainly concerned with the list
 * itself. It works in tandem with the DNode subclass that handles operations
 * concerned with the individual nodes. It has no properties other than those
 * inherited from the superclass. It has no constructors other than the default.
 * 
 * @author Toby Peterson.
 */
public class DList extends DNode {

    /**
     * The addHead method for DList. It adds the given node to the head of this
     * list.
     * 
     * @param node The given node to be added.
     */
    public void addHead(DNode node) {
        addAfter(node);
    };

    /**
     * The addTail method for DList. It adds the given node to the tail of this
     * list.
     * 
     * @param node The given node to be added.
     */
    public void addTail(DNode node) {
        addBefore(node);
    };

    /**
     * The removeHead method for DList. It removes the first node from the list
     * and returns it. If the list is empty this is returned.
     * 
     * @return DNode
     */
    public DNode removeHead() {
        DNode head = getNext();
        return head.remove();
    };

    /**
     * The removeTail method for DList. It removes the last node from the list
     * and returns it. If the list is empty this is returned.
     * 
     * @return DNode
     */
    public DNode removeTail() {
        DNode head = getPrevious();
        return head.remove();
    };

    /**
     * The getHead method for DList. It returns the first node in the list
     * (without removing it). If the list is empty this is returned.
     * 
     * @return DNode
     */
    public DNode getHead() {
        return getNext();
    };

    /**
     * The getTail method for DList. It returns the last node in the list
     * (without removing it). If the list is empty this is returned.
     * 
     * @return DNode
     */
    public DNode getTail() {
        return getPrevious();
    };

    /**
     * The removeAll method for DList. It removes all items from the list,
     * leaving the list empty.
     */
    public void removeAll() {
        DNode node;
        while ((node = getNext()) != this)
            node.remove();
    };

    /**
     * The isEmpty method for DList. It returns true if this list is empty,
     * false otherwise.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    };

    /**
     * The size method for DList. It returns the number of nodes in this list.
     * 
     * @return int
     */
    public int size() {
        int count = 0;
        DNode node = getHead();
        while (node != this) {
            ++count;
            node = node.getNext();
        }
        return count;
    };
}