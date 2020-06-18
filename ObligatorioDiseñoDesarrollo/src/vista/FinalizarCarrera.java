package vista;

import controlador.ControladorFinalizarCarrera;
import controlador.IVistaFinalizarCarrera;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

public class FinalizarCarrera extends javax.swing.JFrame implements IVistaFinalizarCarrera {

    private ControladorFinalizarCarrera controlador;

    public FinalizarCarrera(Hipodromo seleccionado) {
        initComponents();
        controlador = new ControladorFinalizarCarrera(seleccionado, this);
    }

    @Override
    public void mostrarCarrera(Carrera carrera) {

        txtNumero.setText(Integer.toString(carrera.getNumeroCarrera()));
        txtNombre.setText(carrera.getNombre());
        txtMontoTotalApostado.setText(Float.toString(carrera.montoTotalApostado()));
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
        return "Nº" + participante.getNumero() + " - " + participante.getNombreCaballo()
                + " - Paga $" + participante.getDividendo() + " Total apuestas: $"
                + participante.montoTotalApostado();
    }

    @Override
    public void mostrarGanador(Participante participante) {
        txtGanador.setText(participante.getNombreCaballo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblMontoTotal = new javax.swing.JLabel();
        txtMontoTotalApostado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParticipantes = new javax.swing.JList();
        btnFinalizar = new javax.swing.JButton();
        txtGanador = new javax.swing.JTextField();
        lblGanador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(385, 285));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nº");

        txtNumero.setEditable(false);

        lblNombre.setText("Nombre");

        txtNombre.setEditable(false);

        lblMontoTotal.setText("Monto Total Apostado");

        txtMontoTotalApostado.setEditable(false);

        lstParticipantes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstParticipantesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstParticipantes);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        txtGanador.setEditable(false);

        lblGanador.setText("Ganador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMontoTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(lblNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNombre))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGanador)
                    .addComponent(txtGanador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoTotal)
                    .addComponent(txtMontoTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFinalizar)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        setBounds(0, 0, 402, 391);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        controlador.FinalizarCarrera();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void lstParticipantesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstParticipantesValueChanged
        controlador.seleccionarGanador(lstParticipantes.getSelectedIndex());
    }//GEN-LAST:event_lstParticipantesValueChanged

    @Override
    public void cerrar() {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGanador;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList lstParticipantes;
    private javax.swing.JTextField txtGanador;
    private javax.swing.JTextField txtMontoTotalApostado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

}
