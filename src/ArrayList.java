import java.util.*;

public class ArrayList<E> implements List<E> {
    private final static int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(Object e) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        this.elements[this.size++] = e;
        this.size++;
        return true;
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) this.elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size - 1)
            throw new IndexOutOfBoundsException(String.format("Index out of range %d, %d", index, this.size));
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = (E) this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldElement = (E) this.elements[index];
        shift(index);
        this.size--;
        ensureCapacity();
        return oldElement;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            this.elements = shrink();
        }
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        insert(index, element);
    }

    private void insert(int index, E element) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        E lastElement = this.getElement(this.size - 1);
        for (int i = this.size - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[this.size] = lastElement;
        this.elements[index] = element;
        this.size++;
    }

    private E getElement(int index) {
        return (E) this.elements[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.elements.length; i++){
            if (this.elements[i] == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}