import Otp.ExternalSmsService;
import Otp.OtpGenerator;
import Otp.OtpService;
import Otp.OtpStorage;

public class Main {
    public static void main( String[] args ) {
        otp();

    }

    public static void otp(){
        String userId = "user";
        String operation = "payment approve";

        OtpService otpService = new OtpService(new OtpGenerator(),new OtpStorage(),new ExternalSmsService());
        otpService.sendOTP(userId, operation);

        String otpForTests = otpService.getOtpForTests(userId);

        boolean verified = otpService.verifyOtp( userId, otpForTests );

        System.out.println(verified);
    }
    public static void slotMachine(){
//        Develop a modular Slot Machine engine in Java with the following specifications:
//        - Extensible Reel Logic: Implement the "Wheel" (slot) to hold numeric digits while remaining decoupled to support future symbol types.
//                - Configurable Parameters: The system must support a variable number of wheels, defined at runtime or via configuration.
//                - Collection Management: The engine should manage a dynamic set of wheel instances and synchronize their states.
//        - Probability-Based Win Logic: Implement a payout engine that evaluates outcomes against predefined probability tables to determine winning combinations.
    }
}
