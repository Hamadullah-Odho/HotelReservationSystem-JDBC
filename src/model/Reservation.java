package model;

public class Reservation {
    private String clientName;
    private String clientPhone;
    private int roomNo;
    private String clientEmail;
    private String reservationDate;
    private String reservationTime;

    public void setClientName(String clientName) {this.clientName = clientName;}
    public void setClientPhone(String clientPhone) {this.clientPhone = clientPhone;}
    public void setRoomNo(int roomNo) {this.roomNo = roomNo;}
    public void setReservationDate(String reservationDate) {this.reservationDate = reservationDate;}
    public void setReservationTime(String reservationTime) {this.reservationTime = reservationTime;}
    public void setClientEmail(String clientEmail) {this.clientEmail = clientEmail;}

    public String getClientName() {return clientName;}
    public String getClientPhone() {return clientPhone;}
    public int getRoomNo() {return roomNo;}
    public String getReservationDate() {return reservationDate;}
    public String getReservationTime() {return reservationTime;}
    public String getClientEmail() {return clientEmail;}
}
