package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("dat1",18));
        persons.add(new Person("dat2",26));
        persons.add(new Person("dat3",19));
        persons.add(new Person("dat4",4));

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return Integer.compare(person.getAge(), t1.getAge());
            }
        };
        Collections.sort(persons, comparator);
    }

    static class Person {
        String name;
        int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
