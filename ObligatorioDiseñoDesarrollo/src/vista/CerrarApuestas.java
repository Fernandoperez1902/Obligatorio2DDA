
package vista;

import controlador.ControladorCerrarApuestas;
import controlador.IVistaCerrarApuestas;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

public class CerrarApuestas extends javax.swing.JFrame implements IVistaCerrarApuestas{
    
    private ControladorCerrarApuestas controlador;
    
    public CerrarApuestas(Hipodromo seleccionado) {
        initComponents();
        controlador = new ControladorCerrarApuestas(seleccionado, this);
    }

    @Override
    public void mostrarCarrera(Carrera carrera) {
        txtNumeroCarrera.setText(Integer.toString(carrera.getNumeroCarrera()));
        txtNombre.setText(carrera.getNombre());
        txtMontoTotalApostado.setText(Float.toString(carrera.montoTotalApostado()));
        mostrarParticipantesCarrera(carrera.getParticipantes());
    }

    @Override
    public void mostrarParticipantesCarrera(ArrayList<Participante> participantes) {
        ArrayList<String> participantesString = new ArrayList();
        for (Participante p : participantes){
            participantesString.add(formatearParticipante(p));
        }
        lstParticipantes.setListData(participantesString.toArray());
    }

    @Override
    public String formatearParticipante(Participante participante) {
        return "Nº" + participante.getNumero() + " - " + participante.getNombreCaballo() +
                " - Paga $" + participante.getDividendo() + " Total apuestas: $" 
                + participante.montoTotalApostado();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumero = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNumeroCarrera = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblMontoTotalApostado = new javax.swing.JLabel();
        txtMontoTotalApostado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipantes = new javax.swing.JList();
        btnCerrarApuestas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNumero.setText("Número");

        lblNombre.setText("Nombre");

        txtNumeroCarrera.setEditable(false);

        txtNombre.setEditable(false);

        lblMontoTotalApostado.setText("Monto Total Apostado");

        txtMontoTotalApostado.setEditable(false);

        jScrollPane1.setViewportView(lstParticipantes);

        btnCerrarApuestas.setText("Cerrar Apuestas");
        btnCerrarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarApuestasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMontoTotalApostado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrarApuestas)
                            .addComponent(txtMontoTotalApostado))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumeroCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoTotalApostado)
                    .addComponent(txtMontoTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCerrarApuestas)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarApuestasActionPerformed
        controlador.cerrarApuesta();
    }//GEN-LAST:event_btnCerrarApuestasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    @Override
    public void cerrar() {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarApuestas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMontoTotalApostado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JList lstParticipantes;
    private javax.swing.JTextField txtMontoTotalApostado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCarrera;
    // End of variables declaration//GEN-END:variables


   
}
