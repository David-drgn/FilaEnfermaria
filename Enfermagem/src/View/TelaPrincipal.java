package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.EntradaPaciente;
import Controller.PedeSenha;
import Model.Cliente;
import Model.HistoricoChamada;

public class TelaPrincipal extends JFrame implements ActionListener {

	private JPanel buttonPanel, medicoPanel, pacientePanel, atendentePanel, pacientePanelHistorico, historicoOuPaciente;
	private JButton buttons[];
	private JLabel label[];
	private JTextField txtField[][];
	private JFrame c;
	private String aux1, aux2, aux3, aux4, aux5;
	private String prioridade;
	private static int cont;
	private int contAtendimento;
	private int posicaoPrioridade, auxposicaoPrioridade = 0;
	Cliente cliente = new Cliente();
	HistoricoChamada historico = new HistoricoChamada();

	public TelaPrincipal() {
		txtField = new JTextField[51][6];

		historicoOuPaciente = new JPanel();
		historicoOuPaciente.setLayout(new GridLayout(1, 2));
		historicoOuPaciente.setSize(100, 100);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 4));
		buttonPanel.setSize(100, 100);

		medicoPanel = new JPanel();
		medicoPanel.setLayout(new GridLayout(4, 2));
		medicoPanel.setSize(200, 200);

		pacientePanelHistorico = new JPanel();
		pacientePanelHistorico.setLayout(new GridLayout(0, 5));
		pacientePanelHistorico.setSize(1000, 700);

		pacientePanel = new JPanel();
		pacientePanel.setLayout(new GridLayout(0, 5));
		pacientePanel.setSize(1000, 700);

		atendentePanel = new JPanel();
		atendentePanel.setLayout(new GridLayout(1, 2));
		pacientePanel.setSize(100, 100);

		buttons = new JButton[20];
		label = new JLabel[20];

		/* TELA PRINCIPAL */

		label[0] = new JLabel("--------------------", SwingConstants.CENTER);
		label[1] = new JLabel("QUAL VOCE ", SwingConstants.RIGHT);
		label[2] = new JLabel("SERIA?", SwingConstants.LEFT);
		label[3] = new JLabel("--------------------", SwingConstants.CENTER);

		buttons[0] = new JButton("Sou Medico");
		buttonPanel.add(buttons[0]);

		buttons[1] = new JButton("Sou Atendente");
		buttonPanel.add(buttons[1]);

		buttons[2] = new JButton("Sou Paciente");
		buttonPanel.add(buttons[2]);

		buttons[3] = new JButton("Sair");
		buttonPanel.add(buttons[3]);

		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		buttons[2].addActionListener(this);
		buttons[3].addActionListener(this);

		buttonPanel.add(label[0]);
		buttonPanel.add(label[1]);
		buttonPanel.add(label[2]);
		buttonPanel.add(label[3]);
		buttonPanel.add(buttons[0]);
		buttonPanel.add(buttons[1]);
		buttonPanel.add(buttons[2]);
		buttonPanel.add(buttons[3]);

		/* TELA ATENDENTE */

		buttons[4] = new JButton("Adicionar paciente");
		buttons[5] = new JButton("Voltar");

		atendentePanel.add(buttons[4]);
		atendentePanel.add(buttons[5]);
		buttons[5].setBackground(Color.RED);

		buttons[4].addActionListener(this);
		buttons[5].addActionListener(this);

		/* TELA MEDICO */

		label[4] = new JLabel("--- Nome próximo paciente: ");
		label[5] = new JLabel("NOME PACIENTE", SwingConstants.CENTER);
		label[6] = new JLabel("--- Senha: ");
		label[7] = new JLabel("SENHA", SwingConstants.CENTER);
		label[8] = new JLabel("--- PRIORIDADE: ");
		label[9] = new JLabel("PRIORIDADE", SwingConstants.CENTER);

		buttons[6] = new JButton("VOLTAR");
		buttons[6].setBackground(Color.RED);
		buttons[7] = new JButton("ATENDER PACIENTE");
		buttons[7].setEnabled(false);

		buttons[6].addActionListener(this);
		buttons[7].addActionListener(this);

		medicoPanel.add(label[4]);
		medicoPanel.add(label[5]);
		medicoPanel.add(label[6]);
		medicoPanel.add(label[7]);
		medicoPanel.add(label[8]);
		medicoPanel.add(label[9]);
		medicoPanel.add(buttons[6]);
		medicoPanel.add(buttons[7]);

		/* TELA PACIENTE */

		label[10] = new JLabel("  --- Senha paciente: ");
		label[11] = new JLabel("--- Nome paciente: ");
		label[12] = new JLabel("--- Idade paciente: ");
		label[13] = new JLabel("--- Prioridade: ");
		label[14] = new JLabel("--- Status: ");

		buttons[8] = new JButton("Voltar");
		buttons[8].addActionListener(this);
		buttons[8].setBackground(Color.RED);

		buttons[12] = new JButton("OPCOES DO PACIENTE:");
		buttons[12].setBackground(Color.LIGHT_GRAY);

		buttons[9] = new JButton("Ver minha posicao");
		buttons[9].addActionListener(this);
		buttons[9].setBackground(Color.RED);

		buttons[10] = new JButton("Ver pacientes na fila de espera");
		buttons[10].addActionListener(this);
		buttons[10].setBackground(Color.RED);

		buttons[11] = new JButton("Ver historico de pacientes");
		buttons[11].addActionListener(this);
		buttons[11].setBackground(Color.RED);

		pacientePanel.add(label[10]);
		pacientePanel.add(label[11]);
		pacientePanel.add(label[12]);
		pacientePanel.add(label[13]);
		pacientePanel.add(label[14]);
		pacientePanel.add(buttons[8]);
		pacientePanel.add(buttons[12]);
		pacientePanel.add(buttons[9]);
		pacientePanel.add(buttons[10]);
		pacientePanel.add(buttons[11]);

		/* TELA HISTORICO PACIENTE */

		label[15] = new JLabel("  --- Senha paciente: ");
		label[16] = new JLabel("--- Nome paciente: ");
		label[17] = new JLabel("--- Idade paciente: ");
		label[18] = new JLabel("--- Prioridade: ");
		label[19] = new JLabel("--- Status: ");

		buttons[13] = new JButton("Voltar");
		buttons[13].addActionListener(this);
		buttons[13].setBackground(Color.RED);

		buttons[14] = new JButton("OPCOES DO PACIENTE:");
		buttons[14].setBackground(Color.LIGHT_GRAY);

		buttons[15] = new JButton("Ver minha posicao");
		buttons[15].addActionListener(this);
		buttons[15].setBackground(Color.RED);

		buttons[16] = new JButton("Ver pacientes na fila de espera");
		buttons[16].addActionListener(this);
		buttons[16].setBackground(Color.RED);

		buttons[17] = new JButton("Ver historico de pacientes");
		buttons[17].addActionListener(this);
		buttons[17].setBackground(Color.RED);

		pacientePanelHistorico.add(label[15]);
		pacientePanelHistorico.add(label[16]);
		pacientePanelHistorico.add(label[17]);
		pacientePanelHistorico.add(label[18]);
		pacientePanelHistorico.add(label[19]);
		pacientePanelHistorico.add(buttons[13]);
		pacientePanelHistorico.add(buttons[14]);
		pacientePanelHistorico.add(buttons[15]);
		pacientePanelHistorico.add(buttons[16]);
		pacientePanelHistorico.add(buttons[17]);

		/* TELA DE ESCOLHA */

		buttons[18] = new JButton("SIM");
		buttons[18].setBackground(Color.red);

		buttons[19] = new JButton("NAO");

		buttons[18].addActionListener(this);
		buttons[19].addActionListener(this);

		historicoOuPaciente.add(buttons[18]);
		historicoOuPaciente.add(buttons[19]);

		c = new JFrame("Tela atendimento");
		c.setSize(600, 100);

		c.getContentPane().setLayout(new GridLayout(0, 1));

		c.getContentPane().add(buttonPanel);

		c.setVisible(true);
	}

	public static void main(String args[]) {
		TelaPrincipal app = new TelaPrincipal();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		/* BTN MEDICO */
		if (e.getSource() == buttons[0]) {
			c.getContentPane().remove(buttonPanel);
			c.add(medicoPanel);
			c.setSize(400, 170);
		}

		/* BTN ATENDENTE */
		if (e.getSource() == buttons[1]) {
			c.remove(buttonPanel);
			c.add(atendentePanel);
			c.setSize(300, 80);
		}

		/* BTN PACIENTE */
		if (e.getSource() == buttons[2]) {
			if (cont == 0) {
				JOptionPane.showMessageDialog(c, "FILA VAZIA");
			} else if (cont == contAtendimento) {
				JOptionPane.showMessageDialog(c, "NEHUM CLIENTE A ESPERA");
				JOptionPane.showMessageDialog(c, "Deseja entrar na aba de historico?");
				c.remove(buttonPanel);
				c.add(historicoOuPaciente);
				c.setSize(10, 200);
				c.setSize(200, 80);
			} else {
				c.remove(buttonPanel);
				c.add(pacientePanel);
				c.setSize(1000, 200);
			}
		}

		/* BTN SAIR APLICACAO */
		if (e.getSource() == buttons[3]) {
			System.exit(0);
		}

		if (e.getSource() == buttons[4]) {
			if (cont == 50) {
				JOptionPane.showMessageDialog(c, "FILA CHEIA");
			} else {
				posicaoPrioridade = cliente.getCont();
				
				pacientePanel.remove(buttons[8]);
				pacientePanel.remove(buttons[9]);
				pacientePanel.remove(buttons[10]);
				pacientePanel.remove(buttons[11]);
				pacientePanel.remove(buttons[12]);
				String contString = "" + (cont + 1);
				EntradaPaciente adicionaPaciente = new EntradaPaciente();
				adicionaPaciente.criandoPaciente();
				buttons[7].setEnabled(true);

				txtField[cont][1] = new JTextField(contString);
				txtField[cont][2] = new JTextField(adicionaPaciente.getNome());
				txtField[cont][3] = new JTextField(adicionaPaciente.getIdadeEntrada());
				txtField[cont][4] = new JTextField(adicionaPaciente.getVal());
				txtField[cont][5] = new JTextField("AGUARDANDO");

				cliente.mostraFila();

				txtField[cont][1].setEnabled(false);
				txtField[cont][2].setEnabled(false);
				txtField[cont][3].setEnabled(false);
				txtField[cont][4].setEnabled(false);
				txtField[cont][5].setEnabled(false);
				txtField[cont][1].setHorizontalAlignment(JTextField.CENTER);
				txtField[cont][2].setHorizontalAlignment(JTextField.CENTER);
				txtField[cont][3].setHorizontalAlignment(JTextField.CENTER);
				txtField[cont][4].setHorizontalAlignment(JTextField.CENTER);
				txtField[cont][5].setHorizontalAlignment(JTextField.CENTER);
				txtField[cont][1].setDisabledTextColor(Color.RED);
				txtField[cont][2].setDisabledTextColor(Color.RED);
				txtField[cont][3].setDisabledTextColor(Color.RED);
				txtField[cont][4].setDisabledTextColor(Color.RED);
				txtField[cont][5].setDisabledTextColor(Color.RED);
				pacientePanel.add(txtField[cont][1]);
				pacientePanel.add(txtField[cont][2]);
				pacientePanel.add(txtField[cont][3]);
				pacientePanel.add(txtField[cont][4]);
				pacientePanel.add(txtField[cont][5]);

				prioridade = txtField[cont][4].getText();

				pacientePanel.add(buttons[8]);
				pacientePanel.add(buttons[12]);
				pacientePanel.add(buttons[9]);
				pacientePanel.add(buttons[10]);
				pacientePanel.add(buttons[11]);

				if (prioridade.equals("Preferencial")) {
					int i;
					int contaComum = 0;
					for (i = posicaoPrioridade; i <= cont; i++) {

						if (contaComum >= 3) {

							aux1 = txtField[i][1].getText();
							aux2 = txtField[i][2].getText();
							aux3 = txtField[i][3].getText();
							aux4 = txtField[i][4].getText();
							aux5 = txtField[i][5].getText();

							txtField[i][1].setText(txtField[cont][1].getText());
							txtField[i][2].setText(txtField[cont][2].getText());
							txtField[i][3].setText(txtField[cont][3].getText());
							txtField[i][4].setText(txtField[cont][4].getText());
							txtField[i][5].setText(txtField[cont][5].getText());

							txtField[cont][1].setText(aux1);
							txtField[cont][2].setText(aux2);
							txtField[cont][3].setText(aux3);
							txtField[cont][4].setText(aux4);
							txtField[cont][5].setText(aux5);
							i = cont;
							cliente.setCont(i);
						}

						else {
							contaComum = contaComum + 1;
							cliente.setCont(cont);
						}
					}
				}

				if (label[7].getText() == "SENHA") {
					label[5].setText(txtField[cont][2].getText());
					label[7].setText(txtField[cont][1].getText());
					label[9].setText(txtField[cont][4].getText());
				} else {
					System.out.println("Cliente a espera");
				}
				cont = 1 + cont;
			}
		}

		/* BTNs VOLTAR INICIAL */
		if (e.getSource() == buttons[6] || e.getSource() == buttons[5] || e.getSource() == buttons[8]
				|| e.getSource() == buttons[13]) {
			c.remove(atendentePanel);
			c.remove(medicoPanel);
			c.remove(pacientePanel);
			c.remove(pacientePanelHistorico);
			c.add(buttonPanel);
			c.setSize(600, 100);
		}

		if (e.getSource() == buttons[7]) {
			System.out.println("\nCliente atendido");
			txtField[contAtendimento][5].setText("ATENDIDO");
			txtField[contAtendimento][5].setBackground(Color.red);
			txtField[contAtendimento][5].setDisabledTextColor(Color.black);

			cliente.removeProximo();
			cliente.mostraFila();

			pacientePanel.remove(txtField[contAtendimento][1]);
			pacientePanel.remove(txtField[contAtendimento][2]);
			pacientePanel.remove(txtField[contAtendimento][3]);
			pacientePanel.remove(txtField[contAtendimento][4]);
			pacientePanel.remove(txtField[contAtendimento][5]);

			pacientePanelHistorico.remove(buttons[13]);
			pacientePanelHistorico.remove(buttons[14]);
			pacientePanelHistorico.remove(buttons[15]);
			pacientePanelHistorico.remove(buttons[16]);
			pacientePanelHistorico.remove(buttons[17]);

			pacientePanelHistorico.add(txtField[contAtendimento][1]);
			pacientePanelHistorico.add(txtField[contAtendimento][2]);
			pacientePanelHistorico.add(txtField[contAtendimento][3]);
			pacientePanelHistorico.add(txtField[contAtendimento][4]);
			pacientePanelHistorico.add(txtField[contAtendimento][5]);

			pacientePanelHistorico.add(buttons[13]);
			pacientePanelHistorico.add(buttons[14]);
			pacientePanelHistorico.add(buttons[15]);
			pacientePanelHistorico.add(buttons[16]);
			pacientePanelHistorico.add(buttons[17]);

			pacientePanel.repaint();
			pacientePanelHistorico.repaint();

			contAtendimento = 1 + contAtendimento;

			if (contAtendimento == cont) {
				label[5].setText("NOME PACIENTE");
				label[7].setText("SENHA");
				label[9].setText("PRIORIDADE");
				buttons[7].setEnabled(false);
			}
			if (contAtendimento < cont) {
				label[5].setText(txtField[contAtendimento][2].getText());
				label[7].setText(txtField[contAtendimento][1].getText());
				label[9].setText(txtField[contAtendimento][4].getText());
				buttons[7].setEnabled(true);
			}

			else {
				label[5].setText("NOME PACIENTE");
				label[7].setText("SENHA");
				label[9].setText("PRIORIDADE");
				buttons[7].setEnabled(false);
			}
		}

		if (e.getSource() == buttons[9] || e.getSource() == buttons[15]) {

			for (int i = 0; i < cont; i++) {

				txtField[i][1].setDisabledTextColor(Color.RED);
				txtField[i][2].setDisabledTextColor(Color.RED);
				txtField[i][3].setDisabledTextColor(Color.RED);
				txtField[i][4].setDisabledTextColor(Color.RED);

				txtField[i][1].setBackground(Color.WHITE);
				txtField[i][2].setBackground(Color.WHITE);
				txtField[i][3].setBackground(Color.WHITE);
				txtField[i][4].setBackground(Color.WHITE);

				if (txtField[i][5].getText().equals("ATENDIDO")) {
					txtField[i][5].setBackground(Color.red);
					txtField[i][5].setDisabledTextColor(Color.black);
				}

				else {
					txtField[i][5].setBackground(Color.white);
					txtField[i][5].setDisabledTextColor(Color.red);
				}
			}

			PedeSenha senha = new PedeSenha();
			int id;
			id = Integer.parseInt(senha.getSenha());
			id = id - 1;

			if (id >= cont) {
				JOptionPane.showMessageDialog(null, "Senha nao encontrada");
			}

			else {
				id = id-1;
				String senha1 = "" + (id+2);
				for (int i = 0; i <= cont - 1; i++) {
					if (txtField[i][1].getText().equals(senha1)) {
						txtField[i][1].setBackground(Color.red);
						txtField[i][2].setBackground(Color.red);
						txtField[i][3].setBackground(Color.red);
						txtField[i][4].setBackground(Color.red);
						txtField[i][5].setBackground(Color.red);

						txtField[i][1].setDisabledTextColor(Color.BLACK);
						txtField[i][2].setDisabledTextColor(Color.BLACK);
						txtField[i][3].setDisabledTextColor(Color.BLACK);
						txtField[i][4].setDisabledTextColor(Color.BLACK);
						txtField[i][5].setDisabledTextColor(Color.BLACK);
						i = cont;
					}
				}
				
			}

		}

		if (e.getSource() == buttons[10]) {
			for (int i = 0; i < cont; i++) {

				txtField[i][1].setDisabledTextColor(Color.RED);
				txtField[i][2].setDisabledTextColor(Color.RED);
				txtField[i][3].setDisabledTextColor(Color.RED);
				txtField[i][4].setDisabledTextColor(Color.RED);

				txtField[i][1].setBackground(Color.WHITE);
				txtField[i][2].setBackground(Color.WHITE);
				txtField[i][3].setBackground(Color.WHITE);
				txtField[i][4].setBackground(Color.WHITE);

				if (txtField[i][5].getText().equals("ATENDIDO")) {
					pacientePanel.remove(txtField[i][1]);
					pacientePanel.remove(txtField[i][2]);
					pacientePanel.remove(txtField[i][3]);
					pacientePanel.remove(txtField[i][4]);
					pacientePanel.remove(txtField[i][5]);
					pacientePanel.repaint();
				}
			}
		}

		if (e.getSource() == buttons[11]) {
			if (contAtendimento == 0) {
				JOptionPane.showMessageDialog(c, "NINGUEM FOI ATENDIDO");
			} else {
				c.remove(pacientePanel);
				c.add(pacientePanelHistorico);
				historico.mostraFila();
				c.setSize(10, 200);
				c.setSize(1000, 200);
			}
		}

		if (e.getSource() == buttons[16]) {
			if (cont == 0) {
				JOptionPane.showMessageDialog(c, "FILA VAZIA");
			}
			if (cont == contAtendimento) {
				JOptionPane.showMessageDialog(c, "NEHUM CLIENTE A ESPERA");
				JOptionPane.showMessageDialog(c, "Deseja sair da aba de historico?");
				c.remove(pacientePanelHistorico);
				c.add(historicoOuPaciente);
				c.setSize(10, 200);
				c.setSize(200, 80);
			} else {
				c.remove(pacientePanelHistorico);
				c.add(pacientePanel);
				c.setSize(10, 200);
				c.setSize(1000, 200);
			}
		}

		if (e.getSource() == buttons[18]) {
			c.add(pacientePanelHistorico);
			c.remove(historicoOuPaciente);
			c.setSize(10, 200);
			c.setSize(1000, 200);
		}

		if (e.getSource() == buttons[19]) {
			c.add(buttonPanel);
			c.remove(historicoOuPaciente);
			c.setSize(600, 100);
		}

	}

	public static int getCont() {
		return cont;
	}
}