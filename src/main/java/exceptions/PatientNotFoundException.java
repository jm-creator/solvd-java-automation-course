package exceptions;

public class PatientNotFoundException extends  Exception{
    public PatientNotFoundException() {
        super("Error patient not found");
    }
}
