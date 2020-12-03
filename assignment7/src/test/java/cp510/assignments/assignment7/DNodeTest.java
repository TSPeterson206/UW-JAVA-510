package cp510.assignments.assignment7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DNodeTest {

    @Test
    void remove() {
        DNode nodeA = new DNode("test1");
        DNode nodeB = new DNode("test2");
        DNode nodeC = new DNode("test3");
        DNode nodeD = new DNode("test4");
        DNode nodeE = new DNode("test5");

        nodeA.addAfter(nodeB);
        nodeB.addAfter(nodeC);
        nodeC.addAfter(nodeD);
        nodeD.addAfter(nodeE);

        assertEquals(nodeA.getNext(), nodeB);
        assertEquals(nodeB.getNext(), nodeC);
        assertEquals(nodeC.getNext(), nodeD);
        assertEquals(nodeD.getNext(), nodeE);

        assertEquals(nodeB.getPrevious(), nodeA);
        assertEquals(nodeC.getPrevious(), nodeB);
        assertEquals(nodeD.getPrevious(), nodeC);
        assertEquals(nodeE.getPrevious(), nodeD);

        nodeA.remove();
        assertFalse(nodeA.isEnqueued());
        assertEquals(nodeB.getNext(), nodeC);
        assertEquals(nodeB.getPrevious(), nodeE);

        nodeE.remove();
        assertFalse(nodeE.isEnqueued());
        assertEquals(nodeB.getNext(), nodeC);
        assertEquals(nodeB.getPrevious(), nodeD);
        assertEquals(nodeD.getNext(), nodeB);

        nodeC.remove();
        assertFalse(nodeC.isEnqueued());
        assertEquals(nodeB.getNext(), nodeD);
        assertEquals(nodeB.getPrevious(), nodeD);
        assertEquals(nodeD.getNext(), nodeB);
        assertEquals(nodeD.getPrevious(), nodeB);

        nodeD.remove();
        assertFalse(nodeB.isEnqueued());
        assertFalse(nodeD.isEnqueued());

        nodeB.addAfter(nodeD);
        assertEquals(nodeB.getNext(), nodeD);
        assertEquals(nodeD.getPrevious(), nodeB);

        nodeB.remove();
        assertFalse(nodeB.isEnqueued());
        assertFalse(nodeD.isEnqueued());

        DNode nodeF = new DNode("test6");
        assertFalse(nodeF.isEnqueued());

        nodeF.remove();
        assertFalse(nodeF.isEnqueued());

        DNode nodeG = new DNode();
        DNode nodeH = new DNode();
        assertFalse(nodeG.isEnqueued());
        assertFalse(nodeH.isEnqueued());

        nodeG.addAfter(nodeH);
        assertTrue(nodeG.isEnqueued());
        assertTrue(nodeH.isEnqueued());
    }

    @Test
    void testExpectedExceptionEnqueuedAddAfter() {
        DList list = new DList();

        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");

        list.addAfter(node1);
        list.addAfter(node2);
        list.addAfter(node3);

        Assertions.assertThrows(IllegalArgumentException.class,
            new Executable() {
                public void execute() throws Throwable {
                    list.addAfter(node2);
                }
            });
    }

    @Test
    void testExpectedExceptionEnqueuedAddBefore() {
        DList list = new DList();

        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");

        list.addAfter(node1);
        list.addAfter(node2);
        list.addAfter(node3);

        Assertions.assertThrows(IllegalArgumentException.class,
            new Executable() {
                public void execute() throws Throwable {
                    list.addBefore(node2);
                }
            });
    }

    @Test
    void addAfter() {
        DNode left = new DNode();
        DNode right = new DNode();
        DNode middle = new DNode();
        DNode term = new DNode();

        left.addAfter(right);
        assertEquals(right, left.getNext());
        assertEquals(right, left.getPrevious());
        assertEquals(left, right.getNext());
        assertEquals(left, right.getPrevious());

        left.addAfter(middle);
        assertEquals(middle, left.getNext());
        assertEquals(right, left.getPrevious());
        assertEquals(right, middle.getNext());
        assertEquals(left, middle.getPrevious());
        assertEquals(left, right.getNext());
        assertEquals(middle, right.getPrevious());

        right.addAfter(term);
        assertEquals(term, right.getNext());
        assertEquals(middle, right.getPrevious());
        assertEquals(right, term.getPrevious());
        assertEquals(left, term.getNext());
    }

    @Test
    void addBefore() {
        DNode left = new DNode();
        DNode right = new DNode();
        DNode middle = new DNode();
        DNode term = new DNode();

        right.addBefore(left);
        assertEquals(right, left.getNext());
        assertEquals(right, left.getPrevious());
        assertEquals(left, right.getNext());
        assertEquals(left, right.getPrevious());

        right.addBefore(middle);
        assertEquals(middle, left.getNext());
        assertEquals(right, left.getPrevious());
        assertEquals(right, middle.getNext());
        assertEquals(left, middle.getPrevious());
        assertEquals(left, right.getNext());
        assertEquals(middle, right.getPrevious());

        right.addBefore(term);
        assertEquals(right, term.getNext());
        assertEquals(left, middle.getPrevious());
        assertEquals(term, right.getPrevious());
        assertEquals(middle, left.getNext());
    }

    @Test
    void getNextAndGetPrevious() {
        DList list = new DList();

        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");

        list.addHead(node1);
        list.addAfter(node2);
        list.addAfter(node3);

        assertEquals("test2", node1.getPrevious().getData());
        assertEquals(null, node1.getNext().getData());
        assertEquals("test3", node2.getPrevious().getData());
        assertEquals("test1", node2.getNext().getData());
        assertEquals(null, node3.getPrevious().getData());
        assertEquals("test2", node3.getNext().getData());
    }

    @Test
    void addTail1() {
        DList list = new DList();
        DNode[] nodes = new DNode[5];
        int length = nodes.length;
        for (int i = 0; i < length; i++) {
            nodes[i] = new DNode(i);
            list.addTail(nodes[i]);
            assert (nodes[i].getNext() == list);
        }

        assertEquals(nodes[0], list.getHead());
        assertEquals(nodes[length - 1], list.getTail());
        for (int i = 0; i < length - 1; i++) {
            DNode currentNode = nodes[i];
            DNode expected = nodes[i + 1];
            assertEquals(expected, currentNode.getNext());
        }
        assertEquals(list, nodes[length - 1].getNext());
    }

    @Test
    void addTail2() {
        DList list = new DList();
        DNode[] nodes = new DNode[5];
        int limit = nodes.length;
        for (int i = 0; i < limit; i++) {
            nodes[i] = new DNode(i);
            list.addTail(nodes[i]);
            assert (nodes[i].getNext() == list);
        }

        int count = 0;
        for (DNode node = list.getHead(); node != list; node = node.getNext()) {
            Object obj = node.getData();
            assertTrue(obj instanceof Integer);
            assertEquals(count++, (Integer) obj);
        }
        assertEquals(list, nodes[limit - 1].getNext());
    }

    @Test
    void getAndSetData() {
        DNode node1 = new DNode();
        node1.setData("sampleData");
        assertEquals("sampleData", node1.getData());
    }

    @Test
    void isEnqueued() {
        DNode nodeA = new DNode("test1");
        DNode nodeB = new DNode("test2");
        DNode nodeC = new DNode("test3");
        DNode nodeD = new DNode("test4");
        DNode nodeE = new DNode("test5");

        nodeA.addAfter(nodeB);
        nodeB.addAfter(nodeC);
        nodeC.addAfter(nodeD);
        nodeD.addAfter(nodeE);
        assertEquals(true, nodeA.isEnqueued());
        assertEquals(true, nodeB.isEnqueued());
        assertEquals(true, nodeC.isEnqueued());
        assertEquals(true, nodeD.isEnqueued());
        assertEquals(true, nodeE.isEnqueued());

        nodeB.remove();

        assertEquals(true, nodeA.isEnqueued());
        assertEquals(false, nodeB.isEnqueued());
        assertEquals(true, nodeC.isEnqueued());

        nodeD.remove();
        assertEquals(false, nodeD.isEnqueued());
        assertEquals(true, nodeE.isEnqueued());

    }
}
