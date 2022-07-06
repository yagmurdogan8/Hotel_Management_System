import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String lines = String.valueOf(Files.readAllLines(Paths.get("src/main/java/Customer.txt"), StandardCharsets.UTF_8)); //pathFromContentRoot
        lines = lines.replaceAll("[\\p{Punct} && [^@.]]+", " ").toLowerCase(new Locale("tr", "TR"));

        String[] numStrings = lines.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(numStrings));
        long phone = Long.parseLong(list.get(1));
        String name = list.get(2);
        String surname = list.get(3);
        String email = list.get(4);
        int checkIn = Integer.parseInt(list.get(5));
        int checkOut = Integer.parseInt(list.get(6));
        int guestNumber = Integer.parseInt(list.get(7));
        System.out.println("The phone number of the customer: " + numStrings[1]);
        System.out.println("The name of the customer: " + numStrings[2]);
        System.out.println("The surname of the customer: " + numStrings[3]);
        System.out.println("The mail address of the customer: " + numStrings[4]);
        System.out.println("The check-in date of the customer: " + numStrings[5]);
        System.out.println("The check-out date of the customer: " + numStrings[6]);
        System.out.println("The number of guests: " + numStrings[7]);

        Scanner scanner = new Scanner(System.in);
        App app = new App();
        app.open();

        Customer customer = new Customer(phone, name, surname, email, checkIn, checkOut, guestNumber);


        Room[] rooms = new Room[10];
        rooms[0] = new KingSuit("sea", guestNumber, 800, 4.8f);
        rooms[1] = new KingSuit("forest", guestNumber, 800, 4.5f);
        rooms[2] = new Deluxe("sea", guestNumber, 700, 4.7f);
        rooms[3] = new Deluxe("city", guestNumber, 700, 4.2f);
        rooms[4] = new Suit("city", guestNumber, 650, 3.8f);
        rooms[5] = new Suit("sea", guestNumber, 650, 4.0f);
        rooms[6] = new Classic("sea", guestNumber, 500, 3.4f);
        rooms[7] = new Classic("forest", guestNumber, 500, 3.2f);
        rooms[8] = new Classic("city", guestNumber, 500, 3f);
        rooms[9] = new Classic("sea", guestNumber, 500, 4.1f);

        Sort sort = new Sort();
        Room room = new Room();
        room.listRooms(rooms);

        System.out.println("\nALL OF THE ROOMS BEFORE SORTING : \n");
        System.out.println("------------------------------------------------\n");


        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getClass().getName().equalsIgnoreCase("KingSuit")) {
                System.out.println("King suit room no: " + i + " and price: " + rooms[i].calculateTotalPrice(rooms[i], customer) + " TL");
            } else if (rooms[i].getClass().getName().equalsIgnoreCase("Suit")) {
                System.out.println("Suit room no: " + i + " and price: " + rooms[i].calculateTotalPrice(rooms[i], customer) + " TL");
            } else if (rooms[i].getClass().getName().equalsIgnoreCase("Deluxe")) {
                System.out.println("Deluxe room no: " + i + " and price " + rooms[i].calculateTotalPrice(rooms[i], customer) + " TL");
            } else if (rooms[i].getClass().getName().equalsIgnoreCase("Classic")) {
                System.out.println("Classic room no: " + i + " and price: " + rooms[i].calculateTotalPrice(rooms[i], customer) + " TL");
            }
        }
        System.out.println("\n------------------------------------------------");
        double[] descendingArray = sort.sortByPriceHighToLow(rooms, customer);

        System.out.println("\nAfter sorting the prices high to low:");
        for (int i = 0; i < descendingArray.length; i++) {
            System.out.println(descendingArray[i]);
        }

        System.out.println("------------------------------------------------");
        System.out.println("After sorting the prices low to high:");
        double[] ascendingArray = sort.sortByPriceLowToHigh(rooms, customer);
        for (int i = 0; i < ascendingArray.length; i++) {
            System.out.println(ascendingArray[i]);
        }
        System.out.println("------------------------------------------------");
        System.out.println("After sorting the rooms by star rates in descending form: ");
        float[] ascendingArray2 = sort.sortByStarRates(rooms, customer);
        for (int i = 0; i < ascendingArray2.length; i++) {
            System.out.println(ascendingArray2[i]);
        }

        System.out.println("------------------------------------------------");
        System.out.println("Please enter your choice based on room no: (Room numbers should be between 0 and 9.)");
        int x = scanner.nextInt();
        System.out.println("You selected room at no: " + x);

        room.selectRoom(rooms[x]);
        app.getRoomInfo(customer, rooms[x]);
        System.out.println("------------------------------------------------");
        System.out.println("PLEASE ENTER THE AMOUNT YOU WILL PAY: (The price of room you selected, you can see payment amount from above.)");
        double price = scanner.nextDouble();
        Report report = new Report();
        Payment payment = new Payment();
        boolean test = payment.payment(rooms[x], customer, price);
        if (test == true) {
            app.addReservation(customer);
            payment.directTo3DSecure();
            app.confirmReservation();
            report.sendConfirmationMail(app, customer, rooms[x]);
        } else if (test == false) {
            System.out.println("Please enter correct amount of money to continue payment process.");
            price = scanner.nextDouble();
            boolean test2 = payment.payment(rooms[x], customer, price);
            if (test2 == true) {
                app.addReservation(customer);
                payment.directTo3DSecure();
                app.confirmReservation();
                report.sendConfirmationMail(app, customer, rooms[x]);
            }
        }

        System.out.println("\nIF YOU WANT TO CANCEL THE RESERVATION TYPE : 'Cancel'");
        System.out.println("IF YOU WANT TO CLOSE THE SYSTEM TYPE : 'Exit'");
        String answer = scanner.next();
        if (answer.toLowerCase().equals("cancel")) {
            System.out.println("Enter your id to continue cancelling reservation process: ");
            int id = scanner.nextInt();
            if (app.checkReservationAvailability(id)) {
                app.cancelReservation(id);
                System.out.println("Reservation with the given id " + id + " is cancelled now.\nThe amount you paid, will return your bank account in at most 2 days.");
                app.close(); }
             else if (!app.checkReservationAvailability(id)) {
                System.out.println("Please enter id again");
                id = scanner.nextInt();
                if (app.checkReservationAvailability(id)) {
                    app.cancelReservation(id);
                    System.out.println("Reservation with the given id " + id + " is cancelled now.\nThe amount you paid, will return your bank account in at most 2 days.");
                    app.close();
                }
            }
        } else if (answer.toLowerCase().equals("exit")) {
            System.out.println("You are logging out of the application. Take care.");
            app.close();
        } else {
            System.out.println("You entered an invalid value.");
        }

    }
}


