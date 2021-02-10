package QrCode;

import QrCode.Contstants.Values;

public class Separators 
{
	//Get Value Of SEPARATOR in ModuleMatrix
	private static final int VAL = -Values.SEPARATOR;
	
	//Place The Separator In the ModuleMatrix
	 public static void placeInMatrix(int[][] moduleMatrix) {
		 
		 int Offset=moduleMatrix.length-8;
		 for(int i=0;i<=7;i++)
		 {
			 //Separators
			 moduleMatrix[i][7]=VAL;
			 moduleMatrix[7][i]=VAL;
			 moduleMatrix[i][Offset]=VAL;
			 moduleMatrix[7][Offset+i]=VAL;
			 
			 moduleMatrix[Offset][i]=VAL;
			 moduleMatrix[Offset+i][7]=VAL;
		 }
		 
		 
	 }
}
