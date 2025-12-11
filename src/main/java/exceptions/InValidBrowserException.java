package exceptions;

@SuppressWarnings("serial")
public class InValidBrowserException extends RuntimeException{
	
	public  InValidBrowserException() {
		super("InValidBrowserException, Select the valid browser");
		
	}

}
