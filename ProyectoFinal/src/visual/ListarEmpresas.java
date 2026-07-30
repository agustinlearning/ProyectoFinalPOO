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
import logico.Empresa;
import logico.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarEmpresas extends JDialog {

	private JPanel contentPane = new JPanel();
	private DefaultTableModel model;
	private JTable table;
	private Object[] row;
	private Empresa selected = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarEmpresas dialog = new ListarEmpresas();
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
	public ListarEmpresas() {
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
		
		String[] headers = {"Id","Rnc","Ubicacion"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index >= 0)
				{
					
				}
			}
		});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setActionCommand("Cancel");
		panel.add(button_1);
		
		
		loadAlquileres();
	}

	private void loadAlquileres() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(Empresa empresa : Bolsa.getBolsa().lasEmpresas)
		{
			row[0] = empresa.getId();
			row[1] = empresa.getRnc();
			row[2] = empresa.getUbicacion();
			model.addRow(row);
		}
		
	}

}
