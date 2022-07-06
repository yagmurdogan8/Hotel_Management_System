public class Report {
    public void sendConfirmationMail(App app, Customer customer, Room room) {
        System.out.println("Your reservation id is: " + customer.getId() + " (Please don't forget this id, you can cancel your reservation with this id if it's needed.)");
        System.out.println("Name is: " + customer.getName());
        System.out.println("Surname is: " + customer.getSurname());
        System.out.println("Contact e-mail is: " + customer.getEmail());
        System.out.println("Contact phone number is: " + customer.getPhoneNumber());
        System.out.println("Your check in date: " + customer.getCheckInDate());
        System.out.println("Your check out date: " + customer.getCheckOutDate());
        System.out.println("The number of nights you are going to stay : " + (customer.getCheckOutDate() - customer.getCheckInDate()));
        System.out.println("Number of guests you asked for: " + customer.getGuestNumber());
        app.getRoomInfo(customer, room);
    }
}
