package integration;

import java.io.IOException;
import java.util.Scanner;

public class AppDriver {
    public static void main(String[] args) {
        PDFConversion converter = new PDFConversion();
        Scanner input = new Scanner(System.in);
        String filesrc;

        System.out.println("Enter filepath of PDF to convert to PNG. Leave empty for default file");
        filesrc = input.nextLine();

        if (filesrc == null || filesrc.equals(""))
            filesrc = "C:/Workspace/reporting/testreport.pdf";

        try {
            converter.convert(filesrc);
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("Finished!");

    }
}
