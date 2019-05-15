package integration;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class PDFConversion {
    private static final String OUTPUT_FILE = "C:/Users/harri/Desktop/output/output";

    void convert(String filepath) throws IOException {
        final PDDocument doc = PDDocument.load(new File(filepath));
        final PDFRenderer renderer = new PDFRenderer(doc);

        /*
         * This application only renders the first page of a PDF
         * 
         * The following block of commented code replaces the two that follow it
         * and can generate images from multi page documents
         */

//        for(int i = 0; i < doc.getNumberOfPages(); i++) {
//            BufferedImage img = renderer.renderImage(i);
//
//            ImageIOUtil.writeImage(img, OUTPUT_FILE + (i + 1) + ".png", 300);
//        }

        BufferedImage img = renderer.renderImage(0);
        ImageIOUtil.writeImage(img, OUTPUT_FILE + ".png", 300);

        doc.close();
    }

}
