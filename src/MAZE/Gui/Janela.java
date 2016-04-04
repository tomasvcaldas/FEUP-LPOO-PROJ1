package MAZE.Gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JTextField;
import MAZE.Logic.Dragon;
import MAZE.Logic.Maze;
import MAZE.Logic.MazeBuilder;

import javax.swing.JComboBox;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Maze maze;
	private MazeBuilder mazebuilder;
	private GPainel panel;
	private JLabel lblState;
	private JButton btnCima, btnBaixo, btnDireita, btnEsquerda;


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
	public void setAllButtons(boolean button){
		btnCima.setEnabled(button);
		btnBaixo.setEnabled(button);
		btnDireita.setEnabled(button);
		btnEsquerda.setEnabled(button);
	}
	
	public void moveDirection (char dir){
		maze.moveHero(dir);
		if (maze.getDragon().getType() == Dragon.Type.RANDOM )
			maze.moveAllDragons();
		if (maze.getDragon().getType() == Dragon.Type.SLEEPING ){
			maze.randomSleep();
			if (!maze.getDragon().getDragonAsleep())
				maze.moveAllDragons();
		}
		maze.checkDragonPosition();
		if (maze.getHero().getHeroAlive() == false){
			lblState.setText("O herói morreu. Perdeu o jogo!");
			setAllButtons(false);
		}
		
		if (maze.getVitoria() == true){
			lblState.setText("Ganhou o jogo!");
			setAllButtons(false);
		}
		panel.repaint();
	}
	
	


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 11));
		frame.setBounds(200, 50, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(label);

		JLabel lblDimensoDoLabirinto = new JLabel("Dimens\u00E3o do labirinto");
		lblDimensoDoLabirinto.setBounds(33, 39, 135, 14);
		frame.getContentPane().add(lblDimensoDoLabirinto);
		

		textField = new JTextField();
		textField.setText("11");
		textField.setBounds(178, 36, 64, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNmeroDeDrages = new JLabel("N\u00FAmero de drag\u00F5es");
		lblNmeroDeDrages.setBounds(33, 70, 135, 14);
		frame.getContentPane().add(lblNmeroDeDrages);

		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(178, 67, 64, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTipoDeDrages = new JLabel("Tipo de drag\u00F5es");
		lblTipoDeDrages.setBounds(33, 101, 94, 14);
		frame.getContentPane().add(lblTipoDeDrages);

		String[] dragonType = {"Estático", "Aleatório", "Aleatório e adormecido"};
		JComboBox comboBox = new JComboBox(dragonType);
		comboBox.setBounds(178, 98, 135, 20);
		frame.getContentPane().add(comboBox);	

		lblState = new JLabel("Pode gerar novo labirinto!");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblState.setBounds(33, 630, 334, 20);
		frame.getContentPane().add(lblState);		

		//Botao Cima
		btnCima = new JButton("Cima");
		btnCima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDirection('W');
			}
		});
		btnCima.setEnabled(false);
		btnCima.setBounds(669, 210, 89, 37);
		frame.getContentPane().add(btnCima);

		//Botao Esquerda
		btnEsquerda = new JButton("Esquerda");
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDirection('A');
			}
		});
		btnEsquerda.setEnabled(false);
		btnEsquerda.setBounds(616, 258, 89, 37);
		frame.getContentPane().add(btnEsquerda);


		//Botao Direita
		btnDireita = new JButton("Direita");
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDirection('D');
			}
		});
		btnDireita.setEnabled(false);
		btnDireita.setBounds(717, 258, 89, 37);
		frame.getContentPane().add(btnDireita);


		//Botao Baixo
		btnBaixo = new JButton("Baixo");
		btnBaixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDirection('S');
			}
		});
		btnBaixo.setEnabled(false);
		btnBaixo.setBounds(669, 306, 89, 37);
		frame.getContentPane().add(btnBaixo);

		JButton btnGerarNovoLabirinto = new JButton("Gerar novo labirinto");
		btnGerarNovoLabirinto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int dimensao = Integer.parseInt(textField.getText());
					int numerodedragoes = Integer.parseInt(textField_1.getText());

					if (dimensao > 19 )
						throw new IllegalArgumentException();
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(frame, "Formato não válido!");
					return;
				}
				catch (IllegalArgumentException ex){
					JOptionPane.showMessageDialog(frame, "Dimensão máxima: 19");
					return;
				}

				panel = new GPainel();
				panel.requestFocus();
				panel.repaint();
				panel.setBounds(40, 135, 500, 480);
				maze = new Maze();
				mazebuilder = new MazeBuilder();
				maze.setBoard(mazebuilder.buildMaze(Integer.parseInt(textField.getText())));
				maze.placeHero();
				maze.placeDragons(Integer.parseInt(textField_1.getText()));
				maze.placeSword();
				frame.getContentPane().add(panel);
				String dragonstate = (String) comboBox.getSelectedItem();
				for (int i =0; i < Integer.parseInt(textField_1.getText()); i++){
				if (dragonstate == "Estático"){
					maze.getDragons().get(i).setType(Dragon.Type.STATIONARY);
				}
				if (dragonstate == "Aleatório"){
					maze.getDragons().get(i).setType(Dragon.Type.RANDOM);
				}
				if (dragonstate == "Aleatório e adormecido"){
					maze.getDragons().get(i).setType(Dragon.Type.SLEEPING);
				}
				panel.setMaze(maze.getBoard());
				panel.repaint();
				setAllButtons(true);
				lblState.setText("Pode jogar!");
				panel.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (!maze.getVitoria() && maze.getHero().getHeroAlive())
						switch(e.getKeyCode()){
						case KeyEvent.VK_W:
						case KeyEvent.VK_UP:
							moveDirection('W');
							panel.repaint();
							break;
						case KeyEvent.VK_S:
						case KeyEvent.VK_DOWN:	
							moveDirection('S');
							panel.repaint();
							break;
						case KeyEvent.VK_A:
						case KeyEvent.VK_LEFT:	
							moveDirection('A');
							panel.repaint();
							break;
						case KeyEvent.VK_D:
						case KeyEvent.VK_RIGHT:
							moveDirection('D');
							panel.repaint();
							break;
						default:
							break;
						}  
					}

					@Override
					public void keyReleased(KeyEvent e) {}

					@Override
					public void keyTyped(KeyEvent e) {}
				});
				panel.requestFocus();
			}
			}
		});	
		btnGerarNovoLabirinto.setBounds(629, 36, 152, 43);
		frame.getContentPane().add(btnGerarNovoLabirinto);

		JButton btnTerminarPrograma = new JButton("Terminar programa");
		btnTerminarPrograma.setBounds(629, 110, 152, 43);
		frame.getContentPane().add(btnTerminarPrograma);
		btnTerminarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

	}


}
