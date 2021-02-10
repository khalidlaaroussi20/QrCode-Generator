package DataAnalyse;

import DateEncoder.Constants;

public class ChoseLevel {
	
	/*
	 * Parameter 1 ModeEncoding
	 * Parameter 2 Count Character The Data
	 */
	//Return Best Level For QrCode
	public static int ChoseBstVersion(int ModeEncoding,int Count_char)
	{	
		for(int i=1;i<=Constants.MAX_VERSION;i++)
		{
			if(CharactereCapacity.CapaciteTable[ModeEncoding-1][i]>=Count_char)
			{
				return i;
			}
		}
		throw new IllegalArgumentException("count charactere "); 
	}
}
