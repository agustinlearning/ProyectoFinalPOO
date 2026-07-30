package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Obrero;
import logico.Tecnico;
import logico.Universitario;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JPanel panel_2 = new JPanel();
	
	private Usuario myUser = null;
	private JRadioButton rbtnObrero;
	private JRadioButton rbtnTecnico;
	private JRadioButton rbtnUniversitario;
	private JSpinner spnAspiracionSalarial;
	private JTextField txtCedula;
	private JTextField txtSexo;
	private JTextField txtProvincia;
	private JCheckBox chxLicencia;
	private JPanel panel;
	private JLayeredPane panelVariable;
	private JTextArea txtHabilidades;
	private JLabel lblHabilidades;
	private JLabel lblAreaTecnica;
	private JTextField txtAreaTecnica;
	private JSpinner spnAnosExperiencia;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblAosDeExperiencia;
	private JCheckBox chxDispMudanza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersona dialog = new RegPersona(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersona(Usuario user) {
		setResizable(false);
		setModal(true);
		myUser = user;
		setTitle("Crear Perfil");
		setBounds(100, 100, 686, 381);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre: ");
				lblNewLabel_1.setBounds(328, 30, 78, 20);
				panel.add(lblNewLabel_1);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(421, 30, 235, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			
			spnAspiracionSalarial = new JSpinner();
			spnAspiracionSalarial.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnAspiracionSalarial.setBounds(175, 102, 105, 20);
			panel.add(spnAspiracionSalarial);
			
			JLabel lblAoDeFabricacin = new JLabel("Aspiracion salarial:");
			lblAoDeFabricacin.setBounds(10, 102, 165, 20);
			panel.add(lblAoDeFabricacin);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 139, 729, 41);
			panel.add(panel_1);
			
			rbtnObrero = new JRadioButton("Obrero");
			rbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblHabilidades.setVisible(true);
					txtHabilidades.setVisible(true);
					lblAreaTecnica.setVisible(false);
					txtAreaTecnica.setVisible(false);
					lblAosDeExperiencia.setVisible(false);
					spnAnosExperiencia.setVisible(false);
					lblTitulo.setVisible(false);
					txtTitulo.setVisible(false);
				}
			});
			rbtnObrero.setSelected(true);
			buttonGroup.add(rbtnObrero);
			panel_1.add(rbtnObrero);
			
			rbtnTecnico = new JRadioButton("Tecnico");
			rbtnTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblHabilidades.setVisible(false);
					txtHabilidades.setVisible(false);
					lblAreaTecnica.setVisible(true);
					txtAreaTecnica.setVisible(true);
					lblAosDeExperiencia.setVisible(true);
					spnAnosExperiencia.setVisible(true);
					lblTitulo.setVisible(false);
					txtTitulo.setVisible(false);
				}
			});
			buttonGroup.add(rbtnTecnico);
			panel_1.add(rbtnTecnico);
			
			rbtnUniversitario = new JRadioButton("Universitario");
			rbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblHabilidades.setVisible(false);
					txtHabilidades.setVisible(false);
					lblAreaTecnica.setVisible(false);
					txtAreaTecnica.setVisible(false);
					lblAosDeExperiencia.setVisible(false);
					spnAnosExperiencia.setVisible(false);
					lblTitulo.setVisible(true);
					txtTitulo.setVisible(true);
				}
			});
			buttonGroup.add(rbtnUniversitario);
			panel_1.add(rbtnUniversitario);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(10, 30, 78, 20);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(103, 30, 177, 20);
			panel.add(txtCedula);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10, 66, 78, 20);
			panel.add(lblSexo);
			
			txtSexo = new JTextField();
			txtSexo.setColumns(10);
			txtSexo.setBounds(103, 66, 177, 20);
			panel.add(txtSexo);
			
			JLabel lblProvincia = new JLabel("Provincia");
			lblProvincia.setBounds(328, 66, 78, 20);
			panel.add(lblProvincia);
			
			txtProvincia = new JTextField();
			txtProvincia.setColumns(10);
			txtProvincia.setBounds(421, 66, 235, 20);
			panel.add(txtProvincia);
			
			chxDispMudanza = new JCheckBox("Disp. mudanza");
			chxDispMudanza.setBounds(326, 98, 139, 29);
			panel.add(chxDispMudanza);
			
			chxLicencia = new JCheckBox("Licencia de conducir");
			chxLicencia.setBounds(477, 98, 179, 29);
			panel.add(chxLicencia);
			
			panelVariable = new JLayeredPane();
			panelVariable.setBounds(0, 181, 729, 121);
			panel.add(panelVariable);
			
			lblHabilidades = new JLabel("Habilidades");
			lblHabilidades.setBounds(35, 25, 105, 20);
			lblHabilidades.setVisible(true);
			panelVariable.add(lblHabilidades);
			
			txtHabilidades = new JTextArea();
			txtHabilidades.setBounds(140, 25, 341, 59);
			txtHabilidades.setVisible(true);
			panelVariable.add(txtHabilidades);
			
			lblAreaTecnica = new JLabel("Area tecnica");
			panelVariable.setLayer(lblAreaTecnica, 1);
			lblAreaTecnica.setBounds(35, 25, 105, 20);
			lblAreaTecnica.setVisible(false);
			panelVariable.add(lblAreaTecnica);
			
			txtAreaTecnica = new JTextField();
			panelVariable.setLayer(txtAreaTecnica, 1);
			txtAreaTecnica.setBounds(140, 22, 179, 26);
			panelVariable.add(txtAreaTecnica);
			txtAreaTecnica.setVisible(false);
			txtAreaTecnica.setColumns(10);
			
			lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia");
			panelVariable.setLayer(lblAosDeExperiencia, 1);
			lblAosDeExperiencia.setBounds(358, 25, 159, 20);
			panelVariable.add(lblAosDeExperiencia);
			lblAosDeExperiencia.setVisible(false);
			
			spnAnosExperiencia = new JSpinner();
			spnAnosExperiencia.setBounds(532, 22, 105, 26);
			panelVariable.add(spnAnosExperiencia);
			spnAnosExperiencia.setVisible(false);
			
			lblTitulo = new JLabel("Titulo: ");
			panelVariable.setLayer(lblTitulo, 2);
			lblTitulo.setBounds(35, 25, 69, 20);
			panelVariable.add(lblTitulo);
			lblTitulo.setVisible(false);
			
			txtTitulo = new JTextField();
			panelVariable.setLayer(txtTitulo, 2);
			txtTitulo.setBounds(140, 22, 179, 26);
			panelVariable.add(txtTitulo);
			txtTitulo.setColumns(10);
			txtTitulo.setVisible(false);
			
			
			
			
		}
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPanel.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Bolsa.getBolsa();
					if(rbtnObrero.isSelected())
					{
						ArrayList<String> lista = new ArrayList<>();
						String[] habilidades = txtHabilidades.getText().split("\n");
						for (String string : habilidades) {
							lista.add(string);
						}
						Obrero obrero = new Obrero(Bolsa.getBolsa().generarIdPersonas(),txtCedula.getText(),txtNombre.getText(),myUser,new Float(spnAspiracionSalarial.getValue().toString()),chxLicencia.isSelected(),chxDispMudanza.isSelected(),txtProvincia.getText(),txtSexo.getText(),
								lista);
						Bolsa.getBolsa().registraPersona(obrero);
						myUser.setPerfilP(obrero);
						JOptionPane.showMessageDialog(null, "Perfil creado correctamente");
						dispose();
					}
					if(rbtnTecnico.isSelected())
					{
						Tecnico tecnico = new Tecnico(Bolsa.getBolsa().generarIdPersonas(),txtCedula.getText(),txtNombre.getText(),myUser,new Float(spnAspiracionSalarial.getValue().toString()),chxLicencia.isSelected(),chxDispMudanza.isSelected(),txtProvincia.getText(),txtSexo.getText(),txtAreaTecnica.getText(),new Integer(spnAnosExperiencia.getValue().toString()));
						Bolsa.getBolsa().registraPersona(tecnico);
						myUser.setPerfilP(tecnico);
						JOptionPane.showMessageDialog(null, "Perfil creado correctamente");
						dispose();
					}
					if(rbtnUniversitario.isSelected())
					{
						Universitario universitario = new Universitario(Bolsa.getBolsa().generarIdPersonas(),txtCedula.getText(),txtNombre.getText(),myUser,new Float(spnAspiracionSalarial.getValue().toString()),chxLicencia.isSelected(),chxDispMudanza.isSelected(),txtProvincia.getText(),txtSexo.getText(),txtTitulo.getText());
						Bolsa.getBolsa().registraPersona(universitario);
						myUser.setPerfilP(universitario);
						JOptionPane.showMessageDialog(null, "Perfil creado correctamente");
						dispose();
					}
				}
		});
		btnRegistrar.setActionCommand("OK");
		panel_2.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setActionCommand("Cancel");
		panel_2.add(btnCancelar);
		
	}
}
