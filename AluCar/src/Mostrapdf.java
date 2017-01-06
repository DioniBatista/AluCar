import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

 public class Mostrapdf  
 {
	
	 public Mostrapdf(String nome, String cpf,String marca,String modelo,String cor, String placa, String valorlocacao,String observacao, String valortotal,String dataloc) throws Exception
	 {
		 final String nomearquivo;
		 
		 Document doc = null;
		 OutputStream os = null;
		/* Date data = new Date(0);
		 DateFormat formato = new SimpleDateFormat("HH:mm:ss:SSS");
		 String dataformatada = formato.format(data);*/
		 
		 try {
		 //cria o documento tamanho A4, margens de 2,54cm
		 doc = new Document(PageSize.A4, 72, 72, 72, 72);
		 
		 //cria a stream de saída
		 int numero=0;
		 int[]vetor = new int[100];
		 for(int i = 0;i<vetor.length;i++)
		 {
			 int rnd = (int)(1+Math.random()*100);
			 vetor[i]=rnd;
		 }
		 for(int i = 0; i< vetor.length;i++)
		 {
			 numero = vetor[i];
		 }
		 nomearquivo=nome+numero;
		 os = new FileOutputStream("D://"+nomearquivo+".pdf");
		
		 //associa a stream de saída ao
		 PdfWriter.getInstance(doc, os);

		 //abre o documento
		 doc.open();

		 //adiciona o texto ao PDF
		 Image img = Image.getInstance("logo.png");
		 img.setAlignment(Element.ALIGN_CENTER);
		 doc.add(img);
		 Paragraph p0 = new Paragraph("                                                    "+dataloc);
		 doc.add(p0);
		 Paragraph p1 = new Paragraph("______________________________________________________");
		 doc.add(p1);
		 Paragraph p = new Paragraph("Nome:  "+nome+"     Cpf: "+cpf);
		 doc.add(p);

		 Paragraph p2 = new Paragraph("Veículo: "+marca+" - "+modelo+" - "+cor);
		 doc.add(p2);
		 Paragraph p3 = new Paragraph("Placa: "+placa);
		 doc.add(p3);
		 Paragraph p4 = new Paragraph("Valor dia: R$"+valorlocacao+",00");
		 doc.add(p4);

		 Paragraph p6 = new Paragraph("Observação: ");
		 doc.add(p6);
		 Paragraph p7 = new Paragraph(observacao);
		 doc.add(p7);
		 Paragraph p8 = new Paragraph("______________________________________________________");
		 doc.add(p8);
		 Paragraph p5 = new Paragraph("Valor Total: R$"+valortotal+",00");
		 doc.add(p5);
		
		 
		 PdfPTable table = new PdfPTable(2);
		  //PdfPCell header = new PdfPCell(new Paragraph("Algumas Palavaras Reservadas do Java"));
		  //header.setColspan(3);
		// table.addCell(header);
		 /*table.addCell("Nome:  Dioni Batista da Silva");
		 table.addCell("CPF: 111.111.111-98 ");
		 table.addCell("Veículo: Gol");
		  table.addCell("Placa:  AAA-1234");
		  table.addCell("Valor Locação:  R$ 100,00");
		  table.addCell("Dias Locacação: 4");
		  table.addCell("Valor Total:  R$ 400,00");
		  table.addCell("");
		 doc.add(table);*/

		 } finally {
		 if (doc != null) {
		 //fechamento do documento
		 doc.close();
		 }
		 if (os != null) {
		 //fechamento da stream de saída
		 os.close();
		}
		 }
		 //Process pro = Runtime.getRuntime().exec("cmd.exe /c D://outtable.pdf");
		 //pro.waitFor();
		 //abre pdf salvo
		 File pdf = new File("D://"+nomearquivo+".pdf");
		 
		 Desktop.getDesktop().open(pdf);
		
	 }
	 
	 
	 public static void main(String[] args) throws Exception 
	 {
		// new Pdf();
	 }
 }