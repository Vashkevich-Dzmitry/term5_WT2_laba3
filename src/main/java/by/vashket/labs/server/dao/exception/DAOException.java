package by.vashket.labs.server.dao.exception;

public class DAOException extends Exception {
    public DAOException(String message){
        super(message);
    }
    public DAOException(Exception e){
        super(e);
    }
}
