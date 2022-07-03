package validationsPackage;

public class PasswordValidator {

    public static void haveAtLessOneUpperCase(String password) throws UpperCaseRequiredException {
    	boolean haveUpperCase = false;
    	
		for(int index = 0; index < password.length(); index++){
			char c = password.charAt(index);
			if(Character.isUpperCase(c) && haveUpperCase == false) {
				haveUpperCase = true;
			}
		}
		
		if (!haveUpperCase) {
			throw new UpperCaseRequiredException("Password must have at less one capital letter");
		}
    }
    
    public static void haveAtLessOneLowerCase(String password) throws LowerCaseRequiredException {
    	boolean haveLowerCase = false;
    	
		for(int index = 0; index < password.length(); index++){
			char c = password.charAt(index);
			if(Character.isLowerCase(c) && haveLowerCase == false) {
				haveLowerCase = true;
			}
		}
		
		if (!haveLowerCase) {
			throw new LowerCaseRequiredException("Password must have at less one lower case");
		}
    }
    
    public static void haveAtLessOneNumber(String password) throws NumberRequiredException {
    	boolean haveNumber = false;
    	
		for(int index = 0; index < password.length(); index++){
			char c = password.charAt(index);
			if(Character.isDigit(c) && haveNumber == false) {
				haveNumber = true;
			}
		}
		
		if (!haveNumber) {
			throw new NumberRequiredException("Password must have at less one number");
		}
    }
    
    public static void maxLength(String password, int limit) throws TextLengthOutOfBoundsException {
    	if(password.length() > limit) {
            throw new TextLengthOutOfBoundsException("Password must have no longer than: " + limit + " characters");
        }
    }
    
    public static void minLength(String password, int limit) throws TextLengthOutOfBoundsException {
    	if(password.length() < limit) {
            throw new TextLengthOutOfBoundsException("Password have to be more longer than: " + limit + " characters");
        }
    }
    
    public static void validatePassword(String password) throws InvalidPasswordException {
    	try {
    		PasswordValidator.haveAtLessOneLowerCase(password);
    		PasswordValidator.haveAtLessOneNumber(password);
    		PasswordValidator.haveAtLessOneUpperCase(password);
    		PasswordValidator.maxLength(password, 8);
    		PasswordValidator.minLength(password, 4);
    	} catch (Exception e) {
    		throw new InvalidPasswordException("You inserted not a valid Password, insert it again, ERROR: " + e.toString());
    	}
    }
}
