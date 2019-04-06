import java.util.LinkedList;

/**
 * 基础知识学习
 *
 * @author-liudongxu
 * @created 2019-04-06 19:07
 * @param <E> the type of elements held in this collection
 */
public class BasicsTest<E> {
    static transient int size = 0;
    static transient Node first;
    static transient Node last;
    public static void main(String[]args){
        Node e;
        final Node f = first;
        final Node newNode = new Node<>(null, 1, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;

    }
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
