package Otp;

public class JsonMessageFormatter {
    public static String format( String message, String otp ) {

        return """
        {
            "message": %s,
            "otp": %s
        }
        """.formatted( message, otp );
    }
}
