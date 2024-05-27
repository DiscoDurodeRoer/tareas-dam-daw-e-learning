package com.mycompany.prog11_tarea;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class App extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private ConexionMySQL conexion;

    public App() {
        initComponents();

        // inicialzo la conexion
        this.conexion = new ConexionMySQL("localhost", "3306", "constructora", "root", "123456");

        // limpio la tabla
        this.cleanTable();
        
        // inicializo los proyectos
        loadProjects();

    }

    private void loadProjects() {

        // elimino todos los elementos
        this.cmbProyectos.removeAllItems();

        try {
            // Obtengo los datos de los proyectos
            Object[][] projects = this.conexion.executeQuery("SELECT * FROM proyectos");

            if (projects.length > 0) {

                // relleno el combobox con dos columnas
                for (int i = 0; i < projects.length; i++) {
                    String[] columnas = new String[2];
                    columnas[0] = String.valueOf((Integer) projects[i][0]);
                    columnas[1] = (String) projects[i][1];
                    this.cmbProyectos.addItem(columnas);
                }

                // Hago que se muestre el valor que esta en la posicion 1
                this.cmbProyectos.setRenderer(new DefaultListCellRenderer() {
                    @Override
                    public java.awt.Component getListCellRendererComponent(
                            JList l, Object o, int i, boolean s, boolean f) {
                        return new JLabel(((String[]) o)[1]);
                    }
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cleanTable() {

        // Inicializo y hago la tabla no editable
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Columnas
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRESUPUESTO");

        // Asocio la tabla con su modelo
        this.tblFases.setModel(modelo);

    }

    private void loadPhases(String idProject) {

        if (idProject != null) {

            try {
                // Obtengo las fases del proyecto
                Object[][] phases = this.conexion.executeQuery("SELECT ID,DESCRIPCION,PRESUPUESTO FROM fases WHERE idproyecto = " + idProject);

                // limpio la tabla
                cleanTable();

                // relleno las filas
                for (int i = 0; i < phases.length; i++) {
                    Object[] row = new Object[3];
                    for (int j = 0; j < phases[0].length; j++) {
                        row[j] = phases[i][j];
                    }
                    modelo.addRow(row);
                }

            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private String getIdProject() {

        // obtengo los valores del combobox
        String[] values = (String[]) this.cmbProyectos.getSelectedItem();
        if (values != null) {
            // recojo el valor 0, que es el id
            return values[0];
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbProyectos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFases = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnModifyBudget = new javax.swing.JButton();
        btnDeleteProject = new javax.swing.JButton();
        btnInsertProject = new javax.swing.JButton();
        btnInsertPhase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbProyectos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProyectosItemStateChanged(evt);
            }
        });
        cmbProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProyectosActionPerformed(evt);
            }
        });

        tblFases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblFases);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Proyectos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Fases");

        btnModifyBudget.setText("Modificar presupuesto");
        btnModifyBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyBudgetActionPerformed(evt);
            }
        });

        btnDeleteProject.setText("Borrar proyecto");
        btnDeleteProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProjectActionPerformed(evt);
            }
        });

        btnInsertProject.setText("Insertar proyecto");
        btnInsertProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertProjectActionPerformed(evt);
            }
        });

        btnInsertPhase.setText("Insertar fase");
        btnInsertPhase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertPhaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cmbProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInsertPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertProject, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifyBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(208, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnModifyBudget)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteProject)
                .addGap(18, 18, 18)
                .addComponent(btnInsertProject)
                .addGap(18, 18, 18)
                .addComponent(btnInsertPhase)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(126, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(64, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProyectosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProyectosItemStateChanged

        String idProject = getIdProject();

        loadPhases(idProject);


    }//GEN-LAST:event_cmbProyectosItemStateChanged

    private void cmbProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProyectosActionPerformed

    }//GEN-LAST:event_cmbProyectosActionPerformed

    private void btnModifyBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyBudgetActionPerformed

        // Compruebo si la fila ha sido seleccionada
        int rowSelected = this.tblFases.getSelectedRow();
        if (rowSelected != -1) {

            // Obtengo el id de la tabla
            int id = (int) this.tblFases.getValueAt(rowSelected, 0);

            // pido un valor
            String dato = JOptionPane.showInputDialog(
                    this,
                    "Introduce un presupuesto",
                    "",
                    JOptionPane.QUESTION_MESSAGE);

            if (dato != null) {

                try {
                    int budget = Integer.parseInt(dato);

                    // modifico el presupuesto
                    int rows = this.conexion.executeInstruction("UPDATE fases SET presupuesto = " + budget + " WHERE id = " + id);

                    if (rows > 0) {
                        // modifico el valor en la tabla
                        this.tblFases.setValueAt(budget, rowSelected, 2);

                        JOptionPane.showMessageDialog(
                                this,
                                "Fase modificada",
                                "Exito",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Debe tener formato de numero",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Debes seleccionar una fila",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnModifyBudgetActionPerformed

    private void btnDeleteProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProjectActionPerformed

        // Mensaje de confirmacion
        int option = JOptionPane.showConfirmDialog(
                this,
                "¿Estas seguro de querer borrar el proyecto y sus fases?",
                "",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            String idProject = getIdProject();

            if (idProject != null) {
                try {

                    // Como la tabla inicialmente no tenia el borrado en cascada, nos obliga a hacerlo de esta forma
                    int rowsPhases = this.conexion.executeInstruction("DELETE FROM fases WHERE idProyecto = " + idProject);
                    int rowsProject = this.conexion.executeInstruction("DELETE FROM proyectos WHERE id = " + idProject);

                    if ((rowsPhases + rowsProject) > 0) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Proyecto eliminado",
                                "Exito",
                                JOptionPane.INFORMATION_MESSAGE);
                        this.loadProjects();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }


    }//GEN-LAST:event_btnDeleteProjectActionPerformed

    private void btnInsertProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertProjectActionPerformed

        // Pido el nombre del proyecto
        String nameProject = JOptionPane.showInputDialog(
                this,
                "Introduce el nombre de un proyecto",
                "",
                JOptionPane.QUESTION_MESSAGE);

        if (nameProject != null) {

            try {

                // Obtengo el ultimo id
                Object[][] count = this.conexion.executeQuery("SELECT COUNT(*) + 1 FROM proyectos");

                Long nextId = (Long) count[0][0];

                // Inserto el proyecto
                int rows = this.conexion.executeInstruction("INSERT INTO proyectos VALUES(" + nextId + ", '" + nameProject + "')");

                if (rows > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Proyecto añadido",
                            "Exito",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.loadProjects();
                }

            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btnInsertProjectActionPerformed

    private void btnInsertPhaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertPhaseActionPerformed

        // Creo el dialogo
        DialogPhase dialogo = new DialogPhase(this, true);
        // Muestro la ventana
        dialogo.setVisible(true);

        // Indico si hemos pulsado en guardar
        if (dialogo.isSaveSuccess()) {

            try {
                // Obtenemos los datos
                String idProject = getIdProject();
                String desc = dialogo.getDesc();
                int budget = dialogo.getBudget();

                // Inserta una fase
                int rows = this.conexion.executeInstruction("INSERT INTO fases VALUES(null, '" + desc + "', " + budget + ", " + idProject + ")");

                if (rows > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Fase añadida",
                            "Exito",
                            JOptionPane.INFORMATION_MESSAGE);
                    loadPhases(idProject);

                }
            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btnInsertPhaseActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JButton btnInsertPhase;
    private javax.swing.JButton btnInsertProject;
    private javax.swing.JButton btnModifyBudget;
    private javax.swing.JComboBox<String[]> cmbProyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFases;
    // End of variables declaration//GEN-END:variables
}
