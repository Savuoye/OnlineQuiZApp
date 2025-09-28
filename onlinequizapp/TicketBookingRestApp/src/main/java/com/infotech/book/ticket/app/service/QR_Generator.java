package com.infotech.book.ticket.app.service;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QR_Generator {

	/*
	 * Step 3.) Create a Class for QR Code Generator.
	 * 
	 * In this class we will define a method to generate the QR Code. In the above
	 * class, we have defined two methods, the first method is used to generate the
	 * QR Code in image form.
	 * 
	 * And the second method will generate the QR Code in the form of a byte array,
	 * which we used to return as a response for HTTP Request.
	 */

	public static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		// QrCodeWriter object renders a QR Code as a BitMatrix 2D array of greyscale
		// values.
		QRCodeWriter qrCodeWriter = new QRCodeWriter();

		// BitMatrix Represents a 2D matrix of bits. In function arguments below, and
		// throughout the common module, x is the column position, and y is the row
		// position. The ordering is always x, y. The origin is at the top-left.
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		// Setting up the path of the image where we will get image as given in our
		// controller class
		Path path = FileSystems.getDefault().getPath(filePath);

		// MatrixToImageWriter writes a BitMatrix to BufferedImage, file or stream
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}

	public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		return pngData;
	}

}
