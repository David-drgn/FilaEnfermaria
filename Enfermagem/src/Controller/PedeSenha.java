package Controller;

import javax.swing.JOptionPane;

public class PedeSenha {

	private String senha = JOptionPane.showInputDialog("Digite sua senha: ");

	public String getSenha() {
		return senha;
	}

}