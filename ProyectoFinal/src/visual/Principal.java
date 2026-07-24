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
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.Component;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenu mnEmpleados;
	private JMenu mnOfertas;
	private JMenu mnPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 529);
		setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnEmpleados = new JMenu("Solicitudes");
		mnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmCrearSolicitud = new JMenuItem("Registrar");
		mntmCrearSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
		mnEmpleados.add(mntmCrearSolicitud);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar");
		mnEmpleados.add(mntmNewMenuItem);
		
		mnOfertas = new JMenu("Ofertas");
		menuBar.add(mnOfertas);
		
		JMenuItem mntmRegistrarOferta = new JMenuItem("Registrar");
		mntmRegistrarOferta.setHorizontalAlignment(SwingConstants.LEFT);
		mnOfertas.add(mntmRegistrarOferta);
		
		JMenuItem mntmListarOfertas = new JMenuItem("Listar");
		mnOfertas.add(mntmListarOfertas);
		
		mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmMostrarPerfil = new JMenuItem("Ver perfil");
		mnPerfil.add(mntmMostrarPerfil);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
