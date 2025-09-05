package com.infotech.book.ticket.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.book.ticket.app.service.QR_Generator;

@RestController
@RequestMapping(value = "/api/quiz/qrCode")
@CrossOrigin("http://localhost:8080")
public class QR_Code_Controller {

	/*
	 * Step 4.) Create a Controller Class.
	 * 
	 * In this step, we will create two API, first one is to generate the image form
	 * of the QR Code and also provide the path to save the QR Code automatically in
	 * the local system.
	 * 
	 * Another API will return the QR Code in the form of a byte array so that it
	 * can be used along with the HTML and javascript to display on the web pages.
	 */

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	@GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
	public void download(@PathVariable("codeText") String codeText, @PathVariable("width") Integer width,
			@PathVariable("height") Integer height) throws Exception {
		QR_Generator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
	}

	@GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
	public ResponseEntity<byte[]> generateQRCode(@PathVariable("codeText") String codeText,
			@PathVariable("width") Integer width, @PathVariable("height") Integer height) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(QR_Generator.getQRCodeImage(codeText, width, height));
	}

	/*
	 * Step 5.) APIs mentioned above will accept the three data in the form of Path
	 * Variable.
	 * 
	 * codeText: We can pass any random text which can act as secret text when
	 * somebody scans the QR Code. width: Specify the width of the QR Code image.
	 * height: To specify the height of QR Code image.
	 * 
	 * In the above code, you can see we have specified the path
	 * “./src/main/resources/QRCode.png” where the QR Code Image will get saved.
	 */
}
