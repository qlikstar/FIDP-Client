package com.citrix.xenmobile.clientapp.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@Service
public class StringToImageService {

    private String imageDataString;

    private String qrCodeFilePath;

    public String getQrCodeFilePath() {
        return qrCodeFilePath;
    }

    public void setImageDataString(String imageDataString) throws IOException {
        this.imageDataString = imageDataString;
        convertStringToImage();
    }

    public StringToImageService() throws IOException {
    }

    private void convertStringToImage() throws IOException {

        // Converting a Base64 String into Image byte array
        byte[] imageByteArray = decodeImage(imageDataString);

        Random rand = new Random();
        qrCodeFilePath = "qrcodes/qrcode" +rand.nextInt(20) + ".png";

        File newFile = new File("target/classes/static/" + qrCodeFilePath);
        if (!newFile.exists()) {
            boolean success = newFile.createNewFile();
            System.out.println("QR File created : " + success);
        }

        // Write a image byte array into file system
        FileOutputStream imageOutFile = new FileOutputStream("target/classes/static/" + qrCodeFilePath);

        imageOutFile.write(imageByteArray);
        imageOutFile.close();
    }

    /**
     * Encodes the byte array into base64 string
     *
     * @param imageByteArray - byte array
     * @return String a {@link java.lang.String}
     */
    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

    /**
     * Decodes the base64 string into byte array
     *
     * @param imageDataString - a {@link java.lang.String}
     * @return byte array
     */
    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }

}
