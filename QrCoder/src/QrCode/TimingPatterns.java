package QrCode;

import QrCode.Contstants.Values;

public class TimingPatterns {
	 	// Get value of Timing Pattern
		private static  int VAL = Values.TIMING;
		//Place Timing Pattern in moduleMatrix
		public static void placeInMatrix(int[][] moduleMatrix) 
	    {
			for(int i=8;i<moduleMatrix.length-8;i++)
			{
				if(Values.IsBlank(moduleMatrix[6][i]) || moduleMatrix[6][i]==-Values.FORMAT)
					moduleMatrix[6][i]=VAL;
				if(Values.IsBlank(moduleMatrix[i][6]) || moduleMatrix[i][6]==-Values.FORMAT)
					moduleMatrix[i][6]=VAL;
				VAL*=-1;
			}
	    }
}
