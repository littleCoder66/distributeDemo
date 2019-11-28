import org.junit.Test;

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

    @Test
    public void name() {
        System.out.println("junit test");
    }

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

    @Test
    public void StringTest(){
        String s1= "abc";
        String s2=new String("abc");
        String s3 = "abc";
        System.out.println(s1==s2);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s3));
    }
}
