import java.io.IOException;

import QrCode.QrCodeGenerator;


public class Example {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Call Static Function QrCodeGenerat
		String Data="Hello World<3";
		String ImageName="HelloWorldQrCode";
		/*
		 * It Take Two Parameter 
		 * Parameter 1  Is Data
		 * Parameter 2 iS Name Image
		 */
		QrCodeGenerator.QrCodeGenerat(Data, ImageName);
		
	}
}
