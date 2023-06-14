package Controller;

import Model.Cliente;
import View.TelaPrincipal;
import java.util.Queue;
import java.util.LinkedList;

public class Organiza {

	Cliente cliente = new Cliente();

	private int cont = TelaPrincipal.getCont();
	private int posicaoPrioridade = 0;
	Queue<String> nomeAux = new LinkedList<>();
	Queue<String> statusAux1 = new LinkedList<>();
	Queue<String> senhaAux = new LinkedList<>();
	Queue<String> idadeAux = new LinkedList<>();
	Queue<String> prioridadeAux = new LinkedList<>();


	private void organiza() {
		// TODO Auto-generated method stub
		if (cliente.getPrioridadePaciente().peek().equals("Preferencial")) {
			int i;
			int contaComum = 0;

			nomeAux.add(cliente.getIdadePaciente().peek());
			senhaAux.add(cliente.getSenhaPaciente().peek());
			idadeAux.add(cliente.getIdadePaciente().peek());
			prioridadeAux.add(cliente.getPrioridadePaciente().peek());

			for (i = posicaoPrioridade; i <= cont; i++) {

				if (contaComum >= 3) {

					cliente.adicionaPaciente(senhaAux.remove(), nomeAux.remove(), idadeAux.remove(),
							prioridadeAux.remove());

					for (int j = 0; j <= contaComum; j++) {
						cliente.adicionaPaciente(senhaAux.remove(), nomeAux.remove(), idadeAux.remove(),
								prioridadeAux.remove());
					}

					i = cont;
				}

				else {
					senhaAux.add(cliente.getSenhaPaciente().peek());
					nomeAux.add(cliente.getNomePaciente().peek());
					idadeAux.add(cliente.getIdadePaciente().peek());
					prioridadeAux.add(cliente.getPrioridadePaciente().peek());
					 statusAux1.add(cliente.getStatusPaciente().peek());

					cliente.removeProximo();
					contaComum = contaComum + 1;
				}
			}
		}
	}

}