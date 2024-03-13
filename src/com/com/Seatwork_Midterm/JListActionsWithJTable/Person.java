package com.Seatwork_Midterm.JListActionsWithJTable;

public class Person {
    private String firstname, lastname, title, nickname, jCombos, emails, radioButtons;

    public Person(String firstname, String lastname, String title, String nickname, String jCombos, String emails, String radioButtons) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.nickname = nickname;
        this.jCombos = jCombos;
        this.emails = emails;
        this.radioButtons = radioButtons;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getjCombos() {
        return jCombos;
    }

    public void setjCombos(String jCombos) {
        this.jCombos = jCombos;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getRadioButtons() {
        return radioButtons;
    }

    public void setRadioButtons(String radioButtons) {
        this.radioButtons = radioButtons;
    }
}
