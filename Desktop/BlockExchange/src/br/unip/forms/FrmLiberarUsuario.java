package br.unip.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.UsuarioDAO;
import br.unip.model.Usuario;

import javax.swing.JTable;
import javax.swing.SwingConstants;

public class FrmLiberarUsuario extends JFrame {
	private JPanel contentPanel, panel;
	private JTable table;
	private DefaultTableModel modelTab;
	private JScrollPane scrollPane;
	
	private JLabel lblCpf, lblRg, lblDtNasc, lblTelefone, lblEmail, lblSaldo, lblCliente, lblStatus, lblId;
	
	public FrmLiberarUsuario() {
		setTitle("Moderação de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 543);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		montarMenu(contentPanel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 21, 455, 162);
		contentPanel.add(scrollPane);
		montarTabela();
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(35, 236, 455, 257);
		panel.setBorder(new LineBorder(new Color(245, 134, 24), 2, true));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCpf_2 = new JLabel("CPF:");
		lblCpf_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf_2.setBounds(30, 45, 43, 14);
		panel.add(lblCpf_2);
		
		lblCliente = new JLabel("Cliente", SwingConstants.CENTER);
		lblCliente.setBounds(10, 11, 435, 16);
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblCliente);
		
		lblCpf = new JLabel("000.789.766-44");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(70, 46, 101, 14);
		panel.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(221, 45, 126, 14);
		panel.add(lblDataDeNascimento);
		
		lblDtNasc = new JLabel("10/10/2010");
		lblDtNasc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDtNasc.setBounds(370, 45, 75, 14);
		panel.add(lblDtNasc);
		
		JLabel lblNewLabel_1 = new JLabel("RG:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 91, 31, 14);
		panel.add(lblNewLabel_1);
		
		lblRg = new JLabel("25.568.759-5");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRg.setBounds(70, 91, 90, 14);
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
		
		lblTelefone = new JLabel("11559855-5556");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(306, 91, 90, 14);
		panel.add(lblTelefone);
		
		lblEmail = new JLabel("email@email.com.br");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(85, 139, 119, 14);
		panel.add(lblEmail);
		
		lblSaldo = new JLabel("R$3000");
		lblSaldo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSaldo.setBounds(290, 139, 46, 14);
		panel.add(lblSaldo);
		
		JLabel lblDesejaPermitirUsurio = new JLabel("Deseja permitir usu\u00E1rio ?");
		lblDesejaPermitirUsurio.setBounds(272, 184, 145, 14);
		panel.add(lblDesejaPermitirUsurio);
		
		JButton btnNewButton = new JButton("Permitir");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(234, 209, 95, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moderar("permitir");
			}
		});
		
		JButton btnNegar = new JButton("Negar");
		btnNegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moderar("negar");
			}
		});
		btnNegar.setForeground(Color.WHITE);
		btnNegar.setBackground(Color.RED);
		btnNegar.setBounds(352, 209, 93, 23);
		panel.add(btnNegar);
		
		JLabel lblNewLabel_3_1 = new JLabel("Status:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(30, 194, 57, 14);
		panel.add(lblNewLabel_3_1);
		
		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStatus.setBounds(85, 194, 119, 14);
		panel.add(lblStatus);
		
		lblId = new JLabel("");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(71, 232, 46, 14);
		panel.add(lblId);
		
		panel.setVisible(false);
	}
	
	
	
public void montarMenu (JPanel _contentPanel) {
		
		JButton btnConsultarPerfil = new JButton("Consultar Perfil");
		btnConsultarPerfil.setBackground(Color.WHITE);
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
		btnLiberarUsuario.setBackground(new Color(251, 212, 162));
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

	public void moderar(String tipo) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(tipo == "permitir") {
			usuarioDAO.moderar("1", Integer.parseInt(lblId.getText())); 
			lblStatus.setText("Autorizado");
	
		}else {
			usuarioDAO.moderar("0", Integer.parseInt(lblId.getText())); 
			lblStatus.setText("Negado");
		}
		
		montarTabela();
	}

	public void montarTabela(){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarios = usuarioDAO.exibirUsuarios();
		
		modelTab = new DefaultTableModel();
		table = new JTable(modelTab);
		
		modelTab.addColumn("Nome");
		modelTab.addColumn("Email");
		modelTab.addColumn("CPF");
		modelTab.addColumn("Status");
		
	
		for(Usuario usuario : usuarios){
			modelTab.addRow(new Object[]{usuario.getNome(),usuario.getEmail(), usuario.getCpf(), usuario.getStatus()});
		}
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String cpf = table.getValueAt(table.getSelectedRow(), 2).toString();
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario user = new Usuario();
				
				user = usuarioDAO.getUserByCpf(cpf);
				
				lblCliente.setText(user.getNome());
				lblCpf.setText(user.getCpf());
				lblDtNasc.setText(user.getData_nascimento());
				lblRg.setText(user.getRg());
				lblEmail.setText(user.getEmail());
				lblTelefone.setText(user.getCelular());
				lblSaldo.setText(String.valueOf(user.getSaldo()));
				lblId.setText(String.valueOf(user.getId()));
				
				if(Integer.parseInt(user.getStatus()) == 1) {
					lblStatus.setText("Autorizado");
				}else {
					lblStatus.setText("Negado");
				}
				panel.setVisible(true);
			}
		});
	
	}
}
