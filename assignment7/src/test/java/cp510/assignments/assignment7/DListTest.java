package cp510.assignments.assignment7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DListTest {

    @Test
    void isEmpty() {
        DList list = new DList();
        DNode head = new DNode("test");
        assertTrue(list.isEmpty());
        list.addBefore(head);
        assertFalse(list.isEmpty());
        head.remove();
        assertTrue(list.isEmpty());
    }

    @Test
    void removeAll() {
        DList list = new DList();
        DNode head = new DNode("test");
        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");

        assertTrue(list.isEmpty());
        list.addBefore(head);
        list.addAfter(node1);
        list.addBefore(node2);
        list.addAfter(node3);

        assertFalse(list.isEmpty());
        list.removeAll();
        assertTrue(list.isEmpty());
    }

    @Test
    void addRemoveHead() {
        DList listTrial = new DList();
        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");
        DNode node4 = new DNode("test4");

        listTrial.addAfter(node1);
        listTrial.addAfter(node2);
        listTrial.addAfter(node3);

        assertTrue(listTrial.size() == 3);
        assertEquals("test3", listTrial.getHead().getData());

        listTrial.removeHead();
        assertTrue(listTrial.size() == 2);
        assertEquals("test2", listTrial.getHead().getData());

        listTrial.addHead(node4);
        assertEquals("test4", listTrial.getHead().getData());
    }

    @Test
    void removeTail() {
        DList list = new DList();
        DNode[] testNodes = new DNode[5];
        int limit = testNodes.length;
        for (int inx = 0; inx < limit; ++inx) {
            testNodes[inx] = new DNode(inx);
            list.addTail(testNodes[inx]);
            assert (testNodes[inx].getNext() == list);
        }

        for (int inx = limit - 1; inx >= 0; --inx) {
            DNode node = list.removeTail();
            assertEquals(testNodes[inx], node);
        }

        assertEquals(list, list.removeTail());
        assertTrue(list.isEmpty());
    }

//    @Test
//    void addTail1() {
//        DList list = new DList();
//        DNode[] testNodes = new DNode[5];
//        int limit = testNodes.length;
//        for (int inx = 0; inx < limit; ++inx) {
//            testNodes[inx] = new DNode(inx);
//            list.addTail(testNodes[inx]);
//            assert (testNodes[inx].getNext() == list);
//        }
//
//        assertEquals(testNodes[0], list.getHead());
//        assertEquals(testNodes[limit - 1], list.getTail());
//        for (int inx = 0; inx < limit - 1; ++inx) {
//            DNode currNode = testNodes[inx];
//            DNode expNext = testNodes[inx + 1];
//            assertEquals(expNext, currNode.getNext());
//        }
//        assertEquals(list, testNodes[limit - 1].getNext());
//    }
//
//    @Test
//    void addTail2() {
//        DList list = new DList();
//        DNode[] testNodes = new DNode[5];
//        int limit = testNodes.length;
//        for (int inx = 0; inx < limit; ++inx) {
//            testNodes[inx] = new DNode(inx);
//            list.addTail(testNodes[inx]);
//            assert (testNodes[inx].getNext() == list);
//        }
//
//        int count = 0;
//        for (DNode node = list.getHead(); node != list; node = node.getNext()) {
//            Object obj = node.getData();
//            assertTrue(obj instanceof Integer);
//            assertEquals(count++, (Integer) obj);
//        }
//        assertEquals(list, testNodes[limit - 1].getNext());
//    }

}
