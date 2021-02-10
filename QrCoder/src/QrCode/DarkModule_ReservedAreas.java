package QrCode;
import QrCode.Contstants.Values;

public class DarkModule_ReservedAreas {
	private static  int VAL = Values.VERSION;
	public static void placeInMatrix(int[][] moduleMatrix,int Version) 
    {
		PlaceDarkModuleInMatrix(moduleMatrix,Version);
		if(Version >= 7)
		{
			
			int offset = moduleMatrix.length - 11;
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<3;j++)
				{
					moduleMatrix[i][j+offset]=VAL;
					
					moduleMatrix[offset+j][i]=VAL;
				}
			}
		}
    }
	
	public static void PlaceDarkModuleInMatrix(int[][] moduleMatrix,int Version)
	{
		moduleMatrix[(4*Version)+9][8]=Values.DarkMODE;
	}
	public static void PlaceDarkModuleInMatrix(int[][] moduleMatrix,int Version,int Value)
	{
		moduleMatrix[(4*Version)+9][8]=Value;
	}
}
