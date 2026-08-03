package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
        JPanel panel;
        public Dashboard(){
            setTitle("Dashboard");
            setSize(800,600);
            setLocationRelativeTo(null);
            setVisible(true);
            init();
        }
     
        private void init() {
            panel = new JPanel();
            getContentPane().add(panel);
            // Fuente de Datos
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Total de Usuarios", Bolsa.getBolsa().losUsuarios.size());
            data.setValue("Total de Empresas", Bolsa.getBolsa().lasEmpresas.size());
            data.setValue("Personas Registradas", Bolsa.getBolsa().lasPersonas.size());
     
            // Creando el Grafico
            JFreeChart chart = ChartFactory.createPieChart(
             "Estadisticas generales", 
             data, 
             true, 
             true, 
             false);
            panel.setLayout(null);
     
            // Crear el Panel del Grafico con ChartPanel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBounds(15, 16, 525, 313);
            panel.add(chartPanel);
            
            JLabel lblNewLabel = new JLabel("Empleado mejor pagado");
            lblNewLabel.setBounds(555, 16, 208, 20);
            panel.add(lblNewLabel);
            
            JLabel label = new JLabel("Empleado mejor pagado");
            label.setBounds(555, 119, 208, 20);
            panel.add(label);
        }
        
        public static void main(String args[]){
            new Dashboard().setVisible(true);
        }
}