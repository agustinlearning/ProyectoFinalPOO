package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Sesion;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.Component;

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
		mySesion = sesion;
		
		setLocationRelativeTo(null);
		setResizable(false);
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
		mnPerfil.add(mntmMostrarPerfil);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
