public class Payment {

    public boolean payment(Room room, Customer customer, double price) {
        boolean flag = false;
        if (room.calculateTotalPrice(room, customer) == price) {
            flag = true;
        } else if (room.calculateTotalPrice(room, customer) > price) {
            System.out.println("Payment amount is not enough. Please try again and enter the correct room price.");
        }
        return flag;
    }

    public void directTo3DSecure() {
        System.out.println("You are directing to the 3D Secure");
        System.out.println("----------------------------------");
        System.out.println("Payment process completed successfully.\n");
    }
}
