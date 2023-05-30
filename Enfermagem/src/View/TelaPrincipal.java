package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaPrincipal extends JFrame {
	private JPanel historicoPanel, atendimentoPanel, buttonPanel;
	private JButton buttons[];
	private JLabel label[];
	public TelaPrincipal( )
	{
		atendimentoPanel = new JPanel();
		atendimentoPanel.setLayout(new GridLayout(2,3));
		label = new JLabel[ 9 ];
		
		label[0] = new JLabel("--------------------", SwingConstants.CENTER);
		label[1] = new JLabel("ORDEM DE ATENDIMENTO", SwingConstants.CENTER);
		label[2] = new JLabel("--------------------", SwingConstants.CENTER);
		
		label[3] = new JLabel("Senha", SwingConstants.CENTER);
		label[4] = new JLabel("Nome", SwingConstants.CENTER);
		label[5] = new JLabel("Sala", SwingConstants.CENTER);
		
		label[0].setAlignmentX(Component.CENTER_ALIGNMENT);
		label[1].setAlignmentX(Component.CENTER_ALIGNMENT);
		label[2].setAlignmentX(Component.CENTER_ALIGNMENT);
		
		atendimentoPanel.add( label[ 0 ] );
		atendimentoPanel.add( label[ 1 ] );
		atendimentoPanel.add( label[ 2 ] );
		
		atendimentoPanel.add( label[ 3 ] );
		atendimentoPanel.add( label[ 4 ] );
		atendimentoPanel.add( label[ 5 ] );
		
		historicoPanel = new JPanel();
		historicoPanel.setLayout(new GridLayout(1,3));
		
		label[6] = new JLabel("--------------------", SwingConstants.CENTER);
		label[7] = new JLabel("HISTORICO DE ATENDIMENTO", SwingConstants.CENTER);
		label[8] = new JLabel("--------------------", SwingConstants.CENTER);
		
		historicoPanel.add(label[6]);
		historicoPanel.add(label[7]);
		historicoPanel.add(label[8]);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttons = new JButton[ 2 ];
		
		buttons[ 0 ] = new JButton( "Adicionar paciente" );
		buttons[0].setSize(100,100);
		buttonPanel.add( buttons[ 0 ] );
		
		buttons[ 1 ] = new JButton( "Paciente atendido" );
		buttonPanel.add( buttons[ 1 ] );
		
		JFrame c = new JFrame("Tela atendimento");
		c.setSize(400,400);
		
		c.getContentPane().setLayout(new GridLayout(3,1));
		
		c.getContentPane().add( atendimentoPanel);
		c.getContentPane().add( historicoPanel );
		c.getContentPane().add( buttonPanel);
		
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
}