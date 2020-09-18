package uaslp.enginering.labs;

import uaslp.enginering.labs.list.ArrayList;
import uaslp.enginering.labs.list.OtherIterator;
import uaslp.enginering.labs.model.Student;

public class Main {

    // String pool

    public static void main(String[] args) {
        ArrayList group1 = new ArrayList();


        group1.add(new Student("Ivan"));
        group1.add(new Student("Mario"));
        group1.add(new Student("Juan"));

        OtherIterator iterator = new OtherIterator(group1);

        while(iterator.hasNext()){
            Student student = iterator.next();

            System.out.println(student.getName());
        }


    }
}
