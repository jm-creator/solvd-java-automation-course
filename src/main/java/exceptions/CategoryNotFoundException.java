package exceptions;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException() {
        super("error category not Found");
    }
}
