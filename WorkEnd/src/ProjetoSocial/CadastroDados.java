package ProjetoSocial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ProjetoSocial.ManipularDados;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class CadastroDados extends JFrame {

	private JPanel contentPane;
	private JTextField textTITULO;
	private JTextField textDATA;
	private JTextField textOBJETIVO;
	private JTextField textRUA;
	private JLabel NUM;
	private JLabel BAI;
	private JTextField textCIDADE;
	private JLabel CID;
	private JTextField textBAIRRO;
	private JLabel ESTADO;
	private JTextField textField_7;
	private JLabel lblNewLabel_2;
	private JLabel DADOSCAD;
	private JLabel lblNewLabel_3;
	private JLabel STATUS2;
	private JLabel lblNewLabel_4;
	private JRadioButton INICIANDO;
	private JRadioButton INTERROMPER;
	private JRadioButton FIM;
	private JButton CADASTRAR;
	private JTextField textNUMERO;
	private JTextField textESTADO;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDados frame = new CadastroDados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public CadastroDados() throws Exception {
		setTitle("CADASTRO DE DADOS DO PROJETO");
		setBackground(new Color(250, 235, 215));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 629, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel TITULO = new JLabel("T\u00CDTULO");
		TITULO.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textTITULO = new JTextField();
		textTITULO.setColumns(10);
		
		JLabel DATAINICIO = new JLabel("DATA DE IN\u00CDCIO");
		DATAINICIO.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JTextField textDATA1 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textDATA1.setColumns(10);
		
		JLabel OBJETIVO = new JLabel("OBJETIVO");
		OBJETIVO.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textOBJETIVO = new JTextField();
		textOBJETIVO.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ENDERE\u00C7O");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("RUA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textRUA = new JTextField();
		textRUA.setColumns(10);
		
		NUM = new JLabel("N\u00DAMERO");
		NUM.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		BAI = new JLabel("BAIRRO");
		BAI.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textCIDADE = new JTextField();
		textCIDADE.setColumns(10);
		
		CID = new JLabel("CIDADE");
		CID.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textBAIRRO = new JTextField();
		textBAIRRO.setColumns(10);
		
		ESTADO = new JLabel("UF");
		ESTADO.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		lblNewLabel_2 = new JLabel("--------------------------------------------------------------------------------------------------------");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		DADOSCAD = new JLabel("DADOS CADASTRAIS");
		DADOSCAD.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_3 = new JLabel("------------------------------------------------------------------------------------------");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		STATUS2 = new JLabel("STATUS");
		STATUS2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_4 = new JLabel("-----------------------------------------------------------------------------------------------------------");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		INICIANDO = new JRadioButton("INICIADO");
		INICIANDO.setBackground(new Color(250, 235, 215));
		INICIANDO.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		INTERROMPER = new JRadioButton("INTERROMPIDO");
		INTERROMPER.setFont(new Font("Tahoma", Font.BOLD, 12));
		INTERROMPER.setBackground(new Color(250, 235, 215));
		
		FIM = new JRadioButton("FINALIZADO");
		FIM.setBackground(new Color(250, 235, 215));
		FIM.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		CADASTRAR = new JButton("CADASTRAR");
		CADASTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String STATUS = null;
				
				//DADOS CADASTRAIS
				String TITULO = textTITULO.getText();
				String DESC = textOBJETIVO.getText();
				String DATA = textDATA1.getText(); 
				
				//ENDEREÇO
				String RUA = textRUA.getText();
				String NUMERO = textNUMERO.getText(); 
				String UF = textESTADO.getText();
				String BAIRRO = textBAIRRO.getText();
				String CIDADE = textCIDADE.getText();
				
				//ArrayList
				ArrayList<String> cadastroDados = new ArrayList();
				
				if(INICIANDO.isSelected() == true) 
					 {
					 STATUS = "EXECUTANDO"; 
					 } 
				 if(INTERROMPER.isSelected() == true) 
					 {
					 STATUS = "INTERROMPIDO"; 
					 } 
				 if(FIM.isSelected() == true) 
					 {
					 STATUS = "CONCLUIDO"; 
					 }
				 
				 String doc="WorkEndDados.txt", nome, dados;
				 
				 dados = TITULO+"\r\n"+DESC+"\r\n"+DATA+"\r\n"+RUA+" - "+NUMERO+"\r\n"+BAIRRO+" - "+CIDADE+"\r\n"+STATUS;
				 cadastroDados.add(dados);
				 JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				
				 try {
					ManipularDados.escritor(doc,dados);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}
			
		});
		CADASTRAR.setFont(new Font("Tahoma", Font.BOLD, 11));
		CADASTRAR.setBackground(new Color(255, 160, 122));
		
		textNUMERO = new JTextField();
		textNUMERO.setColumns(10);
		
		textESTADO = new JTextField();
		textESTADO.setColumns(10);
		
		btnNewButton = new JButton("ABRIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Path dir = Paths.get("C:/Users/marya/OneDrive/Área de Trabalho/eclipse-workspace/WorkEnd/WorkEndDados.txt");
				//"C:\Users\marya\OneDrive\Área de Trabalho\eclipse-workspace\WorkEnd\WorkEndDados.txt"
				try {
					byte [] text = Files.readAllBytes(dir);
					String leia = new String(text);
					
					JOptionPane.showMessageDialog(null, leia);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(DATAINICIO)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textDATA1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(DADOSCAD)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(BAI)
										.addComponent(lblNewLabel_1))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textBAIRRO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(CID)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textCIDADE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(267)
											.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textRUA, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(NUM, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textNUMERO, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(ESTADO)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textESTADO, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(OBJETIVO)
										.addComponent(TITULO))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textTITULO)
										.addComponent(textOBJETIVO, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 523, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(STATUS2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(INICIANDO)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 540, Short.MAX_VALUE)
										.addComponent(INTERROMPER)
										.addComponent(FIM)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(CADASTRAR)
							.addGap(103)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(DADOSCAD)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TITULO)
						.addComponent(textTITULO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textOBJETIVO, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(OBJETIVO))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDATA1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(DATAINICIO))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textRUA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NUM)
						.addComponent(textNUMERO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textESTADO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ESTADO))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BAI)
						.addComponent(textBAIRRO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CID)
						.addComponent(textCIDADE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(STATUS2)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(INICIANDO)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(INTERROMPER)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FIM)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(CADASTRAR)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
