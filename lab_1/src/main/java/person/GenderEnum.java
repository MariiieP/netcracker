package person;

/**
 * enum for gender Person
 */
public enum GenderEnum {
    MAN("Мужской"),
    WOMAN("Женский");

    /**
     * gender selection
     */
    private final String gender;

    /**
     * constructor gender selection
     * @param gender - value enum
     */
    GenderEnum(String gender) {
        this.gender = gender;
    }

    /**
     * override method
     * @return String gender
     */
    @Override
    public String toString() {
        return gender;
    }
}
