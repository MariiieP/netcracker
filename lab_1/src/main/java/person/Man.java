package person;

import java.time.LocalDate;
import java.util.*;

public class Man {

    private MyArrayList<Person> array = new MyArrayList<Person>();
    private Man man;
    static int currentCount = -1;
    static Scanner in = new Scanner(System.in);


    public Man() {
        this.array = new MyArrayList<Person>();
    }

    public void addPerson(Person p) {
        array.add(p);
    }

    public Person getPerson(int id) {
        return array.get(id);
    }

    public void delPersonById(int id) {
        array.remove(id - 1);
    }


    public boolean isCorrect(String line) {
        if (line.matches("^[a-z]+$")) {
            return true;
        }
        return false;
    }

    public String inputString(String message) {
        String name;
        do {
            System.out.println(message);
            assert false;
            name = in.nextLine();
        } while (!isCorrect(name.trim().toLowerCase()));
        return name;
    }

    public int inputInteger(String message, int leftSide, int rightSide) {
        String gender;
        int selectGender;
        do {
            System.out.println(message);
            assert false;
            gender = in.nextLine().trim();
            selectGender = tryParse(gender);
        } while (selectGender < leftSide || selectGender > rightSide);
        return selectGender;
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void inputPerson() {
        int i = array.size();
        i++;
        System.out.println("Введите данные для " + i + " человека");
        i--;

        String name = inputString("Введите имя");
        String surname = inputString("Введите фамилию");
        int selectGender = inputInteger("Введите пол: \n0 - Мужской \n1 - Женский ", 0, 1);

        LocalDate currentDate = LocalDate.now();
        int iYear = inputInteger("Введите год рождения", 0, currentDate.getYear());
        int iMonth = inputInteger("Введите месяц рождения", 0, 12);

        Calendar mycal = new GregorianCalendar(iYear, iMonth - 1, 1);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int iDay = inputInteger("Введите день рождения", 0, daysInMonth);

        Person p = new Person(name, surname, selectGender, iYear, iMonth, iDay);
        addPerson(p);
    }

    public boolean tryGet() {
        return array.size() == 0;

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
        if (!tryGet()) {
            for (int i = 0; i < arrayTmp.size(); i++)
                outputPerson(i, arrayTmp);
        } else System.out.println("Список людей пуст ");
    }

    public int getPersonName(String name) {
        for (int i = 0; i < array.size(); i++) {
            Person p = array.get(i);
//                if (p.getSurName().equalsIgnoreCase(name)) {
            if (p.getSurName().compareToIgnoreCase(name) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonSurname(String surname) {
        for (int i = 0; i < array.size(); i++) {
            Person p = array.get(i);
            if (p.getSurName().compareToIgnoreCase(surname) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonId(int id) {
        for (int i = 0; i < array.size(); i++) {
            Person p = array.get(i);
            if (p.getId() == id) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonGender(String gender) {
        for (int i = 0; i < array.size(); i++) {
            Person p = array.get(i);
            if (p.toGender().compareToIgnoreCase(gender) == 0) {
                return p.getId();
            }
        }
        return -1;
    }

    public int getPersonDate(LocalDate Date) {
        for (int i = 0; i < array.size(); i++) {
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
            System.out.println("1 - id человека ");
            System.out.println("2 - Фамилии человека  ");
            System.out.println("3 - Имени человека  ");
            System.out.println("4 - Полу человека ");
            System.out.println("5 - Дате рождения человека ");
            System.out.println("0 - Выход в главное меню");
            assert false;
            String line = in.nextLine();
            selectedNumber = Integer.parseInt(line.trim());
        } while (selectedNumber < 0 || selectedNumber > 5);
        searchMenu(selectedNumber);
    }

    public void searchMenu(int selectValue) {
        switch (selectValue) {
            case 1: {
                String gender;
                int inputid;
                System.out.println("Введите id");
                assert false;
                gender = in.nextLine().trim();
                inputid = tryParse(gender);

                MyArrayList<Person> arrayTmp = new MyArrayList<Person>();
                for (int i = 0; i < array.size(); i++) {
                    if (!(getPersonId(inputid) == -1))
                        arrayTmp.add(array.get(getPersonId(inputid) - 1));
                }
                if (arrayTmp.size() == 0)
                    System.out.println("Пользователей с таким id не найдено");
                else
                    outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 2: {
                String name = inputString("Введите имя");
                MyArrayList<Person> arrayTmp = new MyArrayList<Person>();
                for (int i = 0; i < array.size(); i++) {
                    if (!(getPersonName(name) == -1))
                        arrayTmp.add(array.get(getPersonName(name) - 1));
                }
                if (arrayTmp.size() == 0)
                    System.out.println("Пользователей с таким именем не найдено");
                else
                    outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 3: {
                String surname = inputString("Введите фамилию");
                MyArrayList<Person> arrayTmp = new MyArrayList<Person>();
                for (int i = 0; i < array.size(); i++) {
                    if (!(getPersonSurname(surname) == -1))
                        arrayTmp.add(array.get(getPersonSurname(surname) - 1));
                }
                if (arrayTmp.size() == 0)
                    System.out.println("Пользователей с такой фамилией не найдено");
                else
                    outputAllPerson(arrayTmp);

//                LinkedList a = new LinkedList() ;arrayTmp.sort();

                helpSearchMenu();
                break;
            }
            case 4: {
                String gender = inputString("Введите пол");
                MyArrayList<Person> arrayTmp = new MyArrayList<Person>();
                for (int i = 0; i < array.size(); i++) {
                    if (!(getPersonGender(gender) == -1))
                        arrayTmp.add(array.get(getPersonGender(gender) - 1));
                }
                if (arrayTmp.size() == 0)
                    System.out.println("Пользователей с таким полом не найдено");
                else
                    outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 5: {
                LocalDate currentDate = LocalDate.now();
                int iYear = inputInteger("Введите год рождения", 0, currentDate.getYear());
                int iMonth = inputInteger("Введите месяц рождения", 0, 12);
                Calendar mycal = new GregorianCalendar(iYear, iMonth - 1, 1);
                int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
                int iDay = inputInteger("Введите день рождения", 0, daysInMonth);
                LocalDate LDate = LocalDate.of(iYear, iMonth, iDay);

                MyArrayList<Person> arrayTmp = new MyArrayList<Person>();
                for (int i = 0; i < array.size(); i++) {
                    if (!(getPersonDate(LDate) == -1))
                        arrayTmp.add(array.get(getPersonDate(LDate) - 1));
                }
                if (arrayTmp.size() == 0)
                    System.out.println("Пользователей с такой датой рождения не найдено");
                else
                    outputAllPerson(arrayTmp);

                helpSearchMenu();
                break;
            }
            case 0: {
                helpMenu();
            }
        }
    }

    public void helpMenu() {
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
                inputPerson();
                helpMenu();
                break;
            }
            case 2: {
                do {
                    System.out.println("Введите номер человека, которого хотите посмотреть");
                    assert false;
                    String line = in.nextLine();
                    currentCount = Integer.parseInt(line) - 1;
                } while (currentCount < 0 || currentCount > array.size());
                outputPerson(currentCount, array);
//                    findAll((Collection) array,  array.get(i).getName());
                helpMenu();
                break;
            }
            case 3: {
                System.out.println("Введите номер человека, которого хотите удалить");
                assert false;
                String linedel = in.nextLine();
                currentCount = Integer.parseInt(linedel);
                delPersonById(currentCount);
                helpMenu();
                break;
            }
            case 4: {
                outputAllPerson(array);
                helpMenu();
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

    public void bubbleSort(MyArrayList<Person>  arr){
//    Внешний цикл каждый раз сокращает фрагмент массива,
//      так как внутренний цикл каждый раз ставит в конец
//      фрагмента максимальный элемент
        for(int i = arr.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
//            Сравниваем элементы попарно,
//              если они имеют неправильный порядок,
//              то меняем местами
            if( arr.get(j).compareTo(arr.get(j+1)) == 1 ){
                Swap(arr,j,j+1);
//                int tmp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = tmp;
            }
        }
    }
}


    public void Swap(MyArrayList<Person> arrayHelp, int left, int right)
    {
        if (left != right)
        {
            Person perTmp;
            MyArrayList tmp = array[left];

            array[left] = array[right];
            array.get(right) = perTmp;
        }
    }

    public void sortSelect()
    {
        int sortedRangeEnd = 0;

        while (sortedRangeEnd < array.size())
        {
            int nextIndex = FindIndexOfSmallestFromIndex(array, sortedRangeEnd);
            Swap(sortedRangeEnd, nextIndex);

            sortedRangeEnd++;
        }
    }

    private int FindIndexOfSmallestFromIndex(MyArrayList<Person> items, int sortedRangeEnd)
    {
        MyArrayList currentSmallest;// = new Person();

        currentSmallest = (Person) items[sortedRangeEnd];
        int currentSmallestIndex = sortedRangeEnd;

        for (int i = sortedRangeEnd + 1; i < items.length; i++)
        {
            if (currentSmallest.CompareTo(items[i]) > 0)
            {
                currentSmallest = items[i];
                currentSmallestIndex = i;
            }
        }

        return currentSmallestIndex;
    }
}