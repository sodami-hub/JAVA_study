package ch11.ex07;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {}

    public WrongPasswordException(String msg) {
        super(msg);
    }
}
