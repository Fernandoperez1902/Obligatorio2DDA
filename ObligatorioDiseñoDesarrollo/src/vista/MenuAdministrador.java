package vista;

import controlador.ControladorMenuAdministrador;
import controlador.IVistaMenuAdministrador;
import java.util.ArrayList;
import modelo.Administrador;
import modelo.Hipodromo;

public class MenuAdministrador extends javax.swing.JFrame implements IVistaMenuAdministrador {

    private ControladorMenuAdministrador controlador;

    public MenuAdministrador(Administrador adm) {
        initComponents();
        controlador = new ControladorMenuAdministrador(adm, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAdminName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstHipodromo = new javax.swing.JList();
        lblHipodromos = new javax.swing.JLabel();
        btnCrearCarrera = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnCerrarApuestas = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnMonitorear = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblCarreras = new javax.swing.JLabel();
        btnCambiarModalidad = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        optSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setAutoRequestFocus(false);

        txtAdminName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        lstHipodromo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstHipodromoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstHipodromo);

        lblHipodromos.setText("Hipódromos");

        btnCrearCarrera.setText("Crear");
        btnCrearCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCarreraActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnCerrarApuestas.setText("Cerrar Apuestas");
        btnCerrarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarApuestasActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnMonitorear.setText("Monitorear");
        btnMonitorear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorearActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");

        lblCarreras.setText("Carreras");

        btnCambiarModalidad.setText("Cambiar Modalidad");
        btnCambiarModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarModalidadActionPerformed(evt);
            }
        });

        optSalir.setText("Salir");
        menuBar.add(optSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAdminName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHipodromos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMonitorear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarreras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarModalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCarreras)
                            .addComponent(lblHipodromos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrearCarrera)
                                .addGap(18, 18, 18)
                                .addComponent(btnAbrir)
                                .addGap(16, 16, 16)
                                .addComponent(btnCerrarApuestas)
                                .addGap(17, 17, 17)
                                .addComponent(btnFinalizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnMonitorear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCambiarModalidad))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCarreraActionPerformed
        controlador.crearCarrera();
    }//GEN-LAST:event_btnCrearCarreraActionPerformed

    private void lstHipodromoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstHipodromoValueChanged
        int index = lstHipodromo.getSelectedIndex();
        controlador.seleccionarHipodromo(index);
    }//GEN-LAST:event_lstHipodromoValueChanged

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        controlador.abrirCarrera();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnMonitorearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorearActionPerformed
        controlador.monitorDeCarrera();
    }//GEN-LAST:event_btnMonitorearActionPerformed
    private void btnCerrarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarApuestasActionPerformed
        controlador.cerrarApuestas();
    }//GEN-LAST:event_btnCerrarApuestasActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        controlador.finalizarCarrera();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCambiarModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarModalidadActionPerformed
        controlador.cambiarModalidad();
    }//GEN-LAST:event_btnCambiarModalidadActionPerformed

    @Override
    public void llamarCrearCarrera(Hipodromo hip) {
        new CrearCarrera(hip).setVisible(true);
    }

    @Override
    public void llamarAbrirCarrera(Hipodromo hip) {
        new AbrirCarrera(hip).setVisible(true);
    }

    @Override
    public void llamarCerrarApuestas(Hipodromo hip) {
        new CerrarApuestas(hip).setVisible(true);
    }

    @Override
    public void llamarFinalizarCarrera(Hipodromo hip) {
        new FinalizarCarrera(hip).setVisible(true);
    }

    @Override
    public void llamarMonitorearCarrera(Hipodromo hip) {
        new MonitorDeCarreras(hip).setVisible(true);
    }
    
    @Override
    public void llamarCambiarModadlidad(Hipodromo hip) {
        new CambiarModalidadApuesta(hip).setVisible(true);
    }


    @Override
    public String formatear(Hipodromo hip) {
        return hip.getNombre();
    }

    @Override
    public void mostrarHipodromos(ArrayList<Hipodromo> hipodromos) {
        ArrayList<String> stringHip = new ArrayList();
        for (Hipodromo h : hipodromos) {
            stringHip.add(formatear(h));
        }
        lstHipodromo.setListData(stringHip.toArray());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCambiarModalidad;
    private javax.swing.JButton btnCerrarApuestas;
    private javax.swing.JButton btnCrearCarrera;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnMonitorear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCarreras;
    private javax.swing.JLabel lblHipodromos;
    private javax.swing.JList lstHipodromo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu optSalir;
    private javax.swing.JLabel txtAdminName;
    // End of variables declaration//GEN-END:variables

    
}
