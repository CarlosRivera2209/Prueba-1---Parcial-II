/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package progra2;

import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private Tránsito tránsito;

    public Main() {
        initComponents();
        tránsito = new Tránsito();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BUSCAR_MULTA = new javax.swing.JButton();
        PAGAR_MULTA = new javax.swing.JButton();
        IMPRIMIR_MULTA = new javax.swing.JButton();
        CREAR_MULTA = new javax.swing.JButton();
        INFO = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BUSCAR_MULTA.setText("BUSCAR MULTA");
        BUSCAR_MULTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCAR_MULTAActionPerformed(evt);
            }
        });
        jPanel2.add(BUSCAR_MULTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 170, 30));

        PAGAR_MULTA.setText("PAGAR MULTA");
        PAGAR_MULTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAGAR_MULTAActionPerformed(evt);
            }
        });
        jPanel2.add(PAGAR_MULTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 170, 30));

        IMPRIMIR_MULTA.setText("IMPRIMIR MULTA");
        IMPRIMIR_MULTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPRIMIR_MULTAActionPerformed(evt);
            }
        });
        jPanel2.add(IMPRIMIR_MULTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 170, 30));

        CREAR_MULTA.setText("CREAR MULTA");
        CREAR_MULTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREAR_MULTAActionPerformed(evt);
            }
        });
        jPanel2.add(CREAR_MULTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 170, 30));

        INFO.setText("INFORMACION DE MULTAS");
        INFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INFOActionPerformed(evt);
            }
        });
        jPanel2.add(INFO, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 599, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUSCAR_MULTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCAR_MULTAActionPerformed
        String codigoStr = JOptionPane.showInputDialog("Ingrese el código de la multa:");
        if (codigoStr != null && !codigoStr.isEmpty()) {
            try {
                int codigo = Integer.parseInt(codigoStr);
                Multa multa = tránsito.buscarMulta(codigo);
                if (multa != null) {
                    JOptionPane.showMessageDialog(this, "Multa encontrada:\n" + multa.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Multa no encontrada.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un código válido (número entero).");
            }
        }
    }//GEN-LAST:event_BUSCAR_MULTAActionPerformed

    private void CREAR_MULTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREAR_MULTAActionPerformed
        String codigoStr = JOptionPane.showInputDialog("Ingrese el código de la multa:");

        if (codigoStr == null) {
            JOptionPane.showMessageDialog(this, "Creación de multa cancelada.");
            return;
        }

        if (!codigoStr.isEmpty()) {
            try {
                int codigo = Integer.parseInt(codigoStr);

                
                if (tránsito.existeCodigoMulta(codigo)) {
                    JOptionPane.showMessageDialog(this, "Ya existe una multa con ese código. Creación de multa cancelada.");
                    return;
                }

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del infractor:");

                if (nombre == null) {
                    JOptionPane.showMessageDialog(this, "Creación de multa cancelada.");
                    return;
                }

                if (!nombre.isEmpty()) {
                    String tipo = JOptionPane.showInputDialog("Ingrese el tipo de multa (LEVE, MEDIO, GRAVE):");

                    if (tipo == null) {
                        JOptionPane.showMessageDialog(this, "Creación de multa cancelada.");
                        return;
                    }

                    if (!tipo.isEmpty()) {

                        tipo = tipo.toUpperCase();

                        if (!tipo.equals("LEVE") && !tipo.equals("MEDIO") && !tipo.equals("GRAVE")) {
                            JOptionPane.showMessageDialog(this, "Tipo de multa inválido. Se establecerá como LEVE por defecto.");
                            tipo = "LEVE"; 
                        }

                        tránsito.agregarMulta(codigo, nombre, tipo);
                        JOptionPane.showMessageDialog(this, "Multa creada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe ingresar el tipo de multa.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del infractor.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un código válido (número entero).");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar al menos un número como código.");
        }
    }//GEN-LAST:event_CREAR_MULTAActionPerformed

    private void PAGAR_MULTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAGAR_MULTAActionPerformed
        String codigoStr = JOptionPane.showInputDialog("Ingrese el código de la multa a pagar:");
        if (codigoStr != null && !codigoStr.isEmpty()) {
            try {
                int codigo = Integer.parseInt(codigoStr);
                Multa multa = tránsito.buscarMulta(codigo);
                if (multa != null) {
                    if (!multa.estaPagada()) {
                        tránsito.pagarMulta(codigo);
                        JOptionPane.showMessageDialog(this, "Multa pagada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: La multa con código " + codigo + " ya ha sido pagada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error: La multa con código " + codigo + " no existe.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un código válido (número entero).");
            }
        }
    }//GEN-LAST:event_PAGAR_MULTAActionPerformed

    private void IMPRIMIR_MULTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMPRIMIR_MULTAActionPerformed
        StringBuilder mensaje = new StringBuilder();

        for (Multa multa : tránsito.getMultas()) {
            if (multa != null) {
                mensaje.append("Código: ").append(multa.getCodigo()).append("\n");
                mensaje.append("Nombre del infractor: ").append(multa.getNombreInfractor()).append("\n");
                mensaje.append("Tipo de multa: ").append(multa.getTipo()).append("\n");
                mensaje.append("Monto a pagar: Lps. ").append(multa.getMontoPagar()).append("\n");
                mensaje.append(multa.estaPagada() ? "Pagada por un monto de Lps. " + multa.getMontoPagar() : "Multa pendiente").append("\n");
                mensaje.append("------------------------------\n");
            }
        }

        if (mensaje.length() > 0) {
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Información de Multas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No hay multas registradas.", "Información de Multas", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_IMPRIMIR_MULTAActionPerformed

    private void INFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INFOActionPerformed
        StringBuilder mensaje = new StringBuilder();

        mensaje.append("Cantidad de Multas generadas: ").append(tránsito.getCantidadMultasGeneradas()).append("\n");

        mensaje.append("Cantidad de Multas Pagadas: ").append(tránsito.getCantidadMultasPagadas()).append("\n");
        mensaje.append("Monto total de Multas Pagadas: Lps. ").append(tránsito.getMontoTotalMultasPagadas()).append("\n");

        mensaje.append("Cantidad de Multas Pendientes: ").append(tránsito.getCantidadMultasPendientes()).append("\n");
        mensaje.append("Monto total de Multas Pendientes: Lps. ").append(tránsito.getMontoTotalMultasPendientes()).append("\n");

        JOptionPane.showMessageDialog(this, mensaje.toString(), "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_INFOActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSCAR_MULTA;
    private javax.swing.JButton CREAR_MULTA;
    private javax.swing.JButton IMPRIMIR_MULTA;
    private javax.swing.JButton INFO;
    private javax.swing.JButton PAGAR_MULTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
