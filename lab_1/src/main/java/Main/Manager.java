package Main;

import person.Person;
import repository.MyArrayList;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Manager {

    static int currentCount = -1;
    static Scanner in = new Scanner(System.in);

    public void addPerson(MyArrayList array,Person p) {
        array.add(p);
    }

    public Person getPerson(MyArrayList array,int id) {
        return array.get(id);
    }

    public void delPersonById(MyArrayList array,int id)
    {
        array.removeAt(id - 1);
    }
    public void inputPerson(MyArrayList array) {
        int i = array.Count();
        i++;
        System.out.println("Введите данные для " + i + " человека");
        i--;

        InputCorrect inpputCorrect =new InputCorrect();

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
//        Person p = new Person(name, surname, selectGender, iYear, iMonth, iDay);
        addPerson(array,p);
    }

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

    public void outputAllPerson(MyArrayList arrayTmp) {
        if (!tryGet(arrayTmp)) {
            for (int i = 0; i < arrayTmp.Count(); i++)
                outputPerson(i, arrayTmp);
        } else System.out.println("Список людей пуст ");
    }

    public boolean tryGet(MyArrayList array) {
        return array.Count() == 0;

    }




}
