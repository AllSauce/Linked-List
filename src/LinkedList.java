import java.util.NoSuchElementException;
/**
 * A singly linked list.
 *
 * @author (Krenar Manxhuka)
 * @version (2021-01-28)
 */
public class LinkedList<T> {
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.

    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        ListElement<T> newFirst = new ListElement<T>(element);
        ListElement<T> previousFirst = first;

        if(size > 0)
        {
          newFirst.next = previousFirst;
        }
        else
        {
          last = newFirst;
        }
        first = newFirst;
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
      ListElement<T> newLast = new ListElement<T>(element);
      ListElement<T> previousLast = last;

      if(last != null)
      {
        previousLast.next = newLast;
      }
      else
      {
        first = newLast;
      }
      last = newLast;
      size++;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if(size == 0)
        {
          throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if(size == 0)
        {
          throw new NoSuchElementException("List is empty");
        }
        return last.data;
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if(index >= size || index < 0)
        {
          throw new IndexOutOfBoundsException("Index is either too big or too small");
        }
        else if(index == size -1)
        {
          getLast();
        }

        int temp = 0;
        ListElement<T> element = first;

        while(element != null)
        {

          if(temp == index)
          {
            return element.data;
          }

          temp++;
          element = element.next;

        }

        return null;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if(size == 0)
        {
          throw new NoSuchElementException("List is empty");
        }

        ListElement<T> previousFirst = first;

        first = previousFirst.next;
        size--;
        if(size == 0)
        {
          last = null;
        }

        return previousFirst.data;
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
      if(size == 0){
        return "[]";
      }
      String stringList = "[" + first.data;

      for(ListElement<T> current = first.next; current != null; current = current.next)
      {
        stringList += ", ";
        stringList += current.data;
      }
      stringList += "]";
      System.out.println(stringList);

      return stringList;
    }
}
