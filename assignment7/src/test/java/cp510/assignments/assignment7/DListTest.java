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
    void addAndRemoveHead() {
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
        assertEquals("test4", listTrial.removeHead().getData());
    }

    @Test
    void addAndRemoveTail() {
        DList list = new DList();
        DNode[] nodes = new DNode[5];
        int length = nodes.length;

        for (int i = 0; i < length; i++) {
            nodes[i] = new DNode(i);
            list.addTail(nodes[i]);
            assert (nodes[i].getNext() == list);
        }

        for (int i = length - 1; i >= 0; i--) {
            DNode node = list.removeTail();
            assertEquals(nodes[i], node);
        }
        assertEquals(list, list.removeTail());
    }

    @Test
    void getHeadAndGetTail() {
        DList list = new DList();
        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");
        DNode node4 = new DNode("test4");

        list.addHead(node1);
        assertEquals("test1", list.getHead().getData());

        list.addHead(node2);
        assertEquals("test2", list.getHead().getData());

        list.addTail(node3);
        assertEquals("test3", list.getTail().getData());

        list.addTail(node4);
        assertEquals("test4", list.getTail().getData());
    }

    @Test
    void size() {
        DList listTrial = new DList();
        DNode node1 = new DNode("test1");
        DNode node2 = new DNode("test2");
        DNode node3 = new DNode("test3");
        DNode node4 = new DNode("test4");

        listTrial.addAfter(node1);
        listTrial.addHead(node2);
        listTrial.addBefore(node3);

        assertEquals(3, listTrial.size());

        listTrial.removeHead();
        assertEquals(2, listTrial.size());

        listTrial.addTail(node4);
        assertEquals(3, listTrial.size());
    }

}
