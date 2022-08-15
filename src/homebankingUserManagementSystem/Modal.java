package homebankingUserManagementSystem;

import javax.swing.JOptionPane;

public class Modal {
	
	public void displayErrorModal(String message) {
		this.displayModal("error", message);
    }
	
	public void displaySuccessModal(String message) {
		this.displayModal("success", message);
    }
	
	public String displayInputModal(String message) {
		return this.displayModal("input", message);
    }
	
	public String displayModal(String typeOfModal, String message) {
		String modal = null;
		
		switch (typeOfModal) {
			case "error": {
				modal = "WARNING_MESSAGE";
				break;
			}
			case "success": {
				modal = "PLAIN_MESSAGE";
				break;
			}
			default: {
				modal = "PLAIN_MESSAGE";
			}
		}

		if (typeOfModal == "input") {
			String inputValue = (JOptionPane.showInputDialog(message)).toString();
			return inputValue;
		} else {
			JOptionPane.showMessageDialog(null, message, modal, JOptionPane.WARNING_MESSAGE);
			return "";
		}
    }
}
