package bankingProducts;

import homebankingUserManagementSystem.Modal;
import homebankingUserManagementSystem.Usuario;
import validationsPackage.PasswordValidator;
import validationsPackage.TextValidator;

public class ProductManagementView {
	private static ProductoDAO daoProducto = new ProductoDAOMethods();


	public static Usuario agregarProducto() {
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
				String passwordInput = new Modal().displayInputModal("Please insert account type: ");
				
				// Validation Password
				Boolean validPassword = false;
				do {
					try {
						PasswordValidator.validatePassword(passwordInput);
						validPassword = true;
					} catch (Exception error) {
						new Modal().displayErrorModal(error.toString());
						validPassword = false;
						passwordInput = new Modal().displayInputModal("Please insert user password: ");
					}
				} while(validPassword == false);
				
				
				if (passwordInput != null) {
					String addressInput = new Modal().displayInputModal("Please insert user address: ");
					
					if (addressInput != null) {
						Integer dniInput = Integer.parseInt(new Modal().displayInputModal("Please insert user DNI: "));
						
						if (dniInput != null) {
							productCreated = new Usuario(userInput, accountTypeInput, emailInput, dniInput, addressInput);
							
							// DB create
							daoProducto.crearProducto(productCreated);
						}
					}
				}
			}
		}
		return(productCreated);
	}
}
