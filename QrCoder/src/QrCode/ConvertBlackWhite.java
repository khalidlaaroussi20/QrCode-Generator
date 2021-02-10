package QrCode;

import QrCode.Contstants.Values;

public class ConvertBlackWhite {

	public static void ConvertToBlackWhite(int [][]Matrix)
	{
		for(int i=0;i<Matrix.length;i++)
		{
			for(int j=0;j<Matrix.length;j++)
			{
				if(Values.isDark(Matrix[i][j]))
					Matrix[i][j]=1;
				else
					Matrix[i][j]=0;
			}
		}
	}
}
