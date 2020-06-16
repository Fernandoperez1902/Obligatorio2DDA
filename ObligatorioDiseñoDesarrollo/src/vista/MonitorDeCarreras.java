package vista;

import controlador.ControladorMonitorDeCarrera;
import controlador.IVistaMonitorDeCarrera;
import java.util.ArrayList;
import java.util.Date;
import modelo.Administrador;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

public class MonitorDeCarreras extends javax.swing.JFrame implements IVistaMonitorDeCarrera {

    private ControladorMonitorDeCarrera controlador;

    public MonitorDeCarreras(Hipodromo unHipodromo) {
        initComponents();
        controlador = new ControladorMonitorDeCarrera(this, unHipodromo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstApuestas = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCarreras = new javax.swing.JList();
        btnCargar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstParticipantes = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        lblUno = new javax.swing.JLabel();
        lblDos = new javax.swing.JLabel();
        lblTres = new javax.swing.JLabel();
        lblCuatro = new javax.swing.JLabel();
        lblCinco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(dateChooser);
        dateChooser.setBounds(30, 20, 170, 30);

        lstApuestas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(lstApuestas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 220, 200, 130);

        lstCarreras.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lstCarreras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCarrerasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstCarreras);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 70, 170, 130);

        btnCargar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnCargar.setText("Cargar Carreras");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargar);
        btnCargar.setBounds(220, 20, 140, 30);

        lstParticipantes.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(lstParticipantes);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(220, 70, 200, 130);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INFO DE CARRERA"));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lblUno.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lblDos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lblTres.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lblCuatro.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        lblCinco.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(lblTres, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(lblCuatro, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(lblCinco, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblUno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTres, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 220, 170, 130);

        setBounds(0, 0, 471, 419);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        Date fecha = dateChooser.getDate();   
        controlador.cargarCarreras(fecha);
    }//GEN-LAST:event_btnCargarActionPerformed

    private void lstCarrerasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCarrerasValueChanged
        int index = lstCarreras.getSelectedIndex();
        controlador.seleccionarCarrera(index);
    }//GEN-LAST:event_lstCarrerasValueChanged

    @Override
    public void cargarCarreras(ArrayList<Carrera> carreras) {
        ArrayList<String> lista = new ArrayList();
        if (carreras != null) {
            for (Carrera c : carreras) {
                lista.add(formatearCarrera(c));
            }
        }else{
            lista.add("No hay carreras ingresadas");
        }
        lstCarreras.setListData(lista.toArray());
    }

    //Formatos para las listas propias de esta vista.
    private String formatearCarrera(Carrera carrera) {
        return carrera.getNumeroCarrera() + " - " + carrera.getEstado() + " - " + carrera.getNombre();
    }

    private String formatearApuesta(Apuesta apuesta) {
        return apuesta.getJugador().getNombreCompleto();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCinco;
    private javax.swing.JLabel lblCuatro;
    private javax.swing.JLabel lblDos;
    private javax.swing.JLabel lblTres;
    private javax.swing.JLabel lblUno;
    private javax.swing.JList lstApuestas;
    private javax.swing.JList lstCarreras;
    private javax.swing.JList lstParticipantes;
    // End of variables declaration//GEN-END:variables


    @Override
    public void mostrarDetalle(Carrera carreraSeleccionada) {
        lblUno.setText("N° " + carreraSeleccionada.getNumeroCarrera() + " - " + carreraSeleccionada.getNombre());
        lblDos.setText("Estado: " + carreraSeleccionada.getEstado());
        lblTres.setText("Participantes: " + carreraSeleccionada.cantidadParticipantes());
        lblCuatro.setText("Monto Apostado: $ " + carreraSeleccionada.montoApostado());
        lblCinco.setText("Monto Pagado: $ " + carreraSeleccionada.montoPagado());
    }

    @Override
    public void mostrarParticipantes(ArrayList<Participante> participantes) {
        ArrayList<String> lista = new ArrayList();
        if (participantes != null) {
            for (Participante p : participantes) {
                lista.add(formatearParticipante(p));
            }
        } else {
            lista.add("No existen participantes");
        }
        lstParticipantes.setListData(lista.toArray());
    }

    private String formatearParticipante(Participante participante) {
        String ganador = "";
        if (participante.isGanador()) {
            ganador = " * GANADOR";
        }
        return participante.getNumero() + " - " + participante.getCaballo().getNombre() + " - " + participante.getDividendo() + ganador;
    }

    @Override
    public void mostrarDetalleApuestasGanadoras(ArrayList<Apuesta> apuestas) {
        ArrayList<String> lista = new ArrayList();
        if (apuestas != null) {
            for (Apuesta a : apuestas) {
                lista.add(formatearApuesta(a));
            }
            if(apuestas.size() == 0){
                lista.add("Ganador sin apuestas");
            }
        } else {
            lista.add("Carrera no finalizada");
        }
        lstApuestas.setListData(lista.toArray());

    }
}
