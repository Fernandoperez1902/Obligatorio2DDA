
package vista;

import controlador.ControladorAbrirCarrera;
import controlador.IVistaAbrirCarrera;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

public class AbrirCarrera extends javax.swing.JFrame implements IVistaAbrirCarrera {

    private ControladorAbrirCarrera controlador;

    public AbrirCarrera(Hipodromo seleccionado) {
        initComponents();
        controlador = new ControladorAbrirCarrera(seleccionado, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipantes = new javax.swing.JList();
        btnAbrirBoton = new javax.swing.JToggleButton();
        lblNumero = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(lstParticipantes);

        btnAbrirBoton.setText("Abrir");
        btnAbrirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnAbrirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAbrirBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mostrarCarrera(Carrera carrera) {
        lblNumero.setText(Integer.toString(carrera.getNumeroCarrera()));
        lblNombre.setText(carrera.getNombre());
        mostrarParticipantesCarrera(carrera.getParticipantes());

    }

    @Override
    public void mostrarParticipantesCarrera(ArrayList<Participante> participantes) {
        ArrayList<String> participantesString = new ArrayList();
        for (Participante p : participantes) {
            participantesString.add(formatearParticipante(p));
        }
        lstParticipantes.setListData(participantesString.toArray());
    }

    @Override
    public String formatearParticipante(Participante participante) {
        return "N° " + participante.getNumero() + " - " + participante.getNombreCaballo() + " - $"
                + participante.getDividendo();
    }

    private void btnAbrirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirBotonActionPerformed
        controlador.abrirCarrera();
        this.dispose();
    }//GEN-LAST:event_btnAbrirBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAbrirBoton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JList lstParticipantes;
    // End of variables declaration//GEN-END:variables

}
