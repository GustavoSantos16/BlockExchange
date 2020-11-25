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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.OrdemDAO;
import br.unip.dao.UsuarioDAO;
import br.unip.model.Ordem;
import br.unip.model.Usuario;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FrmRelatorios extends JFrame {
	private JPanel contentPanel;
	private DefaultTableModel modelTab;
	private JScrollPane scrollPane;
	private JTable table;
	
	
	public FrmRelatorios() {
		setTitle("Relatórios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 457);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		montarMenu(contentPanel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 63, 455, 234);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		montarTabela();
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
		btnRelatorios.setBackground(new Color(251, 212, 162));
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

public void montarTabela(){
	ArrayList<Ordem> ordens = new ArrayList<>();
	OrdemDAO ordemDao = new OrdemDAO();
	
	ordens = ordemDao.listaOrdens();
	
	modelTab = new DefaultTableModel();
	table = new JTable(modelTab);
	
	modelTab.addColumn("Data");
	modelTab.addColumn("Tipo");
	modelTab.addColumn("Moeda");
	modelTab.addColumn("QTD");
	modelTab.addColumn("Valor");
	

	for(Ordem ordem : ordens){
		modelTab.addRow(new Object[]{ordem.getData(),ordem.getTipo(), ordem.getCriptoname(), ordem.getQuantidade(), ordem.getPreco()});
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
		
		}
	});

}

}
