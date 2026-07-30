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
				JOptionPane.showMessageDialog(null, "No tiene un perfil, vamos a crear uno");
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
		mnEmpleados.setEnabled(false);
		mnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnEmpleados);
		
		mntmCrearSolicitud = new JMenuItem("Registrar");
		mntmCrearSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
		mnEmpleados.add(mntmCrearSolicitud);
		
		
		mntmNewMenuItem = new JMenuItem("Listar");
		mnEmpleados.add(mntmNewMenuItem);
		
		mnOfertas = new JMenu("Ofertas");
		mnOfertas.setEnabled(false);
		menuBar.add(mnOfertas);
		
		mntmRegistrarOferta = new JMenuItem("Registrar");
		mntmRegistrarOferta.setHorizontalAlignment(SwingConstants.LEFT);
		mnOfertas.add(mntmRegistrarOferta);
		
		mntmListarOfertas = new JMenuItem("Listar");
		mnOfertas.add(mntmListarOfertas);
		
		mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmMostrarPerfil = new JMenuItem("Ver perfil");
		mntmMostrarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sesion.getUser().getPerfilE()== null && sesion.getUser().getPerfilP()== null)
				{
					JOptionPane.showMessageDialog(null, "No tiene un perfil, vamos a crear uno");
					if(sesion.getUser().getRol().equalsIgnoreCase("Persona"))
					{
						RegPersona regPersona = new RegPersona(sesion.getUser());
						regPersona.setVisible(true);
						regPersona.setModal(true);
					}
					if(sesion.getUser().getRol().equalsIgnoreCase("Empresa"))
					{
						RegEmpresa regEmpresa = new RegEmpresa();
						regEmpresa.setVisible(true);
						regEmpresa.setModal(true);
					}
				}
				if(sesion.getUser().getPerfilE() == null && sesion.getUser().getPerfilP()!= null)
				{
					
				}
				if(sesion.getUser().getPerfilE() != null && sesion.getUser().getPerfilP()== null)
				{
					
				}
			}
		});
		mnPerfil.add(mntmMostrarPerfil);
		
		mnAdministracion = new JMenu("Admin");
		menuBar.add(mnAdministracion);
		if(sesion.getUser().getRol().equalsIgnoreCase("admin"))
		{
			mnAdministracion.setVisible(true);
		}
		else
		{
			mnAdministracion.setVisible(false);
		}
		
		
		mntmListarUsuarios = new JMenuItem("Listar usuarios");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios listar = new ListarUsuarios();
				listar.setVisible(true);
				listar.setModal(true);
			}
		});
		mnAdministracion.add(mntmListarUsuarios);
		
		mListarEmpresa = new JMenuItem("Listar Empresas");
		mListarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpresas listarEmpresa = new ListarEmpresas();
				listarEmpresa.setVisible(true);
				listarEmpresa.setModal(true);
			}
		});
		mnAdministracion.add(mListarEmpresa);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
