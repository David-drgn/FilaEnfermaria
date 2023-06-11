package Model;

import java.util.LinkedList;
import java.util.Queue;

public class HistoricoChamada {
	static Queue<String> nomePaciente = new LinkedList<>();
	static Queue<String> senhaPaciente = new LinkedList<>();
	static Queue<String> idadePaciente = new LinkedList<>();
	static Queue<String> prioridadePaciente = new LinkedList<>();
	static Queue<String> statusPaciente = new LinkedList<>();

	public void mostraFila() {
		System.out.println("Todos os atendidos----------------------------------" + "\nNome paciente: " + nomePaciente
				+ "\nIdade Paciente: " + idadePaciente + "\nSenha: " + senhaPaciente + "\nPrioridade: "
				+ prioridadePaciente + "\nStatus: " + statusPaciente
				+ "\n-------------------------------------------------- \n");
	}
	
	public void adicionaPaciente(String contString, String nome, String idade, String prioridade) {
		senhaPaciente.add(contString);
		nomePaciente.add(nome);
		idadePaciente.add(idade);
		prioridadePaciente.add(prioridade);
		statusPaciente.add("ATENDIDO");
		
		System.out.println("ADICIONADO AO HISTORICO\n");
	}
}
