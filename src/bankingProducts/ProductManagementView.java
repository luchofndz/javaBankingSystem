package bankingProducts;

import homebankingUserManagementSystem.Modal;
import homebankingUserManagementSystem.Usuario;
import validationsPackage.PasswordValidator;
import validationsPackage.TextValidator;

public class ProductManagementView {
	private static ProductoDAO daoProducto = new ProductoDAOMethods();


	public static Producto agregarProducto() {
		// TODO: add validations for data
		String userInput = new Modal().displayInputModal("Please insert user name: ");
		Producto productCreated = null;
		
		// Validation User Name
		Boolean validUserName = false;
		do {
			try {
				TextValidator.validateStringLength(userInput, 256, 0);
				validUserName = true;
			} catch (Exception error) {
				new Modal().displayErrorModal(error.toString());
				validUserName = false;
				userInput = new Modal().displayInputModal("Please insert again user name: ");
			}
		} while(validUserName == false);
		
		if (userInput != null) {
			String accountTypeInput = new Modal().displayInputModal("Please insert account type: ");
			
			if (accountTypeInput != null) {
				productCreated = new Producto(userInput, accountTypeInput, 0, 0, 0);
				
				// DB create
				daoProducto.crearProducto(productCreated);
			}
		}
		return(productCreated);
	}
	
	public static void deleteProduct(String user, String accountType) {
		daoProducto.borraProducto(user, accountType);
	}
}
