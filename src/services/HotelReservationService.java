package services;
import dao.HotelReservationDB;
import java.util.Scanner;
import model.Reservation;
import util.DateAndTime;

final public class HotelReservationService {

    Reservation reservation;

    public HotelReservationService() {
        reservation = new Reservation();
    }

    // create reservation method
    public void CreateReservation(Scanner scanner){
        System.out.println("--- Creating Reservation ---\n");
        try {
            System.out.print("Enter Client Room : ");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Client name : ");
            String name = scanner.nextLine();
            System.out.print("Enter Client Phone : ");
            String phone = scanner.nextLine();
            System.out.print("Enter Client Email : ");
            String email = scanner.nextLine();
            CreateReservationHelper(room,name,phone,email);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid Input" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    // create reservation method helper
    private void CreateReservationHelper(int room, String name, String phone, String email){
        reservation.setRoomNo(room);
        reservation.setClientName(name);
        reservation.setClientPhone(phone);
        reservation.setClientEmail(email);
        reservation.setReservationDate(DateAndTime.getDate());
        reservation.setReservationTime(DateAndTime.getTime());
        boolean success = new HotelReservationDB().AddReservation(reservation);

        if(success){
            System.out.println("Reservation Created Successfully");
        }
        else {
            System.out.println("Room Number: " + room + " Already Associated");
        }
    }

    // show reservations method
    public void showReservations(){
        System.out.println("--- Reservations ---\n");
        new HotelReservationDB().showReservation();
    }

    public void deleteReservation(Scanner scanner){

        try{
            System.out.println("--- Deleting Reservation ---\n");
            System.out.print("Enter Client name : ");
            String name = scanner.nextLine();
            System.out.print("Enter Client Phone : ");
            String phone = scanner.nextLine();
            deleteReservationHelper(name,phone);

        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
    private void deleteReservationHelper(String clientName, String clientPhone){
            boolean success = new HotelReservationDB().deleteReservation(clientName,clientPhone);
            if(success){
                System.out.println("Reservation Deleted Successfully");
            }
            else {
                System.out.println("Reservation Not Found");
            }
    }

    public void updateReservation(Scanner scanner){
        try {
            System.out.println("--- Updating Reservation ---\n");
            System.out.print("Enter Client phone : ");
            String ClientPhone = scanner.nextLine();
            System.out.println("1. Update name");
            System.out.println("2. Update room");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                updateName(ClientPhone,scanner);
            } else if (choice == 2) {
                updateRoom(ClientPhone,scanner);
            }
            else if (choice == 3) {return;}
        }
        catch (NumberFormatException e){
            System.out.println("Enter valid room");
        }
    }

    private void updateRoom(String clientPhone, Scanner scanner) throws NumberFormatException{
        System.out.println("--- Updating Room ---\n");
        System.out.print("Enter Room No: ");
        int roomNo = Integer.parseInt(scanner.nextLine());
        boolean success = new HotelReservationDB().updateReservation(clientPhone, roomNo);
        if(success){
            System.out.println("Room Updated Successfully");
        }
        else{
            System.out.println("Room Not Updated");
        }


    }
    private void updateName(String clientPhone ,Scanner scanner){
        System.out.println("--- Updating Name ---\n");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        boolean success = new HotelReservationDB().updateReservation(clientPhone, name);
        if(success){
            System.out.println("Name Updated Successfully");
        }
        else{
            System.out.println("Name Not Updated");
        }
    }


}
