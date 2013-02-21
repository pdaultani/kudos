package com.expedia.lux;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class HelloWorldPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		Paragraph header = new Paragraph(new Chunk(
	            "This is a PDF from the Hello World Web App",
	            FontFactory.getFont(FontFactory.HELVETICA, 24)));
	        document.add(header);

	}


}
