package com.home.programs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class CalculateBase64Size {

    public static void calculateSize () throws IOException {
        String base64Str = "VGhpcyBpcyBhIGRlbW8gZmlsZS4uIApEZW1vIGNvbnRlbnQuLgppcGVyb20gc2pkbmFzanBhamF3bGttc2EKCmFzZGttc2FrbWRzCgprYXNkbWtzZGFtCgphc2tkbWtzYW1zYWtkbXNhCmthc2Rta3NtZGFzCmthc2Rrc2RtbHNkYW1kbHNhOwprYXNtZHNsYWRtYXNkc2Rhawpza2Ftc2FsbWRza2FtZHNhCmthc21za2FtZHNha21kc2EKYXNrZG1zYWttZHNha2Fkc21hcwoKYXNka21zYWRrbXNhZGw7bWRzYQoKCmFzZGttc2FrZG1hczthc2RrbXNhZGttc2FkbAoK";

//        double size = 4*Math.ceil((double)base64Str.length()/3);

        int size = countBase64Size(base64Str);
        System.out.println("size : " + size);

        createFile(base64Str);
    }

    public static int countBase64Size(String in) {
        int count = 0;
        int pad = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == '=') pad++;
            if (!Character.isWhitespace(c)) count++;
        }
        return (count * 3 / 4) - pad;
    }


    public static void createFile (String encodedString) throws IOException {

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        // Creating an instance of file
        Path path
                = Paths.get("D:\\PepCoding\\gfg.txt");

        // Try block to check for exceptions
        try {
            // Now calling Files.writeString() method
            // with path , content & standard charsets
            Files.writeString(path, decodedString,
                    StandardCharsets.UTF_8);

            File file = new File("D:\\PepCoding\\gfg.txt");
            double bytes = file.length();
            double kilobytes = (bytes / 1024);

            System.out.println("bytes : " + bytes);

            System.out.println("kilobytes : " + kilobytes);
        }



        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.print("Invalid Path");
        }
    }
}
