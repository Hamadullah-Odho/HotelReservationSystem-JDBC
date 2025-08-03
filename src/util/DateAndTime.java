package util;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

final public class DateAndTime {
    static private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH-mm");
    private DateAndTime(){}

    public static String getDate(){return  String.valueOf(LocalDate.now());}
    public static String getTime(){return  String.valueOf(LocalTime.now().format(format));}
}
