package visual;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import logico.Bolsa;

public class Dashboard extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public Dashboard() {
        setModal(true);
        setTitle("Resumen del Sistema");
        setBounds(100, 100, 500, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(2, 2, 15, 15));

        contentPanel.add(crearPanelMetrica("Total de Usuarios", Bolsa.getBolsa().losUsuarios.size()));
        contentPanel.add(crearPanelMetrica("Total de Empresas", Bolsa.getBolsa().lasEmpresas.size()));
        contentPanel.add(crearPanelMetrica("Personas Registradas", Bolsa.getBolsa().lasPersonas.size()));
        
        //recordar añadir otra estadística: ej (la lista de ofertas o solicitudes) mas tarde
        contentPanel.add(crearPanelMetrica("Ofertas Activas", 0)); 
    }

    private JPanel crearPanelMetrica(String titulo, int valor) {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, titulo, TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 12), null));
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblValor = new JLabel(String.valueOf(valor));
        lblValor.setHorizontalAlignment(SwingConstants.CENTER);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 24));
        panel.add(lblValor, BorderLayout.CENTER);
        
        return panel;
    }
}