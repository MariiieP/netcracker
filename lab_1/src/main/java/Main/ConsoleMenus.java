package Main;

import Comparator.PersonAgeComparator;
import Comparator.PersonNameComparator;
import Comparator.PersonlDateComparator;
import repository.MyArrayList;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ConsoleMenus main class of user and program communication
 */
public class ConsoleMenus {

    /**
     * manager - object Manager
     * input/output object
     * @see Manager
     */
    public Manager manager = new Manager();

    /**
     * array - my repository
     * create,add,remove et object
     * @see MyArrayList
     */
    private MyArrayList array = new MyArrayList();

    /**
     * inpputCorrect - object help validate imput
     * @see InputCorrect
     */
    InputCorrect inpputCorrect = new InputCorrect();
    //    static int currentCount = -1;

    /**
     * Scanner in - console input/output
     */
    static Scanner in = new Scanner(System.in);


    /**
     * helpSearchMenu help menu to search for a person by selection
     * return void
     */
    public void helpSortMenu() {
        int selectedNumber = -1;
        do {
            System.out.println("Сортировка по: ");
            System.out.println("1 - Имени человека  ");
            System.out.println("2 - Возрасту человека ");
            System.out.println("3 - Дате рождения человека ");
            System.out.println("0 - Выход в главное меню");
            System.out.println("___________________________________");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 4);
        sortMenu(selectedNumber);
    }

    /**
     * sortMenu - method that calls other methods depending on the selected field
     * 1-search by name
     * 2- by age
     * 3- by date of birth
     * @param selectValue - select value
     * return void
     */
    public void sortMenu(int selectValue) {
        switch (selectValue) {
            case 1: {
                manager.outputAllPerson(array);
                array.sortBy(new PersonNameComparator());
                System.out.println("___________NEW SORT ARRAY__________");
                manager.outputAllPerson(array);
                helpSearchMenu();
                break;
            }
            case 2: {
                manager.outputAllPerson(array);
                array.sortBy(new PersonAgeComparator());
                manager.outputAllPerson(array);
                helpSearchMenu();
                break;
            }
            case 3: {
                manager.outputAllPerson(array);
                array.sortBy(new PersonlDateComparator());
                manager.outputAllPerson(array);
                helpSearchMenu();
                break;
            }
            case 0: {
                helpMainMenu();
            }
        }
    }

    /**
     * helpSearchMenu help menu to search for a person by selection
     * return void
     */
    public void helpSearchMenu() {
        int selectedNumber = -1;
        do {
            System.out.println("Поиск по: ");
            System.out.println("1 - Имени человека  ");
            System.out.println("2 - Возрасту человека ");
            System.out.println("3 - Дате рождения человека ");
            System.out.println("0 - Выход в главное меню");
            System.out.println("___________________________________");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 4);
        searchMenu(selectedNumber);
    }

    /**
     * searchMenu - method that calls other methods depending on the selected field
     * 1-search by name
     * 2- by age
     * 3- by date of birth
     * @param selectValue - select value
     * return void
     */
    public void searchMenu(int selectValue) {
        switch (selectValue) {
            case 1: {
                String name = inpputCorrect.inputString("Введите имя");
                manager.outputAllPerson(array.findOn(name));
                helpSearchMenu();
                break;
            }
            case 2: {
                int age = inpputCorrect.inputInteger("Введите возраст человека", 0, 2018);
                manager.outputAllPerson(array.findOn(age));
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
                LocalDate lDate = LocalDate.of(iYear, iMonth, iDay);

                manager.outputAllPerson(array.findOn(lDate));
                helpSearchMenu();
                break;
            }
            case 0: {
                helpMainMenu();
            }
        }
    }

    /**
     * helpMainMenu help menu to act for a person by selection
     * return void
     */
    public void helpMainMenu() {
        int selectedNumber = -1;
        do {
            System.out.println("Выбор: ");
            System.out.println("1 - Добавить человека ");
            System.out.println("2 - Посмотреть человека  ");
            System.out.println("3 - Удалить человека  ");
            System.out.println("4 - Посмотреть всех ");
            System.out.println("5 - Поиск ");
            System.out.println("6 - Отсортировать");
            System.out.println("0 - Выход ");
            System.out.println("___________________________________");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 7);
        mainMenu(selectedNumber);
    }

    /**
     * mainMenu - method that calls other methods depending on the selected field
     * 1- add person
     * 2- see person
     * 3- delete person
     * 4- see all
     * 5- helpSearchMenu
     * 6- helpSortMenu
     * @param selectValue - select value
     * return void
     */
    public void mainMenu(int selectValue) {

        switch (selectValue) {
            case 1: {
                manager.inputPerson(array);
                helpMainMenu();
                break;
            }
            case 2: {
                int currentCount = inpputCorrect.inputInteger("Введите номер человека, которого хотите посмотреть", 0, array.Count());
                manager.outputPerson(currentCount - 1, array);
                helpMainMenu();
                break;
            }
            case 3: {
                int currentCount = inpputCorrect.inputInteger("Введите номер человека, которого хотите удалить", 0, array.Count());
                manager.delPersonById(array, currentCount);
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
            case 6: {
                helpSortMenu();
                break;
            }
            case 0:
                return;

        }
    }
}
