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
import logico.Empresa;
import logico.Persona;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Dashboard extends JDialog {        
        JPanel panel;
        private JLabel label;
        private JLabel lblNewLabel;
        public Dashboard(){
            setTitle("Dashboard");
            setSize(800,398);
            setLocationRelativeTo(null);
            setVisible(true);
            init();
        }
     
        private void init() {
            panel = new JPanel();
            getContentPane().add(panel);
            // Fuente de Datos
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Total de Usuarios " + Bolsa.getBolsa().losUsuarios.size(), Bolsa.getBolsa().losUsuarios.size());
            data.setValue("Total de Empresas " + Bolsa.getBolsa().lasEmpresas.size(), Bolsa.getBolsa().lasEmpresas.size());
            data.setValue("Personas Registradas " + Bolsa.getBolsa().lasPersonas.size(), Bolsa.getBolsa().lasPersonas.size());
     
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
            
            lblNewLabel = new JLabel("Empleado mejor pagado");
            lblNewLabel.setBounds(555, 79, 208, 20);
            panel.add(lblNewLabel);
            
            label = new JLabel("Empresa con mas empleados");
            Persona empleado = Bolsa.getBolsa().getEmpleadoMejorPagado();
            if(empleado != null)
            {
            	JLabel lblNewLabel_1 = new JLabel("" + empleado.getNombre());
                lblNewLabel_1.setBounds(555, 132, 175, 20);
                panel.add(lblNewLabel_1);
            }
            else
            {
            	JLabel lblNewLabel_1 = new JLabel("No existe");
                lblNewLabel_1.setBounds(555, 132, 175, 20);
                panel.add(lblNewLabel_1);
            }
            label.setBounds(555, 197, 208, 20);
            panel.add(label);
            
            
            Empresa empresa = Bolsa.getBolsa().getEmpresaConMasEmpleados();
            if(empresa != null)
            {
            	JLabel label_1 = new JLabel("" + empresa.getRnc());
            	label_1.setBounds(555, 230, 175, 20);
                panel.add(label_1);
            }
            else
            {
            	JLabel label_1 = new JLabel("No existe");
            	label_1.setBounds(555, 230, 175, 20);
                panel.add(label_1);
            }
        }
        
        public static void main(String args[]){
            new Dashboard().setVisible(true);
        }
}