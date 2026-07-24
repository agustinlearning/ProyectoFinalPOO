package visual;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Singup extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtPassword;
	private JFormattedTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Singup frame = new Singup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Singup() {
		setTitle("Sing up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo Electronico");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(77, 38, 169, 38);
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasea.setBounds(77, 114, 169, 38);
		panel.add(lblContrasea);
		
		txtPassword = new JFormattedTextField();
		txtPassword.setBounds(272, 120, 257, 26);
		panel.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFTienes una cuenta?");
		lblNewLabel_1.setBounds(52, 266, 223, 20);
		panel.add(lblNewLabel_1);
		
		Button btnLogin = new Button("Inicia sesion");
		btnLogin.setActionCommand("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnLogin.setBounds(272, 259, 128, 27);
		panel.add(btnLogin);
		
		txtEmail = new JFormattedTextField();
		txtEmail.setBounds(272, 44, 257, 26);
		panel.add(txtEmail);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTipo.setBounds(77, 190, 169, 38);
		panel.add(lblTipo);
		
		JComboBox<String> cbxTipo = new JComboBox<String>();
		cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Empresa", "Persona"}));
		cbxTipo.setBounds(272, 196, 128, 26);
		panel.add(cbxTipo);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		panel_1.add(toolBar, BorderLayout.EAST);
		
		JButton btnSingup = new JButton("Registrar");
		btnSingup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(btnSingup);
		
		JButton btnCancel = new JButton("Cancelar");
		toolBar.add(btnCancel);
	}
}
