package Controller;

import Model.Cliente;
import View.TelaPrincipal;
import java.util.Queue;
import java.util.LinkedList;

public class OrganizaPacientes {
	
	Cliente cliente = new Cliente();
	
	private int cont = TelaPrincipal.getCont();
	private int posicaoPrioridade = 0;
	
	Queue<String> nomeAux = new LinkedList<>();
	Queue<String> senhaAux = new LinkedList<>();
	Queue<String> idadeAux = new LinkedList<>();
	Queue<String> prioridadeAux = new LinkedList<>();
	Queue<String> statusAux = new LinkedList<>();
	Queue<String> aux = new LinkedList<>();
	
	for (i = 0; i >= cont; i++) {
		String prioridade = cliente.getPrioridadePaciente().peek();
		if (prioridade.equals("Preferencial")) {
			int i;
			int contaComum = 0;
			cliente.getStatusPaciente().peek();
			cliente.getNomePaciente().peek();
			cliente.getIdadePaciente().peek(); 
			cliente.getPrioridadePaciente().peek();
			for (i = posicaoPrioridade; i <= cont; i++) {

				if (contaComum >= 3) {

					cliente.adicionaPaciente(cliente.getStatusPaciente().peek(), cliente.getNomePaciente().peek(), cliente.getIdadePaciente().peek(), cliente.getPrioridadePaciente().peek());

					i = cont;
				}

				else {
					senhaAux.add(cliente.getSenhaPaciente().peek());
					nomeAux.add(cliente.getNomePaciente().peek());
					idadeAux.add(cliente.getIdadePaciente().peek());
					prioridadeAux.add(cliente.getPrioridadePaciente().peek());
					statusAux.add(cliente.getStatusPaciente().peek());
					
					cliente.removeProximo();
					contaComum = contaComum + 1;
				}
			}
		}
	}
}}
