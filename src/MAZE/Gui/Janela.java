package MAZE.Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import MAZE.Logic.Dragon;
import MAZE.Logic.Maze;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Janela {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Maze maze = new Maze();
	private GPainel panel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela()  {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 11));
		frame.setBounds(100, 100, 643, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(label);
		
		JLabel lblDimensoDoLabirinto = new JLabel("Dimens\u00E3o do labirinto");
		lblDimensoDoLabirinto.setBounds(33, 36, 135, 14);
		frame.getContentPane().add(lblDimensoDoLabirinto);
		
		textField = new JTextField();
		textField.setText("11");
		textField.setBounds(178, 33, 64, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNmeroDeDrages = new JLabel("N\u00FAmero de drag\u00F5es");
		lblNmeroDeDrages.setBounds(33, 64, 135, 14);
		frame.getContentPane().add(lblNmeroDeDrages);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(178, 61, 64, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTipoDeDrages = new JLabel("Tipo de drag\u00F5es");
		lblTipoDeDrages.setBounds(33, 93, 94, 14);
		frame.getContentPane().add(lblTipoDeDrages);
		
		String[] dragonType = {"Estático", "Aleatório", "Aleatório e adormecido"};
		JComboBox comboBox = new JComboBox(dragonType);
		comboBox.setBounds(178, 92, 135, 20);
		frame.getContentPane().add(comboBox);	
		
		JLabel lblState = new JLabel("Pode gerar novo labirinto!");
		lblState.setBounds(33, 396, 164, 14);
		frame.getContentPane().add(lblState);		
		
		//Cria botoes
		JButton btnCima = new JButton("Cima");
		btnCima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maze.moveHero('W');
				panel.setMaze(maze);
				if (maze.getDragon().getType() == Dragon.Type.RANDOM )
					maze.moveDragonRandomly();
				if (maze.getDragon().getType() == Dragon.Type.SLEEPING ){
					maze.randomSleep();
					if (!maze.getDragon().getDragonAsleep())
						maze.moveDragonRandomly();
				}
				maze.checkDragonPosition();
				panel.repaint();
				if (maze.getVitoria() == true)
					lblState.setText("Ganhou o jogo!");
			}
		});
		btnCima.setEnabled(false);
		btnCima.setBounds(453, 194, 89, 37);
		frame.getContentPane().add(btnCima);
		
		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maze.moveHero('A');
				panel.setMaze(maze);
				if (maze.getDragon().getType() == Dragon.Type.RANDOM )
					maze.moveDragonRandomly();
				if (maze.getDragon().getType() == Dragon.Type.SLEEPING ){
					maze.randomSleep();
					if (!maze.getDragon().getDragonAsleep())
						maze.moveDragonRandomly();
				}
				maze.checkDragonPosition();
				panel.repaint();
				if (maze.getVitoria() == true)
					lblState.setText("Ganhou o jogo!");
			}
		});
		btnEsquerda.setEnabled(false);
		btnEsquerda.setBounds(404, 238, 89, 37);
		frame.getContentPane().add(btnEsquerda);
		
		JButton btnDireita = new JButton("Direita");
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maze.moveHero('D');
				panel.setMaze(maze);
				if (maze.getDragon().getType() == Dragon.Type.RANDOM )
					maze.moveDragonRandomly();
				if (maze.getDragon().getType() == Dragon.Type.SLEEPING ){
					maze.randomSleep();
					if (!maze.getDragon().getDragonAsleep())
						maze.moveDragonRandomly();
				}
				maze.checkDragonPosition();
				panel.repaint();
				if (maze.getVitoria() == true)
					lblState.setText("Ganhou o jogo!");
			}
		});
		btnDireita.setEnabled(false);
		btnDireita.setBounds(507, 238, 89, 37);
		frame.getContentPane().add(btnDireita);
		
		JButton btnBaixo = new JButton("Baixo");
		btnBaixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maze.moveHero('S');
				panel.setMaze(maze);
				if (maze.getDragon().getType() == Dragon.Type.RANDOM )
					maze.moveDragonRandomly();
				if (maze.getDragon().getType() == Dragon.Type.SLEEPING ){
					maze.randomSleep();
					if (!maze.getDragon().getDragonAsleep())
						maze.moveDragonRandomly();
				}
				maze.checkDragonPosition();
				panel.repaint();
				if (maze.getVitoria() == true)
					lblState.setText("Ganhou o jogo!");
			}
		});
		btnBaixo.setEnabled(false);
		btnBaixo.setBounds(453, 286, 89, 37);
		frame.getContentPane().add(btnBaixo);
		
		JButton btnGerarNovoLabirinto = new JButton("Gerar novo labirinto");
		btnGerarNovoLabirinto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel = new GPainel();
				panel.setBounds(37, 133, 278, 262);
				frame.getContentPane().add(panel);
				String dragonstate = (String) comboBox.getSelectedItem();
				if (dragonstate == "Estático"){
					maze.getDragon().setType(Dragon.Type.STATIONARY);
				}
				if (dragonstate == "Aleatório"){
					maze.getDragon().setType(Dragon.Type.RANDOM);
				}
				if (dragonstate == "Aleatório e adormecido"){
					maze.getDragon().setType(Dragon.Type.SLEEPING);
				}
				panel.setMaze(maze);
				panel.repaint();
				btnCima.setEnabled(true);
				btnBaixo.setEnabled(true);
				btnDireita.setEnabled(true);
				btnEsquerda.setEnabled(true);
				lblState.setText("Pode jogar!");
		
			}
		});	
		
		btnGerarNovoLabirinto.setBounds(404, 36, 152, 37);
		frame.getContentPane().add(btnGerarNovoLabirinto);

		JButton btnTerminarPrograma = new JButton("Terminar programa");
		btnTerminarPrograma.setBounds(404, 95, 152, 37);
		frame.getContentPane().add(btnTerminarPrograma);
		
		
	
		
		btnTerminarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

	}
}
