package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.EntradaPaciente;

public class TelaPrincipal extends JFrame implements ActionListener {
	private JPanel buttonPanel, medicoPanel, pacientePanel, atendentePanel;
	private JButton buttons[];
	private JLabel label[];
	public TelaPrincipal( )
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,4));
		buttonPanel.setSize(100,100);
		
		medicoPanel = new JPanel();
		medicoPanel.setLayout(new GridLayout(2,4));
		medicoPanel.setSize(100,100);
		
		pacientePanel = new JPanel();
		pacientePanel.setLayout(new GridLayout(2,4));
		pacientePanel.setSize(100,100);
		
		atendentePanel = new JPanel();
		atendentePanel.setLayout(new GridLayout(1,2));
		pacientePanel.setSize(100,100);
		atendentePanel.setVisible(false);
		
		/* TELA PRINCIPAL */
		
		label = new JLabel[4];
		
		label[0] = new JLabel("--------------------", SwingConstants.CENTER);
		label[1] = new JLabel("QUAL VOCÊ ", SwingConstants.RIGHT);
		label[2] = new JLabel("SERIA?", SwingConstants.LEFT);
		label[3] = new JLabel("--------------------", SwingConstants.CENTER);
		
		buttons = new JButton[ 5 ];
		
		buttons[ 0 ] = new JButton( "Sou Médico" );
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
		
		buttons[ 3 ] = new JButton( "Adicionar paciente" );
		buttons[ 4 ] = new JButton( "Sair" );
		
		atendentePanel.add(buttons[3]);
		atendentePanel.add(buttons[4]);
		
		JFrame c = new JFrame("Tela atendimento");
		c.setSize(600,100);
		
		c.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		
		c.getContentPane().add(buttonPanel);
		
		c.getContentPane().add(atendentePanel);
		
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
		if(e.getSource() == buttons[0]) {
			buttonPanel.setVisible(false);
			buttonPanel.setPreferredSize(new Dimension(0,0));
			atendentePanel.setVisible(true);
		}
		if(e.getSource() == buttons[1]) {
			
		}
		if(e.getSource() == buttons[2]) {
			
		}
		if(e.getSource() == buttons[3]) {
			System.exit( 0 );
		}
	}
}