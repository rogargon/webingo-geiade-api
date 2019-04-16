package cat.udl.eps.entsoftarch.webingogeiadeapi.handler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ShowResultException extends RuntimeException{
    public ShowResultException(String message) { super(message);}
}