/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import logica.Administrador;
import logica.Fachada;
import logica.Hipodromo;

/**
 *
 * @author Fernando
 */
public class MenuAdministrador extends javax.swing.JFrame {

    private Hipodromo seleccionado = null; 
    
    /**
     * Creates new form MenuAdministrador
     */
    public MenuAdministrador(Administrador adm) {
        initComponents();
        txtAdminName.setText(adm.getNombreCompleto());
        cargarHipodromos();

    }

    private void cargarHipodromos() {

        ArrayList<Hipodromo> hipodromos = Fachada.getInstancia().getHipodromos();
        lstHipodromo.setListData(hipodromos.toArray());

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

        btnCerrarApuestas.setText("Cerrar Apuestas");

        btnFinalizar.setText("Finalizar");

        btnMonitorear.setText("Monitorear");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");

        lblCarreras.setText("Carreras");

        optSalir.setText("Salir");
        menuBar.add(optSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblHipodromos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAdminName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrarApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAbrir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCrearCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMonitorear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblCarreras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHipodromos)
                                .addGap(190, 190, 190))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCarreras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearCarrera)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrir)
                        .addGap(16, 16, 16)
                        .addComponent(btnCerrarApuestas)
                        .addGap(17, 17, 17)
                        .addComponent(btnFinalizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnMonitorear)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCarreraActionPerformed
        CrearCarrera crearC = new CrearCarrera(seleccionado);
        crearC.setVisible(true);

    }//GEN-LAST:event_btnCrearCarreraActionPerformed

    private void lstHipodromoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstHipodromoValueChanged
        Hipodromo sel = (Hipodromo)lstHipodromo.getSelectedValue();
        setSeleccionado(sel);
    }//GEN-LAST:event_lstHipodromoValueChanged

    private void setSeleccionado(Hipodromo sel){
        seleccionado = sel; 
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
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
