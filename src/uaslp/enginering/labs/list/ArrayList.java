package uaslp.enginering.labs.list;

public class ArrayList<T> implements List<T> {

    public class ArrayListIterator<T> implements Iterator<T>{

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndexForTheTEst;
        }

        public T next() {
            return (T)elements[currentIndex++];
        }

    }


    public static final int DEFAULT_SIZE = 2;

    private Object[] elements;
    private int lastIndexForTheTEst;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int initialSize) {
        lastIndexForTheTEst = 0;
        elements = new Object[initialSize];
    }

    public void add(T element) {

        if (lastIndexForTheTEst == elements.length) {
            increaseArraySize();
        }

        elements[lastIndexForTheTEst++] = element;
    }

    public void delete(T element) {
        for (int index = 0; index < lastIndexForTheTEst; index++) {
            if (elements[index].equals(element)) {
                delete(index);
                break;
            }
        }
    }

    public void delete(int index) {
        if (lastIndexForTheTEst - index > 0 && index >= 0) {
            lastIndexForTheTEst--;
            System.arraycopy(elements, index + 1, elements, index, lastIndexForTheTEst - index);
        }
    }

    public Iterator<T> getIterator() {
        return new ArrayListIterator<>();
    }

    public int size() {
        return lastIndexForTheTEst;
    }

    public T getAt(int index) {
        return index < lastIndexForTheTEst ? (T)elements[index] : null;
    }

    public void insert(T reference, T newStudent, InsertPosition insertPosition) {

        if (lastIndexForTheTEst == elements.length) {
            increaseArraySize();
        }

        for (int index = 0; index < lastIndexForTheTEst; index++) {
            if (elements[index].equals(reference)) {
                if (insertPosition.equals(InsertPosition.BEFORE)) {
                    for (int j = lastIndexForTheTEst; j > index; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index] = newStudent;
                } else {
                    for (int j = lastIndexForTheTEst; j > index + 1; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index + 1] = newStudent;
                }
                break;
            }
        }
        lastIndexForTheTEst++;
    }

    private void increaseArraySize() {
        Object[] newArray = new Object[elements.length * 2];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }
}
