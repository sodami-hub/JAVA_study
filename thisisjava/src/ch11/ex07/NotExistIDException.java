package ch11.ex07;

public class NotExistIDException extends Exception{
    public NotExistIDException() {}

    public NotExistIDException(String msg){
        super(msg);
    }
}
