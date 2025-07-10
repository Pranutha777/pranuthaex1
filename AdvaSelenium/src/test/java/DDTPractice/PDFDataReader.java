package DDTPractice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFDataReader {

	public static void main(String[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
		File f = new File("./src/test/resources/13. AGILE MODEL.pdf");
		PDDocument doc = PDDocument.load(f);
		int totalnoofPages = doc.getNumberOfPages();
		System.out.println("totalpages:"+totalnoofPages);
		PDFTextStripper p = new PDFTextStripper();
		String FullpdfData = p.getText(doc);
		System.out.println("FULLpdfdata:"+FullpdfData);
		//this is start page of pdf data to read and till end page
		/*p.setStartPage(4);
		p.setEndPage(4);
		String data = p.getText(doc);
		System.out.println("pdfdata:"+data);*/

	}

}
