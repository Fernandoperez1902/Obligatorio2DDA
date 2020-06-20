
package vista;

import controlador.ControladorCambiarModalidadApuesta;
import controlador.IVistaCambiarModalidadApuesta;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

public class CambiarModalidadApuesta extends javax.swing.JFrame implements IVistaCambiarModalidadApuesta{

    ControladorCambiarModalidadApuesta controlador;
    
    public CambiarModalidadApuesta(Hipodromo seleccionado) {
        initComponents();
        controlador = new ControladorCambiarModalidadApuesta(seleccionado, this);
    }

    @Override
    public void mostrarCarrera(Carrera carrera) {
        txtNumero.setText(Integer.toString(carrera.getNumeroCarrera()));
        txtNombre.setText(carrera.getNombre());
        txtMontoTotalApostado.setText(Float.toString(carrera.montoTotalApostado()));
    }

    @Override
    public void mostrarParticipantesSinApuestas(ArrayList<Participante> participantes) {
        ArrayList<String> participantesString = new ArrayList();
        for (Participante p : participantes){
            participantesString.add(formatearParticipante(p));
        }
        lstParticipantesSinApuestas.setListData(participantesString.toArray());
    }

    @Override
    public String formatearParticipante(Participante participante) {
        return "Nº" + participante.getNumero() + " - " + participante.getNombreCaballo() 
                + " - paga: $" + participante.getDividendo() + " Modalidad Apuesta: "
                + participante.getModalidad();
    }

    @Override
    public void mostrarProximaVista(Participante seleccionado) {
        new ModificarModalidadParticipante(this, true, seleccionado).setVisible(true);
    }
    
    @Override
    public void mostrarError(String mensaje) {
    }

    @Override
    public void cerrar() {
        this.dispose();
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipantesSinApuestas = new javax.swing.JList();
        lblParticipantes = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblMontoTotal = new javax.swing.JLabel();
        txtMontoTotalApostado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Modalidad");

        lstParticipantesSinApuestas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstParticipantesSinApuestasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstParticipantesSinApuestas);

        lblParticipantes.setText("Participantes sin apuestas");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblNumero.setText("Número");

        txtNumero.setEditable(false);

        lblNombre.setText("Nombre");

        txtNombre.setEditable(false);

        lblMontoTotal.setText("Monto Total Apostado");

        txtMontoTotalApostado.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMontoTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblParticipantes)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoTotal)
                    .addComponent(txtMontoTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblParticipantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnModificar)
                .addContainerGap())
        );

        setBounds(0, 0, 404, 318);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        controlador.modificarParticipante();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void lstParticipantesSinApuestasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstParticipantesSinApuestasValueChanged
        controlador.seleccionarParticipante(lstParticipantesSinApuestas.getSelectedIndex());
    }//GEN-LAST:event_lstParticipantesSinApuestasValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblParticipantes;
    private javax.swing.JList lstParticipantesSinApuestas;
    private javax.swing.JTextField txtMontoTotalApostado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

}
