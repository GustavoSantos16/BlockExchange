package br.unip.forms;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrmHome extends JFrame {
	private JPanel contentPanel;
	
	public FrmHome() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 398);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		montarMenu(contentPanel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmHome.class.getResource("/br/unip/imagens/logo-maior.png")));
		lblNewLabel.setBounds(45, 35, 430, 260);
		contentPanel.add(lblNewLabel);
	}
	
	
	public void montarMenu (JPanel _contentPanel) {
		JButton btnConsultarPerfil = new JButton("Consultar Perfil");
		btnConsultarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnConsultarPerfil.setBackground(new Color(251, 212, 162));
				setVisible(false);
				FrmConsultarPerfil frmconsultarPerfil = new FrmConsultarPerfil();
				frmconsultarPerfil.setVisible(true);
			}
		});
		btnConsultarPerfil.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultarPerfil.setBackground(Color.WHITE);
		btnConsultarPerfil.setBounds(515, 35, 115, 70);
		btnConsultarPerfil.setBorder(new LineBorder(new Color(245, 134, 24), 1, true));
		_contentPanel.add(btnConsultarPerfil);
		
		JButton btnLiberarUsuario = new JButton("Liberar Usu\u00E1rio");
		btnLiberarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmLiberarUsuario frmliberarUsuario = new FrmLiberarUsuario();
				frmliberarUsuario.setVisible(true);
				
			}
		});
		btnLiberarUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLiberarUsuario.setBorder(new LineBorder(new Color(245, 134, 24), 1, true));
		btnLiberarUsuario.setBackground(Color.WHITE);
		btnLiberarUsuario.setBounds(515, 116, 115, 70);
		_contentPanel.add(btnLiberarUsuario);
		
		JButton btnRelatorios = new JButton("Relat\u00F3rios");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmRelatorios frmRelatorios = new FrmRelatorios();
				frmRelatorios.setVisible(true);
				
			}
		});
		btnRelatorios.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRelatorios.setBorder(new LineBorder(new Color(245, 134, 24), 1, true));
		btnRelatorios.setBackground(Color.WHITE);
		btnRelatorios.setBounds(515, 198, 115, 70);
		_contentPanel.add(btnRelatorios);
		
		JButton btnAlterarTaxa = new JButton("Alterar taxa");
		btnAlterarTaxa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmAlterarTaxa frmAlterarTaxa = new FrmAlterarTaxa();
				frmAlterarTaxa.setVisible(true);
			}
		});
		btnAlterarTaxa.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterarTaxa.setBorder(new LineBorder(new Color(245, 134, 24), 1, true));
		btnAlterarTaxa.setBackground(Color.WHITE);
		btnAlterarTaxa.setBounds(515, 278, 115, 70);
		_contentPanel.add(btnAlterarTaxa);
	}
}
