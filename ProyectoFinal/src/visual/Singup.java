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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Singup extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JFormattedTextField txtEmail;
	private JButton btnCancel;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Bolsa.guardarSistema();
			}
		});
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
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(77, 38, 169, 38);
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblContrasea.setBounds(77, 114, 169, 38);
		panel.add(lblContrasea);
		
		txtPassword = new JPasswordField();
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
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTipo.setBounds(77, 190, 169, 38);
		panel.add(lblTipo);
		
		JComboBox<String> cbxTipo = new JComboBox<String>();
		cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Empresa", "Persona"}));
		cbxTipo.setBounds(272, 196, 128, 26);
		panel.add(cbxTipo);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnSingup = new JButton("Registrar");
		panel_2.add(btnSingup);
		btnSingup.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String email = txtEmail.getText().trim();
		        String password = txtPassword.getText();

		        if(email.isEmpty() || password.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Termine de llenar los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
		        }
		        else if (!email.matches("^[^@\\s]+@[^@\\s]+\\.com$")) {
		            JOptionPane.showMessageDialog(null, 
		                "El formato del correo es inválido.\nAsegúrese de que contenga un '@' y termine en '.com'.", 
		                "Error de Formato", 
		                JOptionPane.ERROR_MESSAGE);
		        }
		        else {
		            String nuevoId = Bolsa.getBolsa().generarIdUsuarios();
		            Usuario user = new Usuario(nuevoId, email, password, cbxTipo.getSelectedItem().toString());
		            
		            JOptionPane.showMessageDialog(null, "Registro exitoso, su nombre de usuario es: " + user.getUsername());
		            
		            Bolsa.getBolsa().registrarUsuario(user);
		            Bolsa.guardarSistema(); 
		            
		            dispose();
		            Login login = new Login();
		            login.setVisible(true);
		        }
		    }
		});
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_2.add(btnCancel);
	}
}
