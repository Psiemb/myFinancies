package myApplications.myFinancies.controller;

public class NameAndSurnameResponse {

    private String name;
    private String surname = "Kukułka";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
