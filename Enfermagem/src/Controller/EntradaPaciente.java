package Controller;

import javax.swing.JOptionPane;

public class EntradaPaciente {
	
	static enum Prioridade {
	    NORMAL,
	    PRIORIDADE
	}
	
	private String sala;
	private String nome; 
	private String idadeEntrada;
	private int idade;

	public void criandoPaciente(){
		nome = JOptionPane.showInputDialog(nome, "Nome do Paciente" );
		sala = JOptionPane.showInputDialog(sala, "Sala de atendimento" );
		idadeEntrada = JOptionPane.showInputDialog(idade, "Idade do paciente");
		idade = Integer.parseInt(idadeEntrada);
		if(idade >= 60) {
		}
	}

	private String parseInt(String showInputDialog) {
		// TODO Auto-generated method stub
		return null;
	}
}
