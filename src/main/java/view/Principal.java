package view;

import model.dao.Banco;

public class Principal {

	public static void main(String[] args) {
		
		Banco.getConnection();
		System.out.println("OK");
		
	}

}
