package person;

import java.util.Collection;

public class PersonChecker implements person.Checker<Person> {
//    public class CatChecker implements person.Checker<Person> {

        public boolean check(Person p) {
            return (p.getId() == 1); // or whatever, implement your comparison here

        }
//    }

public static <E> Collection<E> findAll(Collection<E> coll, person.Checker<E> chk) {
        MyArrayList<E> l = new MyArrayList<E>();
        for (E obj : coll) {
            if (chk.check(obj))
                l.add(obj);
        }
        return l;
    }

}