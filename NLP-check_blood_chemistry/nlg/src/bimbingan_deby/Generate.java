/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bimbingan_deby;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;

import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class Generate extends javax.swing.JFrame {

    String defaultURL = "D:\\bimbingan\\2017\\usu\\deby\\data 1\\DATA_PASIEN";

    ReadWord readWord = new ReadWord();

    public static int count_gen = 0;
    public static String urlTemp = "";

    /**
     * Creates new form Generate
     */
    public Generate() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        labelURL = new javax.swing.JLabel();
        buttonPilihFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jeData = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        labelURL.setText("...");

        buttonPilihFile.setText("Pilih File");
        buttonPilihFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPilihFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPilihFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPilihFile)
                    .addComponent(labelURL))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jeData);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(630, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPilihFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPilihFileActionPerformed

        count_gen++;

        clean();
        JFileChooser jfc = new JFileChooser(defaultURL);
        jfc.showOpenDialog(null);
        File file = jfc.getSelectedFile();

        String url = file.getAbsolutePath();
        labelURL.setText(url);
        tampilkanKonten(url);

        ArrayList<HasilCek> hasil = new ArrayList<>();

        ReadWord readWord = new ReadWord();
        hasil = readWord.read(url);

        tampil_generate(hasil);


    }//GEN-LAST:event_buttonPilihFileActionPerformed

    Proses p = new Proses();

    public void tampil_generate(ArrayList<HasilCek> hasil) {

        for (int i = 0; i < hasil.size(); i++) {
//            System.out.println(hasil.get(i).getHasil() + " " + hasil.get(i).getField() + " " + hasil.get(i).getTraction());

            System.out.println("\n\n\n===============================================\n" + hasil.get(i).getField().replace("_", " ") + "\n===============================================");

            ReadFile readFile = new ReadFile();

            String isiKorpus = readFile.getContent("korpus.txt");

            p.proses(isiKorpus, hasil.get(i).getField().replace("_", " "), hasil.get(i).getTraction());
        }

    }

    public void clean() {
        jeData.setText("");
    }

    public void tampilkanKonten(String url) {

        try {

            // 1) Load DOCX into XWPFDocument
            InputStream is = new FileInputStream(new File(url));
            XWPFDocument document = new XWPFDocument(is);

            // 2) Prepare Html options
            XHTMLOptions options = XHTMLOptions.create();

            if (count_gen % 2 == 1) {
                urlTemp = "src/temp1.html";
                File f2 = new File("src//temp2.html");
                if (f2.exists()) {
                    f2.delete();
                }

            } else {
                urlTemp = "src/temp2.html";
                File f2 = new File("src//data1.html");
                if (f2.exists()) {
                    f2.delete();
                }

            }
            // 3) Convert XWPFDocument to HTML
            OutputStream out = new FileOutputStream(new File(urlTemp));
            XHTMLConverter.getInstance().convert(document, out, options);

            is.close();
            out.close();

            File f2 = new File(urlTemp);
            jeData.setPage(f2.toURL());
            jeData.setEditable(false);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(Generate.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generate.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generate.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generate.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Generate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPilihFile;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JEditorPane jeData;
    private javax.swing.JLabel labelURL;
    // End of variables declaration//GEN-END:variables
}
