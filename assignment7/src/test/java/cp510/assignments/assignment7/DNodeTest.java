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
//        DList list = new DList();

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
    void addTail1() {
        DList list = new DList();
        DNode[] testNodes = new DNode[5];
        int limit = testNodes.length;
        for (int inx = 0; inx < limit; ++inx) {
            testNodes[inx] = new DNode(inx);
            list.addTail(testNodes[inx]);
            assert (testNodes[inx].getNext() == list);
        }

        assertEquals(testNodes[0], list.getHead());
        assertEquals(testNodes[limit - 1], list.getTail());
        for (int inx = 0; inx < limit - 1; ++inx) {
            DNode currNode = testNodes[inx];
            DNode expNext = testNodes[inx + 1];
            assertEquals(expNext, currNode.getNext());
        }
        assertEquals(list, testNodes[limit - 1].getNext());
    }

    @Test
    void addTail2() {
        DList list = new DList();
        DNode[] testNodes = new DNode[5];
        int limit = testNodes.length;
        for (int inx = 0; inx < limit; ++inx) {
            testNodes[inx] = new DNode(inx);
            list.addTail(testNodes[inx]);
            assert (testNodes[inx].getNext() == list);
        }

        int count = 0;
        for (DNode node = list.getHead(); node != list; node = node.getNext()) {
            Object obj = node.getData();
            assertTrue(obj instanceof Integer);
            assertEquals(count++, (Integer) obj);
        }
        assertEquals(list, testNodes[limit - 1].getNext());
    }
}
