package com.javamultiplex.qrcodegenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class QRCodeExample implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("https://github.com/javamultiplex", BarcodeFormat.QR_CODE, 350, 350);
        Path path = Paths.get("output.jpg");
        MatrixToImageWriter.writeToPath(bitMatrix, "JPG", path);
    }
}
