package exceptions;

public class InvalidCoverageException extends Exception {
    public InvalidCoverageException() {
        super("Coverage doesn't exist");
    }
}
