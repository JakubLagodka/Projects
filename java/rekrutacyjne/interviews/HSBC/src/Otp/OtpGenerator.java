package Otp;

import java.security.SecureRandom;

public class OtpGenerator {
    private final SecureRandom random = new SecureRandom();
    public String generateOtp() {
        int number = random.nextInt(1_000_000);
        return String.format("%06d",number);
    }
}
