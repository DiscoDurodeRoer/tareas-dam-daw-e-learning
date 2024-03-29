package es.discoduroderoer.prog07_tarea;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CalcGUIApp extends javax.swing.JFrame {

    private int resultado;
    private boolean limpiarTexto;
    private boolean sePuedeCalcular;
    private boolean primerOperando;
    private char ultimoOperando;

    public CalcGUIApp() {
        initComponents();
        this.resultado = 0;
        this.limpiarTexto = true;
        this.sePuedeCalcular = false;
        this.primerOperando = true;
        this.setIconImage(new ImageIcon("calculadora.png").getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnIgual = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtResultado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");

        btn0.setText("0");
        btn0.setToolTipText("Boton 0");
        btn0.setPreferredSize(new java.awt.Dimension(80, 30));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel1.add(btn0);

        btn1.setText("1");
        btn1.setToolTipText("Boton 1");
        btn1.setPreferredSize(new java.awt.Dimension(80, 30));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1);

        btn2.setText("2");
        btn2.setToolTipText("Boton 2");
        btn2.setPreferredSize(new java.awt.Dimension(80, 30));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2);

        btn3.setText("3");
        btn3.setToolTipText("Boton 3");
        btn3.setPreferredSize(new java.awt.Dimension(80, 30));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3);

        btn4.setText("4");
        btn4.setToolTipText("Boton 4");
        btn4.setPreferredSize(new java.awt.Dimension(80, 30));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4);

        btn5.setText("5");
        btn5.setToolTipText("Boton 5");
        btn5.setPreferredSize(new java.awt.Dimension(80, 30));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5);

        btn6.setText("6");
        btn6.setToolTipText("Boton 6");
        btn6.setPreferredSize(new java.awt.Dimension(80, 30));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6);

        btn7.setText("7");
        btn7.setToolTipText("Boton 7");
        btn7.setPreferredSize(new java.awt.Dimension(80, 30));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7);

        btn8.setText("8");
        btn8.setToolTipText("Boton 8");
        btn8.setPreferredSize(new java.awt.Dimension(80, 30));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8);

        btn9.setText("9");
        btn9.setToolTipText("Boton 9");
        btn9.setPreferredSize(new java.awt.Dimension(80, 30));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn9);

        btnPlus.setText("+");
        btnPlus.setToolTipText("Boton +");
        btnPlus.setPreferredSize(new java.awt.Dimension(80, 30));
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlus);

        btnMinus.setText("-");
        btnMinus.setToolTipText("Boton -");
        btnMinus.setPreferredSize(new java.awt.Dimension(80, 30));
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinus);

        btnMult.setText("X");
        btnMult.setToolTipText("Boton x");
        btnMult.setPreferredSize(new java.awt.Dimension(80, 30));
        btnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultActionPerformed(evt);
            }
        });
        jPanel1.add(btnMult);

        btnDiv.setText("/");
        btnDiv.setToolTipText("Boton /");
        btnDiv.setPreferredSize(new java.awt.Dimension(80, 30));
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });
        jPanel1.add(btnDiv);

        btnIgual.setText("=");
        btnIgual.setToolTipText("Boton =");
        btnIgual.setPreferredSize(new java.awt.Dimension(80, 30));
        btnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualActionPerformed(evt);
            }
        });
        jPanel1.add(btnIgual);

        jPanel2.setLayout(new java.awt.BorderLayout());

        txtResultado.setEditable(false);
        txtResultado.setBackground(new java.awt.Color(255, 255, 255));
        txtResultado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtResultado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtResultado.setText("0");
        txtResultado.setToolTipText("Caja de resultado");
        jPanel2.add(txtResultado, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed

        if (!this.txtResultado.getText().equals("0")) {

            if (this.limpiarTexto) {
                this.txtResultado.setText("0");
                this.limpiarTexto = false;
            } else {
                this.txtResultado.setText(this.txtResultado.getText() + "0");
            }
            this.sePuedeCalcular = true;

        }

    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("1");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "1");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("2");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "2");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("3");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "3");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("4");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "4");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("5");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "5");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("6");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "6");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("7");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "7");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("8");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "8");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (this.limpiarTexto) {
            this.txtResultado.setText("9");
            this.limpiarTexto = false;
        } else {
            this.txtResultado.setText(this.txtResultado.getText() + "9");
        }
        this.sePuedeCalcular = true;

    }//GEN-LAST:event_btn9ActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed

        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResultado.getText());
            } else {
                this.resultado += Integer.parseInt(this.txtResultado.getText());
            }
            this.txtResultado.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        }
        this.ultimoOperando = '+';

    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResultado.getText());
            } else {
                this.resultado -= Integer.parseInt(this.txtResultado.getText());
            }
            this.txtResultado.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        } else if (this.primerOperando) {
            this.txtResultado.setText("-");
            this.limpiarTexto = false;
        }
        this.ultimoOperando = '-';
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultActionPerformed
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResultado.getText());
            } else {
                this.resultado *= Integer.parseInt(this.txtResultado.getText());
            }
            this.txtResultado.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        }
        this.ultimoOperando = '*';
    }//GEN-LAST:event_btnMultActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        if (this.sePuedeCalcular) {
            if (this.primerOperando) {
                this.resultado = Integer.parseInt(this.txtResultado.getText());
            } else {
                if(this.txtResultado.getText().equals("0")){
                    JOptionPane.showMessageDialog(this, "No se puede dividir entre 0");
                }else{
                    this.resultado /= Integer.parseInt(this.txtResultado.getText());
                }
            }
            this.txtResultado.setText(this.resultado + "");
            this.primerOperando = false;
            this.limpiarTexto = true;
            this.sePuedeCalcular = false;
        }
        this.ultimoOperando = '/';
    }//GEN-LAST:event_btnDivActionPerformed

    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed

        switch (this.ultimoOperando) {
            case '+':
                this.btnPlusActionPerformed(evt);
                break;
            case '-':
                this.btnMinusActionPerformed(evt);
                break;
            case '*':
                this.btnMultActionPerformed(evt);
                break;
            case '/':
                this.btnDivActionPerformed(evt);
                break;
        }


    }//GEN-LAST:event_btnIgualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(CalcGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcGUIApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnIgual;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMult;
    private javax.swing.JButton btnPlus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
