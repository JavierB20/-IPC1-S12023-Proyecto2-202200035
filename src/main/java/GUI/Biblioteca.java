/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Class.Categoria;
import Class.Imagen;
import Class.VariablesGlobales;
import Estructuras.ListaDoble;
import Estructuras.NodoImagen;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Javier
 */
public class Biblioteca extends javax.swing.JFrame {
    /**
     * Creates new form Biblioteca
     */
    public Biblioteca() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Biblioteca");
        jlUsuario.setText(VariablesGlobales.usuarioActual);
        
        boolean usuarioEncontrado = false;
            for (Categoria categoria : VariablesGlobales.categorias) {
                if (categoria.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                    usuarioEncontrado = true;
                    break;
                }
            }
            
        if (usuarioEncontrado) {
            // Validar si ya existe la categoría "General" para el usuario actual
            boolean categoriaGeneralExiste = Categoria.existeCategoriaGeneral();

            // Agregar la categoría "General" si no existe
            if (!categoriaGeneralExiste) {
                Categoria categoriaGeneral = new Categoria(VariablesGlobales.usuarioActual, "General", VariablesGlobales.listaDoble);
                VariablesGlobales.categorias.add(categoriaGeneral);
            }

            //Mostar los datos en el Jlist
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            for (Categoria c : VariablesGlobales.categorias) {
                if (c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                    modeloLista.addElement(c.getCategoria());
                }
            }
            lstCategorias.setModel(modeloLista);
        }   
            
        if (usuarioEncontrado) {
            DefaultListModel<String> modeloLista = new DefaultListModel<>();

            for (Categoria c : VariablesGlobales.categorias) {
                if(c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                    modeloLista.addElement(c.getCategoria());

                }
            }
            lstCategorias.setModel(modeloLista);
        }
        
        //Cargar la listaDoble de las categorias
        lstCategorias.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener el elemento seleccionado actualmente
                    VariablesGlobales.listaDoble = null;
                    String elementoSeleccionado = lstCategorias.getSelectedValue();
                    System.out.println("El elemento seleccionado es: " + elementoSeleccionado);
                    cbImagen.removeAllItems();
                    // Hacer algo con el elemento seleccionado
                    for (int i = 0; i < VariablesGlobales.categorias.size(); i++) {
                        Categoria c = VariablesGlobales.categorias.get(i);
                        if (c.getCategoria().equals(elementoSeleccionado) && c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                            if(c.getListaDoble() != null) {
                                ListaDoble listaDoble  = c.getListaDoble();
                                VariablesGlobales.listaDoble = listaDoble;
                                Icon urlImg = (Icon) VariablesGlobales.listaDoble.getInicio();

                                if(urlImg != null) {
                                    jlImg.setIcon(urlImg);
                                    
                                    NodoImagen actual = listaDoble.getPrimero();
                                    while (actual != null) {
                                        cbImagen.addItem(actual.getImagen().getNombre().toString());
                                        actual = actual.getSiguiente();
                                    }
                                }
                            }

                        }
                        System.out.println(VariablesGlobales.categorias.get(i).getCategoria());
                        System.out.println(VariablesGlobales.categorias.get(i).getUsuario());
                        System.out.println(VariablesGlobales.categorias.get(i).getListaDoble());
                    } 
                    
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarImagen = new javax.swing.JButton();
        btnEliminarImagen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        jlUsuario = new javax.swing.JLabel();
        cbImagen = new javax.swing.JComboBox<>();
        btnCategoriaAgregar = new javax.swing.JButton();
        btnCategoriaElimnar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnImagenAnterior = new javax.swing.JButton();
        btnImagenSiguiente = new javax.swing.JButton();
        jlImg = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(28, 83, 131));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categorias");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 22, 100, 20));

        btnAgregarImagen.setText("Agregar Imagen");
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 18, -1, -1));

        btnEliminarImagen.setText("Eliminar Imagen");
        btnEliminarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 18, -1, -1));

        lstCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "General" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstCategorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 60, 94, 391));

        jlUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuario.setText("lbUsuario");
        jPanel1.add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 20, 110, -1));

        cbImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImagenActionPerformed(evt);
            }
        });
        jPanel1.add(cbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 610, -1));

        btnCategoriaAgregar.setText("Agregar Categoria");
        btnCategoriaAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCategoriaAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 488, 160, -1));

        btnCategoriaElimnar.setText("Eliminar Categoria");
        btnCategoriaElimnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaElimnarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCategoriaElimnar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 150, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 80, -1));

        btnImagenAnterior.setText("A");
        btnImagenAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenAnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagenAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 40, 46));

        btnImagenSiguiente.setText(">");
        btnImagenSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagenSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 40, 45));

        jlImg.setToolTipText("");
        jPanel1.add(jlImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 600, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        String categoriaSeleccionada = lstCategorias.getSelectedValue();
        if (categoriaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría para agregar una imagen.");
        } 
        else {
            categoriaSeleccionada = categoriaSeleccionada.toString();
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Seleccione una imagen");
            chooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen","jpg","bmp"));

            int resultado = chooser.showOpenDialog(this);
            ListaDoble listaDoble = new ListaDoble();
            
            for (int i = 0; i < VariablesGlobales.categorias.size(); i++) {
                Categoria c = VariablesGlobales.categorias.get(i);
                if (c.getCategoria().equals(categoriaSeleccionada) && c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                    if(c.getListaDoble() != null) {
                        if(resultado == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = chooser.getSelectedFile();
                        String fileName = selectedFile.getName(); 
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                        
                        jlImg.setIcon(imageIcon);

                        Imagen imagen = new Imagen(imageIcon, fileName);
                        listaDoble = c.getListaDoble();

                        listaDoble.add(imagen);
                        listaDoble.imprimir();
                        
                        //Codigo Provisional
                        VariablesGlobales.listaDoble = listaDoble;
                        }
                    }
                    else {
                        if(resultado == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = chooser.getSelectedFile();
                        String fileName = selectedFile.getName(); 
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                        jlImg.setIcon(imageIcon);

                        Imagen imagen = new Imagen(imageIcon, fileName);
                        

                        listaDoble.add(imagen);
                        listaDoble.imprimir();
                        }
                    }
                                        // Se encontró el objeto Categoria, agregar la imagen a la lista de imágenes
                    Categoria categoria = new Categoria(VariablesGlobales.usuarioActual, categoriaSeleccionada, listaDoble);
                    VariablesGlobales.categorias.set(i, categoria);
                    System.out.println(VariablesGlobales.categorias.get(i).getCategoria());
                    System.out.println(VariablesGlobales.categorias.get(i).getUsuario());
                    System.out.println(VariablesGlobales.categorias.get(i).getListaDoble());
                    break;
                }   
            }
        }
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void btnCategoriaAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaAgregarActionPerformed
        String categoriaIngresada = JOptionPane.showInputDialog(this, "Ingresa una Categoria:");
        ListaDoble listaDoble = new ListaDoble();
        
        Categoria categoria = new Categoria(VariablesGlobales.usuarioActual, categoriaIngresada, listaDoble);
        
        VariablesGlobales.categorias.add(categoria);
                
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (Categoria c : VariablesGlobales.categorias) {
            if(c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                modeloLista.addElement(c.getCategoria());

            }
        }
        lstCategorias.setModel(modeloLista);
        VariablesGlobales.listaDoble.imprimir();
    }//GEN-LAST:event_btnCategoriaAgregarActionPerformed

    private void btnCategoriaElimnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaElimnarActionPerformed
        String categoriaIngresada = lstCategorias.getSelectedValue().toString();
        boolean categoriaEliminada  = false;
        
        // Recorrer el LinkedList y encontrar el objeto Categoria que tenga la categoria y nombre ingresados
        for (int i = 0; i < VariablesGlobales.categorias.size(); i++) {
            Categoria c = VariablesGlobales.categorias.get(i);
            if (c.getCategoria().equals(categoriaIngresada) && c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                // Se encontró el objeto Categoria, eliminarlo del LinkedList
                VariablesGlobales.categorias.remove(i);
                categoriaEliminada = true;
                break;
            }
        }
        
        if (categoriaEliminada) {
            // Mostrar mensaje de éxito
            DefaultListModel<String> modeloLista = new DefaultListModel<>();

            for (Categoria c : VariablesGlobales.categorias) {
                if(c.getUsuario().equals(VariablesGlobales.usuarioActual)) {
                    modeloLista.addElement(c.getCategoria());

                }
            }
            lstCategorias.setModel(modeloLista);

            JOptionPane.showMessageDialog(null, "La categoría " + categoriaIngresada + " ha sido eliminada.");
            
        } else {
            // Mostrar mensaje de error si no se encontró el objeto Categoria
            JOptionPane.showMessageDialog(null, "La categoría " + categoriaIngresada + " no existe.");
        }
    }//GEN-LAST:event_btnCategoriaElimnarActionPerformed

    private void btnEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarImagenActionPerformed
        // Obtener el Icon del JLabel
        Icon icono = jlImg.getIcon();

        // Obtener la imagen del Icon
        ImageIcon imagenIcono = (ImageIcon) icono;
        Image imagen = imagenIcono.getImage();

        // Convertir la imagen en un File y obtener su nombre
        File archivoImagen = new File(imagenIcono.getDescription());
        String nombreImagen = archivoImagen.getName();
        
        VariablesGlobales.listaDoble.delete(nombreImagen);
        VariablesGlobales.listaDoble.imprimir();
    }//GEN-LAST:event_btnEliminarImagenActionPerformed

    private void btnImagenAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenAnteriorActionPerformed
        // Obtener el Icon del JLabel
        Icon icono = jlImg.getIcon();

        // Obtener la imagen del Icon
        ImageIcon imagenIcono = (ImageIcon) icono;

        // Convertir la imagen en un File y obtener su nombre
        File archivoImagen = new File(imagenIcono.getDescription());
        VariablesGlobales.imagenActual = archivoImagen.getName();

        Icon urlImg = (Icon) VariablesGlobales.listaDoble.getBefore();
        
        if(urlImg != null) {
            jlImg.setIcon(urlImg);
        }

    }//GEN-LAST:event_btnImagenAnteriorActionPerformed

    private void btnImagenSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenSiguienteActionPerformed
        // Obtener el Icon del JLabel
        Icon icono = jlImg.getIcon();

        // Obtener la imagen del Icon
        ImageIcon imagenIcono = (ImageIcon) icono;

        // Convertir la imagen en un File y obtener su nombre
        File archivoImagen = new File(imagenIcono.getDescription());
        VariablesGlobales.imagenActual = archivoImagen.getName();

        Icon urlImg = (Icon) VariablesGlobales.listaDoble.getNext();
        
        if(urlImg != null) {
            jlImg.setIcon(urlImg);
        }
    }//GEN-LAST:event_btnImagenSiguienteActionPerformed

    private void cbImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbImagenActionPerformed

    }//GEN-LAST:event_cbImagenActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnCategoriaAgregar;
    private javax.swing.JButton btnCategoriaElimnar;
    private javax.swing.JButton btnEliminarImagen;
    private javax.swing.JButton btnImagenAnterior;
    private javax.swing.JButton btnImagenSiguiente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbImagen;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlImg;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JList<String> lstCategorias;
    // End of variables declaration//GEN-END:variables
}
