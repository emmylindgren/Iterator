package se.umu.cs.emli;
import se.umu.cs.apjava.DoubleLinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator-class for DoubleLinkedList.
 * @param <T>,  The type of the elements in the list.
 * @author Emmy Lindgren, id19eln.
 */
public class DoubleLinkedListIterator<T> implements Iterator<T> {
    private final DoubleLinkedList<T> list;
    private DoubleLinkedList.Position currentPosition;

    public DoubleLinkedListIterator(DoubleLinkedList<T> list){
        this.list = list;
        this.currentPosition = list.first();
    }

    @Override
    public boolean hasNext() {
        return currentPosition != list.end();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T value = list.inspect(currentPosition);
        currentPosition = list.next(currentPosition);
        return value;
    }
}
