package bankingProducts;

import java.util.concurrent.ThreadLocalRandom;

import homebankingUserManagementSystem.Modal;
import homebankingUserManagementSystem.Usuario;
import validationsPackage.PasswordValidator;
import validationsPackage.ProductServiceException;
import validationsPackage.TextValidator;

public class ProductManagementView {
//	private static ProductoDAO daoProducto = new ProductoDAOMethods();
	private static ProductService productService = new ProductService();


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
				Integer accountNumber = ThreadLocalRandom.current().nextInt();
				productCreated = new Producto(accountNumber, userInput, accountTypeInput,  accountNumber, userInput+"Alias", 0, 0, 10000);
				
				// DB create
				try {
					productService.crearProducto(productCreated);
				} catch (ProductServiceException productCreateError) {
					new Modal().displayErrorModal(productCreateError.toString());
				}
			}
		}
		return(productCreated);
	}
	
	public static void deleteProduct(String user, String accountType) {
		try {
			productService.borraProducto(user, accountType);
		} catch (ProductServiceException productDeleteError) {
			new Modal().displayErrorModal(productDeleteError.toString());
		}
	}
}
