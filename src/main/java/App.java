
import java.util.HashMap;

public class App {
    HashMap<Integer, Customer> reservation; //integer:id customer:customer objesi

    public App() {
        reservation = new HashMap<Integer, Customer>();
    }


    public void getRoomInfo(Customer customer, Room room) {
        System.out.println("The room type you selected is room: " + room.selectRoom(room).getClass().getName());
        System.out.println("The view type of the room you selected is:  " + room.selectRoom(room).getViewType());
        System.out.println("The star rate of the room you selected is: " + room.selectRoom(room).getStarRates());
        System.out.println("The price of the room you selected: " + room.selectRoom(room).calculateTotalPrice(room, customer) + " TL");
        System.out.println("The capacity of your selected room is: " + room.selectRoom(room).getCapacity());

    }

    public void open() {
        System.out.println("\n     WELCOME TO OUR HOTEL RESERVATION SYSTEM\n" +
                "------------------------------------------------\n");
    }

    public void close() {
        System.out.println("---------------------------------------------------\n" +
                "\n       It was nice to meet you! \nWe are looking forward to see you AGAIN!");
    }

    public void confirmReservation() {
        System.out.println("The reservation is confirmed now.\n");
    }

    public void addReservation(Customer customer) {
        reservation.put(customer.getId(), customer);
        System.out.println("The reservation is added for the name: " + customer.getName());
    }

    public void cancelReservation(int id) {
        reservation.remove(id);
    }


    public boolean checkReservationAvailability(int id) {
        boolean test;
        if (!reservation.containsKey(id)) {
            System.out.println("There is no reservation with the given id.");
            test = false;
        } else {
            test = true;
            System.out.println("There is a reservation with the id:  " + id);
        }
        return test;
    }


}
