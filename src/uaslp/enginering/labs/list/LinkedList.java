package uaslp.enginering.labs.list;

public class LinkedList<T> {
    public enum InsertPosition {
        BEFORE,
        AFTER
    }


    public class Iterator {

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndex;
        }

        public T next() {
            return (T)elements[currentIndex++];
        }

    }


    public static final int DEFAULT_SIZE = 2;

    private Object[] elements;
    private int lastIndex;

    public LinkedList() {
        this(DEFAULT_SIZE);
    }

    public LinkedList(int initialSize) {
        lastIndex = 0;
        elements = new Object[initialSize];
    }

    public void add(T element) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        elements[lastIndex++] = element;
    }

    public void delete(T element) {
        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(element)) {
                delete(index);
                break;
            }
        }
    }

    public void delete(int index) {
        if (lastIndex - index > 0 && index >= 0) {
            lastIndex--;
            System.arraycopy(elements, index + 1, elements, index, lastIndex - index);
        }
    }

    public LinkedList.Iterator getIterator() {
        return new LinkedList.Iterator();
    }

    public int size() {
        return lastIndex;
    }

    public T getAt(int index) {
        return index < lastIndex ? (T)elements[index] : null;
    }

    public void insert(T reference, T newStudent, ArrayList.InsertPosition insertPosition) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(reference)) {
                if (insertPosition.equals(ArrayList.InsertPosition.BEFORE)) {
                    for (int j = lastIndex; j > index; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index] = newStudent;
                } else {
                    for (int j = lastIndex; j > index + 1; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index + 1] = newStudent;
                }
                break;
            }
        }
        lastIndex++;
    }

    private void increaseArraySize() {
        Object[] newArray = new Object[elements.length * 2];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }
}
