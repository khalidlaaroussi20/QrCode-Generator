package QrCode;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import QrCode.Contstants.Values;

import StringHelper.StringHelper;

public class DrawImage 
{
	/*
	 * Parameter 1 ModuleMatrix that we Will Draw
	 * Parameter 2 Name Image That we will Draw
	 */
	public static void DrawQr(int [][]Matrix,String nameImg) throws IOException
	{
		int xLenght = Matrix.length;
		int yLength = Matrix.length;
		Color color;
		BufferedImage b = new BufferedImage(xLenght, yLength, 3);

		for(int x = 0; x < xLenght; x++) {
		    for(int y = 0; y < yLength; y++) 
		    {
		    	//Get Color what is BLACK Or WHITE
		    	if(Values.isDark(Matrix[y][x]))
		    		color=Color.BLACK;
		    	else
		    		color=Color.WHITE;
		    	
		    	//Then Draw this Color in the Current Pixel
		        b.setRGB(x, y, color.getRGB());
		    }
		}
		
		//Create Image
		try {
			String ImageName=StringHelper.SplitWithPoint(nameImg);
			if(ImageName.length()==0)
				throw new IllegalArgumentException("Please Enter Valid Image Name "); 
		    File outputfile = new File(ImageName+".png");
		    ImageIO.write(b, "png", outputfile);
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
		
	}
}
