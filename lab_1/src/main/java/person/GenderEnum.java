package person;

public enum GenderEnum {
    MAN("Мужской"),
    WOMAN("Женский");

    private final String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }

}
