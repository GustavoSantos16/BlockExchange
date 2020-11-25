package br.unip.forms;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.unip.model.Login;
import br.unip.dao.LoginDAO;
import br.unip.banco.ConexaoSqlServer;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;




public class FrmLogin extends JFrame {
	private JPanel contentPanel;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	
	private Connection con = ConexaoSqlServer.getConexao();

	
	
	public FrmLogin() {
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 398);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(245, 134, 24), 2, true));
		panel.setBounds(164, 73, 312, 220);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Arial", Font.ITALIC, 14));
		lblUsurio.setBounds(35, 61, 59, 27);
		panel.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Email:admin@admin.com");
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setBounds(104, 60, 160, 30);
		txtUsuario.setBorder(new LineBorder(new Color(245, 134, 24)));
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.ITALIC, 14));
		lblSenha.setBounds(35, 117, 59, 27);
		panel.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Senha:123456");
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSenha.setColumns(10);
		txtSenha.setBounds(104, 116, 160, 30);
		txtSenha.setBorder(new LineBorder(new Color(245, 134, 24)));
		panel.add(txtSenha);
		
		//Logar
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login logar = new Login();
				
				logar.setEmail(txtUsuario.getText());
				logar.setSenha(txtSenha.getText());
				
				LoginDAO loginDAO = new LoginDAO();
				if(loginDAO.getLoginSenha(logar) == true){
					setVisible(false);
					FrmHome home = new FrmHome();
					home.setVisible(true);
				}
				
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(245, 134, 24));
		btnLogin.setBorder(new LineBorder(new Color(245, 134, 24), 1, true));
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLogin.setBounds(219, 186, 71, 23);
		panel.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/br/unip/imagens/logo.png")));
		lblNewLabel.setBounds(10, 10, 123, 83);
		contentPanel.add(lblNewLabel);
		
	}
}
