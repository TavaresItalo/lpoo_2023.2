package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import modelos.LivroModelo;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControleExemplares extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtQtdExemplares;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleExemplares frameControleExemplares = new ControleExemplares();
					frameControleExemplares.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControleExemplares() {
		setResizable(false);
		
		DefaultListModel<LivroModelo> modeloJlist = new DefaultListModel();
		final JList listaLivros = new JList(modeloJlist);
		JScrollPane scroll = new JScrollPane(listaLivros);
		
		final LivroControlador controlador = new LivroControlador();
			
		try {
			
			final List<LivroModelo> livros = controlador.buscarTodosOsLivros();
<<<<<<< HEAD
			for(LivroModelo livro : livros) {
				modeloJlist.addElement(livro);
			}
=======
			modeloJlist.addAll(livros);
>>>>>>> 3d135f1c15886609d763394ac8f124b790358b11
			
			listaLivros.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int index = listaLivros.getSelectedIndex();
					String isbn = livros.get(index).getIsbn();
					txtIsbn.setText(isbn);
				}
			});
			
		} catch (ExcecaoControlador e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
			exc.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIVROS:");
		lblNewLabel.setBounds(5, 5, 52, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(232, 11, 516, 423);
		panel.setBackground(new Color(141, 197, 62));
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{207, 214, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{37, 50, 22, 22, 140, 27, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitutlo = new JLabel("CONTROLE DE EXEMPLARES");
		lblTitutlo.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitutlo = new GridBagConstraints();
		gbc_lblTitutlo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitutlo.gridwidth = 4;
		gbc_lblTitutlo.gridx = 0;
		gbc_lblTitutlo.gridy = 0;
		panel.add(lblTitutlo, gbc_lblTitutlo);
		
		JLabel lblImagem = new JLabel("New label");
		GridBagConstraints gbc_lblImagem = new GridBagConstraints();
		gbc_lblImagem.gridheight = 4;
		gbc_lblImagem.gridwidth = 4;
		gbc_lblImagem.insets = new Insets(0, 0, 5, 0);
		gbc_lblImagem.gridx = 0;
		gbc_lblImagem.gridy = 1;
		panel.add(lblImagem, gbc_lblImagem);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.anchor = GridBagConstraints.EAST;
		gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsbn.gridx = 0;
		gbc_lblIsbn.gridy = 5;
		panel.add(lblIsbn, gbc_lblIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIsbn.setEnabled(false);
		GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
		gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIsbn.insets = new Insets(0, 0, 5, 0);
		gbc_txtIsbn.gridx = 1;
		gbc_txtIsbn.gridy = 5;
		panel.add(txtIsbn, gbc_txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lblQtdExemplares = new JLabel("Quantidade de exemplares:");
		lblQtdExemplares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblQtdExemplares = new GridBagConstraints();
		gbc_lblQtdExemplares.gridheight = 2;
		gbc_lblQtdExemplares.anchor = GridBagConstraints.EAST;
		gbc_lblQtdExemplares.insets = new Insets(0, 0, 20, 5);
		gbc_lblQtdExemplares.gridx = 0;
		gbc_lblQtdExemplares.gridy = 6;
		panel.add(lblQtdExemplares, gbc_lblQtdExemplares);
		
		txtQtdExemplares = new JTextField();
		txtQtdExemplares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtQtdExemplares = new GridBagConstraints();
		gbc_txtQtdExemplares.gridheight = 2;
		gbc_txtQtdExemplares.anchor = GridBagConstraints.NORTH;
		gbc_txtQtdExemplares.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQtdExemplares.insets = new Insets(0, 0, 20, 5);
		gbc_txtQtdExemplares.gridx = 1;
		gbc_txtQtdExemplares.gridy = 6;
		panel.add(txtQtdExemplares, gbc_txtQtdExemplares);
		txtQtdExemplares.setColumns(10);
		
		JButton btnAdicionarExemplar = new JButton(" Adiconar Exemplar/s");
		btnAdicionarExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtIsbn.getText();
				String qtdExemplares = txtQtdExemplares.getText();
				
				try {
					controlador.AdicionarExemplares(isbn, qtdExemplares);
					JOptionPane.showMessageDialog(null, "Exemplar/s adicionado/s com sucesso!", null, JOptionPane.INFORMATION_MESSAGE, null);
				} catch (ExcecaoControlador e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
				
			}
		});
		btnAdicionarExemplar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnAdicionarExemplar = new GridBagConstraints();
		gbc_btnAdicionarExemplar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdicionarExemplar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionarExemplar.gridx = 0;
		gbc_btnAdicionarExemplar.gridy = 9;
		panel.add(btnAdicionarExemplar, gbc_btnAdicionarExemplar);
		
		JButton btnRemoverExemplar = new JButton("Remover Exemplar/s");
		btnRemoverExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Isbn = txtIsbn.getText();
				String qtdExemplares = txtQtdExemplares.getText();
				
				try {
					controlador.ExcluirExemplares(Isbn, qtdExemplares);
					JOptionPane.showMessageDialog(null, "Exemplar/s excluído/s com sucesso!", null, JOptionPane.INFORMATION_MESSAGE, null);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			}
		});
		btnRemoverExemplar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnRemoverExemplar = new GridBagConstraints();
		gbc_btnRemoverExemplar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemoverExemplar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnRemoverExemplar.gridx = 1;
		gbc_btnRemoverExemplar.gridy = 9;
		panel.add(btnRemoverExemplar, gbc_btnRemoverExemplar);
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 9;
		panel.add(btnNewButton, gbc_btnNewButton);
		scroll.setBounds(5, 26, 217, 408);
		
		listaLivros.setBounds(EXIT_ON_CLOSE, ABORT, 100, 450);
		listaLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLivros.setVisibleRowCount(5);
		getContentPane().add(scroll);
	}
}
