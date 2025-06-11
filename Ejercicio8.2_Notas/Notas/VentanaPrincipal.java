package Notas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JLabel promedio, desviacion, mayor, menor;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        iniciarComponentes();
        setTitle("Notas");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void iniciarComponentes() {
        Container contenedor = getContentPane();
        contenedor.setLayout(null);

        String[] etiquetas = {"Nota 1:", "Nota 2:", "Nota 3:", "Nota 4:", "Nota 5:"};
        JTextField[] campos = {
            campoNota1 = new JTextField(), campoNota2 = new JTextField(),
            campoNota3 = new JTextField(), campoNota4 = new JTextField(),
            campoNota5 = new JTextField()
        };

        for (int i = 0; i < etiquetas.length; i++) {
            JLabel label = new JLabel(etiquetas[i]);
            label.setBounds(20, 20 + i * 30, 80, 23);
            contenedor.add(label);
            campos[i].setBounds(100, 20 + i * 30, 150, 23);
            contenedor.add(campos[i]);
        }

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 180, 100, 25);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(130, 180, 100, 25);
        limpiar.addActionListener(this);
        contenedor.add(limpiar);

        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 220, 250, 23);
        contenedor.add(promedio);

        desviacion = new JLabel("Desviación estándar = ");
        desviacion.setBounds(20, 250, 250, 23);
        contenedor.add(desviacion);

        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(20, 280, 250, 23);
        contenedor.add(mayor);

        menor = new JLabel("Nota menor = ");
        menor.setBounds(20, 310, 250, 23);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            try {
                Notas notas = new Notas();
                notas.listaNotas[0] = Double.parseDouble(campoNota1.getText());
                notas.listaNotas[1] = Double.parseDouble(campoNota2.getText());
                notas.listaNotas[2] = Double.parseDouble(campoNota3.getText());
                notas.listaNotas[3] = Double.parseDouble(campoNota4.getText());
                notas.listaNotas[4] = Double.parseDouble(campoNota5.getText());

                promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
                desviacion.setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviación()));
                mayor.setText("Nota mayor = " + notas.calcularMayor());
                menor.setText("Nota menor = " + notas.calcularMenor());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa solo números válidos en todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviacion.setText("Desviación estándar = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}
