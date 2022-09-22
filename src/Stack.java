import java.util.EmptyStackException;

public class Stack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> previous;

        public Node(E e) {
            this.element = e;
        }
    }

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }

    public E pop() {
        ensureNonEmpty();
        E element = this.top.element;
        Node<E> temp = this.top.previous;
        this.top.previous = null;
        this.top = temp;
        this.size--;
        return element;
    }

    public void ensureNonEmpty() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
    }

}
