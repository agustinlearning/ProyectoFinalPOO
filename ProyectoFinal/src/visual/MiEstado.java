package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Persona;

public class MiEstado extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public MiEstado(Persona miPerfil) {
        setTitle("Estado de mi Candidatura");
        setModal(true);
        setBounds(100, 100, 450, 250);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panelCentral = new JPanel();
        panelCentral.setBorder(new TitledBorder(null, "Estatus Actual", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 12), null));
        contentPanel.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));

        JLabel lblMensaje = new JLabel();
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentral.add(lblMensaje, BorderLayout.CENTER);

        if (miPerfil.isContratado()) {
            lblMensaje.setText("<html><center><h2 style='color:green;'>Felicidades, " + miPerfil.getNombre() + "</h2><p>Has sido seleccionado por una empresa.</p><p>Tu perfil ya no está visible para nuevas ofertas.</p></center></html>");
        } else {
            lblMensaje.setText("<html><center><h2 style='color:blue;'>Perfil Activo</h2><p>Hola, " + miPerfil.getNombre() + ".</p><p>Tu currículum está en nuestra base de datos y<br>está siendo evaluado por las empresas.</p></center></html>");
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Cerrar");
        okButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
    }
}