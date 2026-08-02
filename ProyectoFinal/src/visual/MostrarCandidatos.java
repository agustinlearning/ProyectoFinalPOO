package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import logico.Bolsa;
import logico.CandidatoEvaluado;
import logico.Empresa;
import logico.Obrero;
import logico.Persona;
import logico.Tecnico;
import logico.Universitario;
import logico.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarCandidatos extends JDialog {

	private JPanel contentPane = new JPanel();
	private DefaultTableModel model;
	private JTable table;
	private Object[] row;
	private Persona selected = null;
	private static ArrayList<CandidatoEvaluado> losCandidatos = new ArrayList<>();
	private JButton btnCancel;
	private JButton btnElegir;
	private Empresa empresaLogueada;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarCandidatos dialog = new MostrarCandidatos(losCandidatos, null); 
				    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				    dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MostrarCandidatos(ArrayList<CandidatoEvaluado> candidatos, Empresa empresaActual) {
		losCandidatos = candidatos;
	    this.empresaLogueada = empresaActual;
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 640, 340);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] headers = {"% Coincidencia","Nombre","Preparacion","Ubicacion"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index >= 0)
				{
					selected = Bolsa.getBolsa().buscarPersonaPorNombre(table.getValueAt(index, 1).toString());
					btnElegir.setEnabled(true);
				}
			}
		});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnElegir = new JButton("Elegir");
		btnElegir.setEnabled(false);
		btnElegir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (selected != null) {
		            if (empresaLogueada != null) {
		                empresaLogueada.contratarCandidato(selected);
		                Bolsa.guardarSistema();
		                
		                JOptionPane.showMessageDialog(null, 
		                    "¡Has seleccionado a " + selected.getNombre() + " exitosamente!\n" +
		                    "El candidato será notificado.", 
		                    "Contratación Exitosa", 
		                    JOptionPane.INFORMATION_MESSAGE);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Error: Sesión de empresa no válida.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un candidato de la tabla", "Error", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		btnElegir.setActionCommand("OK");
		panel.add(btnElegir);
		btnCancel.setActionCommand("Cancel");
		panel.add(btnCancel);
		
		
		loadAlquileres();
	}

	private void loadAlquileres() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(CandidatoEvaluado candidato : losCandidatos)
		{
			row[0] = Math.round(((float)candidato.getPuntajeTotal()/100.00f)) + "%";
			row[1] = candidato.getCandidato().getNombre();
			if(candidato.getCandidato() instanceof Obrero)
			{
				row[2] = "Obrero";
			}
			if(candidato.getCandidato() instanceof Tecnico)
			{
				row[2] = "Tecnico";
			}
			if(candidato.getCandidato() instanceof Universitario)
			{
				row[2] = "Universitario";
			}
			row[3] = candidato.getCandidato().getProvincia();
			model.addRow(row);
		}
		
	}

}
