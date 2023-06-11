package Controller;

import javax.swing.JOptionPane;

import Model.Cliente;
import View.TelaPrincipal;

public class EntradaPaciente {

	private enum Prioridade {
		NORMAL("Normal"), PREFERENCIAL("Preferencial");

		private static String val;

		Prioridade(String string) {
			// TODO Auto-generated constructor stub
		}

		public static String getValor() {
			return val;
		}

		public static void setValor(String valor) {
			val = valor;
		}
	}

	private String prioridade = "Normal";
	private String sala;
	private String nome = "";
	private String idadeEntrada = "";
	private int idade;

	public void criandoPaciente() {
		nome = JOptionPane.showInputDialog("Nome do Paciente");
		while (nome == null || nome == "") {
			nome = JOptionPane.showInputDialog("Nome do paciente");
		}
		idadeEntrada = JOptionPane.showInputDialog("Idade do paciente");
		while (idadeEntrada == null) {
			idadeEntrada = JOptionPane.showInputDialog("Idade do paciente");
		}
		idade = Integer.parseInt(idadeEntrada);
		if (idade >= 60) {
			prioridade = "Preferencial";
			Prioridade.setValor(prioridade);
		} else {
			Prioridade.setValor(prioridade);
		}
		
		Cliente cliente = new Cliente();
		String senha = null;
		try {
			senha = "" + (TelaPrincipal.getCont()+1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cliente.adicionaPaciente(senha, nome, idadeEntrada, prioridade);
		
	}

	public String getVal() {
		return Prioridade.getValor();
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
