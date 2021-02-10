package QrCode;

import QrCode.Contstants.Values;

public class FormatArea {

	
	private static final int VAL = -Values.FORMAT;
	
	//Reserve Format Area In Matrix
	 public static void placeInMatrix(int[][] moduleMatrix) {
		 
		 int Offset=moduleMatrix.length-8,i;
		 for(i=0;i<=7;i++)
		 {
			 //Add Format Info
			 moduleMatrix[i][8]=VAL;
			 moduleMatrix[8][i]=VAL;
			 
			 moduleMatrix[8][Offset+i]=VAL;
			
			 moduleMatrix[Offset+i][8]=VAL;
		 }
		 moduleMatrix[i][8]=VAL;
		 
	 }
}
