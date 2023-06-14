package Controller;

import Model.Cliente;
import View.TelaPrincipal;
import java.util.Queue;
import java.util.LinkedList;

public class OrganizaPacientes {
	public void organiza(String contString, String nome, String idade, String prioridade) {
		Cliente cliente = new Cliente();

		int cont = TelaPrincipal.getCont();
		int posicaoPrioridade = 0;
		Queue<String> nomeAux = new LinkedList<>();
		Queue<String> statusAux = new LinkedList<>();
		Queue<String> senhaAux = new LinkedList<>();
		Queue<String> idadeAux = new LinkedList<>();
		Queue<String> prioridadeAux = new LinkedList<>();

		// TODO Auto-generated method stub
		int i;
		int contaComum = 1;

		nomeAux.add(contString);
		senhaAux.add(nome);
		idadeAux.add(idade);
		prioridadeAux.add(prioridade);
		
		System.out.println(nomeAux.peek() + senhaAux + idadeAux + prioridadeAux);

		for (i = posicaoPrioridade; i <= cont; i++) {

			if (contaComum >= 3) {
				System.out.println("Entrou");
				for (int j = 1; j <= contaComum; j++) {
					senhaAux.add(cliente.getSenhaPaciente().peek());
					nomeAux.add(cliente.getNomePaciente().peek());
					idadeAux.add(cliente.getIdadePaciente().peek());
					prioridadeAux.add(cliente.getPrioridadePaciente().peek());
					statusAux.add(cliente.getStatusPaciente().peek());

					cliente.removeProximoOrganiza();
				}

				System.out.println(prioridadeAux.peek());

				cliente.adicionaPaciente(senhaAux.peek(), nomeAux.peek(), idadeAux.peek(), prioridadeAux.peek());
				senhaAux.remove();
				nomeAux.remove();
				idadeAux.remove();
				prioridadeAux.remove();
				statusAux.remove();

				for (int j = 2; j <= contaComum; j++) {
					System.out.println(j);
					cliente.adicionaPaciente(senhaAux.peek(), nomeAux.peek(), idadeAux.peek(), prioridadeAux.peek());
					senhaAux.remove();
					nomeAux.remove();
					idadeAux.remove();
					prioridadeAux.remove();
					statusAux.remove();
				}

				i = cont;
			}

			else {
				contaComum = contaComum + 1;
			}
		}
	}
}