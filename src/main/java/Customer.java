public class Customer extends PersonalInformation {

    private int checkInDate;
    private int checkOutDate;
    private int guestNumber;
    private final int id;

    public int generateRandomId() {
        return (int)(Math.random()*10000);
    }

    Customer(long phoneNumber, String name, String surname, String email, int checkInDate, int checkOutDate, int guestNumber) {
        super(phoneNumber, name, surname, email);
        setCheckInDate(checkInDate);
        setCheckOutDate(checkOutDate);
        setGuestNumber(guestNumber);
        this.id=generateRandomId();
    }

    public int getId() {
        return this.id;
    }


    public int getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }
}
