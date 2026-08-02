package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bolsa;
import logico.CandidatoEvaluado;
import logico.Empresa;
import logico.Oferta;

public class ListarOfertas extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel model;
    private Object[] row;
    private Empresa empresaLogueada;
    private JButton btnEvaluar;
    private Oferta selected = null;

    /**
	 * Create the frame.
	 */
    public ListarOfertas(Empresa empresa) {
        this.empresaLogueada = empresa;
        
        setTitle("Mis Ofertas Publicadas");
        setModal(true);
        setBounds(100, 100, 700, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        String[] headers = {"Código", "Título", "Candidato Ideal", "Salario Mínimo"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                if (index >= 0) {
                    btnEvaluar.setEnabled(true);
                    String idOferta = table.getValueAt(index, 0).toString();
                    
                    // Buscamos la oferta manualmente iterando sobre la lista pública
                    selected = null;
                    for (Oferta o : Bolsa.getBolsa().lasOfertas) {
                        if (o.getId().equalsIgnoreCase(idOferta)) {
                            selected = o;
                            break;
                        }
                    }
                }
            }
        });
        table.setModel(model);
        scrollPane.setViewportView(table);

        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        btnEvaluar = new JButton("Evaluar Candidatos");
        btnEvaluar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnEvaluar.setEnabled(false);
        btnEvaluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selected != null) {
                    ArrayList<CandidatoEvaluado> listaCandidatosCompatibles = Bolsa.getBolsa().mejoresCandidatosOferta(selected);
                    
                    if (listaCandidatosCompatibles.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "Aún no hay candidatos que cumplan con el puntaje mínimo de coincidencia para esta oferta.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                         MostrarCandidatos ventanaCandidatos = new MostrarCandidatos(listaCandidatosCompatibles, empresaLogueada);
                         ventanaCandidatos.setVisible(true);
                    }
                }
            }
        });
        buttonPane.add(btnEvaluar);

        JButton btnCancelar = new JButton("Cerrar");
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCancelar);

        loadOfertas();
    }

    private void loadOfertas() {
        model.setRowCount(0);
        row = new Object[model.getColumnCount()];
        
        for (Oferta oferta : Bolsa.getBolsa().lasOfertas) {
            if (oferta.getEmpresa().getRnc().equalsIgnoreCase(empresaLogueada.getRnc())) {
                row[0] = oferta.getId();
                row[1] = oferta.getTitulo();
                row[2] = oferta.getTipoCandidato();
                row[3] = "$" + oferta.getSalarioMin();
                model.addRow(row);
            }
        }
    }
}