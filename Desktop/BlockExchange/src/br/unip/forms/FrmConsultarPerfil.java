package br.unip.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import br.unip.dao.UsuarioDAO;
import br.unip.model.Usuario;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

public class FrmConsultarPerfil extends JFrame {
	private JPanel contentPanel;
	
	
	public FrmConsultarPerfil() {
		setTitle("Consultar Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 479);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setToolTipText("");
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		montarMenu(contentPanel);
		
		JLabel lblCp = new JLabel("CPF");
		lblCp.setBounds(41, 40, 26, 14);
		contentPanel.add(lblCp);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(37, 95, 455, 314);
		panel.setBorder(new LineBorder(new Color(245, 134, 24), 2, true));
		contentPanel.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblCpf_2 = new JLabel("CPF:");
		lblCpf_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf_2.setBounds(30, 45, 43, 14);
		panel.add(lblCpf_2);
		
		JLabel lblCliente = new JLabel("Cliente", SwingConstants.CENTER);
		lblCliente.setBounds(10, 11, 435, 16);
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblCliente);
		
		JLabel lblCpf = new JLabel("000.789.766-44");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(58, 45, 126, 14);
		panel.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(234, 46, 126, 14);
		panel.add(lblDataDeNascimento);
		
		JLabel lblDtNasc = new JLabel("10/10/2010");
		lblDtNasc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDtNasc.setBounds(370, 45, 75, 14);
		panel.add(lblDtNasc);
		
		JLabel lblNewLabel_1 = new JLabel("RG:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 91, 31, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblRg = new JLabel("25.568.759-5");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRg.setBounds(58, 91, 113, 14);
		panel.add(lblRg);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(234, 91, 82, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(30, 139, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Saldo:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(234, 139, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblTelefone = new JLabel("11 98799-4556");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(306, 91, 90, 14);
		panel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("email@email.com.br");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(70, 139, 154, 14);
		panel.add(lblEmail);
		
		JLabel lblSaldo = new JLabel("R$3000");
		lblSaldo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSaldo.setBounds(290, 139, 46, 14);
		panel.add(lblSaldo);
		
		
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(245, 134, 24));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(190, 36, 89, 23);
		

		JFormattedTextField txtCpf = new JFormattedTextField();
		txtCpf.setBounds(66, 37, 114, 20);
		MaskFormatter mascara = new MaskFormatter();
		
		try {
			mascara.setMask("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			mascara.install(txtCpf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contentPanel.add(txtCpf);
		
		//Consultar CPF 
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario user = new Usuario();
				
				user = usuarioDAO.getUserByCpf(txtCpf.getText());
				
				if(user.getId() == 0) {
					panel.setVisible(false);
					JOptionPane.showMessageDialog(contentPanel, "Não existe nenhum usuário cadastrado com esse CPF");
					return;
				}
				
				lblCliente.setText(user.getNome());
				lblCpf.setText(user.getCpf());
				lblDtNasc.setText(user.getData_nascimento());
				lblRg.setText(user.getRg());
				lblTelefone.setText(user.getCelular());
				lblEmail.setText(user.getEmail());
				lblSaldo.setText(String.valueOf(user.getSaldo()));
				
				panel.setVisible(true);
			}
		});
		
		contentPanel.add(btnConsultar);
		
	}
	
	
	public void montarMenu (JPanel _contentPanel) {
		
		JButton btnConsultarPerfil = new JButton("Consultar Perfil");
		btnConsultarPerfil.setBackground(new Color(251, 212, 162));
		btnConsultarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmConsultarPerfil frmconsultarPerfil = new FrmConsultarPerfil();
				frmconsultarPerfil.setVisible(true);
			}
		});
		btnConsultarPerfil.setFont(new Font("Arial", Font.PLAIN, 12));
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
