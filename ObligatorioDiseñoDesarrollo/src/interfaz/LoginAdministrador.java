package interfaz;

import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import logica.Administrador;
import logica.Fachada;

/**
 *
 * @author Mauro
 */
public class LoginAdministrador extends javax.swing.JFrame {

    Fachada logica = Fachada.getInstancia();

    /**
     * Creates new form LoginAdministrador
     */
    public LoginAdministrador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labUsuario = new javax.swing.JLabel();
        txtAdminNom = new javax.swing.JTextField();
        txtAdminPass = new javax.swing.JTextField();
        labUsuario1 = new javax.swing.JLabel();
        btnAdminLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labUsuario.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        labUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labUsuario.setLabelFor(txtAdminNom);
        labUsuario.setText("Usuario");
        getContentPane().add(labUsuario);
        labUsuario.setBounds(20, 80, 80, 30);

        txtAdminNom.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtAdminNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminNomActionPerformed(evt);
            }
        });
        getContentPane().add(txtAdminNom);
        txtAdminNom.setBounds(120, 80, 230, 30);

        txtAdminPass.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtAdminPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtAdminPass);
        txtAdminPass.setBounds(120, 130, 230, 30);

        labUsuario1.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        labUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labUsuario1.setLabelFor(txtAdminPass);
        labUsuario1.setText("Contraseña");
        getContentPane().add(labUsuario1);
        labUsuario1.setBounds(20, 130, 80, 30);

        btnAdminLogin.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAdminLogin.setText("INGRESAR");
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminLogin);
        btnAdminLogin.setBounds(140, 200, 150, 30);

        setSize(new java.awt.Dimension(426, 313));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAdminNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminNomActionPerformed

    private void txtAdminPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminPassActionPerformed

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed

        String nombreUsuario = txtAdminNom.getText();
        String passUsuario = txtAdminPass.getText();

        Administrador adm = logica.loginAdministrador(nombreUsuario, passUsuario);

        if (adm != null) {

            BienvenidaAdministrador mensajeBienvda = new BienvenidaAdministrador(this, true, adm);
            mensajeBienvda.setVisible(true);
            
            this.dispose();
            
            MenuAdministrador menu = new MenuAdministrador(adm);
            menu.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(this, "Login Incorrecto");

        }

    }//GEN-LAST:event_btnAdminLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdministrador().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JLabel labUsuario;
    private javax.swing.JLabel labUsuario1;
    private javax.swing.JTextField txtAdminNom;
    private javax.swing.JTextField txtAdminPass;
    // End of variables declaration//GEN-END:variables
}
