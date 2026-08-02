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
	                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                    if ("Nimbus".equals(info.getName())) {
	                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                        break;
	                    }
	                }

	                Bolsa.cargarSistema();
	                
	                boolean existeAdmin = false;
	                for (Usuario u : Bolsa.getBolsa().losUsuarios) {
	                    if (u.getRol().equalsIgnoreCase("Admin")) {
	                        existeAdmin = true;
	                        break;
	                    }
	                }
	                if (!existeAdmin) {
	                    Usuario adminDefecto = new Usuario(Bolsa.getBolsa().generarIdUsuarios(), "admin", "admin", "Admin");
	                    Bolsa.getBolsa().registrarUsuario(adminDefecto);
	                }

	                if (Bolsa.getBolsa().lasEmpresas.isEmpty()) {
	                    
	                    // empresas de prueba
	                    Bolsa.getBolsa().registrarEmpresa("130123456", null, "InnovaTech Solutions", "Santiago");
	                    Bolsa.getBolsa().registrarEmpresa("130987654", null, "Agroindustrias del Cibao", "La Vega");
	                    
	                    logico.Empresa emp1 = Bolsa.getBolsa().lasEmpresas.get(0);
	                    logico.Empresa emp2 = Bolsa.getBolsa().lasEmpresas.get(1);

	                    // usuarios por defecto vinculado
	                    Usuario uEmp1 = new Usuario(Bolsa.getBolsa().generarIdUsuarios(), "innova@tech.com", "1234", "Empresa");
	                    uEmp1.setPerfilE(emp1);
	                    Usuario uEmp2 = new Usuario(Bolsa.getBolsa().generarIdUsuarios(), "agro@cibao.com", "1234", "Empresa");
	                    uEmp2.setPerfilE(emp2);
	                    Bolsa.getBolsa().registrarUsuario(uEmp1);
	                    Bolsa.getBolsa().registrarUsuario(uEmp2);

	                    // ofertas por defecto para pruebas
	                    java.util.ArrayList<String> reqInnova = new java.util.ArrayList<>();
	                    reqInnova.add("Java"); reqInnova.add("Bases de Datos");
	                    Bolsa.getBolsa().crearOferta(emp1, "Desarrollador Backend", "Programación en Java", 40000, 60000, "Santiago", false, false, "Universitario", 50.0f, 2, 0, "", reqInnova);
	                    
	                    java.util.ArrayList<String> reqAgro = new java.util.ArrayList<>();
	                    reqAgro.add("Redes");
	                    Bolsa.getBolsa().crearOferta(emp2, "Técnico de Redes", "Mantenimiento de infraestructura", 20000, 30000, "La Vega", true, false, "Tecnico", 40.0f, 1, 2, "Telecomunicaciones", reqAgro);

	                    // personas por defecto
	                    Usuario uPer1 = new Usuario(Bolsa.getBolsa().generarIdUsuarios(), "juan@mail.com", "1234", "Persona");
	                    logico.Universitario per1 = new logico.Universitario(Bolsa.getBolsa().generarIdPersonas(), "031-123", "Juan Pérez", uPer1, 45000f, false, false, "Santiago", "M", "Ing. Ciencias de la Computación");
	                    uPer1.setPerfilP(per1);
	                    
	                    Usuario uPer2 = new Usuario(Bolsa.getBolsa().generarIdUsuarios(), "maria@mail.com", "1234", "Persona");
	                    logico.Tecnico per2 = new logico.Tecnico(Bolsa.getBolsa().generarIdPersonas(), "047-456", "María González", uPer2, 25000f, true, true, "Santiago", "F", "Telecomunicaciones", 3);
	                    uPer2.setPerfilP(per2);
	                    
	                    Bolsa.getBolsa().registraPersona(per1);
	                    Bolsa.getBolsa().registraPersona(per2);
	                    Bolsa.getBolsa().registrarUsuario(uPer1);
	                    Bolsa.getBolsa().registrarUsuario(uPer2);

	                    // contratacion por defecto
	                    per2.setContratado(true);
	                    emp2.contratarCandidato(per2);

	                    Bolsa.guardarSistema();
	                    System.out.println("Datos de prueba generados exitosamente.");
	                }

	                Thread hiloDeOfertas = new Thread(new hilos.HiloOfertas());
	                hiloDeOfertas.setDaemon(true);
	                hiloDeOfertas.start();
	                
	                Thread hiloDeSolicitudes = new Thread(new hilos.HiloSolicitudes());
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
