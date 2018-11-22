package Main;

import person.Person;
import repository.MyArrayList;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Manager class - helper for ConsoleMenus class
 */
public class Manager {

    /**
     * add Person in arraymas
     * @param array - my array list create repository
     * @param p - object type p
     */
    public void addPerson(MyArrayList array, Person p) {
        array.add(p);
    }

    /**
     * delete person by id in array list
     * @param array - my array list create repository
     * @param id - id type int for search by delete
     */
    public void delPersonById(MyArrayList array, int id) {
        array.removeAt(id - 1);
    }

    /**
     * method to enter a person with all his fields
     * @param array - my array list create repository
     */
    public void inputPerson(MyArrayList array) {
        int i = array.Count();
        i++;
        System.out.println("Введите данные для " + i + " человека");
        i--;

        InputCorrect inpputCorrect = new InputCorrect();

        String name = inpputCorrect.inputString("Введите имя");
        String surname = inpputCorrect.inputString("Введите фамилию");
        int selectGender = inpputCorrect.inputInteger("Введите пол: \n0 - Мужской \n1 - Женский ", 0, 1);

        LocalDate currentDate = LocalDate.now();
        int iYear = inpputCorrect.inputInteger("Введите год рождения", 0, currentDate.getYear());
        int iMonth = inpputCorrect.inputInteger("Введите месяц рождения", 0, 12);

        Calendar mycal = new GregorianCalendar(iYear, iMonth - 1, 1);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int iDay = inpputCorrect.inputInteger("Введите день рождения", 0, daysInMonth);
        LocalDate lDate = LocalDate.of(iYear, iMonth, iDay);
        Person p = new Person(name, surname, selectGender, lDate);
        addPerson(array, p);
    }

    /**
     * method for printing a person from a sheet by his number to the console with all its fields
     * @param num - input number of destination that we want to print
     * @param arrayTmp - help array mas
     */
    public void outputPerson(int num, MyArrayList arrayTmp) {
        Person p = (Person) arrayTmp.get(num);
        System.out.println("id: " + p.getId());
        System.out.println("Имя: " + p.getName());
        System.out.println("Фамилия: " + p.getSurName());
        System.out.println("Дата рождения: " + p.getBirthday());
        System.out.println("Пол: " + p.toGender());
        System.out.println("Возраст: " + p.getAge());
        System.out.println("___________________________________");
    }

    /**
     * ethod for printing all a person from a sheet by his number to the console with all its fields
     * @param arrayTmp - help array mas
     */
    public void outputAllPerson(MyArrayList arrayTmp) {
        if (!tryGet(arrayTmp)) {
            for (int i = 0; i < arrayTmp.Count(); i++)
                outputPerson(i, arrayTmp);
        } else System.out.println("Список людей пуст ");
    }

    /**
     * try get obgect in array mas
     * @param array - my array list create repository
     * @return boolean
     */
    public boolean tryGet(MyArrayList array) {
        return array.Count() == 0;

    }


}
