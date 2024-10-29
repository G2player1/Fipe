package Enos.projectsApi.Fipe.exceptions;

public class CantGetDataException extends RuntimeException {

    private final String message;

    public CantGetDataException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
