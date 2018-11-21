/*
класс Person с людьми
поля: id
	  фио
	  пол
	  дата рождения (хранить в типе, который позволяет хранить этот тип localdate библиотеки йодо-тайм )
	  +вычисляемое поле: возраст(сделать так, чтобы его можно было получить )

второй класс - класс репозиторий
люди в любом колличестве (добавляем, удаляем и получваем людей)
	коллекции использовать нельзя. только массивы. если списаок - то только свой
залить на гит + комментарии в виде javadoc
*/
package person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {

    private static int idCounter = 0;
    private int id;
    private String name;
    private String surName;
    private GenderEnum gender;
    private LocalDate birthday;


    public Person(String name, String surname, int gen,LocalDate lDate) {

        idCounter++;
        id = idCounter;
        this.name = name;
        this.surName = surname;

        GenderEnum g = gen == 0 ? GenderEnum.MAN : GenderEnum.WOMAN;
        this.gender = g;

        this.birthday = lDate;

    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Person.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if ((birthday != null) && (currentDate != null)) {
            return Period.between(birthday, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public String toGender() {
        return "Пол \"" + gender + "\"";
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void display() {
        System.out.println("Name: " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return Objects.equals(getName(), p.getName()) &&
                Objects.equals(getSurName(), p.getSurName()) &&
                Objects.equals(gender,p.gender) &&
                Objects.equals(getBirthday(), p.getBirthday());

//                getGender() == p.getGender();
    }
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday + '\'' +
                ", gender=" + gender +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurName(), getGender(),getBirthday());
    }

}