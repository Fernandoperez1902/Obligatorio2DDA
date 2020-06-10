/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Date;
import modelo.Jugador;

/**
 *
 * @author Mauro
 */
public class VerSaldo extends javax.swing.JDialog {

    /**
     * Creates new form VerSaldo
     */
    public VerSaldo(java.awt.Frame parent, boolean modal, Jugador j) {
        super(parent, modal);
        initComponents();
        this.setTitle("Consulta de saldo - " + j.getNombreCompleto());
        mostrarDatos(j);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreFijo = new javax.swing.JLabel();
        lblSaldoFijo = new javax.swing.JLabel();
        lblUltimaApuestaFijo = new javax.swing.JLabel();
        lblNombreDinamico = new javax.swing.JLabel();
        lblSaldoDinamico = new javax.swing.JLabel();
        lblUltApuestaDinamico = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblNombreFijo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblNombreFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblNombreFijo.setText("Hola, ");
        getContentPane().add(lblNombreFijo);
        lblNombreFijo.setBounds(30, 50, 40, 30);

        lblSaldoFijo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblSaldoFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblSaldoFijo.setText("Su saldo disponible al momento es: ");
        getContentPane().add(lblSaldoFijo);
        lblSaldoFijo.setBounds(30, 80, 240, 30);

        lblUltimaApuestaFijo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblUltimaApuestaFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblUltimaApuestaFijo.setText("Última apuesta realizada:");
        getContentPane().add(lblUltimaApuestaFijo);
        lblUltimaApuestaFijo.setBounds(30, 110, 180, 30);

        lblNombreDinamico.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblNombreDinamico.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblNombreDinamico);
        lblNombreDinamico.setBounds(70, 50, 320, 30);

        lblSaldoDinamico.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        lblSaldoDinamico.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblSaldoDinamico);
        lblSaldoDinamico.setBounds(270, 80, 120, 30);

        lblUltApuestaDinamico.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        lblUltApuestaDinamico.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblUltApuestaDinamico);
        lblUltApuestaDinamico.setBounds(40, 140, 340, 30);

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblFecha);
        lblFecha.setBounds(210, 20, 170, 20);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 200, 100, 30);

        setBounds(0, 0, 416, 287);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreDinamico;
    private javax.swing.JLabel lblNombreFijo;
    private javax.swing.JLabel lblSaldoDinamico;
    private javax.swing.JLabel lblSaldoFijo;
    private javax.swing.JLabel lblUltApuestaDinamico;
    private javax.swing.JLabel lblUltimaApuestaFijo;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos(Jugador j) {
        lblNombreDinamico.setText(j.getNombreCompleto());
        lblSaldoDinamico.setText("$ " +j.getSaldo());
        lblUltApuestaDinamico.setText("bla bla bla");
        lblFecha.setText(new Date() + "");
    }
}
