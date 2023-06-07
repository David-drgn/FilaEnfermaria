package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.EntradaPaciente;

public class TelaPrincipal extends JFrame implements ActionListener {
	private JPanel buttonPanel, medicoPanel, pacientePanel, atendentePanel;
	private JButton buttons[];
	private JLabel label[];
	private JFrame c;
	private int contagem = 0; 
	public TelaPrincipal( )
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,4));
		buttonPanel.setSize(100,100);
		
		medicoPanel = new JPanel();
		medicoPanel.setLayout(new GridLayout(4,2));
		medicoPanel.setSize(200,200);
		medicoPanel.setVisible(false);
		
		pacientePanel = new JPanel();
		pacientePanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		pacientePanel.setSize(500,500);
		pacientePanel.setVisible(false);
		
		atendentePanel = new JPanel();
		atendentePanel.setLayout(new GridLayout(1,2));
		pacientePanel.setSize(100,100);
		atendentePanel.setVisible(false);
		
		buttons = new JButton[ 11 ];
		label = new JLabel[ 20 ];
		
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
		buttons[ 5 ] = new JButton( "Sair" );
		
		atendentePanel.add(buttons[4]);
		atendentePanel.add(buttons[5]);
		buttons[ 5 ].setBackground(Color.RED);
		
		buttons[ 4 ].addActionListener(this);
		buttons[ 5 ].addActionListener(this);
		
		/* TELA MEDICO */
		
		label[4] = new JLabel("--- Nome prÃ³ximo paciente: ");
		label[5] = new JLabel("NOME PACIENTE");
		label[6] = new JLabel("--- Senha: ");
		label[7] = new JLabel("SENHA");
		label[8] = new JLabel("--- PRIORIDADE: ");
		label[9] = new JLabel("PRIORIDADE");
		
		buttons[ 6 ] = new JButton("VOLTAR");
		buttons[ 6 ].setBackground(Color.RED);
		buttons[ 7 ] = new JButton("ATENDER PACIENTE");
		
		buttons[6].addActionListener(this);
		buttons[7].addActionListener(this);
		
		medicoPanel.add(label[4]); medicoPanel.add(label[5]);
		medicoPanel.add(label[6]); medicoPanel.add(label[7]);
		medicoPanel.add(label[8]); medicoPanel.add(label[9]);
		medicoPanel.add(buttons[ 6 ]); medicoPanel.add(buttons[ 7 ]);
		
		/* TELA PACIENTE */
		
		label[10] = new JLabel("Próximo da fila:");
		label[11] = new JLabel("Próximo da fila:");
		
		pacientePanel.add(label[10], BorderLayout.NORTH);
		pacientePanel.add(label[11], BorderLayout.CENTER);
		
		
		c = new JFrame("Tela atendimento");
		c.setSize(600,100);
		
		c.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		
		c.getContentPane().add(buttonPanel);
		
		c.getContentPane().add(atendentePanel);
		
		c.getContentPane().add(medicoPanel);
		
		c.setVisible(true);
	}
	public int getContagem() {
		return contagem;
	}
	public void setContagem(int contagem) {
		this.contagem = contagem;
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
			buttonPanel.setVisible(false);
			buttonPanel.setSize(0,0);
			medicoPanel.setVisible(true);
			c.setSize(400,170);
		}
		
		/* BTN ATENDENTE */
		if(e.getSource() == buttons[1]) {
			buttonPanel.setVisible(false);
			buttonPanel.setSize(0,0);
			atendentePanel.setVisible(true);
			c.setSize(300,80);
		}
		
		/* BTN PACIENTE */
		if(e.getSource() == buttons[2]) {
			
		}
		
		/* BTN SAIR APLICACAO */
		if(e.getSource() == buttons[3]) {
			System.exit( 0 );
		}
		
		/* BTNs VOLTAR INICIAL */
		if(e.getSource() == buttons[6] || e.getSource() == buttons[5]) {
			buttonPanel.setVisible(true);
			buttonPanel.setSize(100,100);
			c.setSize(600,100);
			atendentePanel.setVisible(false);
			medicoPanel.setVisible(false);
		}
	}
}