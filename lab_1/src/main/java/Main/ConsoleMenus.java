package Main;

import person.Person;
import repository.MyArrayList;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ConsoleMenus {
    public Manager manager = new Manager();
    private MyArrayList array = new MyArrayList();
    InputCorrect inpputCorrect =new InputCorrect();
    static int currentCount = -1;
    static Scanner in = new Scanner(System.in);

    public int getPersonName(String name) {
        for (int i = 0; i < array.Count(); i++) {
            Person p = array.get(i);
//                if (p.getSurName().equalsIgnoreCase(name)) {
            if (p.getSurName().compareToIgnoreCase(name) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonSurname(String surname) {
        for (int i = 0; i < array.Count(); i++) {
            Person p;
            p = array.get(i);
            if (p.getSurName().compareToIgnoreCase(surname) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonAge(int age) {
        for (int i = 0; i < array.Count(); i++) {
            Person p = array.get(i);
            if (p.getSurName().compareTo(String.valueOf(age)) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonDate(LocalDate Date) {
        for (int i = 0; i < array.Count(); i++) {
            Person p = array.get(i);
            if (p.getBirthday().compareTo(Date) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public void helpSearchMenu() {
        int selectedNumber = -1;
        do {
            System.out.println("Поиск по: ");
            System.out.println("1 - Имени человека  ");
            System.out.println("2 - Возрасту человека ");
            System.out.println("3 - Дате рождения человека ");
            System.out.println("0 - Выход в главное меню");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 5);
        searchMenu(selectedNumber);
    }

    public void  searchMenu(int selectValue) {
        switch (selectValue) {
            case 1: {
                String name = inpputCorrect.inputString("Введите имя");
                array.findOn(name);
                manager.outputAllPerson(array);
//                System.out.println(array.findOn(name).toString());
//                array.get(0);
//                MyArrayList arrayTmp = new MyArrayList();
//                for (int i = 0; i < array.Count(); i++) {
//
//                    if (!(getPersonName(name) == -1))
//                        arrayTmp.add(array.get(getPersonName(name) - 1));
//                }
//                if (arrayTmp.Count() == 0)
//                    System.out.println("Пользователей с таким именем не найдено");
//                else
//                    manager.outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 2:{
                int age = inpputCorrect.inputInteger("Введите возраст человека",0,2018);
                MyArrayList arrayTmp = new MyArrayList();
                for (int i = 0; i < array.Count(); i++) {
                    if (!(getPersonAge(age) == -1))
                        arrayTmp.add(array.get(getPersonAge(age) - 1));
                }
                if (arrayTmp.Count() == 0)
                    System.out.println("Пользователей с таким именем не найдено");
                else
                    manager.outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 3: {
                LocalDate currentDate = LocalDate.now();
                int iYear = inpputCorrect.inputInteger("Введите год рождения", 0, currentDate.getYear());
                int iMonth = inpputCorrect.inputInteger("Введите месяц рождения", 0, 12);
                Calendar mycal = new GregorianCalendar(iYear, iMonth - 1, 1);
                int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
                int iDay = inpputCorrect.inputInteger("Введите день рождения", 0, daysInMonth);
                LocalDate LDate = LocalDate.of(iYear, iMonth, iDay);

                MyArrayList arrayTmp = new MyArrayList();
                for (int i = 0; i < array.Count(); i++) {
                    if (!(getPersonDate(LDate) == -1))
                        arrayTmp.add(array.get(getPersonDate(LDate) - 1));
                }
                if (arrayTmp.Count() == 0)
                    System.out.println("Пользователей с такой датой рождения не найдено");
                else
                    manager.outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 0: {
                helpMainMenu();
            }
        }
    }

    public void helpMainMenu() {
        int selectedNumber = -1;
        do {
            System.out.println("Выбор: ");
            System.out.println("1 - Добавить человека ");
            System.out.println("2 - Посмотреть человека  ");
            System.out.println("3 - Удалить человека  ");
            System.out.println("4 - Посмотреть всех ");
            System.out.println("5 - Отсортировать ");
            System.out.println("0 - Выход ");
            System.out.println("___________________________________");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 5);
        mainMenu(selectedNumber);
    }

    public void mainMenu(int selectValue) {

        switch (selectValue) {
            case 1: {
                manager.inputPerson(array);
                helpMainMenu();
                break;
            }
            case 2: {

                int currentCount = inpputCorrect.inputInteger("Введите номер человека, которого хотите посмотреть",0 ,array.Count() );
                manager.outputPerson(currentCount-1, array);
//                array.sort((a,b)->(a.getId()-b.getId()));
                helpMainMenu();
                break;
            }
            case 3: {
                int currentCount = inpputCorrect.inputInteger("Введите номер человека, которого хотите удалить",0 ,array.Count() );
                manager.delPersonById(array,currentCount);
                helpMainMenu();
                break;
            }
            case 4: {
                manager.outputAllPerson(array);
                helpMainMenu();
                break;
            }
            case 5: {
                helpSearchMenu();
                break;
            }
            case 0:
                return;

        }
    }
}
