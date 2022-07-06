import java.text.DecimalFormat;

public class Room {
    private String viewType;
    private int capacity;
    private double roomPrice;
    private float starRates;

    public Room(String viewType, int capacity, double roomPrice, float starRates) {
        setViewType(viewType);
        setCapacity(capacity);
        setRoomPrice(roomPrice);
        setStarRates(starRates);
    }

    public Room() {
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public float getStarRates() {
        return starRates;
    }

    public void setStarRates(float starRates) {
        this.starRates = starRates;
    }

    public double calculateTotalPrice(Room room, Customer customer) {
        double totalPrice = 0;
        int sea = 250;
        int forest = 150;
        int city = 100;
        if (room.getViewType().equalsIgnoreCase("sea")) {
            totalPrice = (room.getRoomPrice() * (customer.getGuestNumber()) + sea + (customer.getGuestNumber() * room.getStarRates()));
        } else if (room.getViewType().equalsIgnoreCase("forest")) {
            totalPrice = (room.getRoomPrice() * (customer.getGuestNumber()) + forest + (customer.getGuestNumber() * room.getStarRates()));
        } else if (room.getViewType().equalsIgnoreCase("city")) {
            totalPrice = (room.getRoomPrice() * (customer.getGuestNumber()) + city + (customer.getGuestNumber() * room.getStarRates()));
        }
        //System.out.println("The total price you should pay: ");
        return (int) totalPrice;
    }


    public void listRooms(Room[] room) {
        System.out.println("\nHERE IS OUR ROOMS AND THEIR PROPERTIES. YOU CAN DECIDE THE ROOM YOU WANTED FROM THIS LIST: \n");
        for (int i = 0; i < room.length; i++) {
            if (room[i].getClass().getName().equalsIgnoreCase("KingSuit")) {
                System.out.println("*Room type is King Suit and Room No:" + i + "*");
            } else if (room[i].getClass().getName().equalsIgnoreCase("Suit")) {
                System.out.println("*Room type is Suit and Room No:" + i + "*");
            } else if (room[i].getClass().getName().equalsIgnoreCase("Deluxe")) {
                System.out.println("*Room type is Deluxe and Room No:" + i + "*");
            } else if (room[i].getClass().getName().equalsIgnoreCase("Classic")) {
                System.out.println("*Room type is Classic and Room No:" + i + "*");
            }
            System.out.println("The view type: " + room[i].getViewType());
            System.out.println("The star rate: " + room[i].getStarRates());
            System.out.println("The base room type price(Not including the price for view type and number of guests.): " + room[i].getRoomPrice() + " TL");
            System.out.println("The capacity: " + room[i].getCapacity() + "\n");


        }
    }

    public Room selectRoom(Room room) {
        return room;
    }


}






