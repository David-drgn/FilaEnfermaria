package Controller;

import javax.swing.JOptionPane;

public class EntradaPaciente {
	
	private enum Prioridade {
	    NORMAL,
	    PRIORIDADE
	}
	
	private String prioridade = "NORMAL";
	private String sala;
	private String nome = ""; 
	private String idadeEntrada = "";
	private int idade;

	public void criandoPaciente(){
		nome = JOptionPane.showInputDialog("Nome do Paciente" );
		while(nome == null || nome == "") {
			nome = JOptionPane.showInputDialog("Nome do paciente");
		}
		idadeEntrada = JOptionPane.showInputDialog("Idade do paciente");
		while(idadeEntrada == null) {
			idadeEntrada = JOptionPane.showInputDialog("Idade do paciente");
		}
		idade = Integer.parseInt(idadeEntrada);
		if(idade >= 60) {
			prioridade = "PRIORIDADE";
		}
	}

	public String getPrioridade() {
		return prioridade;
	}

	public String getSala() {
		return sala;
	}

	public String getNome() {
		return nome;
	}

	public String getIdadeEntrada() {
		return idadeEntrada;
	}

	public int getIdade() {
		return idade;
	}
	
	
}
