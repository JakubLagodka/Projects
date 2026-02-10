package Otp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OtpStorage {
    private final Map<String, String> otps = new ConcurrentHashMap<>();

    public void save( String userId, String otp ) {
        otps.put( userId, otp );
    }

    public String get( String userId ) {
        return otps.get( userId );
    }

    public void remove( String userInputOtp ) {
        otps.remove( userInputOtp );
    }
}
