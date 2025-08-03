package dao;
import connection.DBConnection;
import model.Reservation;
import java.sql.*;

final public class HotelReservationDB {

    private Connection connection;
    private PreparedStatement statement;

    public HotelReservationDB() {
    }

    public boolean AddReservation(Reservation r) {
        try{
            connection = DBConnection.getConnection();
            String query = "INSERT INTO reservations(name,room,email,phone,date,time) " +
                    "VALUES(?,?,?,?,?,?)";
            if (connection != null) {
                statement = connection.prepareStatement(query);
            }

            statement.setString(1,r.getClientName());
            statement.setInt(2,r.getRoomNo());
            statement.setString(3,r.getClientEmail());
            statement.setString(4,r.getClientPhone());
            statement.setString(5,r.getReservationDate());
            statement.setString(6,r.getReservationTime());
            int created = statement.executeUpdate();
            statement.close();
            connection.close();
            return created > 0;
        }
        catch(SQLException e){
            System.out.println("Error Creating Reservation ");
            return false;
        }
    }

    public void showReservation() {
        try{
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM reservations";
            if (connection != null) {
                statement = connection.prepareStatement(query);
            }
            getReservation(statement.executeQuery());
            connection.close();
            statement.close();
        }
        catch (SQLException e){
            System.out.println("Error "  + e.getMessage());
        }
    }
    private void getReservation(ResultSet r) throws SQLException {
        while (r.next()){
            System.out.println("--------------------------------------");
            System.out.println("Reservation id :"+ r.getInt("id"));
            System.out.println("Client name: " + r.getString("name"));
            System.out.println("> room: " + r.getString("room"));
            System.out.println("> email: " + r.getString("email"));
            System.out.println("> number: " + r.getString("phone"));
            System.out.println("> Reservation date: " + r.getString("date"));
            System.out.println("> Reservation time: " + r.getString("time"));
        }
        System.out.println("--------------------------------------");
        r.close();
    }

    public boolean deleteReservation(String clientName, String clientPhone){

        try{
            connection = DBConnection.getConnection();
            String query = "DELETE FROM reservations WHERE name = ? AND phone = ?";
            if (connection != null) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, clientName);
            statement.setString(2, clientPhone);
            int deleted = statement.executeUpdate();
            statement.close();
            connection.close();
            return deleted > 0;

        } catch (SQLException e) {
            System.out.println("Error "  + e.getMessage());
            return false;
        }
    }

    public boolean updateReservation(String clientPhone, String updatedName){
        try {
            connection = DBConnection.getConnection();
            String nameUpdate = "UPDATE reservations SET name = ? WHERE phone = ?;";

            if(connection != null) {
                statement = connection.prepareStatement(nameUpdate);
                statement.setString(1, updatedName);
                statement.setString(2, clientPhone);
            }
            int update = statement.executeUpdate();
            statement.close();
            connection.close();
            return update > 0;
        }
        catch (SQLException e){
            System.out.println("Error "  + e.getMessage());
            return false;
        }
    }
    public boolean updateReservation(String clientPhone, int updatedRoom){
        try {
            connection = DBConnection.getConnection();
            String roomUpdate = "UPDATE reservations SET room = ? WHERE phone = ?;";

            if(connection != null) {
                statement = connection.prepareStatement(roomUpdate);
                statement.setInt(1, updatedRoom);
                statement.setString(2, clientPhone);
            }
            int update = statement.executeUpdate();
            statement.close();
            connection.close();
            return update > 0;
        }
        catch (SQLException e){
            System.out.println("Error "  + e.getMessage());
            return false;
        }
    }

}
