public class PersonalInformation {
    private long phoneNumber;
    private String name;
    private String surname;
    private String email;

    PersonalInformation() {

    }

    PersonalInformation(long phoneNumber, String name, String surname, String email) {
        setPhoneNumber(phoneNumber);
        setName(name);
        setSurname(surname);
        setEmail(email);
    }

    public  long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}