package semhas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Add2Docx {
	String nama;
	String gender,path;

	public void write(String sentence,String inpath,String outpath) throws IOException {


		XWPFDocument doc;
		try {
                    File file = new File(inpath);

    //Create an object of FileInputStream class to read excel file

                        FileInputStream inputStream = new FileInputStream(file);

			doc = new XWPFDocument(OPCPackage.open(inputStream));
			List<XWPFParagraph>  paragraphs = doc.getParagraphs();
			XWPFParagraph paragraph =  paragraphs.get(paragraphs.size() - 1);

			XWPFRun runText = paragraph.createRun();

			//if you want to add text
			runText.addBreak();  
			runText.addBreak();  
			runText.addBreak();  
			runText.addBreak();  
			runText.setText("      "+sentence.replace("[", "").replace("]", ""));
			runText.addBreak();  
			
			try (FileOutputStream out = new FileOutputStream(outpath)) {
				doc.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			}/*
			  
			 XWPFDocument document=new XWPFDocument(OPCPackage.open("F:/TA/dataset/datasetWord/MCU TN 2016 WORDS/010216_RENI_NUR_ASTUTI.docx"));
			 
			  File outFile=new File("F:/TA/dataset/datasetWord/MCU TN 2016 WORDS/edited_010216_RENI_NUR_ASTUTI.pdf");
			  FileOutputStream out = new FileOutputStream("F:/TA/dataset/datasetWord/MCU TN 2016 WORDS/edited_010216_RENI_NUR_ASTUTI.pdf");
			  PdfOptions options=null;
			 
                        */
		} catch (InvalidFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                        
			  




	}
	public static void main (String args[]) throws IOException{
		Add2Docx a= new Add2Docx();
		a.write("coba tes input","F:/TA/dataset/datasetWord/MCU TN 2016 WORDS/010216_RENI_NUR_ASTUTI.docx","F:/TA/dataset/datasetWord/MCU TN 2016 WORDS/edited_010216_RENI_NUR_ASTUTI.docx");
		System.out.print("siap");
	}



}
