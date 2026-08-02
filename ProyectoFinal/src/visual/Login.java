package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Sesion;
import logico.Usuario;
import hilos.HiloOfertas;
import hilos.HiloSolicitudes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel panel_1;
	private JButton btnLogin;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
					Bolsa.cargarSistema();
					
					boolean existeAdmin = false;

	                for (Usuario u : Bolsa.getBolsa().losUsuarios) {
	                    if (u.getRol().equalsIgnoreCase("Admin")) {
	                        existeAdmin = true;
	                        break;
	                    }
	                }
	                
	                if (!existeAdmin) {
	                    String idAdmin = Bolsa.getBolsa().generarIdUsuarios();
	                    Usuario adminDefecto = new Usuario(idAdmin, "admin", "admin", "Admin");
	                    Bolsa.getBolsa().registrarUsuario(adminDefecto);
	                    Bolsa.guardarSistema(); 
	                    System.out.println("Sistema inicializado: Creado usuario admin por defecto.");
	                }
					
					Thread hiloDeOfertas = new Thread(new HiloOfertas());
					hiloDeOfertas.setDaemon(true);
					hiloDeOfertas.start();
					
					Thread hiloDeSolicitudes = new Thread(new HiloSolicitudes());
					hiloDeSolicitudes.setDaemon(true);
					hiloDeSolicitudes.start();
					
					Login frame = new Login();
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
	public Login() {
		
		setTitle("Login");
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
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 69, 217, 38);
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblContrasea.setBounds(29, 154, 169, 38);
		panel.add(lblContrasea);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("");
		txtUsername.setBounds(261, 78, 259, 26);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(263, 163, 257, 26);
		panel.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFNo tienes una cuenta?");
		lblNewLabel_1.setBounds(29, 249, 223, 20);
		panel.add(lblNewLabel_1);
		
		Button btnSingup = new Button("Registrate");
		btnSingup.setActionCommand("Registrarse");
		btnSingup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Singup registro = new Singup();
				registro.setVisible(true);
				
			}
		});
		btnSingup.setBounds(261, 249, 100, 27);
		panel.add(btnSingup);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnLogin = new JButton("Iniciar sesion");
		panel_1.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = Bolsa.getBolsa().buscarUsuarioPorUsername(txtUsername.getText());
				if(user != null)
				{
					if(user.getContrasena().equalsIgnoreCase(txtPassword.getText()))
					{
						JOptionPane.showMessageDialog(null, "Inicio de sesion correcto");
						Sesion actual = new Sesion(user);
						Principal main = new Principal(actual);
						dispose();
						main.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					}
				}
				else {
					int opt = JOptionPane.showConfirmDialog(null, "Usuario no encontrado, ¿desea crear una cuenta?");
					if(opt == JOptionPane.OK_OPTION)
					{
						dispose();
						Singup registro = new Singup();
						registro.setVisible(true);
					}
				}
				
				
			}
		});
		
		btnCancel = new JButton("Cancelar");
		panel_1.add(btnCancel);
	}
}
