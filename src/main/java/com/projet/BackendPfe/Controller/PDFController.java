package com.projet.BackendPfe.Controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pdf")
public class PDFController {
	
	@GetMapping("/dowloadPDF")
	public void dowloadPDF(HttpServletResponse response) throws IOException{
		// Créer un nouveau document PDF
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Créer un contenu pour le PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(100, 700);

        // Ajouter des données au PDF (exemple)
        contentStream.showText("Colonne 1");
        contentStream.newLine();
        contentStream.showText("Colonne 2");
        contentStream.newLine();

        // Remplir le tableau avec vos données (exemple)
        // List<MyData> dataList = getData(); // Obtenez vos données ici
        // for (MyData data : dataList) {
        //     contentStream.showText(data.getField1());
        //     contentStream.newLine();
        //     contentStream.showText(data.getField2());
        //     contentStream.newLine();
        // }

        contentStream.endText();
        contentStream.close();

        // Écrire le contenu dans le flux de sortie
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=data.pdf");
        document.save(response.getOutputStream());
        document.close();
    }
	
}
		  
