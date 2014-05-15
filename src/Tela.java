import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JSlider;

public class Tela extends JFrame {
	private Cliente c;
	private int t = 0;
	private JPanel contentPane;
	private JTextField LOGIN;
	private JPasswordField SENHA;
	private JTextField txtGfgf;
	private JTable table_1;
	private JTextField textField_2;
	private JTable table_2;
	private JTable table_3;
	private JTextField nome;
	private JTextField rg;
	private JTextField cpf;
	private JTextField Endereco;
	private JTextField n;
	private JTextField complemento;
	private JTextField bairro;
	private JTextField cep;
	private JTextField cidade;
	private JTextField eMail;
	private JTextField telefone;
	private JTextField celular;
	private final JComboBox comboBox = new JComboBox();
	private final JComboBox comboBox_1 = new JComboBox();
	private final JComboBox comboBox_2 = new JComboBox();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTable table_4;
	private JTextField nomeExerc;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void atualizarModelos() {
		table_3.setModel(new DefaultTableModel(matrizModeloClientes(),
				new String[] { "Matr\u00EDcula", "Nome" }));
		table.setModel(new DefaultTableModel(matrizModeloExerc2(comboBox
				.getSelectedIndex()), new String[] { "Exerc\u00EDcios",
				"Repeti\u00E7\u00F5es" }));
		table_2.setModel(new DefaultTableModel(matrizModeloExerc2(comboBox_1
				.getSelectedIndex()), new String[] { "Exerc\u00EDcios",
				"Repeti\u00E7\u00F5es" }));
		table_1.setModel(new DefaultTableModel(matrizModeloClientes(),
				new String[] { "Matr\u00EDcula", "Nome" }));
		table_4.setModel(new DefaultTableModel(matrizModeloExerc(),
				new String[] { "Exerc\u00EDcios" }));

	}

	private String[][] matrizModeloClientes() {
		List<Cliente> listaClientes = ClienteDAO.listar();
		String[][] m = new String[listaClientes.size()][2];
		for (int i = 0; i < listaClientes.size(); i++) {
			m[i][0] = "" + listaClientes.get(i).getMatricula();
			m[i][1] = listaClientes.get(i).getNome();
		}
		return m;
	}

	private String[][] matrizModeloClientesB(JTextField t) {
		List<Cliente> listaClientes = null;
		try {
			listaClientes = ClienteDAO.buscar(t.getText());
		} catch (ClienteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] m = new String[listaClientes.size()][2];
		for (int i = 0; i < listaClientes.size(); i++) {
			m[i][0] = "" + listaClientes.get(i).getMatricula();
			m[i][1] = listaClientes.get(i).getNome();
		}
		return m;
	}

	private String[] vetorModeloTreino() {
		if (c != null && c.getFicha() != null) {
			List<Treino> listaT = c.getFicha().treinos;
			String[] m = new String[listaT.size()];
			for (int i = 0; i < listaT.size(); i++) {
				m[i] = listaT.get(i).nome;
			}
			return m;
		}
		String[] m = { "" };
		return m;
	}

	private String[] vetorModeloExerc() {
		List<String> listaE = ExercicioDAO.lerExercicios();
		;
		String[] m = new String[listaE.size()];
		for (int i = 0; i < listaE.size(); i++) {
			m[i] = listaE.get(i);
		}

		return m;

	}

	private String[][] matrizModeloExerc2(int index) {
		if (c != null && !c.getFicha().treinos.isEmpty()) {
			List<Exercicio> listaE = c.getFicha().treinos.get(index).exercs;
			String[][] m = new String[listaE.size()][2];
			for (int i = 0; i < listaE.size(); i++) {
				m[i][0] = listaE.get(i).getNome();
				m[i][1] = "" + listaE.get(i).getReps();
			}
			return m;
		}
		String[][] m = { { "" } };
		return m;
	}

	private String[][] matrizModeloExerc() {
		List<String> listaE = ExercicioDAO.lerExercicios();
		String[][] m = new String[listaE.size()][1];
		for (int i = 0; i < listaE.size(); i++) {
			m[i][0] = listaE.get(i);
		}
		return m;
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setResizable(false);
		setTitle("Academia do Aldo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(0, 0, 626, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLocation(6, 6);
		contentPane.setBackground(new Color(0, 153, 0));

		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel login = new JPanel();
		login.setPreferredSize(new Dimension(0, 0));
		login.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		login.setBackground(SystemColor.inactiveCaption);
		contentPane.add(login, "Login");
		login.setLayout(null);

		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(214, 154, 45, 14);
		login.add(lblSenha);

		JButton Logan = new JButton("Login");

		Logan.setBounds(214, 220, 192, 23);
		login.add(Logan);
		LOGIN = new JTextField();
		LOGIN.setBounds(214, 114, 192, 28);
		login.add(LOGIN);
		LOGIN.setColumns(10);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(214, 88, 45, 14);
		login.add(lblLogin);

		SENHA = new JPasswordField();
		SENHA.setBounds(214, 180, 192, 28);
		login.add(SENHA);

		final JPanel Cliente = new JPanel();
		Cliente.setBackground(SystemColor.inactiveCaption);
		contentPane.add(Cliente, "Cliente");
		Cliente.setLayout(null);
		Cliente.setBounds(0, 0, 500, 500);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(6, 47, 55, 16);
		Cliente.add(lblNome);

		final JLabel lblmatrcula = new JLabel("");
		lblmatrcula.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblmatrcula.setBounds(79, 6, 445, 16);
		Cliente.add(lblmatrcula);

		final JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMatrcula.setBounds(6, 6, 84, 16);
		Cliente.add(lblMatrcula);

		final JLabel lblPedolvaresCabral = new JLabel("");
		lblPedolvaresCabral.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPedolvaresCabral.setBounds(51, 47, 282, 16);
		Cliente.add(lblPedolvaresCabral);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 115, 618, 299);
		Cliente.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Treinos\r\n\r\n\r\n", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = comboBox.getSelectedIndex();
				atualizarModelos();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(vetorModeloTreino()));
		panel_1.add(comboBox, BorderLayout.NORTH);

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_1.add(scrollPane_4, BorderLayout.CENTER);

		table = new JTable();
		scrollPane_4.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Dados pessoais", null, panel, null);
		panel.setLayout(null);

		JLabel label = new JLabel("RG:");
		label.setFont(new Font("SansSerif", Font.BOLD, 13));
		label.setBounds(21, 6, 32, 16);
		panel.add(label);

		JLabel label_1 = new JLabel("CPF:");
		label_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_1.setBounds(21, 34, 32, 16);
		panel.add(label_1);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(46, 6, 113, 16);
		panel.add(lblNewLabel);

		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(56, 34, 105, 16);
		panel.add(lblNewLabel_1);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSexo.setBounds(21, 62, 46, 16);
		panel.add(lblSexo);

		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(64, 62, 64, 16);
		panel.add(lblNewLabel_2);

		JLabel label_2 = new JLabel("Endere\u00E7o:");
		label_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_2.setBounds(21, 90, 71, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel("N\u00BA:");
		label_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(416, 90, 19, 14);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Complemento:");
		label_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_4.setBounds(22, 116, 97, 14);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Bairro:");
		label_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_5.setBounds(21, 142, 55, 16);
		panel.add(label_5);

		JLabel label_6 = new JLabel("CEP:");
		label_6.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_6.setBounds(416, 115, 32, 16);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Cidade:");
		label_7.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_7.setBounds(21, 170, 55, 14);
		panel.add(label_7);

		JLabel label_8 = new JLabel("UF:");
		label_8.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_8.setBounds(416, 170, 32, 14);
		panel.add(label_8);

		JLabel lblNascimento = new JLabel("Nascimento :");
		lblNascimento.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNascimento.setBounds(209, 6, 86, 14);
		panel.add(lblNascimento);

		final JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(296, 6, 108, 16);
		panel.add(lblNewLabel_3);

		JLabel label_10 = new JLabel("E-Mail:");
		label_10.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_10.setBounds(209, 34, 46, 14);
		panel.add(label_10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTelefone.setBounds(416, 7, 60, 14);
		panel.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCelular.setBounds(416, 35, 60, 14);
		panel.add(lblCelular);

		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(87, 88, 313, 16);
		panel.add(lblNewLabel_4);

		final JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(436, 89, 55, 16);
		panel.add(lblNewLabel_5);

		final JLabel label_11 = new JLabel("");
		label_11.setBounds(253, 32, 149, 16);
		panel.add(label_11);

		final JLabel label_12 = new JLabel("");
		label_12.setBounds(478, 6, 134, 16);
		panel.add(label_12);

		final JLabel label_13 = new JLabel("");
		label_13.setBounds(118, 114, 272, 16);
		panel.add(label_13);

		final JLabel label_14 = new JLabel("");
		label_14.setBounds(64, 142, 157, 16);
		panel.add(label_14);

		final JLabel label_15 = new JLabel("");
		label_15.setBounds(74, 168, 157, 16);
		panel.add(label_15);

		final JLabel label_16 = new JLabel("");
		label_16.setBounds(444, 168, 32, 16);
		panel.add(label_16);

		final JLabel label_17 = new JLabel("");
		label_17.setBounds(446, 114, 105, 16);
		panel.add(label_17);

		final JLabel label_18 = new JLabel("");
		label_18.setBounds(471, 34, 141, 16);
		panel.add(label_18);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane,
						"Login");
				t = 0;
				comboBox.setSelectedIndex(0);
				;
			}
		});
		btnSair.setBounds(536, 6, 70, 25);
		Cliente.add(btnSair);

		JPanel Ins = new JPanel();
		contentPane.add(Ins, "Instrutor");
		Ins.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		Ins.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JButton btnSair_1 = new JButton("Sair");
		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane,
						"Login");
				;
			}
		});
		panel_2.add(btnSair_1);

		txtGfgf = new JTextField();
		panel_2.add(txtGfgf);
		txtGfgf.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table_1.setModel(new DefaultTableModel(
						matrizModeloClientesB(txtGfgf), new String[] {
								"Matr\u00EDcula", "Nome" }));
			}
		});
		panel_2.add(btnNewButton);
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					c = ClienteDAO.buscar(Integer.parseInt(""
							+ table_1.getValueAt(table_1.getSelectedRow(), 0)));
					((CardLayout) contentPane.getLayout()).show(contentPane,
							"InsT");
					comboBox_1.setModel(new DefaultComboBoxModel(
							vetorModeloTreino()));
					comboBox_2.setModel(new DefaultComboBoxModel(
							vetorModeloExerc()));
					atualizarModelos();

				} catch (ClienteNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Ins.add(btnModificar, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		Ins.add(scrollPane, BorderLayout.CENTER);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBorder(null);
		table_1.setModel(new DefaultTableModel(matrizModeloClientes(),
				new String[] { "Matr\u00EDcula", "Nome" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(51);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(351);

		JPanel panel_4 = new JPanel();
		Ins.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(null);

		JPanel Ins_T = new JPanel();
		Ins_T.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				atualizarModelos();
			}
		});
		Ins_T.setBackground(UIManager.getColor("nimbusGreen"));
		contentPane.add(Ins_T, "InsT");
		Ins_T.setLayout(new BorderLayout(0, 0));

		JPanel Treinos = new JPanel();
		Treinos.setBackground(Color.LIGHT_GRAY);
		Ins_T.add(Treinos, BorderLayout.NORTH);

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarModelos();

			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(vetorModeloTreino()));

		JLabel lblNewLabel_6 = new JLabel("Treinos:");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JButton btnNewButton_1 = new JButton("Adicionar novo Treino");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Treino t = new Treino();
				c.getFicha().adicionarTreino(t);
				t.setNome("Treino " + c.getFicha().treinos.size());
				comboBox_1.setModel(new DefaultComboBoxModel(
						vetorModeloTreino()));
				ClienteDAO.escreverLista();
			}
		});

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) contentPane.getLayout()).show(contentPane,
						"Instrutor");

				;
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.getFicha().remTreino(comboBox_1.getSelectedIndex());
				ClienteDAO.escreverLista();
				t = 0;
				comboBox_1.setModel(new DefaultComboBoxModel(
						vetorModeloTreino()));
				atualizarModelos();
			}
		});
		GroupLayout gl_Treinos = new GroupLayout(Treinos);
		gl_Treinos.setHorizontalGroup(gl_Treinos.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_Treinos
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNewButton_2)
						.addPreferredGap(ComponentPlacement.RELATED, 102,
								Short.MAX_VALUE)
						.addComponent(lblNewLabel_6)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
								103, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE,
								79, GroupLayout.PREFERRED_SIZE).addGap(54)
						.addComponent(btnNewButton_1).addContainerGap()));
		gl_Treinos
				.setVerticalGroup(gl_Treinos
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_Treinos
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												gl_Treinos
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton_2)
														.addComponent(
																btnNewButton_1)
														.addComponent(
																btnRemover)
														.addComponent(
																comboBox_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_6,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		Treinos.setLayout(gl_Treinos);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		Ins_T.add(panel_3, BorderLayout.SOUTH);

		comboBox_2.setModel(new DefaultComboBoxModel(vetorModeloExerc()));

		JButton btnAdicionarAoTreino = new JButton("+");

		JLabel lblRepeties = new JLabel("Repeti\u00E7\u00F5es:");
		lblRepeties.setFont(new Font("SansSerif", Font.BOLD, 15));

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblExerccio = new JLabel("Exerc\u00EDcio:");
		lblExerccio.setFont(new Font("SansSerif", Font.BOLD, 15));
		JButton btnRemoverExerccio = new JButton("Remover ");
		btnRemoverExerccio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getFicha().treinos.get(comboBox_1.getSelectedIndex()).exercs
						.remove(table_2.getSelectedRow());
				atualizarModelos();
			}
		});

		btnAdicionarAoTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exercicio exerc = new Exercicio((String) comboBox_2
						.getSelectedItem(), Integer.parseInt(textField_2
						.getText()));
				c.getFicha().treinos.get(comboBox_1.getSelectedIndex()).add(
						exerc);
				textField_2.setText("");
				atualizarModelos();
				ClienteDAO.escreverLista();
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblExerccio, GroupLayout.PREFERRED_SIZE,
								71, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE,
								254, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblRepeties)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
								52, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAdicionarAoTreino)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnRemoverExerccio,
								GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addContainerGap(9, Short.MAX_VALUE)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblExerccio,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnRemoverExerccio)
														.addComponent(
																btnAdicionarAoTreino)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRepeties))
										.addContainerGap()));
		panel_3.setLayout(gl_panel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Ins_T.add(scrollPane_1, BorderLayout.CENTER);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(matrizModeloExerc2(comboBox_1
				.getSelectedIndex()), new String[] { "Exerc\u00EDcios",
				"Repeti\u00E7\u00F5es" }) {

		});

		scrollPane_1.setViewportView(table_2);
		
		JPanel Admin = new JPanel();
		contentPane.add(Admin, "name_16740470158295");
		Admin.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		Admin.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadastrarAluno = new JMenuItem("Cliente");
		mnCadastrar.add(mntmCadastrarAluno);
		
		JSeparator separator = new JSeparator();
		mnCadastrar.add(separator);
		
		JMenuItem mntmCadastrarInstrutor = new JMenuItem("Instrutor");
		mnCadastrar.add(mntmCadastrarInstrutor);
		
		JMenu mnEditar = new JMenu("Buscar\r\n");
		menuBar.add(mnEditar);
		
		JMenuItem mntmExerccios = new JMenuItem("Exerc\u00EDcios");
		mnEditar.add(mntmExerccios);
		
		JSeparator separator_1 = new JSeparator();
		mnEditar.add(separator_1);
		
		JMenuItem mntmAluno = new JMenuItem("Clientes");
		mnEditar.add(mntmAluno);
		
		JSeparator separator_2 = new JSeparator();
		mnEditar.add(separator_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instrutores");
		mnEditar.add(mntmNewMenuItem);
		
		JMenuItem mntmSais = new JMenuItem("Sair");
		mntmSais.setBackground(Color.BLACK);
		menuBar.add(mntmSais);
		
		JPanel CardAdmin = new JPanel();
		Admin.add(CardAdmin, BorderLayout.CENTER);
		CardAdmin.setLayout(new CardLayout(0, 0));
		
				JPanel Buscar_Aluno = new JPanel();
				CardAdmin.add(Buscar_Aluno, "name_17049189072812");
				Buscar_Aluno.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentShown(ComponentEvent arg0) {
						atualizarModelos();
					}
				});
				Buscar_Aluno.setBackground(SystemColor.inactiveCaption);
				Buscar_Aluno.setLayout(new BorderLayout(0, 0));
				
						JPanel panel_5 = new JPanel();
						Buscar_Aluno.add(panel_5, BorderLayout.NORTH);
						
								textField = new JTextField();
								textField.setColumns(10);
												
														JButton btnBuscar = new JButton("Buscar");
														btnBuscar.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																table_3.setModel(new DefaultTableModel(
																		matrizModeloClientesB(textField), new String[] {
																				"Matr\u00EDcula", "Nome" }));
															}
														});
																GroupLayout gl_panel_5 = new GroupLayout(panel_5);
																gl_panel_5.setHorizontalGroup(
																	gl_panel_5.createParallelGroup(Alignment.LEADING)
																		.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
																			.addContainerGap()
																			.addComponent(textField, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(btnBuscar)
																			.addContainerGap())
																);
																gl_panel_5.setVerticalGroup(
																	gl_panel_5.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
																			.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(btnBuscar))
																);
																panel_5.setLayout(gl_panel_5);
																
																		JPanel panel_6 = new JPanel();
																		Buscar_Aluno.add(panel_6);
																		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
																		
																				JScrollPane scrollPane_2 = new JScrollPane();
																				scrollPane_2
																						.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
																				panel_6.add(scrollPane_2);
																				
																						table_3 = new JTable();
																						table_3.setModel(new DefaultTableModel(matrizModeloClientes(),
																								new String[] { "Matr\u00EDcula", "Nome" }) {
																							boolean[] columnEditables = new boolean[] { false, false };

																							public boolean isCellEditable(int row, int column) {
																								return columnEditables[column];
																							}
																						});
																						table_3.getColumnModel().getColumn(0).setResizable(false);
																						table_3.getColumnModel().getColumn(1).setResizable(false);
																						table_3.getColumnModel().getColumn(1).setPreferredWidth(254);
																						scrollPane_2.setViewportView(table_3);
																						
																								JPanel panel_7 = new JPanel();
																								Buscar_Aluno.add(panel_7, BorderLayout.SOUTH);
																								panel_7.setLayout(new GridLayout(0, 2, 1, 1));
																										
																										JButton btnEditarAluno = new JButton("Editar Aluno");
																										panel_7.add(btnEditarAluno);
																										
																												JButton btnNewButton_3 = new JButton("Remover Aluno");
																												btnNewButton_3.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent arg0) {
																														try {
																															ContasDAO.remConta(Integer.parseInt(""
																																	+ table_3.getValueAt(table_3.getSelectedRow(), 0)));
																														} catch (NumberFormatException e) {
																															e.printStackTrace();
																														} catch (ClienteNotFoundException e) {
																															e.printStackTrace();
																														}
																														ClienteDAO.excluir(Integer.parseInt(""
																																+ table_3.getValueAt(table_3.getSelectedRow(), 0)));
																														atualizarModelos();

																													}
																												});
																												panel_7.add(btnNewButton_3);
																										
																												JPanel Buscar_E = new JPanel();
																												CardAdmin.add(Buscar_E, "name_17076541215446");
																												Buscar_E.setLayout(new BorderLayout(0, 0));
																												
																														JScrollPane scrollPane_5 = new JScrollPane();
																														Buscar_E.add(scrollPane_5, BorderLayout.CENTER);
																														
																																table_4 = new JTable();
																																table_4.setModel(new DefaultTableModel(matrizModeloExerc(),
																																		new String[] { "Exerc\u00EDcio" }));
																																
																																		scrollPane_5.setViewportView(table_4);
																																		
																																				JPanel panel_8 = new JPanel();
																																				Buscar_E.add(panel_8, BorderLayout.NORTH);
																																				
																																						JButton btnNewButton_5 = new JButton("Voltar");
																																						btnNewButton_5.addActionListener(new ActionListener() {
																																							public void actionPerformed(ActionEvent arg0) {
																																								((CardLayout) contentPane.getLayout()).show(contentPane, "Adm");
																																							}
																																						});
																																						
																																								JButton button = new JButton("Adicionar");
																																								
																																										JLabel lblNewLabel_7 = new JLabel("Nome do Exerc\u00EDcio:");
																																										lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																										
																																												nomeExerc = new JTextField();
																																												nomeExerc.setColumns(10);
																																												GroupLayout gl_panel_8 = new GroupLayout(panel_8);
																																												gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(
																																														Alignment.LEADING).addGroup(
																																														gl_panel_8
																																																.createSequentialGroup()
																																																.addComponent(btnNewButton_5)
																																																.addPreferredGap(ComponentPlacement.UNRELATED)
																																																.addComponent(lblNewLabel_7)
																																																.addPreferredGap(ComponentPlacement.RELATED)
																																																.addComponent(nomeExerc, GroupLayout.PREFERRED_SIZE,
																																																		334, GroupLayout.PREFERRED_SIZE)
																																																.addPreferredGap(ComponentPlacement.RELATED)
																																																.addComponent(button).addGap(20)));
																																												gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(
																																														Alignment.LEADING).addGroup(
																																														gl_panel_8
																																																.createParallelGroup(Alignment.BASELINE)
																																																.addComponent(btnNewButton_5)
																																																.addComponent(lblNewLabel_7)
																																																.addComponent(nomeExerc, GroupLayout.PREFERRED_SIZE,
																																																		GroupLayout.DEFAULT_SIZE,
																																																		GroupLayout.PREFERRED_SIZE)
																																																.addComponent(button)));
																																												panel_8.setLayout(gl_panel_8);
																																												button.addActionListener(new ActionListener() {
																																													public void actionPerformed(ActionEvent e) {
																																														ExercicioDAO.adicionarExercicio(nomeExerc.getText());
																																														atualizarModelos();
																																														nomeExerc.setText("");
																																													}
																																												});
																																												
																																														JPanel panel_9 = new JPanel();
																																														Buscar_E.add(panel_9, BorderLayout.SOUTH);
																																														panel_9.setLayout(new GridLayout(0, 1, 1, 1));
																																														
																																																JButton btnNewButton_4 = new JButton("Remover Exerc\u00EDcio");
																																																panel_9.add(btnNewButton_4);
																																																
																																																		JPanel Cadastro_Cliente = new JPanel();
																																																		CardAdmin.add(Cadastro_Cliente, "name_21411182643907");
																																																		Cadastro_Cliente.setLayout(null);
																																																		Cadastro_Cliente.setBackground(SystemColor.inactiveCaption);
																																																		
																																																				nome = new JTextField();
																																																				nome.setColumns(10);
																																																				nome.setBounds(6, 40, 592, 28);
																																																				Cadastro_Cliente.add(nome);
																																																				
																																																						JLabel label_19 = new JLabel("Nome:");
																																																						label_19.setBounds(6, 23, 46, 14);
																																																						Cadastro_Cliente.add(label_19);
																																																						
																																																								JLabel label_20 = new JLabel("RG:");
																																																								label_20.setBounds(6, 80, 55, 16);
																																																								Cadastro_Cliente.add(label_20);
																																																								
																																																										rg = new JTextField();
																																																										rg.setColumns(10);
																																																										rg.setBounds(6, 98, 122, 28);
																																																										Cadastro_Cliente.add(rg);
																																																										
																																																												JLabel label_21 = new JLabel("CPF:");
																																																												label_21.setBounds(309, 81, 46, 14);
																																																												Cadastro_Cliente.add(label_21);
																																																												
																																																														cpf = new JTextField();
																																																														cpf.setColumns(10);
																																																														cpf.setBounds(309, 98, 131, 28);
																																																														Cadastro_Cliente.add(cpf);
																																																														
																																																																final JRadioButton radioF = new JRadioButton("Feminino");
																																																																buttonGroup.add(radioF);
																																																																radioF.setBackground(SystemColor.inactiveCaption);
																																																																radioF.setBounds(134, 130, 78, 23);
																																																																Cadastro_Cliente.add(radioF);
																																																																
																																																																		final JRadioButton radioM = new JRadioButton("Masculino");
																																																																		buttonGroup.add(radioM);
																																																																		radioM.setBackground(SystemColor.inactiveCaption);
																																																																		radioM.setBounds(44, 130, 78, 23);
																																																																		Cadastro_Cliente.add(radioM);
																																																																		
																																																																				JLabel label_22 = new JLabel("Sexo:");
																																																																				label_22.setBounds(6, 134, 46, 14);
																																																																				Cadastro_Cliente.add(label_22);
																																																																				
																																																																						JLabel label_23 = new JLabel("Endere\u00E7o:");
																																																																						label_23.setBounds(6, 160, 58, 14);
																																																																						Cadastro_Cliente.add(label_23);
																																																																						
																																																																								Endereco = new JTextField();
																																																																								Endereco.setColumns(10);
																																																																								Endereco.setBounds(6, 177, 220, 28);
																																																																								Cadastro_Cliente.add(Endereco);
																																																																								
																																																																										JLabel label_24 = new JLabel("N\u00BA:");
																																																																										label_24.setHorizontalAlignment(SwingConstants.LEFT);
																																																																										label_24.setBounds(238, 160, 29, 14);
																																																																										Cadastro_Cliente.add(label_24);
																																																																										
																																																																												n = new JTextField();
																																																																												n.setColumns(10);
																																																																												n.setBounds(238, 177, 62, 28);
																																																																												Cadastro_Cliente.add(n);
																																																																												
																																																																														JLabel label_25 = new JLabel("Complemento:");
																																																																														label_25.setBounds(6, 207, 97, 14);
																																																																														Cadastro_Cliente.add(label_25);
																																																																														
																																																																																complemento = new JTextField();
																																																																																complemento.setColumns(10);
																																																																																complemento.setBounds(6, 225, 185, 28);
																																																																																Cadastro_Cliente.add(complemento);
																																																																																
																																																																																		JLabel label_26 = new JLabel("Bairro:");
																																																																																		label_26.setBounds(203, 206, 55, 16);
																																																																																		Cadastro_Cliente.add(label_26);
																																																																																		
																																																																																				bairro = new JTextField();
																																																																																				bairro.setColumns(10);
																																																																																				bairro.setBounds(203, 225, 99, 28);
																																																																																				Cadastro_Cliente.add(bairro);
																																																																																				
																																																																																						JButton button_1 = new JButton("Cancelar");
																																																																																						
																																																																																								button_1.setBounds(6, 321, 89, 23);
																																																																																								Cadastro_Cliente.add(button_1);
																																																																																								
																																																																																										JButton button_2 = new JButton("Cadastrar");
																																																																																										
																																																																																												button_2.setBounds(525, 321, 89, 23);
																																																																																												Cadastro_Cliente.add(button_2);
																																																																																												
																																																																																														JLabel label_27 = new JLabel("Nascimento :");
																																																																																														label_27.setBounds(309, 160, 75, 14);
																																																																																														Cadastro_Cliente.add(label_27);
																																																																																														
																																																																																																JLabel label_28 = new JLabel("Dia");
																																																																																																label_28.setBounds(396, 160, 29, 14);
																																																																																																Cadastro_Cliente.add(label_28);
																																																																																																
																																																																																																		final JComboBox diaCombo = new JComboBox();
																																																																																																		diaCombo.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2",
																																																																																																				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
																																																																																																				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
																																																																																																				"24", "25", "26", "27", "28", "29", "30", "31" }));
																																																																																																		diaCombo.setBounds(396, 181, 59, 20);
																																																																																																		Cadastro_Cliente.add(diaCombo);
																																																																																																		
																																																																																																				final JComboBox mesCombo = new JComboBox();
																																																																																																				mesCombo.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2",
																																																																																																						"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
																																																																																																				mesCombo.setBounds(459, 181, 59, 20);
																																																																																																				Cadastro_Cliente.add(mesCombo);
																																																																																																				
																																																																																																						JLabel label_29 = new JLabel("M\u00EAs");
																																																																																																						label_29.setBounds(459, 160, 29, 14);
																																																																																																						Cadastro_Cliente.add(label_29);
																																																																																																						
																																																																																																								JLabel label_30 = new JLabel("Ano");
																																																																																																								label_30.setBounds(525, 160, 29, 14);
																																																																																																								Cadastro_Cliente.add(label_30);
																																																																																																								
																																																																																																										final JComboBox anoCombo = new JComboBox();
																																																																																																										anoCombo.setModel(new DefaultComboBoxModel(new String[] { "", "1930",
																																																																																																												"1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938",
																																																																																																												"1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946",
																																																																																																												"1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954",
																																																																																																												"1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962",
																																																																																																												"1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970",
																																																																																																												"1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978",
																																																																																																												"1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986",
																																																																																																												"1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994",
																																																																																																												"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
																																																																																																												"2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
																																																																																																												"2011", "2012", "2013", "2014" }));
																																																																																																										anoCombo.setBounds(523, 181, 75, 20);
																																																																																																										Cadastro_Cliente.add(anoCombo);
																																																																																																										
																																																																																																												JLabel label_31 = new JLabel("CEP:");
																																																																																																												label_31.setBounds(309, 207, 55, 16);
																																																																																																												Cadastro_Cliente.add(label_31);
																																																																																																												
																																																																																																														cep = new JTextField();
																																																																																																														cep.setColumns(10);
																																																																																																														cep.setBounds(309, 224, 97, 28);
																																																																																																														Cadastro_Cliente.add(cep);
																																																																																																														
																																																																																																																JLabel label_32 = new JLabel("Cidade:");
																																																																																																																label_32.setBounds(413, 209, 46, 14);
																																																																																																																Cadastro_Cliente.add(label_32);
																																																																																																																
																																																																																																																		cidade = new JTextField();
																																																																																																																		cidade.setColumns(10);
																																																																																																																		cidade.setBounds(413, 224, 122, 28);
																																																																																																																		Cadastro_Cliente.add(cidade);
																																																																																																																		
																																																																																																																				JLabel label_33 = new JLabel("UF:");
																																																																																																																				label_33.setBounds(539, 209, 29, 14);
																																																																																																																				Cadastro_Cliente.add(label_33);
																																																																																																																				
																																																																																																																						final JComboBox ufCombo = new JComboBox();
																																																																																																																						ufCombo.setModel(new DefaultComboBoxModel(new String[] { "AC", "AL",
																																																																																																																								"AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
																																																																																																																								"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
																																																																																																																								"RR", "SC", "SP", "SE", "TO" }));
																																																																																																																						ufCombo.setBounds(539, 225, 59, 26);
																																																																																																																						Cadastro_Cliente.add(ufCombo);
																																																																																																																						
																																																																																																																								JLabel label_34 = new JLabel("E-Mail:");
																																																																																																																								label_34.setBounds(6, 264, 46, 14);
																																																																																																																								Cadastro_Cliente.add(label_34);
																																																																																																																								
																																																																																																																										eMail = new JTextField();
																																																																																																																										eMail.setColumns(10);
																																																																																																																										eMail.setBounds(6, 281, 293, 28);
																																																																																																																										Cadastro_Cliente.add(eMail);
																																																																																																																										
																																																																																																																												JLabel label_35 = new JLabel("Telefone");
																																																																																																																												label_35.setBounds(311, 265, 60, 14);
																																																																																																																												Cadastro_Cliente.add(label_35);
																																																																																																																												
																																																																																																																														telefone = new JTextField();
																																																																																																																														telefone.setColumns(10);
																																																																																																																														telefone.setBounds(309, 281, 116, 28);
																																																																																																																														Cadastro_Cliente.add(telefone);
																																																																																																																														
																																																																																																																																JLabel label_36 = new JLabel("Celular");
																																																																																																																																label_36.setBounds(452, 264, 60, 14);
																																																																																																																																Cadastro_Cliente.add(label_36);
																																																																																																																																celular = new JTextField();
																																																																																																																																celular.setColumns(10);
																																																																																																																																celular.setBounds(452, 280, 116, 28);
																																																																																																																																Cadastro_Cliente.add(celular);
																																																																																																																																
																																																																																																																																JPanel Cadastro_Ins = new JPanel();
																																																																																																																																Cadastro_Ins.setLayout(null);
																																																																																																																																Cadastro_Ins.setBackground(SystemColor.inactiveCaption);
																																																																																																																																CardAdmin.add(Cadastro_Ins, "name_21698288833216");
																																																																																																																																
																																																																																																																																textField_1 = new JTextField();
																																																																																																																																textField_1.setColumns(10);
																																																																																																																																textField_1.setBounds(6, 40, 592, 28);
																																																																																																																																Cadastro_Ins.add(textField_1);
																																																																																																																																
																																																																																																																																JLabel label_9 = new JLabel("Nome:");
																																																																																																																																label_9.setBounds(6, 23, 46, 14);
																																																																																																																																Cadastro_Ins.add(label_9);
																																																																																																																																
																																																																																																																																JLabel label_37 = new JLabel("RG:");
																																																																																																																																label_37.setBounds(6, 80, 55, 16);
																																																																																																																																Cadastro_Ins.add(label_37);
																																																																																																																																
																																																																																																																																textField_3 = new JTextField();
																																																																																																																																textField_3.setColumns(10);
																																																																																																																																textField_3.setBounds(6, 98, 122, 28);
																																																																																																																																Cadastro_Ins.add(textField_3);
																																																																																																																																
																																																																																																																																JLabel label_38 = new JLabel("CPF:");
																																																																																																																																label_38.setBounds(309, 81, 46, 14);
																																																																																																																																Cadastro_Ins.add(label_38);
																																																																																																																																
																																																																																																																																textField_4 = new JTextField();
																																																																																																																																textField_4.setColumns(10);
																																																																																																																																textField_4.setBounds(309, 98, 131, 28);
																																																																																																																																Cadastro_Ins.add(textField_4);
																																																																																																																																
																																																																																																																																JRadioButton radioButton = new JRadioButton("Feminino");
																																																																																																																																radioButton.setBackground(SystemColor.inactiveCaption);
																																																																																																																																radioButton.setBounds(134, 130, 78, 23);
																																																																																																																																Cadastro_Ins.add(radioButton);
																																																																																																																																
																																																																																																																																JRadioButton radioButton_1 = new JRadioButton("Masculino");
																																																																																																																																radioButton_1.setBackground(SystemColor.inactiveCaption);
																																																																																																																																radioButton_1.setBounds(44, 130, 78, 23);
																																																																																																																																Cadastro_Ins.add(radioButton_1);
																																																																																																																																
																																																																																																																																JLabel label_39 = new JLabel("Sexo:");
																																																																																																																																label_39.setBounds(6, 134, 46, 14);
																																																																																																																																Cadastro_Ins.add(label_39);
																																																																																																																																
																																																																																																																																JLabel label_40 = new JLabel("Endere\u00E7o:");
																																																																																																																																label_40.setBounds(6, 160, 58, 14);
																																																																																																																																Cadastro_Ins.add(label_40);
																																																																																																																																
																																																																																																																																textField_5 = new JTextField();
																																																																																																																																textField_5.setColumns(10);
																																																																																																																																textField_5.setBounds(6, 177, 220, 28);
																																																																																																																																Cadastro_Ins.add(textField_5);
																																																																																																																																
																																																																																																																																JLabel label_41 = new JLabel("N\u00BA:");
																																																																																																																																label_41.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																																																																label_41.setBounds(238, 160, 29, 14);
																																																																																																																																Cadastro_Ins.add(label_41);
																																																																																																																																
																																																																																																																																textField_6 = new JTextField();
																																																																																																																																textField_6.setColumns(10);
																																																																																																																																textField_6.setBounds(238, 177, 62, 28);
																																																																																																																																Cadastro_Ins.add(textField_6);
																																																																																																																																
																																																																																																																																JLabel label_42 = new JLabel("Complemento:");
																																																																																																																																label_42.setBounds(6, 207, 97, 14);
																																																																																																																																Cadastro_Ins.add(label_42);
																																																																																																																																
																																																																																																																																textField_7 = new JTextField();
																																																																																																																																textField_7.setColumns(10);
																																																																																																																																textField_7.setBounds(6, 225, 185, 28);
																																																																																																																																Cadastro_Ins.add(textField_7);
																																																																																																																																
																																																																																																																																JLabel label_43 = new JLabel("Bairro:");
																																																																																																																																label_43.setBounds(203, 206, 55, 16);
																																																																																																																																Cadastro_Ins.add(label_43);
																																																																																																																																
																																																																																																																																textField_8 = new JTextField();
																																																																																																																																textField_8.setColumns(10);
																																																																																																																																textField_8.setBounds(203, 225, 99, 28);
																																																																																																																																Cadastro_Ins.add(textField_8);
																																																																																																																																
																																																																																																																																JButton button_3 = new JButton("Cancelar");
																																																																																																																																button_3.setBounds(6, 321, 89, 23);
																																																																																																																																Cadastro_Ins.add(button_3);
																																																																																																																																
																																																																																																																																JButton button_4 = new JButton("Cadastrar");
																																																																																																																																button_4.setBounds(525, 321, 89, 23);
																																																																																																																																Cadastro_Ins.add(button_4);
																																																																																																																																
																																																																																																																																JLabel label_44 = new JLabel("Nascimento :");
																																																																																																																																label_44.setBounds(309, 160, 75, 14);
																																																																																																																																Cadastro_Ins.add(label_44);
																																																																																																																																
																																																																																																																																JLabel label_45 = new JLabel("Dia");
																																																																																																																																label_45.setBounds(396, 160, 29, 14);
																																																																																																																																Cadastro_Ins.add(label_45);
																																																																																																																																
																																																																																																																																JComboBox comboBox_3 = new JComboBox();
																																																																																																																																comboBox_3.setBounds(396, 181, 59, 20);
																																																																																																																																Cadastro_Ins.add(comboBox_3);
																																																																																																																																
																																																																																																																																JComboBox comboBox_4 = new JComboBox();
																																																																																																																																comboBox_4.setBounds(459, 181, 59, 20);
																																																																																																																																Cadastro_Ins.add(comboBox_4);
																																																																																																																																
																																																																																																																																JLabel label_46 = new JLabel("M\u00EAs");
																																																																																																																																label_46.setBounds(459, 160, 29, 14);
																																																																																																																																Cadastro_Ins.add(label_46);
																																																																																																																																
																																																																																																																																JLabel label_47 = new JLabel("Ano");
																																																																																																																																label_47.setBounds(525, 160, 29, 14);
																																																																																																																																Cadastro_Ins.add(label_47);
																																																																																																																																
																																																																																																																																JComboBox comboBox_5 = new JComboBox();
																																																																																																																																comboBox_5.setBounds(523, 181, 75, 20);
																																																																																																																																Cadastro_Ins.add(comboBox_5);
																																																																																																																																
																																																																																																																																JLabel label_48 = new JLabel("CEP:");
																																																																																																																																label_48.setBounds(309, 207, 55, 16);
																																																																																																																																Cadastro_Ins.add(label_48);
																																																																																																																																
																																																																																																																																textField_9 = new JTextField();
																																																																																																																																textField_9.setColumns(10);
																																																																																																																																textField_9.setBounds(309, 224, 97, 28);
																																																																																																																																Cadastro_Ins.add(textField_9);
																																																																																																																																
																																																																																																																																JLabel label_49 = new JLabel("Cidade:");
																																																																																																																																label_49.setBounds(413, 209, 46, 14);
																																																																																																																																Cadastro_Ins.add(label_49);
																																																																																																																																
																																																																																																																																textField_10 = new JTextField();
																																																																																																																																textField_10.setColumns(10);
																																																																																																																																textField_10.setBounds(413, 224, 122, 28);
																																																																																																																																Cadastro_Ins.add(textField_10);
																																																																																																																																
																																																																																																																																JLabel label_50 = new JLabel("UF:");
																																																																																																																																label_50.setBounds(539, 209, 29, 14);
																																																																																																																																Cadastro_Ins.add(label_50);
																																																																																																																																
																																																																																																																																JComboBox comboBox_6 = new JComboBox();
																																																																																																																																comboBox_6.setBounds(539, 225, 59, 26);
																																																																																																																																Cadastro_Ins.add(comboBox_6);
																																																																																																																																
																																																																																																																																JLabel label_51 = new JLabel("E-Mail:");
																																																																																																																																label_51.setBounds(6, 264, 46, 14);
																																																																																																																																Cadastro_Ins.add(label_51);
																																																																																																																																
																																																																																																																																textField_11 = new JTextField();
																																																																																																																																textField_11.setColumns(10);
																																																																																																																																textField_11.setBounds(6, 281, 293, 28);
																																																																																																																																Cadastro_Ins.add(textField_11);
																																																																																																																																
																																																																																																																																JLabel label_52 = new JLabel("Telefone");
																																																																																																																																label_52.setBounds(311, 265, 60, 14);
																																																																																																																																Cadastro_Ins.add(label_52);
																																																																																																																																
																																																																																																																																textField_12 = new JTextField();
																																																																																																																																textField_12.setColumns(10);
																																																																																																																																textField_12.setBounds(309, 281, 116, 28);
																																																																																																																																Cadastro_Ins.add(textField_12);
																																																																																																																																
																																																																																																																																JLabel label_53 = new JLabel("Celular");
																																																																																																																																label_53.setBounds(452, 264, 60, 14);
																																																																																																																																Cadastro_Ins.add(label_53);
																																																																																																																																
																																																																																																																																textField_13 = new JTextField();
																																																																																																																																textField_13.setColumns(10);
																																																																																																																																textField_13.setBounds(452, 280, 116, 28);
																																																																																																																																Cadastro_Ins.add(textField_13);
																																																																																																																																
																																																																																																																																JPanel panel_10 = new JPanel();
																																																																																																																																CardAdmin.add(panel_10, "name_24811568972940");
																																																																																																																																button_2.addActionListener(new ActionListener() {
																																																																																																																																	public void actionPerformed(ActionEvent arg0) {
																																																																																																																																		Cliente aux = new Cliente();
																																																																																																																																		aux.setMatricula(ClienteDAO.proximaMatricula());
																																																																																																																																		aux.setNome(nome.getText());
																																																																																																																																		aux.setRG(rg.getText());
																																																																																																																																		aux.setCPF(cpf.getText());
																																																																																																																																		aux.setEndereco(Endereco.getText());
																																																																																																																																		aux.setNumeroCasa(n.getText());
																																																																																																																																		aux.setComplemento(complemento.getText());
																																																																																																																																		aux.setBairro(bairro.getText());
																																																																																																																																		aux.setCEP(cep.getText());
																																																																																																																																		aux.setCidade(cidade.getText());
																																																																																																																																		aux.seteMail(eMail.getText());
																																																																																																																																		aux.setTelefone(telefone.getText());
																																																																																																																																		aux.setCelular(celular.getText());
																																																																																																																																		aux.setEstado((String) ufCombo.getSelectedItem());
																																																																																																																																		try {
																																																																																																																																			aux.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy")
																																																																																																																																					.parse(diaCombo.getSelectedItem() + "/"
																																																																																																																																							+ mesCombo.getSelectedItem() + "/"
																																																																																																																																							+ anoCombo.getSelectedItem()));
																																																																																																																																		} catch (ParseException e) {
																																																																																																																																			// TODO Auto-generated catch block
																																																																																																																																			e.printStackTrace();
																																																																																																																																		}
																																																																																																																																		if (buttonGroup.isSelected(radioM.getModel()))
																																																																																																																																			aux.setSexo('M');
																																																																																																																																		else
																																																																																																																																			aux.setSexo('F');

																																																																																																																																		ContasDAO.addConta(aux.getMatricula(),
																																																																																																																																				(String) JOptionPane.showInputDialog("Digite a senha:"));
																																																																																																																																		ClienteDAO.inserir(aux);

																																																																																																																																		JOptionPane.showMessageDialog(null,
																																																																																																																																				"Cadastro feito com sucesso.");
																																																																																																																																		((CardLayout) contentPane.getLayout()).show(contentPane, "Adm");
																																																																																																																																		nome.setText("");
																																																																																																																																		rg.setText("");
																																																																																																																																		cpf.setText("");
																																																																																																																																		Endereco.setText("");
																																																																																																																																		n.setText("");
																																																																																																																																		complemento.setText("");
																																																																																																																																		bairro.setText("");
																																																																																																																																		cep.setText("");
																																																																																																																																		cidade.setText("");
																																																																																																																																		eMail.setText("");
																																																																																																																																		telefone.setText("");
																																																																																																																																		celular.setText("");
																																																																																																																																		diaCombo.setSelectedIndex(0);
																																																																																																																																		mesCombo.setSelectedIndex(0);
																																																																																																																																		anoCombo.setSelectedIndex(0);
																																																																																																																																		ufCombo.setSelectedIndex(0);
																																																																																																																																	}
																																																																																																																																});
																																																																																																																																button_1.addActionListener(new ActionListener() {
																																																																																																																																	public void actionPerformed(ActionEvent e) {
																																																																																																																																		((CardLayout) contentPane.getLayout()).show(contentPane, "Adm");
																																																																																																																																		nome.setText("");
																																																																																																																																		rg.setText("");
																																																																																																																																		cpf.setText("");
																																																																																																																																		Endereco.setText("");
																																																																																																																																		n.setText("");
																																																																																																																																		complemento.setText("");
																																																																																																																																		bairro.setText("");
																																																																																																																																		cep.setText("");
																																																																																																																																		cidade.setText("");
																																																																																																																																		eMail.setText("");
																																																																																																																																		telefone.setText("");
																																																																																																																																		celular.setText("");
																																																																																																																																		diaCombo.setSelectedIndex(0);
																																																																																																																																		mesCombo.setSelectedIndex(0);
																																																																																																																																		anoCombo.setSelectedIndex(0);
																																																																																																																																		ufCombo.setSelectedIndex(0);
																																																																																																																																	}
																																																																																																																																});
																																																btnNewButton_4.addActionListener(new ActionListener() {
																																																	public void actionPerformed(ActionEvent e) {
																																																		try {
																																																			ExercicioDAO.remExercicio((String) table_4.getValueAt(
																																																					table_4.getSelectedRow(), 0));
																																																			atualizarModelos();
																																																		} catch (ExercicioNotFoundException e1) {
																																																			// TODO Auto-generated catch block
																																																			e1.printStackTrace();
																																																		}
																																																	}
																																																});
		setLocationRelativeTo(null);
		Logan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (SENHA.getText().equals(Conta.getSenhaAdm())) {
					if (LOGIN.getText().equals(Conta.getAdm())) {
						((CardLayout) contentPane.getLayout()).show(
								contentPane, "Adm");
					} else {
						JOptionPane.showMessageDialog(null,
								"Login ou Senha Errado!");
					}
				} else if (SENHA.getText().equals(Conta.getSenhaIns())) {
					if (LOGIN.getText().equals(Conta.getIns())) {
						((CardLayout) contentPane.getLayout()).show(
								contentPane, "Instrutor");
						;
					} else {
						JOptionPane.showMessageDialog(null,
								"Login ou Senha Errado!");
					}
				} else
					try {
						c = ContasDAO.login(Integer.parseInt(LOGIN.getText()),
								SENHA.getText());

						lblmatrcula.setText("" + c.getMatricula());
						lblPedolvaresCabral.setText("" + c.getNome());
						lblNewLabel.setText("" + c.getRG());
						lblNewLabel_1.setText("" + c.getCPF());
						lblNewLabel_2.setText("" + c.getSexo());
						lblNewLabel_3.setText(""
								+ new SimpleDateFormat("dd/MM/yyy").format(c
										.getDataNascimento()));
						lblNewLabel_4.setText("" + c.getEndereco());
						label_11.setText("" + c.geteMail());
						label_12.setText("" + c.getTelefone());
						label_18.setText("" + c.getCelular());
						lblNewLabel_5.setText("" + c.getNumeroCasa());
						label_13.setText("" + c.getComplemento());
						label_17.setText("" + c.getCEP());
						label_14.setText("" + c.getBairro());
						label_15.setText("" + c.getCidade());
						label_16.setText("" + c.getEstado());
						((CardLayout) contentPane.getLayout()).show(
								contentPane, "Cliente");
						comboBox.setModel(new DefaultComboBoxModel(
								vetorModeloTreino()));
						atualizarModelos();
						LOGIN.setText("");
						SENHA.setText("");

					} catch (ClienteNotFoundException e) {
						e = new ClienteNotFoundException();
						JOptionPane.showMessageDialog(null,
								"Login ou Senha Errado!");
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Login ou Senha Errado!");
					} catch (HeadlessException e) {
						JOptionPane.showMessageDialog(null,
								"Login ou Senha Errado!");
					}

				//
				// ((CardLayout)contentPane.getLayout()).show(contentPane,
				// "Instrutor");;
				LOGIN.setText("");
				SENHA.setText("");

			}

		});

	}
}