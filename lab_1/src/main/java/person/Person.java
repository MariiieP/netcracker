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

/**
 * Person class stores an object with fields:
 * id, name, surname,gender,birthday
 */
public class Person {

    private static int idCounter = 0;
    private int id;
    private String name;
    private String surName;
    private GenderEnum gender;
    private LocalDate birthday;

    /**
     * constructor for create object type Person
     * with id which stores the object number
     * @param name    - type string
     * @param surname - type string
     * @param gen     - type enum
     * @param lDate   - type LocalDate
     */
    public Person(String name, String surname, int gen, LocalDate lDate) {

        idCounter++;
        id = idCounter;
        this.name = name;
        this.surName = surname;

        GenderEnum g = gen == 0 ? GenderEnum.MAN : GenderEnum.WOMAN;
        this.gender = g;

        this.birthday = lDate;

    }

    /**
     * getter which return id evoke object
     * @return int id
     */
    public static int getIdCounter() {
        return idCounter;
    }

    /**
     * setter which return id evoke object
     * @param idCounter int id
     */
    public static void setIdCounter(int idCounter) {
        Person.idCounter = idCounter;
    }

    /**
     * getter which return id evoke object
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * getter which return id evoke object
     * @return int id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter which return name evoke object
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * setter which return name evoke object
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter which return surName evoke object
     * @return string surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * setter which return surName evoke object
     * @param surName string surName
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * getter which return birthday evoke object
     * @return LocalDate birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * setter which return surName evoke object
     * @param birthday LocalDate birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * getter which return birthday evoke object
     * @return int age
     */
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if ((birthday != null) && (currentDate != null)) {
            return Period.between(birthday, currentDate).getYears();
        } else {
            return 0;
        }
    }

    /**
     * returns the gender of the person with an explanation for the menu
     * @return sex + gender
     */
    public String toGender() {
        return "Пол \"" + gender + "\"";
    }

    /**
     * getter which return gender evoke object
     * @return GenderEnum gender
     * @see GenderEnum
     */
    public GenderEnum getGender() {
        return gender;
    }

    /**
     * Override method equal
     * @param o - Object
     * @return boolean (true - equals, false - not equals)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return Objects.equals(getName(), p.getName()) &&
                Objects.equals(getSurName(), p.getSurName()) &&
                Objects.equals(gender, p.gender) &&
                Objects.equals(getBirthday(), p.getBirthday());
//                getGender() == p.getGender();
    }

    /**
     * Override method toString - print object with field
     * @return big String
     */
    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday + '\'' +
                ", gender=" + gender +
                ']';
    }

    /**
     * Override method hashCode
     * @return hash Code object person
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurName(), getGender(), getBirthday());
    }

}