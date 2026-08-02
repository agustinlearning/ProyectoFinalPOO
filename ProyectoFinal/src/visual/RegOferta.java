package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Empresa;

public class RegOferta extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtTitulo;
    private JTextArea txtDescripcion;
    private JSpinner spnSalarioMin;
    private JSpinner spnSalarioMax;
    private JTextField txtProvincia;
    private JCheckBox chckbxLicencia;
    private JCheckBox chckbxMudanza;
    private JComboBox<String> cbxTipoCandidato;
    private JSpinner spnCoincidencia;
    private JSpinner spnCantPuestos;
    private JSpinner spnExperiencia;
    private JTextField txtAreaTecnica;
    private JTextArea txtHabilidades;
    private Empresa empresaLogueada;

    public RegOferta(Empresa empresa) {
        this.empresaLogueada = empresa;
        
        setTitle("Registrar Nueva Oferta de Empleo");
        setModal(true);
        setBounds(100, 100, 750, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JPanel panelGeneral = new JPanel();
        panelGeneral.setBorder(new TitledBorder(null, "Datos del Puesto", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 12), null));
        panelGeneral.setBounds(10, 11, 714, 160);
        contentPanel.add(panelGeneral);
        panelGeneral.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Título del Puesto:");
        lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTitulo.setBounds(10, 25, 110, 20);
        panelGeneral.add(lblTitulo);
        
        txtTitulo = new JTextField();
        txtTitulo.setBounds(130, 25, 220, 25);
        panelGeneral.add(txtTitulo);
        txtTitulo.setColumns(10);
        
        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblProvincia.setBounds(380, 25, 80, 20);
        panelGeneral.add(lblProvincia);
        
        txtProvincia = new JTextField();
        txtProvincia.setBounds(470, 25, 230, 25);
        panelGeneral.add(txtProvincia);
        txtProvincia.setColumns(10);
        
        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDescripcion.setBounds(10, 60, 110, 20);
        panelGeneral.add(lblDescripcion);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(130, 60, 570, 45);
        panelGeneral.add(scrollPane_1);
        
        txtDescripcion = new JTextArea();
        txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        scrollPane_1.setViewportView(txtDescripcion);
        
        JLabel lblSalarioMin = new JLabel("Salario Mínimo:");
        lblSalarioMin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSalarioMin.setBounds(10, 120, 110, 20);
        panelGeneral.add(lblSalarioMin);
        
        spnSalarioMin = new JSpinner(new SpinnerNumberModel(10000, 1, 1000000, 1000));
        spnSalarioMin.setBounds(130, 120, 100, 25);
        panelGeneral.add(spnSalarioMin);
        
        JLabel lblSalarioMax = new JLabel("Salario Máximo:");
        lblSalarioMax.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSalarioMax.setBounds(250, 120, 100, 20);
        panelGeneral.add(lblSalarioMax);
        
        spnSalarioMax = new JSpinner(new SpinnerNumberModel(15000, 1, 1000000, 1000));
        spnSalarioMax.setBounds(350, 120, 100, 25);
        panelGeneral.add(spnSalarioMax);
        
        JLabel lblPuestos = new JLabel("Vacantes:");
        lblPuestos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblPuestos.setBounds(500, 120, 60, 20);
        panelGeneral.add(lblPuestos);
        
        spnCantPuestos = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spnCantPuestos.setBounds(570, 120, 60, 25);
        panelGeneral.add(spnCantPuestos);

        // --- SECCIÓN 2: Requisitos ---
        JPanel panelRequisitos = new JPanel();
        panelRequisitos.setBorder(new TitledBorder(null, "Requisitos del Candidato", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 12), null));
        panelRequisitos.setBounds(10, 180, 714, 230);
        contentPanel.add(panelRequisitos);
        panelRequisitos.setLayout(null);
        
        JLabel lblTipo = new JLabel("Tipo Ideal:");
        lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTipo.setBounds(10, 25, 80, 20);
        panelRequisitos.add(lblTipo);
        
        cbxTipoCandidato = new JComboBox<>();
        cbxTipoCandidato.setModel(new DefaultComboBoxModel<>(new String[] {"Obrero", "Tecnico", "Universitario"}));
        cbxTipoCandidato.setBounds(100, 25, 150, 25);
        panelRequisitos.add(cbxTipoCandidato);
        
        JLabel lblExperiencia = new JLabel("Años Exp:");
        lblExperiencia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblExperiencia.setBounds(280, 25, 60, 20);
        panelRequisitos.add(lblExperiencia);
        
        spnExperiencia = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
        spnExperiencia.setBounds(350, 25, 60, 25);
        panelRequisitos.add(spnExperiencia);
        
        JLabel lblCoincidencia = new JLabel("Puntaje Min (%):");
        lblCoincidencia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblCoincidencia.setBounds(450, 25, 100, 20);
        panelRequisitos.add(lblCoincidencia);
        
        spnCoincidencia = new JSpinner(new SpinnerNumberModel(50, 1, 100, 5));
        spnCoincidencia.setBounds(550, 25, 60, 25);
        panelRequisitos.add(spnCoincidencia);
        
        JLabel lblArea = new JLabel("Área Técnica (Si aplica):");
        lblArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblArea.setBounds(10, 70, 140, 20);
        panelRequisitos.add(lblArea);
        
        txtAreaTecnica = new JTextField();
        txtAreaTecnica.setBounds(160, 70, 250, 25);
        panelRequisitos.add(txtAreaTecnica);
        txtAreaTecnica.setColumns(10);
        
        chckbxLicencia = new JCheckBox("Requiere Licencia de Conducir");
        chckbxLicencia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        chckbxLicencia.setBounds(10, 110, 200, 25);
        panelRequisitos.add(chckbxLicencia);
        
        chckbxMudanza = new JCheckBox("Requiere Disp. de Mudanza");
        chckbxMudanza.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        chckbxMudanza.setBounds(210, 110, 200, 25);
        panelRequisitos.add(chckbxMudanza);
        
        JLabel lblHabilidades = new JLabel("Habilidades (Una por línea):");
        lblHabilidades.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblHabilidades.setBounds(10, 150, 170, 20);
        panelRequisitos.add(lblHabilidades);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(190, 150, 510, 60);
        panelRequisitos.add(scrollPane);
        
        txtHabilidades = new JTextArea();
        txtHabilidades.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        scrollPane.setViewportView(txtHabilidades);
        
        // --- BOTONES INFERIORES ---
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton okButton = new JButton("Registrar Oferta");
        okButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txtTitulo.getText().trim().isEmpty() || txtProvincia.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete al menos el Título y la Provincia.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                ArrayList<String> listaHabilidades = new ArrayList<>();
                String[] habs = txtHabilidades.getText().split("\n");
                for (String h : habs) {
                    if(!h.trim().isEmpty()) {
                        listaHabilidades.add(h.trim());
                    }
                }
                
                Bolsa.getBolsa().crearOferta(
                    empresaLogueada, 
                    txtTitulo.getText(), 
                    txtDescripcion.getText(), 
                    (Integer) spnSalarioMin.getValue(), 
                    (Integer) spnSalarioMax.getValue(), 
                    txtProvincia.getText(), 
                    chckbxLicencia.isSelected(), 
                    chckbxMudanza.isSelected(), 
                    cbxTipoCandidato.getSelectedItem().toString(), 
                    ((Integer) spnCoincidencia.getValue()).floatValue(), 
                    (Integer) spnCantPuestos.getValue(), 
                    (Integer) spnExperiencia.getValue(), 
                    txtAreaTecnica.getText(), 
                    listaHabilidades
                );
                Bolsa.guardarSistema();
                
                JOptionPane.showMessageDialog(null, "Oferta registrada y publicada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(cancelButton);
    }
}