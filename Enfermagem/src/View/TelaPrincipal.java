package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.EntradaPaciente;

public class TelaPrincipal extends JFrame implements ActionListener {
	private JPanel buttonPanel, medicoPanel, pacientePanel, atendentePanel;
	private JButton buttons[];
	private JLabel label[];
	private JTextField txtField[][];
	private JFrame c;
	private String aux1,aux2,aux3,aux4,aux5;
	private String prioridade;
	private int cont, contAtendimento, posicaoPrioridade = 0;
	public TelaPrincipal( )
	{
		txtField = new JTextField[6000][6];
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,4));
		buttonPanel.setSize(100,100);
		
		medicoPanel = new JPanel();
		medicoPanel.setLayout(new GridLayout(4,2));
		medicoPanel.setSize(200,200);
		
		pacientePanel = new JPanel();
		pacientePanel.setLayout(new GridLayout(0,5));
		pacientePanel.setSize(1000,700);
		
		atendentePanel = new JPanel();
		atendentePanel.setLayout(new GridLayout(1,2));
		pacientePanel.setSize(100,100);
		
		buttons = new JButton[ 20 ];
		label = new JLabel[ 15 ];
		
		/* TELA PRINCIPAL */
		
		label[0] = new JLabel("--------------------", SwingConstants.CENTER);
		label[1] = new JLabel("QUAL VOCE ", SwingConstants.RIGHT);
		label[2] = new JLabel("SERIA?", SwingConstants.LEFT);
		label[3] = new JLabel("--------------------", SwingConstants.CENTER);
		
		buttons[ 0 ] = new JButton( "Sou Medico" );
		buttonPanel.add( buttons[ 0 ] );
		
		buttons[ 1 ] = new JButton( "Sou Atendente" );
		buttonPanel.add( buttons[ 1 ] );
		
		buttons[ 2 ] = new JButton( "Sou Paciente" );
		buttonPanel.add( buttons[ 2 ] );
		
		buttons[ 3 ] = new JButton( "Sair" );
		buttonPanel.add( buttons[ 3 ] );
		
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		buttons[2].addActionListener(this);
		buttons[3].addActionListener(this);
		
		buttonPanel.add(label[0]);buttonPanel.add(label[1]);buttonPanel.add(label[2]);buttonPanel.add(label[3]);
		buttonPanel.add(buttons[0]);buttonPanel.add(buttons[1]);buttonPanel.add(buttons[2]);buttonPanel.add(buttons[3]);
	
		/* TELA ATENDENTE */
		
		buttons[ 4 ] = new JButton( "Adicionar paciente" );
		buttons[ 5 ] = new JButton( "Voltar" );
		
		atendentePanel.add(buttons[4]);
		atendentePanel.add(buttons[5]);
		buttons[ 5 ].setBackground(Color.RED);
		
		buttons[ 4 ].addActionListener(this);
		buttons[ 5 ].addActionListener(this);
		
		/* TELA MEDICO */
		
		label[4] = new JLabel("--- Nome próximo paciente: ");
		label[5] = new JLabel("NOME PACIENTE");
		label[6] = new JLabel("--- Senha: ");
		label[7] = new JLabel("SENHA");
		label[8] = new JLabel("--- PRIORIDADE: ");
		label[9] = new JLabel("PRIORIDADE");
		
		buttons[ 6 ] = new JButton("VOLTAR");
		buttons[ 6 ].setBackground(Color.RED);
		buttons[ 7 ] = new JButton("ATENDER PACIENTE");
		buttons[7].setEnabled(false);
		
		buttons[6].addActionListener(this);
		buttons[7].addActionListener(this);
		
		medicoPanel.add(label[4]); medicoPanel.add(label[5]);
		medicoPanel.add(label[6]); medicoPanel.add(label[7]);
		medicoPanel.add(label[8]); medicoPanel.add(label[9]);
		medicoPanel.add(buttons[ 6 ]); medicoPanel.add(buttons[ 7 ]);
		
		/* TELA PACIENTE */
		
		label[10] = new JLabel("  --- Senha paciente: ");
		label[11] = new JLabel("--- Nome paciente: ");
		label[12] = new JLabel("--- Idade paciente: ");
		label[13] = new JLabel("--- Prioridade: ");
		label[14] = new JLabel("--- Status: ");
		
		buttons[8] = new JButton("Voltar");
		buttons[8].addActionListener(this);
		buttons[ 8 ].setBackground(Color.RED);
		
		pacientePanel.add(label[10]); pacientePanel.add(label[11]); pacientePanel.add(label[12]); pacientePanel.add(label[13]); pacientePanel.add(label[14]);
		pacientePanel.add(buttons[8]);
		
		c = new JFrame("Tela atendimento");
		c.setSize(600,100);
		
		c.getContentPane().setLayout(new GridLayout(0,1));
		
		c.getContentPane().add(buttonPanel);
		
		c.setVisible(true);
	}
	public static void main( String args[] )
	{
		TelaPrincipal app = new TelaPrincipal( );
		app.addWindowListener(
				new WindowAdapter() {
					public void windowClosing( WindowEvent e )
					{ System.exit( 0 ); } } );
	}
	public void actionPerformed(ActionEvent e) {
		
		/* BTN MEDICO */
		if(e.getSource() == buttons[0]) {
			c.getContentPane().remove(buttonPanel);
			c.add(medicoPanel);
			c.setSize(400,170);
		}
		
		/* BTN ATENDENTE */
		if(e.getSource() == buttons[1]) {
			c.remove(buttonPanel);
			c.add(atendentePanel);
			c.setSize(300,80);
		}
		
		/* BTN PACIENTE */
		if(e.getSource() == buttons[2]) {
			
			c.remove(buttonPanel);
			c.add(pacientePanel);
			c.setSize(1000,200);
		}
		
		/* BTN SAIR APLICACAO */
		if(e.getSource() == buttons[3]) {
			System.exit( 0 );
		}
		
		if(e.getSource() == buttons[ 4 ]) {
			pacientePanel.remove(buttons[8]);
			String contString = "" + (cont+1);
			EntradaPaciente adicionaPaciente = new EntradaPaciente();
			adicionaPaciente.criandoPaciente();
			buttons[7].setEnabled(true);

			txtField[cont][1] = new JTextField(contString);
			txtField[cont][2] = new JTextField(adicionaPaciente.getNome());
			txtField[cont][3] = new JTextField(adicionaPaciente.getIdadeEntrada());
			txtField[cont][4] = new JTextField(adicionaPaciente.getPrioridade());
			txtField[cont][5] = new JTextField("AGUARDANDO");
			
			txtField[cont][1].setEnabled(false); txtField[cont][2].setEnabled(false); txtField[cont][3].setEnabled(false); txtField[cont][4].setEnabled(false); txtField[cont][5].setEnabled(false);
			txtField[cont][1].setHorizontalAlignment(JTextField.CENTER); txtField[cont][2].setHorizontalAlignment(JTextField.CENTER); txtField[cont][3].setHorizontalAlignment(JTextField.CENTER); txtField[cont][4].setHorizontalAlignment(JTextField.CENTER); txtField[cont][5].setHorizontalAlignment(JTextField.CENTER);
			txtField[cont][1].setDisabledTextColor(Color.RED);txtField[cont][2].setDisabledTextColor(Color.RED);txtField[cont][3].setDisabledTextColor(Color.RED);txtField[cont][4].setDisabledTextColor(Color.RED);txtField[cont][5].setDisabledTextColor(Color.RED);
			pacientePanel.add(txtField[cont][1]);pacientePanel.add(txtField[cont][2]);pacientePanel.add(txtField[cont][3]);pacientePanel.add(txtField[cont][4]);pacientePanel.add(txtField[cont][5]);
			
			prioridade = txtField[cont][4].getText();
			System.out.println(prioridade);
			
			pacientePanel.add(buttons[8]);
			if(prioridade.equals("PRIORIDADE")) {
				int i;
				int contaComum = 0;
				for (i = posicaoPrioridade; i <= cont; i++) {
					
					if(contaComum == 3) {
						System.out.println("ORGANIZANDO");
						
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
					}
					
					else {
						contaComum = contaComum + 1;
					}
					
				}
				posicaoPrioridade = cont;
			}
			
			if(label[7].getText() == "SENHA") {
				label[5].setText(txtField[cont][2].getText());
				label[7].setText(txtField[cont][1].getText());
				label[9].setText(txtField[cont][4].getText());
			}
			else {
				System.out.println("Cliente a espera");
			}
			cont = 1 + cont;
		}
		
		/* BTNs VOLTAR INICIAL */
		if(e.getSource() == buttons[6] || e.getSource() == buttons[5] || e.getSource() == buttons[8]) {
			c.remove(atendentePanel);
			c.remove(medicoPanel);
			c.remove(pacientePanel);
			c.add(buttonPanel);
			c.setSize(600,100);
		}
		
		if(e.getSource() == buttons[ 7 ]) {
			System.out.println("Cliente atendido");
			txtField[contAtendimento][5].setText("ATENDIDO");
			contAtendimento = 1 + contAtendimento;
			
			if(contAtendimento == cont) {
				label[5].setText("NOME PACIENTE");
				label[7].setText("SENHA");
				label[9].setText("PRIORIDADE");
				buttons[7].setEnabled(false);
			}
			if(contAtendimento < cont) {
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
		
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
}