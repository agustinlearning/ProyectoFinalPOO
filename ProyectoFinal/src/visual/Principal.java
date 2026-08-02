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
	    
	    mnEmpleados = new JMenu("Solicitudes");
	    if(sesion.getUser().getRol().equalsIgnoreCase("Persona") || sesion.getUser().getRol().equalsIgnoreCase("Admin")) {
	        mnEmpleados.setEnabled(true);
	    }
	    menuBar.add(mnEmpleados);
	    
	    mntmCrearSolicitud = new JMenuItem("Registrar Solicitud");
	    mntmCrearSolicitud.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(null, "Abrir ventana de Registrar Solicitud (En desarrollo)");
	        }
	    });
	    mnEmpleados.add(mntmCrearSolicitud);
	    
	    mntmNewMenuItem = new JMenuItem("Listar Solicitud");
	    mntmNewMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(null, "Abrir ventana de Listar Solicitudes (En desarrollo)");
	        }
	    });
	    mnEmpleados.add(mntmNewMenuItem);
	    
	    // MENÚ DE OFERTAS
	    mnOfertas = new JMenu("Ofertas");
	    if(sesion.getUser().getRol().equalsIgnoreCase("Empresa") || sesion.getUser().getRol().equalsIgnoreCase("Admin")) {
	        mnOfertas.setEnabled(true);
	    }
	    menuBar.add(mnOfertas);
	    
	    mntmRegistrarOferta = new JMenuItem("Registrar Oferta");
	    mntmRegistrarOferta.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(null, "Abrir ventana de Registrar Oferta (En desarrollo)");
	        }
	    });
	    mnOfertas.add(mntmRegistrarOferta);
	    
	    mntmListarOfertas = new JMenuItem("Listar Ofertas");
	    mntmListarOfertas.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            logico.Empresa miEmpresa = mySesion.getUser().getPerfilE();
	            if(miEmpresa != null) {
	                ListarOfertas listarMisOfertas = new ListarOfertas(miEmpresa);
	                listarMisOfertas.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, 
	                    "Debe tener un perfil de tipo Empresa activo para gestionar ofertas.", 
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
	            if(sesion.getUser().getPerfilE() == null && sesion.getUser().getPerfilP() == null) {
	                JOptionPane.showMessageDialog(null, "No tiene un perfil, vamos a crear uno");
	                if(sesion.getUser().getRol().equalsIgnoreCase("Persona")) {
	                    RegPersona regPersona = new RegPersona(sesion.getUser());
	                    regPersona.setVisible(true);
	                } else if(sesion.getUser().getRol().equalsIgnoreCase("Empresa")) {
	                    RegEmpresa regEmpresa = new RegEmpresa();
	                    regEmpresa.setVisible(true);
	                }
	            } 
	            else if(sesion.getUser().getPerfilE() != null) {
	                // Si es empresa y ya tiene perfil, muestra sus datos
	                logico.Empresa emp = sesion.getUser().getPerfilE();
	                JOptionPane.showMessageDialog(null, "Perfil de Empresa:\n" +
	                        "RNC: " + emp.getRnc() + "\n" +
	                        "Razón Social: " + emp.getRazonSocial() + "\n" +
	                        "Ubicación: " + emp.getUbicacion(), "Mi Perfil", JOptionPane.INFORMATION_MESSAGE);
	            } 
	            else if(sesion.getUser().getPerfilP() != null) {
	                // Si es persona y ya tiene perfil, muestra sus datos
	                logico.Persona per = sesion.getUser().getPerfilP();
	                JOptionPane.showMessageDialog(null, "Perfil de Persona:\n" +
	                        "Nombre: " + per.getNombre() + "\n" +
	                        "Cédula: " + per.getCedula() + "\n" +
	                        "Provincia: " + per.getProvincia(), "Mi Perfil", JOptionPane.INFORMATION_MESSAGE);
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

	            if (ip != null && puertoString != null) {
	                try {
	                    int puerto = Integer.parseInt(puertoString.trim());
	                    servidor.Cliente.enviarRespaldoAlServidor(ip, puerto); 
	                    JOptionPane.showMessageDialog(null, "Intento de envío finalizado. Verifique consola.");
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "El puerto debe ser un número.");
	                }
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
