package com.jzweb.common.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.jzweb.common.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.*;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/29/2019
 */
public class PDFUtils {

    /**
     * html转为PDF，需要注意JzWorkerFontProvider字体
     * @param htmlPath
     * @param pdfPath
     * @throws DocumentException
     * @throws IOException
     */
    public static void htmlToPdf(String htmlPath, String pdfPath) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

        document.open();
        InputStream cssInput = null;
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(htmlPath),cssInput,new JzWorkerFontProvider());
        document.close();
    }

    /**
     * 移除PDF密码
     * @param orgPdf
     * @param despath
     * @param pwd
     * @throws Exception
     */
    public static void decodePdf(String orgPdf,String despath ,String pwd) throws Exception{
        File file = new File(orgPdf);
        PDDocument load = PDDocument.load(file, pwd);
        load.setAllSecurityToBeRemoved(true);
        File file2 = new File(despath);
        load.save(file2);
    }

    /**
     * 检查pdf是否有加密码
     * @param pdfFile
     * @return
     */
    public static boolean checkHasFullPermissions(String pdfFile) {
        try {
            if(StringUtils.isBlank(pdfFile)) {
                return false;
            }
            PdfReader pdfFlag = new PdfReader(pdfFile);
            return pdfFlag.isOpenedWithFullPermissions();
        }catch(Exception e) {
            return false;
        }
    }
}
