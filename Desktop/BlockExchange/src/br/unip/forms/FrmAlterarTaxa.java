package br.unip.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.unip.dao.CriptomoedaDAO;
import br.unip.model.Criptomoeda;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FrmAlterarTaxa extends JFrame{
	private JPanel contentPanel;
	private JTextField txtTaxa;
	private JTextField txtValor;
	private JComboBox cbCriptomoedas;
	
	public FrmAlterarTaxa() {
		setTitle("Alterar Taxa");
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
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/br/unip/imagens/logo.png")));
		lblNewLabel.setBounds(10, 10, 123, 83);
		contentPanel.add(lblNewLabel);
		
		
		
		cbCriptomoedas = new JComboBox();
		cbCriptomoedas.setBounds(199, 103, 138, 20);
		
		ArrayList<Criptomoeda> criptomoedas = new ArrayList<>();
		CriptomoedaDAO criptomoedaDAO = new CriptomoedaDAO();
		
		criptomoedas = criptomoedaDAO.exibirCriptomoedas();
		
		for(Criptomoeda cripto : criptomoedas){
			cbCriptomoedas.addItem(cripto.getNome());
		}
		
		cbCriptomoedas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				preencherCampos(cbCriptomoedas.getSelectedItem().toString());
				
			} 
		});
		
		contentPanel.add(cbCriptomoedas);
		
		
		JLabel lblValorAtual = new JLabel("Valor Atual:");
		lblValorAtual.setBounds(197, 227, 71, 14);
		contentPanel.add(lblValorAtual);
		
		JLabel lblTaxa = new JLabel("Taxa");
		lblTaxa.setBounds(106, 272, 46, 14);
		contentPanel.add(lblTaxa);
		
		txtTaxa = new JTextField();
		txtTaxa.setBounds(145, 269, 86, 20);
		contentPanel.add(txtTaxa);
		txtTaxa.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(238, 272, 46, 14);
		contentPanel.add(label);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setBorder(new LineBorder(new Color(245, 134, 24), 1, true));
		btnAlterar.setBackground(new Color(245, 134, 24));
		btnAlterar.setBounds(311, 267, 71, 23);
		contentPanel.add(btnAlterar);
		
		txtValor = new JTextField();
		txtValor.setBounds(275, 224, 86, 20);
		contentPanel.add(txtValor);
		txtValor.setColumns(10);
		
		//Trazer bitcoin como moeda inicial
		String bitcoin = "Bitcoin";
		preencherCampos(bitcoin);
		
	}
	
	public void preencherCampos(String criptoName) {
		Criptomoeda cripto = new Criptomoeda();
		CriptomoedaDAO criptomoedaDAO = new CriptomoedaDAO();
		
		cripto = criptomoedaDAO.getCriptoByName(criptoName);
		
		txtValor.setText(String.valueOf(cripto.getValor()));
		txtTaxa.setText(String.valueOf(cripto.getTaxa()));
		
	}
	
	public void alterar(){
		CriptomoedaDAO criptomoedaDAO = new CriptomoedaDAO();
		Criptomoeda cripto = new Criptomoeda();
		
		cripto.setValor(Double.parseDouble((txtValor.getText())));
		cripto.setTaxa(Integer.parseInt((txtTaxa.getText())));
		cripto.setNome(cbCriptomoedas.getSelectedItem().toString());
		
		criptomoedaDAO.editar(cripto);
		
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
		btnAlterarTaxa.setBackground(new Color(251, 212, 162));
		btnAlterarTaxa.setBounds(515, 278, 115, 70);
		_contentPanel.add(btnAlterarTaxa);
	}
}
