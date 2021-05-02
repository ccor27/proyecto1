package aplication;

import controller.ModelFactoryController;
import views.PrincipalView;

public class Main {

	public static void main(String[] args) {
		try {
			PrincipalView window = new PrincipalView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
