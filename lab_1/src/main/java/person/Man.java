package person;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Man {

    private static MyArrayList<Person> array = new MyArrayList<Person>();
    private Man man;
    static int currentCount = -1;
    static Scanner in = new Scanner(System.in);
    private int capacity = 2;


    public Man() {
        this.capacity = capacity;
        this.array = new MyArrayList<Person>();
    }

    public void addPerson(Person p) {
        array.add(p);
    }

    public static Person getPerson(int id) {
        return array.get(id);
    }

    public static void delPersonById(int id) {
        array.remove(id - 1);
    }


    public static boolean isCorrect(String line) {
        if (line.matches("^[a-z]+$")) {
            return true;
        }
        return false;
    }

    public static void inputPerson(Man man) {
        int i = array.size();
        i++;
        System.out.println("Введите данные для " + i + " человека");
        i--;

        String name;
        do {
            System.out.println("Введите имя");
            assert false;
            name = in.nextLine();
        } while (!isCorrect(name.trim().toLowerCase()));

        String surname;
        do {
            System.out.println("Введите фамилию");
            assert false;
            surname = in.nextLine();
        } while (!isCorrect(surname.trim().toLowerCase()));

        String gender;
        int selectGender;
        do {
            System.out.println("Введите пол: \n0 - Мужской \n1 - Женский ");
            assert false;
            gender = in.nextLine().trim();
            selectGender = Integer.parseInt(gender);
        } while (selectGender < 0 || selectGender > 1);

        LocalDate currentDate = LocalDate.now();
        String yyyy;
        int iYear;
        do {
            System.out.println("Введите год рождения");
            assert false;
            yyyy = in.nextLine().trim();
            iYear = Integer.parseInt(yyyy);
        } while (iYear < 0 || iYear > currentDate.getYear());

        String mm;
        int iMonth;
        do {
            System.out.println("Введите месяц рождения");
            assert false;
            mm = in.nextLine().trim();
            iMonth = Integer.parseInt(mm);
        } while (iMonth < 0 || iMonth > 12);

        String dd;
        int iDay = 1;
        Calendar mycal = new GregorianCalendar(iYear, iMonth - 1, iDay);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        do {
            System.out.println("Введите день рождения");
            assert false;
            dd = in.nextLine().trim();
            iDay = Integer.parseInt(dd);
        } while (iDay < 0 || iDay > daysInMonth);

        Person p = new Person(name, surname, selectGender, iYear, iMonth, iDay);
        man.addPerson(p);
    }

    public static boolean tryGet() {
        return array.size() == 0;

    }

    public static void outputPerson(int num) {
        Person p = array.get(num);
        System.out.println("id: " + p.getId());
        System.out.println("Имя: " + p.getName());
        System.out.println("Фамилия: " + p.getSurName());
        System.out.println("Дата рождения: " + p.getBirthday());
        System.out.println("Пол: " + p.toGender());
        System.out.println("Возраст: " + p.getAge());
    }

    public static void outputAllPerson() {
        if (!tryGet()) {
            for (int i = 0; i < array.size(); i++)
                outputPerson(i);
        } else System.out.println("Список людей пуст ");
    }

    public static void helpMenu(Man man) {
        int selectedNumber = -1;
        do {
            System.out.println("Выбор: ");
            System.out.println("1 - Добавить человека ");
            System.out.println("2 - Посмотреть человека  ");
            System.out.println("3 - Удалить человека  ");
            System.out.println("4 - Посмотреть всех ");
            System.out.println("0 - Выход ");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 4);
        mainMenu(selectedNumber, man);
    }

    public static void mainMenu(int selectValue, Man man) {

        switch (selectValue) {
            case 1: {

                inputPerson(man);
                helpMenu(man);
                break;
            }
            case 2: {
                do {
                    System.out.println("Введите номер человека, которого хотите посмотреть");
                    assert false;
                    String line = in.nextLine();
                    currentCount = Integer.parseInt(line) - 1;
                } while (currentCount < 0 || currentCount > array.size());
                outputPerson(currentCount);
//                outputAllPerson();
                helpMenu(man);
                break;
            }
            case 3: {
                System.out.println("Введите номер человека, которого хотите удалить");
                assert false;
                String linedel = in.nextLine();
                currentCount = Integer.parseInt(linedel);
                delPersonById(currentCount);
                helpMenu(man);
                break;
            }
            case 4: {
                outputAllPerson();
                helpMenu(man);
                break;
            }
            case 0:
                return;

        }
    }

    public static void main(String[] args) {
        Man man = new Man();
        helpMenu(man);
    }
}