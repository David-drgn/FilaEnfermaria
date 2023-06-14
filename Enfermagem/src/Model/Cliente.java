package Model;

import java.util.Queue;

import java.util.LinkedList;

public class Cliente {
	
	private int cont = 0;

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public Queue<String> getNomePaciente() {
		return nomePaciente;
	}

	public Queue<String> getIdadePaciente() {
		return idadePaciente;
	}

	public Queue<String> getStatusPaciente() {
		return statusPaciente;
	}

	static Queue<String> nomePaciente = new LinkedList<>();
	static Queue<String> senhaPaciente = new LinkedList<>();
	static Queue<String> idadePaciente = new LinkedList<>();
	static Queue<String> prioridadePaciente = new LinkedList<>();
	static Queue<String> statusPaciente = new LinkedList<>();

	public void adicionaPaciente(String contString, String nome, String idade, String prioridade) {
		senhaPaciente.add(contString);
		nomePaciente.add(nome);
		idadePaciente.add(idade);
		prioridadePaciente.add(prioridade);
		statusPaciente.add("AGUARDANDO");
	}

	public void mostraFilaProximo() {
		String nome, idade, senha, prior, status;
		nome = nomePaciente.peek();
		idade = idadePaciente.peek();
		senha = senhaPaciente.peek();
		prior = prioridadePaciente.peek();
		status = statusPaciente.peek();

		System.out.println("Proximo paciente---------------------------------" + "\nNome paciente: " + nome
				+ "\nIdade Paciente: " + idade + "\nSenha: " + senha + "\nPrioridade: " + prior + "\nStatus: " + status
				+ "\n-------------------------------------------------- \n");
	}

	public void removeProximo() {
		String nome, idade, senha, prior, status;
		nome = nomePaciente.remove();
		idade = idadePaciente.remove();
		senha = getSenhaPaciente().remove();
		prior = getPrioridadePaciente().remove();
		status = statusPaciente.remove();

		System.out.println("Paciente removido---------------------------------" + "\nNome paciente: " + nome
				+ "\nIdade Paciente: " + idade + "\nSenha: " + senha + "\nPrioridade: " + prior + "\nStatus: "
				+ "ATENDIDO" + "\n-------------------------------------------------- \n");
		
		HistoricoChamada historico = new HistoricoChamada();
		historico.adicionaPaciente(senha, nome, idade, prior);
	}
	
	public void removeProximoOrganiza() {
		String nome, idade, senha, prior, status;
		nome = nomePaciente.remove();
		idade = idadePaciente.remove();
		senha = senhaPaciente.remove();
		prior = prioridadePaciente.remove();
		status = statusPaciente.remove();
	}

	public void mostraFila() {
		System.out.println("Todos os paciente----------------------------------" + "\nNome paciente: " + nomePaciente
				+ "\nIdade Paciente: " + idadePaciente + "\nSenha: " + getSenhaPaciente() + "\nPrioridade: "
				+ getPrioridadePaciente() + "\nStatus: " + statusPaciente
				+ "\n-------------------------------------------------- \n");
	}

	public Queue<String> getPrioridadePaciente() {
		return prioridadePaciente;
	}

	public Queue<String> getSenhaPaciente() {
		return senhaPaciente;
	}
	
}