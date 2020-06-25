
package interfaz;

import persistencia.BaseDatos;
import vista.VentanaJugador;
import vista.LoginAdministrador;


public class VentanaInicio extends javax.swing.JFrame {

    public VentanaInicio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdministrador = new javax.swing.JButton();
        btnJugador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE APUESTAS HÍPICAS");
        setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnAdministrador.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAdministrador.setText("SOY ADMINISTRADOR!");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrador);
        btnAdministrador.setBounds(40, 120, 180, 40);

        btnJugador.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnJugador.setText("QUIERO JUGAR!");
        btnJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugadorActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugador);
        btnJugador.setBounds(250, 120, 180, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 20, 180, 80);

        setSize(new java.awt.Dimension(490, 226));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugadorActionPerformed
        VentanaJugador ventana = new VentanaJugador();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnJugadorActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
         LoginAdministrador ventana = new LoginAdministrador();
         ventana.setVisible(true);
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnJugador;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
