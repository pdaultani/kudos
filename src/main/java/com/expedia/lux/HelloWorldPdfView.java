package com.expedia.lux;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.expedia.lux.model.*;

public class HelloWorldPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
			Paragraph header = new Paragraph(new Chunk(
	            "Listing Kudos sent in your team ",
	            FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18)));
	        document.add(header);
		
		
		 List<KudosData> kudosdata = (List<KudosData>) model.get("kudos");
		
		 Table table = new Table(5);
		 table.setPadding(3);
		table.addCell("Kudos sent from");
		table.addCell("Kudos sent to");
		table.addCell("Content");
		table.addCell("Manager name");
		table.addCell("Date sent");
		
		for (int i=0;i<kudosdata.size();i++) {
			KudosData kd = kudosdata.get(i);
			
			
			for(int u=0;u<kd.getUsers().size();u++){
				User user = kd.getUsers().get(u);
				table.addCell(user.getUsername());
			}
		
			
			table.addCell(kd.getKudosContent());
			
			for(int t=0;t<kd.getTeams().size();t++){
				Team team = kd.getTeams().get(t);
				table.addCell(team.getManager());
			}
			
			
			table.addCell(kd.getDateSent().toString());
                }
 
		document.add(table);
		

	}


}
