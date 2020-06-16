/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorConsultarSaldo;
import controlador.ControladorRealizarApuestas;
import controlador.IVistaConsultarSaldo;
import controlador.IVistaRealizarApuestas;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ApuestasException;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Jugador;
import modelo.Participante;
import observer.Observable;
import observer.Observador;

/**
 *
 * @author Mauro
 */
public class IUJugador extends javax.swing.JFrame implements IVistaRealizarApuestas, IVistaConsultarSaldo {

    private ControladorRealizarApuestas controladorRealizarApuesta;
    private ControladorConsultarSaldo controladorConsultarSaldo;
    private Hipodromo hipSeleccionado = null;


    public IUJugador() {
        initComponents();
        controladorRealizarApuesta = new ControladorRealizarApuestas(this);
        controladorConsultarSaldo = new ControladorConsultarSaldo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCarrera = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstCaballo = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnConsultarSaldo = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstHipodromo = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("HIPÓDROMO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 150, 30);

        lstCarrera.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lstCarrera.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCarreraValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstCarrera);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(240, 110, 180, 160);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("CARRERA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 80, 150, 30);

        lstCaballo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lstCaballo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCaballoValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstCaballo);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(450, 110, 180, 160);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("CABALLO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(450, 80, 150, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("¡Bienvenido! Lo invitamos a efectuar su apuesta...");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 40, 600, 20);

        txtMonto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMonto);
        txtMonto.setBounds(330, 290, 100, 30);

        txtUsuario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(160, 370, 150, 30);

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(160, 410, 150, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Monto de la apuesta:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 290, 140, 30);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("$");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 290, 20, 30);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Usuario");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 370, 70, 30);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Contraseña");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 410, 70, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(50, 340, 560, 10);

        btnConsultarSaldo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnConsultarSaldo.setText("Consultar Saldo");
        btnConsultarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarSaldoActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultarSaldo);
        btnConsultarSaldo.setBounds(380, 410, 150, 30);

        btnConfirmar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnConfirmar.setText("Confirmar Apuesta");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(380, 370, 150, 30);

        lstHipodromo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lstHipodromo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstHipodromoValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstHipodromo);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(30, 110, 180, 160);

        setBounds(0, 0, 680, 505);
    }// </editor-fold>//GEN-END:initComponents

    private void lstCarreraValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCarreraValueChanged
        int index = lstCarrera.getSelectedIndex();
        controladorRealizarApuesta.seleccionarCarrera(index);
    }//GEN-LAST:event_lstCarreraValueChanged

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        btnConfirmarActionPerformed(evt);
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        btnConfirmarActionPerformed(evt);
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnConsultarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarSaldoActionPerformed
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());
        consultarSaldo(usuario, password);
        limpiarFormulario();
    }//GEN-LAST:event_btnConsultarSaldoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String nombre = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());
        controladorRealizarApuesta.agregarApuesta(nombre, pass, txtMonto.getText());
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void lstCaballoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCaballoValueChanged
        int index = lstHipodromo.getSelectedIndex();
        controladorRealizarApuesta.seleccionarCaballo(index);
    }//GEN-LAST:event_lstCaballoValueChanged

    private void lstHipodromoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstHipodromoValueChanged
        int index = lstHipodromo.getSelectedIndex();
        controladorRealizarApuesta.seleccionarHipodromo(index);
    }//GEN-LAST:event_lstHipodromoValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConsultarSaldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList lstCaballo;
    private javax.swing.JList lstCarrera;
    private javax.swing.JList lstHipodromo;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiarFormulario() {
        lstHipodromo.removeAll();
        lstCarrera.removeAll();
        lstCaballo.removeAll();
        txtMonto.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        controladorRealizarApuesta.cargarHipodromos();
    }

    @Override
    public void cargarHipodromos(ArrayList<Hipodromo> hipodromos) {
        ArrayList<String> lista = new ArrayList();
        if (hipodromos != null) {
            for (Hipodromo h : hipodromos) {
                lista.add(formatearHipodromos(h));
            }
        } else {
            lista.add("No existen hipódromos");
        }
        lstHipodromo.setListData(lista.toArray());
    }

    @Override
    public void cargarCarreras(ArrayList<Carrera> carreras) {
        ArrayList<String> lista = new ArrayList();
        if (carreras != null) {
            for (Carrera c : carreras) {
                lista.add(formatearCarreras(c));
            }
        } else {
            lista.add("No existen carreras hoy");
        }
        lstCarrera.setListData(lista.toArray());
    }

    @Override
    public void cargarParticipantes(ArrayList<Participante> participantes) {
        ArrayList<String> lista = new ArrayList();
        if (participantes != null) {
            for (Participante p : participantes) {
                lista.add(formatearParticipantes(p));
            }
        } else {
            lista.add("No existen participantes");
        }
        lstCaballo.setListData(lista.toArray());
    }

    
    @Override
    public void habilitarBotonApuesta(boolean habilitar) {
        btnConfirmar.setEnabled(habilitar);
    }

    
    
    //Formatos para las listas propias de esta vista.
    private String formatearHipodromos(Hipodromo hipodromo) {
        return hipodromo.getNombre() + " - " + hipodromo.getDireccion();
    }

    private String formatearCarreras(Carrera carrera) {
        return carrera.getNombre() + " - " + carrera.getEstado();
    }

    private String formatearParticipantes(Participante participante) {
        return participante.getNumero() + " - " + participante.getCaballo().getNombre() + " - " + participante.getDividendo();
    }

    @Override
    public void consultarSaldo(String usuario, String password) {
        controladorConsultarSaldo.consultarSaldo(usuario, password);
    }

    @Override
    public void mostrarVistaSaldo(Jugador jugador) {
        new VerSaldo(this, true, jugador).setVisible(true);
    }
    
    
}
