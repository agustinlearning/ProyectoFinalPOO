package visual;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import logico.Bolsa;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Dashboard extends JDialog {

    private final JPanel contentPanel = new JPanel();
    public Dashboard() {
        setModal(true);
        setTitle("Resumen del Sistema");
        setBounds(100, 100, 723, 477);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel);
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Total de Usuarios", Bolsa.getBolsa().losUsuarios.size());
        data.setValue("Total de Empresas", Bolsa.getBolsa().lasEmpresas.size());
        data.setValue("Personas Registradas", Bolsa.getBolsa().lasPersonas.size());
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Ejemplo Rapido de Grafico en un ChartFrame", 
         data, 
         true, 
         true, 
         false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        contentPanel.add(chartPanel);
    }
}