package app;
import services.HotelReservationService;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HotelReservationService service = new HotelReservationService();
        while (true) {

            try {
                System.out.println("----- Hotel Reservation System -----\n");
                System.out.println("1. Create Hotel Reservation");
                System.out.println("2. Show Hotel Reservations");
                System.out.println("3. Update Hotel Reservation");
                System.out.println("4. Delete Hotel Reservation");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if(choice == 1) {service.CreateReservation(scanner);}
                else if(choice == 2) { service.showReservations();}
                else if(choice == 3) {service.updateReservation(scanner);}
                else if(choice == 4) {service.deleteReservation(scanner);}
                else if(choice == 5) {break;}
                else {System.out.println("Invalid choice");}
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice");

            }
        }
        System.out.println("Terminated");
        scanner.close();

    }
}