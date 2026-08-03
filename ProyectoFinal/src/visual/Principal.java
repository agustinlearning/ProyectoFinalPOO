package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Bolsa;
import logico.Sesion;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenu mnEmpleados;
	private JMenu mnOfertas;
	private JMenu mnPerfil;
	private JMenuItem mntmCrearSolicitud;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmListarOfertas;
	private JMenuItem mntmRegistrarOferta;
	private JPanel panel;
	private JMenuBar menuBar;
	private static Sesion mySesion = null;
	private JMenu mnAdministracion;
	private JMenuItem mntmListarUsuarios;
	private JMenuItem mListarEmpresa;
	private JMenuItem mntmCrearRespaldo;
	private JMenuItem mntmDashboad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(mySesion);
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
	public Principal(Sesion sesion) {
	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            Bolsa.guardarSistema();
	        }
	    });
	    mySesion = sesion;
	    
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 834, 529);
	    setVisible(false);
	    
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    mnEmpleados = new JMenu("Mi Candidatura");
	    if(sesion.getUser().getRol().equalsIgnoreCase("Persona") || sesion.getUser().getRol().equalsIgnoreCase("Admin")) {
	        mnEmpleados.setEnabled(true);
	    }
	    menuBar.add(mnEmpleados);
	    
	    mntmCrearSolicitud = new JMenuItem("Ver mi Estado");
	    mntmCrearSolicitud.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            logico.Persona miPersona = mySesion.getUser().getPerfilP();

	            if(miPersona != null) {
	                MiEstado ventanaEstado = new MiEstado(miPersona);
	                ventanaEstado.setVisible(true);
	            } else {
	                javax.swing.JOptionPane.showMessageDialog(null, 
	                    "Debe tener un perfil de tipo Persona creado para ver su estado.", 
	                    "Perfil Incompleto", 
	                    javax.swing.JOptionPane.WARNING_MESSAGE);
	            }
	        }
	    });
	    mnEmpleados.add(mntmCrearSolicitud);

	    
	    // MENÚ DE OFERTAS
	    mnOfertas = new JMenu("Ofertas");
	    if(sesion.getUser().getRol().equalsIgnoreCase("Empresa") || sesion.getUser().getRol().equalsIgnoreCase("Admin")) {
	        mnOfertas.setEnabled(true);
	    }
	    menuBar.add(mnOfertas);
	    
	    mntmRegistrarOferta = new JMenuItem("Registrar Oferta");
	    mntmRegistrarOferta.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String rol = mySesion.getUser().getRol();
	            
	            if(rol.equalsIgnoreCase("Empresa") || rol.equalsIgnoreCase("Admin")) {
	                logico.Empresa miEmpresa = mySesion.getUser().getPerfilE();
	                RegOferta ventanaRegistro = new RegOferta(miEmpresa);
	                ventanaRegistro.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, 
	                    "Solo los usuarios de tipo Empresa o Admin pueden registrar ofertas.", 
	                    "Acceso Denegado", 
	                    JOptionPane.WARNING_MESSAGE);
	            }
	        }
	    });
	    mnOfertas.add(mntmRegistrarOferta);
	    
	    mntmListarOfertas = new JMenuItem("Listar Ofertas");
	    mntmListarOfertas.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            String rol = mySesion.getUser().getRol();
	            
	            if(rol.equalsIgnoreCase("Empresa") || rol.equalsIgnoreCase("Admin")) {
	                logico.Empresa miEmpresa = mySesion.getUser().getPerfilE();
	                ListarOfertas listarMisOfertas = new ListarOfertas(miEmpresa);
	                listarMisOfertas.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, 
	                    "Solo los usuarios de tipo Empresa o Admin pueden listar ofertas.", 
	                    "Acceso Denegado", 
	                    JOptionPane.WARNING_MESSAGE);
	            }
	        }
	    });
	    mnOfertas.add(mntmListarOfertas);
	    
	    // MENÚ PERFIL
	    mnPerfil = new JMenu("Perfil");
	    menuBar.add(mnPerfil);
	    
	    JMenuItem mntmMostrarPerfil = new JMenuItem("Ver perfil");
	    mntmMostrarPerfil.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String rol = sesion.getUser().getRol();

	            if(rol.equalsIgnoreCase("Empresa")) {
	                if(sesion.getUser().getPerfilE() == null) {
	                    JOptionPane.showMessageDialog(null, "No tiene un perfil de Empresa, vamos a crear uno");
	                    RegEmpresa regEmpresa = new RegEmpresa(sesion.getUser());
	                    regEmpresa.setVisible(true);
	                } else {
	                    logico.Empresa emp = sesion.getUser().getPerfilE();
	                    JOptionPane.showMessageDialog(null, "Perfil de Empresa:\n" +
	                            "RNC: " + emp.getRnc() + "\n" +
	                            "Razón Social: " + emp.getRazonSocial() + "\n" +
	                            "Ubicación: " + emp.getUbicacion(), "Mi Perfil", JOptionPane.INFORMATION_MESSAGE);
	                }
	            } 
	            else if(rol.equalsIgnoreCase("Persona")) {
	                if(sesion.getUser().getPerfilP() == null) {
	                    JOptionPane.showMessageDialog(null, "No tiene un perfil de Persona, vamos a crear uno");
	                    RegPersona regPersona = new RegPersona(sesion.getUser());
	                    regPersona.setVisible(true);
	                } else {
	                    logico.Persona per = sesion.getUser().getPerfilP();
	                    JOptionPane.showMessageDialog(null, "Perfil de Persona:\n" +
	                            "Nombre: " + per.getNombre() + "\n" +
	                            "Cédula: " + per.getCedula() + "\n" +
	                            "Provincia: " + per.getProvincia(), "Mi Perfil", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
	        }
	    });
	    mnPerfil.add(mntmMostrarPerfil);
	    
	    // MENÚ ADMINISTRACIÓN
	    mnAdministracion = new JMenu("Admin");
	    menuBar.add(mnAdministracion);
	    if(sesion.getUser().getRol().equalsIgnoreCase("Admin")) {
	        mnAdministracion.setVisible(true);
	    } else {
	        mnAdministracion.setVisible(false);
	    }
	    
	    mntmListarUsuarios = new JMenuItem("Listar usuarios");
	    mntmListarUsuarios.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            ListarUsuarios listar = new ListarUsuarios();
	            listar.setVisible(true);
	        }
	    });
	    mnAdministracion.add(mntmListarUsuarios);
	    
	    mListarEmpresa = new JMenuItem("Listar Empresas");
	    mListarEmpresa.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            ListarEmpresas listarEmpresa = new ListarEmpresas();
	            listarEmpresa.setVisible(true);
	        }
	    });
	    mnAdministracion.add(mListarEmpresa);
	    
	    mntmCrearRespaldo = new JMenuItem("Guardar Localmente");
	    mntmCrearRespaldo.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Bolsa.guardarSistema();
	            JOptionPane.showMessageDialog(null, "Datos guardados en disco local.");
	        }
	    });
	    mnAdministracion.add(mntmCrearRespaldo);

	    JMenuItem mntmEnviarServidor = new JMenuItem("Enviar al Servidor (Profesor)");
	    mntmEnviarServidor.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String ip = JOptionPane.showInputDialog(null, "Ingrese la IP del servidor:", "localhost");
	            String puertoString = JOptionPane.showInputDialog(null, "Ingrese el puerto:", "7000");

	            if (ip != null && puertoString != null && !ip.trim().isEmpty() && !puertoString.trim().isEmpty()) {
	                try {
	                    int puerto = Integer.parseInt(puertoString.trim());
	                    
	                    servidor.Cliente.enviarRespaldoAlServidor(ip, puerto); 
	                    
	                    JOptionPane.showMessageDialog(null, "Intento de envío finalizado. Verifique consola para ver detalles de la conexión.");
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Error: El puerto debe ser un número entero.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
	                }
	            } else if (ip != null || puertoString != null) {
	                JOptionPane.showMessageDialog(null, "Operación cancelada. Debe ingresar IP y puerto.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
	            }
	        }
	    });
	    mnAdministracion.add(mntmEnviarServidor);
	    
	    mntmDashboad = new JMenuItem("Dashboard");
	    mntmDashboad.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Dashboard dash = new Dashboard();
	            dash.setVisible(true);
	        }
	    });
	    mnAdministracion.add(mntmDashboad);
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(new BorderLayout(0, 0));
	    setContentPane(contentPane);
	    
	    panel = new JPanel();
	    contentPane.add(panel, BorderLayout.CENTER);
	}

}
