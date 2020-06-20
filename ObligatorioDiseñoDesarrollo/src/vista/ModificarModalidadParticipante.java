package vista;

import controlador.ControladorModificarModalidadParticipante;
import controlador.IVistaModificarModalidadParticipante;
import java.util.ArrayList;
import modelo.ModalidadApuesta;
import modelo.Participante;

public class ModificarModalidadParticipante extends javax.swing.JDialog implements IVistaModificarModalidadParticipante {

    ControladorModificarModalidadParticipante controlador;
    CambiarModalidadApuesta cambiarModalidadApuesta;
    
    public ModificarModalidadParticipante(java.awt.Frame parent, boolean modal, Participante seleccionado) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        controlador = new ControladorModificarModalidadParticipante(seleccionado, this);
        cambiarModalidadApuesta = (CambiarModalidadApuesta)parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDividendo = new javax.swing.JLabel();
        slcModalidades = new javax.swing.JComboBox();
        lblModalidades = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Participante"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        lblNumero.setText("jLabel1");

        lblNombre.setText("jLabel2");

        lblDividendo.setText("jLabel3");

        lblModalidades.setText("Modalidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slcModalidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(lblNombre)
                            .addComponent(lblDividendo)
                            .addComponent(lblModalidades))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumero)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(lblDividendo)
                .addGap(18, 18, 18)
                .addComponent(lblModalidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slcModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        controlador.modificarParticipante(slcModalidades.getSelectedIndex());
    }//GEN-LAST:event_btnAceptarActionPerformed

    @Override
    public void mostrarDatosParticipante(Participante participante) {
        lblNumero.setText(Integer.toString(participante.getNumero()));
        lblNombre.setText(participante.getNombreCaballo());
        lblDividendo.setText(Double.toString(participante.getDividendo()));       
    }

    @Override
    public void mostrarModalidades(ArrayList<ModalidadApuesta> modalidades) {
        for (ModalidadApuesta m : modalidades) {
            slcModalidades.addItem(formatearModalidad(m));
        }
    }

    @Override
    public String formatearModalidad(ModalidadApuesta modalidad) {
        //Hermoso método polimórfico
        return modalidad.tipoModalidad();
    }

    @Override
    public void cerrar() {
        this.dispose();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDividendo;
    private javax.swing.JLabel lblModalidades;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JComboBox slcModalidades;
    // End of variables declaration//GEN-END:variables

}
