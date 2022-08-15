package validationsPackage;

public class TextValidator {
	
    public static void validateStringLength(String text, int maxLength, int minLength) throws StringClassExeption {
    	if (text.length() < minLength || text.length() > maxLength) {
    		throw new StringClassExeption("Text length have to be less or equal to: " + maxLength + ", and minimum: " + minLength);
    	}
    }
    
    public static void validateNumber(String text) throws NumberRequiredException {
		try {  
		    Double.parseDouble(text);
		} catch(NumberFormatException e) {  
			throw new NumberRequiredException("Text have to be a number");
		}  
    }
}
