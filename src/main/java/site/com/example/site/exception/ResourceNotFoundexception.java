package site.com.example.site.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundexception extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundexception(String message) {
		super(message);
}
}