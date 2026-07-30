package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Bolsa;
import logico.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRnc;
	private JTextField txtUbicacion;
	private JTextField txtRazonSocial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpresa dialog = new RegEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEmpresa() {
		setResizable(false);
		setModal(true);
		setTitle("Crear Perfil");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
		});
		setBounds(100, 100, 640, 262);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rnc");
		lblNewLabel.setBounds(50, 45, 69, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Razon social");
		lblNewLabel_1.setBounds(309, 45, 101, 20);
		contentPanel.add(lblNewLabel_1);
		{
			JLabel lblUbicacion = new JLabel("Ubicaci\u00F3n");
			lblUbicacion.setBounds(50, 115, 75, 20);
			contentPanel.add(lblUbicacion);
		}
		
		txtRnc = new JTextField();
		txtRnc.setBounds(138, 42, 146, 26);
		contentPanel.add(txtRnc);
		txtRnc.setColumns(10);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(138, 112, 146, 26);
		contentPanel.add(txtUbicacion);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(425, 42, 146, 26);
		contentPanel.add(txtRazonSocial);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtRnc.getText().isEmpty() || txtUbicacion.getText().isEmpty() || txtRazonSocial.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Termine de llenar los campos");
						}
						else 
						{
							Bolsa.getBolsa().registrarEmpresa(txtRnc.getText(),null,txtRazonSocial.getText(),txtUbicacion.getText());
							JOptionPane.showMessageDialog(null, "Perfil creado correctamente");
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
