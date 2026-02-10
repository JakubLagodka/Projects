package Otp;

public class OtpService {
    private final OtpGenerator generator;
    private final OtpStorage storage;
    private final ExternalSmsService externalSmsService;

    public OtpService( OtpGenerator generator, OtpStorage storage, ExternalSmsService externalSmsService ) {
        this.generator = generator;
        this.storage = storage;
        this.externalSmsService = externalSmsService;
    }

    public void sendOTP( String userId, String operation ) {
        String otp = generator.generateOtp();
        storage.save(userId,otp);

        String message = JsonMessageFormatter.format( operation, otp );
        externalSmsService.sendOtp(userId,message);
    }

    public boolean verifyOtp( String userId, String userInputOtp ) {
        String storedOtp = storage.get( userId );
        if( storedOtp == null ) {
            return false;
        }
        boolean equals = storedOtp.equals( userInputOtp );
        if( equals ) {
            storage.remove(userInputOtp);
        }
        return equals;
    }

    public String getOtpForTests(String userId) {
        return storage.get(userId);
    }
}
