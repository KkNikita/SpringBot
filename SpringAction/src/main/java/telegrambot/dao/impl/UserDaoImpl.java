package telegrambot.dao.impl;


import javax.validation.constraints.Pattern;

public class UserDaoImpl {

    @Pattern(regexp = "",message = "")
    private String surname;

    @Pattern(regexp = "", message = "")
    private String name;

    public void registerUser(String surname, String name) {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
