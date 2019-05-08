package semhas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bimbingan_deby;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.aspose.words.examples.quickstart.LoadAndSaveToDisk;

public class Generate extends javax.swing.JFrame {

	String defaultURL = "D:\\bimbingan\\2017\\usu\\deby\\data 1\\DATA_PASIEN";
	String KalimatAkhir;
	ReadWord readWord = new ReadWord();
	Proses p =new Proses();
	String Path="",klmt="";
	JFileChooser jfc;
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
		jButton1 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jeData = new javax.swing.JEditorPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jMenuBar1 = new javax.swing.JMenuBar();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel3.setBackground(new java.awt.Color(204, 204, 255));

		labelURL.setBackground(new java.awt.Color(204, 204, 204));
		labelURL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelURL.setText("...");
		labelURL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		buttonPilihFile.setText("Pilih File");
		buttonPilihFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonPilihFileActionPerformed(evt);
			}
		});

		jButton1.setText("Proses");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(labelURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonPilihFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(21, 21, 21))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap(23, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonPilihFile)
								.addComponent(labelURL))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton1)
						.addContainerGap())
				);

		jScrollPane2.setViewportView(jeData);

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jScrollPane1.setViewportView(jTextArea1);
		jTextArea1.getAccessibleContext().setAccessibleName("");

		jButton2.setText("jButton2");

		jButton3.setText("jButton3");

		jButton4.setForeground(new java.awt.Color(0, 51, 204));
		jButton4.setText("Lihat dalam PDF");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton4ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}}				);

		jButton5.setBackground(javax.swing.UIManager.getDefaults().getColor("ToolBar.dockingForeground"));
		jButton5.setForeground(new java.awt.Color(255, 0, 0));
		jButton5.setText("Reset");
		jButton5.setBorderPainted(false);
		jButton5.setOpaque(false);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jTextField1.setEditable(false);
		jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextField1.setText("INTERPRETASI NARATIF");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(15, 15, 15)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
														.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(39, 39, 39))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addComponent(jScrollPane1)
														.addContainerGap())))
								.addGroup(layout.createSequentialGroup()
										.addGap(66, 66, 66)
										.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(64, 64, 64))))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGap(22, 22, 22)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(34, 34, 34)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void buttonPilihFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPilihFileActionPerformed

		count_gen++;

		clean();
		jfc = new JFileChooser("E:\\College\\TA\\bimbingan-1\\nlg\\src");
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();

		String url = file.getAbsolutePath();
		labelURL.setText(url);
		tampilkanKonten(url);

		ArrayList<HasilCek> hasil = new ArrayList<>();

		Path = file.getPath();
		ReadWord readWord = new ReadWord();
		hasil = readWord.read(url);
		//System.out.println(" hasil list:"+hasil.toString());
		tampil_generate(hasil);

		//System.out.println(getKalimat());


	}//GEN-LAST:event_buttonPilihFileActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		jTextArea1.setLineWrap(true);
		jTextArea1.setText(p.klmt1+"\n");
		jTextArea1.append(p.klmt);
		klmt = p.klmt1+"\n"+p.klmt;

	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
		jTextArea1.setText("");
		p.klmt ="";
		p.klmt1 ="";
		jeData.setText("");
		labelURL.setText("...");

	}//GEN-LAST:event_jButton5ActionPerformed

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextField1ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jButton4ActionPerformed
		int returnVal = jfc.showSaveDialog(Generate.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			//This is where a real application would save the file.
			Add2Docx doc= new Add2Docx();
			try {
				doc.write(klmt, Path, "E:/College/TA/bimbingan-1/Hasil.docx"); // TODO Auto-generated catch block
			} catch (IOException ex) {
				Logger.getLogger(Generate.class.getName()).log(Level.SEVERE, null, ex);
			}

			JOptionPane.showMessageDialog(null,"masuk");
			LoadAndSaveToDisk b = new LoadAndSaveToDisk();
				b.simpan( "E:/College/TA/bimbingan-1/Hasil.docx",file.getPath());
			JOptionPane.showMessageDialog(null,"Telah Berhasil Disimpan file Dapat DIlihat di "+file.getPath());
		}		
	}//GEN-LAST:event_jButton4ActionPerformed



	public void tampil_generate(ArrayList<HasilCek> hasil) {

		if(hasil.size()==0){
			p.setKLMT("Berdasarkan hasil pemeriksaan di atas, pasien memiliki kondisi yang normal pada seluruh komponen kimia darah dan urin.");
		}
		for (int i = 0; i < hasil.size(); i++) {
			System.out.println(hasil.get(i).getHasil() + " " + hasil.get(i).getField() + " " + hasil.get(i).getTraction());

			System.out.println("\n\n\n===============================================\n" + hasil.get(i).getField().replace("_", " ") + "\n===============================================");

			ReadFile readFile = new ReadFile();

			String isiKorpus = readFile.getContent("korpus.txt");

			String t;

			if(hasil.get(i).getTraction()!=null)
			{
				t=hasil.get(i).getTraction();
			}else{
				t="";


			}
			p.setKLMT("Berdasarkan hasil pemeriksaan di atas, pasien memiliki kondisi yang abnormal pada beberapa komponen kimia darah dan urin.");

			//System.out.println(t);
			String field;
			if(hasil.get(i).getField().toLowerCase().equals("creatinine")){
				field="kreatinin";
			}else if(hasil.get(i).getField().toLowerCase().equals("warna")){
				field="warna";
			}else if(hasil.get(i).getField().toLowerCase().equals("protein")){
				field="protein";
			}else if(hasil.get(i).getField().toLowerCase().equals("glukosa")){
				field="glukosa";
			}else if(hasil.get(i).getField().toLowerCase().equals("ureum")){
				field="ureum";
			}else if(hasil.get(i).getField().toLowerCase().equals("asam_urat")||hasil.get(i).getField().toLowerCase().equals("Asam Urat")){
				field="asam urat";
			}else if(hasil.get(i).getField().toLowerCase().equals("cholestrol_total")){
				field="kolesterol total";
			}else if(hasil.get(i).getField().toLowerCase().equals("ldl_cholestrol")){
				field="LDL";
			}else if(hasil.get(i).getField().toLowerCase().equals("hdl_cholestrol")){
				field="HDL";
			}else if(hasil.get(i).getField().toLowerCase().equals("leukosit")){
				field="leukosit";
			}else if(hasil.get(i).getField().toLowerCase().equals("epitel")){
				field="epitel";
			}else if(hasil.get(i).getField().toLowerCase().equals("kristal")){
				field="kristal";
			}else if(hasil.get(i).getField().toLowerCase().equals("erytrosit")){
				field="eritrosit";
			}else if(hasil.get(i).getField().toLowerCase().equals("glukosa_puasa")){
				field="glukosa puasa";
			}else if(hasil.get(i).getField().toLowerCase().equals("trygliserida")){
				field="trigliserida";
			}else if(hasil.get(i).getField().toLowerCase().equals("silinder")){
				field="silinder";
			}else if(hasil.get(i).getField().toLowerCase().equals("sgpt")){
				field="SGPT";
			}else if(hasil.get(i).getField().toLowerCase().equals("sgot")){
				field="SGOT";
			}else if(hasil.get(i).getField().toLowerCase().equals("bakteri")){
				field="bakteri";
			}


			else{
				field=hasil.get(i).getField();
				System.out.println("--------------------------------------------------------------------------"+field);
			}
			//System.out.println(hasil.get(i).getField().replace("_", " "));
			//System.out.println("ISI T ADalah"+ t );
			p.proses(Proses.isiKorpus, field.replace("_"," "), t.toLowerCase() );
		}

	}
	public String getKalimat(){
		return KalimatAkhir;
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
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JEditorPane jeData;
	private javax.swing.JLabel labelURL;
	// End of variables declaration//GEN-END:variables
}
