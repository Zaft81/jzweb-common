package com.jzweb.common.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/29/2019
 */
public class PDFUtils {

    public static void htmlToPdf(String htmlPath, String pdfPath) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

        document.open();
        InputStream cssInput = null;
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(htmlPath),cssInput,new JzWorkerFontProvider());
        document.close();
    }
}
