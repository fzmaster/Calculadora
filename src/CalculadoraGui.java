import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.color.*;

// Código fonte disponível no endereço: https://github.com/fzmaster/Calculadora


@SuppressWarnings("serial")
public class CalculadoraGui extends JFrame implements KeyListener, ActionListener{

	private JFrame frmCalculadora;
	private JTextField textField_Texto;
	private JPanel panel;
	private JPanel panel_Excluir;
	private JButton button_Excluir;
	private JPanel panel_Teclado;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_Div;
	private JButton button_Neg;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_Mult;
	private JButton button_Pot;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_Menos;
	private JButton button_Rad;
	private JButton button_Ponto;
	private JButton button_0;
	private JButton button_Igual;
	private JButton button_Mais;
	private JButton button_Log;
	
	private String Valor1 = "", Valor2 = "", Resultado = "";
	private int qualUsar = 1;
	private String qualOperador = "";
	
	private JMenu menu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGui window = new CalculadoraGui();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setSize(new Dimension(280, 300));
		frmCalculadora.setBounds(0, 0, 260, 290);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.setLocationRelativeTo(null);
		frmCalculadora.setResizable(false);
		
		panel = new JPanel();
		frmCalculadora.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//menuzin
		// TODO: CRIAR UM MENU LEGAL NO FINAL
		menu = new JMenu();
		
		
		textField_Texto = new JTextField();
		textField_Texto.addKeyListener(this);
		textField_Texto.setBounds(0, 0, 254, 30);
		panel.add(textField_Texto);
		textField_Texto.setColumns(10);
		textField_Texto.setEditable(false);
		textField_Texto.setBackground(java.awt.Color.WHITE);
		
		
		panel_Excluir = new JPanel();
		panel_Excluir.setBounds(50, 30, 204, 30);
		panel.add(panel_Excluir);
		panel_Excluir.setLayout(null);
		
		button_Excluir = new JButton("C");
		button_Excluir.setBounds(115, 0, 89, 30);
		panel_Excluir.add(button_Excluir);
		button_Excluir.addActionListener(this);
		
		panel_Teclado = new JPanel();
		panel_Teclado.setBounds(0, 60, 254, 202);
		panel.add(panel_Teclado);
		panel_Teclado.setLayout(new GridLayout(4, 4, 0, 0));
		
		button_7 = new JButton("7");
		panel_Teclado.add(button_7);
		button_7.addActionListener(this);
		
		button_8 = new JButton("8");
		panel_Teclado.add(button_8);
		button_8.addActionListener(this);
		
		button_9 = new JButton("9");
		panel_Teclado.add(button_9);
		button_9.addActionListener(this);
		
		button_Div = new JButton("/");
		panel_Teclado.add(button_Div);
		button_Div.addActionListener(this);
		
		button_Neg = new JButton("N");
		panel_Teclado.add(button_Neg);
		button_Neg.addActionListener(this);
		
		button_4 = new JButton("4");
		panel_Teclado.add(button_4);
		button_4.addActionListener(this);
		
		button_5 = new JButton("5");
		panel_Teclado.add(button_5);
		button_5.addActionListener(this);
		
		button_6 = new JButton("6");
		panel_Teclado.add(button_6);
		button_6.addActionListener(this);
		
		button_Mult = new JButton("*");
		panel_Teclado.add(button_Mult);
		button_Mult.addActionListener(this);
		
		button_Pot = new JButton("^");
		panel_Teclado.add(button_Pot);
		button_Pot.addActionListener(this);
		
		button_1 = new JButton("1");
		panel_Teclado.add(button_1);
		button_1.addActionListener(this);
		
		button_2 = new JButton("2");
		panel_Teclado.add(button_2);
		button_2.addActionListener(this);
		
		button_3 = new JButton("3");
		panel_Teclado.add(button_3);
		button_3.addActionListener(this);
		
		button_Menos = new JButton("-");
		panel_Teclado.add(button_Menos);
		button_Menos.addActionListener(this);
		
		button_Ponto = new JButton(".");
		panel_Teclado.add(button_Ponto);
		button_Ponto.addActionListener(this);
		
		button_0 = new JButton("0");
		panel_Teclado.add(button_0);
		button_0.addActionListener(this);
		
		button_Igual = new JButton("=");
		panel_Teclado.add(button_Igual);
		button_Igual.addActionListener(this);
		
		button_Mais = new JButton("+");
		panel_Teclado.add(button_Mais);
		button_Mais.addActionListener(this);

		button_Rad = new JButton("R");
		panel_Teclado.add(button_Rad);
		button_Rad.addActionListener(this);

		button_Log = new JButton("L");
		panel_Teclado.add(button_Log);
		button_Log.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = ((JButton) e.getSource()).getText();
		tratamentoTeclado(key);
	}
	
	public void tratamentoTeclado(String key) {

		switch (key) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9": {
			textField_Texto.setText(textField_Texto.getText() + key);
			if(this.qualUsar == 1) {
				//coloca no Valor1
				this.Valor1 = this.Valor1+key;
			} else {
				//coloca no Valor2
				this.Valor2 = this.Valor2+key;
				
			}
			break;
		}
		case ".": {
			textField_Texto.setText(textField_Texto.getText() + key);
			// TODO: Implementar a funcionalidade de bloquear o uso de pontos sequenciais
			if(this.qualUsar == 1) {
				//coloca no Valor1
				this.Valor1 = this.Valor1+key;
			} else {
				//coloca no Valor2
				this.Valor2 = this.Valor2+key;
				
			}
			break;
		}
		case "+": {
			this.qualUsar = 2;
			this.qualOperador = "+";
			textField_Texto.setText("");
			break;
		}
		case "-": {
			this.qualUsar = 2;
			this.qualOperador = "-";
			textField_Texto.setText("");
			break;
		}
		case "*": {
			this.qualUsar = 2;
			this.qualOperador = "*";
			textField_Texto.setText("");
			break;
		}
		case "/": {
			this.qualUsar = 2;
			this.qualOperador = "/";
			textField_Texto.setText("");
			break;
		}
		case "^" : {
			this.qualUsar = 2;
			this.qualOperador = "^";
			textField_Texto.setText("");
			break;
		}
		case "R" : {
			this.qualUsar = 2;
			this.qualOperador = "R";
			textField_Texto.setText("");
			break;
		}
		case "L" : {
			this.qualUsar = 2;
			this.qualOperador = "L";
			textField_Texto.setText("");
			break;
		}
		case "=": {
			this.qualUsar = 1;
			resposta();
			break;
		}
		case "N" : {
			if(this.qualUsar == 1) {
				//coloca no Valor1
				if(this.Valor1.equals("")) {
					JOptionPane.showMessageDialog(null, "Valor está vazio. Digite um número para negar!", null, JOptionPane.ERROR_MESSAGE);
				} else {
					this.Valor1 = "-" + this.Valor1;
					textField_Texto.setText(this.Valor1);	
				}
			}
			break;
		}
		
		case "C": resetaCalculadora(); break;
		default: break;
		}
	}
	
	private void imprimeStatus() {
		System.out.println("V1:      "+this.Valor1);
		System.out.println("V2 :     "+this.Valor2);
		System.out.println("qualop : "+this.qualOperador);
		System.out.println("qualusar:"+this.qualUsar);
		//System.out.println("V1: "+this.Valor1);
		//System.out.println("V1: "+this.Valor1);
		//System.out.println("V1: "+this.Valor1);
	}
	
	private void resetaCalculadora() {
		this.Valor1 = "";
		this.Valor2 = "";
		this.qualOperador = "";
		this.Resultado = "";
		this.qualUsar = 1;
		textField_Texto.setText("");
		imprimeStatus();
	}

	private void resposta() {
		// EXECUTAR A OPERACAO
		Double v1 = Double.parseDouble(this.Valor1);
		Double v2 = Double.parseDouble(this.Valor2);
		Double resultadoFinal = null;
		imprimeStatus();
		switch (this.qualOperador) {
		case "+":
			resultadoFinal = v1 + v2;
			break;
		case "-":
			resultadoFinal = v1 - v2;
			break;
		case "/":
			if(this.Valor2.equals("0")) {
				JOptionPane.showMessageDialog(null, "Divisão por Zero Proibida. Use 0.0", "Erro!", JOptionPane.ERROR_MESSAGE);
			} else {
				resultadoFinal = v1 / v2;				
			}	
			break;
		case "*":
			resultadoFinal = v1 * v2;
			break;
		case "^":
			resultadoFinal = (Double) Math.pow(v1, v2);
			break;
		case "R":
			resultadoFinal = (Double) Math.pow(v1, 1.0/v2);
			break;
		case "L":
			resultadoFinal = (Double) Math.log(v1)/Math.log(v2);
			break;
		default:
			break;
		}
		
		//exibe texto no display
		textField_Texto.setText(resultadoFinal.toString());
		
		this.Valor1 = resultadoFinal.toString();
		if(this.Valor1.equals("Infinity")) {
			this.Valor1 = "";
		}
		this.Valor2 = "";
		this.qualOperador = "";
		this.qualUsar = 2;
		textField_Texto.setText(Valor1);
		imprimeStatus();
		return;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		String key = String.valueOf(e.getKeyChar());
		tratamentoTeclado(key);
	}
}
