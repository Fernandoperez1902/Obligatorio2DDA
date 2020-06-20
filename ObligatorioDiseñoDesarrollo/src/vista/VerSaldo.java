package vista;

import java.util.Date;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Jugador;
import modelo.Participante;

public class VerSaldo extends javax.swing.JDialog {

    public VerSaldo(java.awt.Frame parent, boolean modal, Jugador j) {
        super(parent, modal);
        initComponents();
        mostrarDatos(j);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreFijo = new javax.swing.JLabel();
        lblSaldoFijo = new javax.swing.JLabel();
        lblUltimaApuestaFijo = new javax.swing.JLabel();
        lblNombreDinamico = new javax.swing.JLabel();
        lblSaldoDinamico = new javax.swing.JLabel();
        lblDatoApuesta3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblDatoApuesta1 = new javax.swing.JLabel();
        lblDatoApuesta2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombreFijo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblNombreFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblNombreFijo.setText("Hola, ");
        getContentPane().add(lblNombreFijo);
        lblNombreFijo.setBounds(20, 40, 40, 30);

        lblSaldoFijo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblSaldoFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblSaldoFijo.setText("Su saldo disponible al momento es: ");
        getContentPane().add(lblSaldoFijo);
        lblSaldoFijo.setBounds(20, 70, 240, 30);

        lblUltimaApuestaFijo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblUltimaApuestaFijo.setForeground(new java.awt.Color(204, 0, 0));
        lblUltimaApuestaFijo.setText("Última apuesta realizada:");
        getContentPane().add(lblUltimaApuestaFijo);
        lblUltimaApuestaFijo.setBounds(20, 100, 180, 30);

        lblNombreDinamico.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblNombreDinamico.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblNombreDinamico);
        lblNombreDinamico.setBounds(60, 40, 320, 30);

        lblSaldoDinamico.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        lblSaldoDinamico.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblSaldoDinamico);
        lblSaldoDinamico.setBounds(260, 70, 120, 30);

        lblDatoApuesta3.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        lblDatoApuesta3.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblDatoApuesta3);
        lblDatoApuesta3.setBounds(40, 170, 340, 20);

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

        lblDatoApuesta1.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        lblDatoApuesta1.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblDatoApuesta1);
        lblDatoApuesta1.setBounds(40, 130, 340, 20);

        lblDatoApuesta2.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        lblDatoApuesta2.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblDatoApuesta2);
        lblDatoApuesta2.setBounds(40, 150, 340, 20);

        setBounds(0, 0, 414, 287);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblDatoApuesta1;
    private javax.swing.JLabel lblDatoApuesta2;
    private javax.swing.JLabel lblDatoApuesta3;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreDinamico;
    private javax.swing.JLabel lblNombreFijo;
    private javax.swing.JLabel lblSaldoDinamico;
    private javax.swing.JLabel lblSaldoFijo;
    private javax.swing.JLabel lblUltimaApuestaFijo;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos(Jugador j) {
        Apuesta a = j.getUltimaApuesta();
        this.setTitle("Consulta de saldo - " + j.getNombreCompleto());
        lblFecha.setText(new Date() + "");
        lblNombreDinamico.setText(j.getNombreCompleto());
        lblSaldoDinamico.setText("$ " + j.getSaldo());
        if (a != null) {
            Carrera c = a.getCarrera();
            Participante p = a.getParticipante();
            lblDatoApuesta1.setText(c.getFecha() + " - Carrera n° " + c.getNumeroCarrera());
            lblDatoApuesta2.setText("Caballo n° " + p.getNumero() + " - dividendo" + p.getDividendo());
            lblDatoApuesta3.setText("Apostó: " + a.getMontoApostado());
            if (!c.isFinalizada()) {
                lblDatoApuesta3.setText("Aún no hay un ganador");
            } else {
                lblDatoApuesta3.setText("Ganado: " + a.getMontoGanado());
            }
        } else {
            lblDatoApuesta1.setText("Sin apuestas");
        }
    }
}
