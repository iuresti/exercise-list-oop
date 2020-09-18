package uaslp.enginering.labs.list;

import uaslp.enginering.labs.model.Student;

public class ArrayList {

    public enum InsertPosition {
        BEFORE,
        AFTER
    }


    public class Iterator {

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndex;
        }

        public Student next() {
            return students[currentIndex++];
        }

    }


    public static final int DEFAULT_SIZE = 2;

    private Student[] students;
    private int lastIndex;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int initialSize) {
        lastIndex = 0;
        students = new Student[initialSize];
    }

    public void add(Student student) {

        if (lastIndex == students.length) {
            increaseArraySize();
        }

        students[lastIndex++] = student;
    }

    public void delete(Student student) {
        for (int index = 0; index < lastIndex; index++) {
            if (students[index].equals(student)) {
                delete(index);
                break;
            }
        }
    }

    public void delete(int index) {
        if (lastIndex - index > 0 && index >= 0) {
            lastIndex--;
            System.arraycopy(students, index + 1, students, index, lastIndex - index);
        }
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return lastIndex;
    }

    public Student getAt(int index) {
        return index < lastIndex ? students[index] : null;
    }

    public void insert(Student reference, Student newStudent, InsertPosition insertPosition) {

        if (lastIndex == students.length) {
            increaseArraySize();
        }

        for (int index = 0; index < lastIndex; index++) {
            if (students[index].equals(reference)) {
                if (insertPosition.equals(InsertPosition.BEFORE)) {
                    for (int j = lastIndex; j > index; j--) {
                        students[j] = students[j - 1];
                    }
                    students[index] = newStudent;
                } else {
                    for (int j = lastIndex; j > index + 1; j--) {
                        students[j] = students[j - 1];
                    }
                    students[index + 1] = newStudent;
                }
                break;
            }
        }
        lastIndex++;
    }

    private void increaseArraySize() {
        Student[] newArray = new Student[students.length * 2];

        System.arraycopy(students, 0, newArray, 0, students.length);

        students = newArray;
    }
}
