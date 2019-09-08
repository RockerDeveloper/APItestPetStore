package rest.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
    public enum statusCode{
        INVALIDINPUT(405),
        SUCCESS(200),
        NOTFOUND(404),
        INVALIDDATA(400),
        SERVERERROR(500)
        ;

        private int statusCode;
        statusCode(int statusCode) {
            this.statusCode = statusCode;
        }
        public int getStatusCode(){
            return statusCode;
        }
    }

    public static String dateGenerationAndCasting() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("+0000"));
        return dateFormat.format(date);

    }


}
