package vista;

import controlador.ControladorMostrarSaldo;
import controlador.IVistaMostrarSaldo;
import java.util.Date;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Jugador;
import modelo.Participante;
import utilidades.ManejoDeFechas;

public class VerSaldo extends javax.swing.JDialog implements IVistaMostrarSaldo {

    private ControladorMostrarSaldo controlador;

    public VerSaldo(java.awt.Frame parent, boolean modal, Jugador j) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorMostrarSaldo(this, j);
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
        lblDatoApuesta4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombreFijo.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblNombreFijo.setText("Hola, ");
        getContentPane().add(lblNombreFijo);
        lblNombreFijo.setBounds(20, 40, 40, 30);

        lblSaldoFijo.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblSaldoFijo.setText("Su saldo disponible al momento es: ");
        getContentPane().add(lblSaldoFijo);
        lblSaldoFijo.setBounds(20, 70, 240, 30);

        lblUltimaApuestaFijo.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblUltimaApuestaFijo.setText("Última apuesta realizada:");
        getContentPane().add(lblUltimaApuestaFijo);
        lblUltimaApuestaFijo.setBounds(20, 100, 180, 30);

        lblNombreDinamico.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        getContentPane().add(lblNombreDinamico);
        lblNombreDinamico.setBounds(60, 40, 280, 30);

        lblSaldoDinamico.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        getContentPane().add(lblSaldoDinamico);
        lblSaldoDinamico.setBounds(250, 70, 90, 30);

        lblDatoApuesta3.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblDatoApuesta3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lblDatoApuesta3);
        lblDatoApuesta3.setBounds(50, 170, 280, 20);

        lblFecha.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblFecha);
        lblFecha.setBounds(150, 20, 170, 20);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 220, 100, 30);

        lblDatoApuesta1.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblDatoApuesta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lblDatoApuesta1);
        lblDatoApuesta1.setBounds(50, 130, 280, 20);

        lblDatoApuesta2.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblDatoApuesta2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lblDatoApuesta2);
        lblDatoApuesta2.setBounds(50, 150, 280, 20);

        lblDatoApuesta4.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        lblDatoApuesta4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lblDatoApuesta4);
        lblDatoApuesta4.setBounds(50, 190, 280, 20);

        setBounds(0, 0, 365, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    @Override
    public void mostrarDatos(Jugador j) {
        Apuesta a = j.getUltimaApuesta();
        this.setTitle("Consulta de saldo - " + j.getNombreCompleto());
        lblFecha.setText(ManejoDeFechas.formatearFecha(new Date(), "dd/MM/yyyy"));
        lblNombreDinamico.setText(j.getNombreCompleto());
        lblSaldoDinamico.setText("$ " + j.getSaldo());
        if (a != null) {
            Carrera c = a.getCarrera();
            Participante p = a.getParticipante();
            lblDatoApuesta1.setText(c.getHipodromo().getNombre()+ " - " + ManejoDeFechas.formatearFecha(c.getFecha(), "dd/MM/yyyy") + " - Carrera n° " + c.getNumeroCarrera());
            lblDatoApuesta2.setText("Caballo n° " + p.getNumero() + " - " + p.getNombreCaballo() + " - dividendo " + p.getDividendo());
            lblDatoApuesta3.setText("Apostó: $ " + a.getMontoApostado());
            if (!c.isFinalizada()) {
                lblDatoApuesta4.setText("Carrera pendiente");
            } else {
                lblDatoApuesta4.setText("Ganado: $ " + a.getMontoGanado());
            }
        } else {
            lblDatoApuesta1.setText("Sin apuestas");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblDatoApuesta1;
    private javax.swing.JLabel lblDatoApuesta2;
    private javax.swing.JLabel lblDatoApuesta3;
    private javax.swing.JLabel lblDatoApuesta4;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreDinamico;
    private javax.swing.JLabel lblNombreFijo;
    private javax.swing.JLabel lblSaldoDinamico;
    private javax.swing.JLabel lblSaldoFijo;
    private javax.swing.JLabel lblUltimaApuestaFijo;
    // End of variables declaration//GEN-END:variables

}
