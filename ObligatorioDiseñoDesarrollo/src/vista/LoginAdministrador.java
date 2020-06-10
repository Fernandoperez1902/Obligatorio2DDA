package vista;

import controlador.ControladorLoginAdmin;
import controlador.IVistaLoginAdmin;
import javax.swing.JOptionPane;
import modelo.Administrador;

/**
 *
 * @author Mauro
 */
public class LoginAdministrador extends javax.swing.JFrame implements IVistaLoginAdmin {

    private ControladorLoginAdmin controlador;

    public LoginAdministrador() {
        initComponents();
        controlador = new ControladorLoginAdmin(this);
    }

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
        controlador.login(nombreUsuario, passUsuario);
    }//GEN-LAST:event_btnAdminLoginActionPerformed

    @Override
    public void mostrarProximaVista(Administrador admin) {
        new MenuAdministrador(admin).setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JLabel labUsuario;
    private javax.swing.JLabel labUsuario1;
    private javax.swing.JTextField txtAdminNom;
    private javax.swing.JTextField txtAdminPass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void cerrar() {
        this.dispose();
    }

    @Override
    public void mostrarBienvenida(Administrador admin) {
        String msg = "Bienvenido " + admin.getNombreCompleto();
        JOptionPane.showMessageDialog(this, msg);
    }

}
