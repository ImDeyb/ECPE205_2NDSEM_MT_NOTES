package JListActions;

public class Person {
        private String firstname, lastname, title, nickname, DisplayFormat, MailFormat;
        private String EmailAddress;

    public Person(String firstname, String lastname, String title, String nickname, String displayFormat, String emailAddress, String mailFormat) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.nickname = nickname;
        DisplayFormat = displayFormat;
        EmailAddress = emailAddress;
        MailFormat = mailFormat;
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

    public String getDisplayFormat() {
        return DisplayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        DisplayFormat = displayFormat;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getMailFormat() {
        return MailFormat;
    }

    public void setMailFormat(String mailFormat) {
        MailFormat = mailFormat;
    }

    @Override
    public String toString() {
        return firstname + lastname + title +
                nickname + DisplayFormat + EmailAddress + MailFormat;
    }
}

