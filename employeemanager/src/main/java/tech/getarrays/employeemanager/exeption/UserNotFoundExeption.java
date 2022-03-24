package tech.getarrays.employeemanager.exeption;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
