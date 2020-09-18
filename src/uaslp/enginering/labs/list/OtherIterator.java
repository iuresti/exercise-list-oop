package uaslp.enginering.labs.list;

import uaslp.enginering.labs.model.Student;

public class OtherIterator {

    private ArrayList arrayList;
    private int currentIndex;

    public OtherIterator(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public boolean hasNext() {
        return currentIndex < arrayList.size();
    }

    public Student next() {
        return arrayList.getAt(currentIndex++);
    }
}
