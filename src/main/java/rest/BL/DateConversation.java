package rest.BL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConversation {
    public static String dateGenerationAndCasting() {
//        SimpleDateFormat format;
//        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        String dateString = format.format(LocalDate.now());
//        return dateString;

//        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
//        String formattedDate = formatter.format(LocalDate.now());
//        return "1970-01-01T05:36:30.820+0000";
//
       // return String.valueOf(LocalDateTime.now());
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//        String formattedDate = formatter.format(LocalDate.now());
//        return formattedDate;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("+0000"));
        return dateFormat.format(date);

    }
}
