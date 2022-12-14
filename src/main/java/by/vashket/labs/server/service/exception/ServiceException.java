package by.vashket.labs.server.service.exception;

public class ServiceException extends Exception {
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Exception e){
        super(e);
    }
}
