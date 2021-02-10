package QrCode;
import QrCode.Contstants.BitValue;
import QrCode.Contstants.VersionInfo;

public class FormatInformation {
	public static void PlaceFormBit(int [][] Matrix,int ErroCorrLevel,int MaskPattern)
	{
		int Ofsset=Matrix.length-8;
		int FormatBit=BitValue.getBitValue(ErroCorrLevel, MaskPattern);
		for(int i=0,k=14,count=0;count<=7;i++,k--)
		{
			if(i!=6)
			{
				//full Left Horizontal
				if((FormatBit &(1 << k))!=0)
				{
					Matrix[8][i]=1; 
				}
				else
				{
					Matrix[8][i]=0;
				}
				//full Left Vertical
				if((FormatBit &(1 << count))!=0)
				{
					Matrix[i][8]=1;
				}
				else
				{
					Matrix[i][8]=0;
				}
				//full Right Horizontal
				if((FormatBit &(1 << 7-count))!=0)
				{
					Matrix[8][Ofsset+count]=1;
				}
				else
				{
					Matrix[8][Ofsset+count]=0;
				}
				//full Bottom Vertical
				if((FormatBit &(1 << 7+count))!=0)
				{
					Matrix[Ofsset+count][8]=1;
				}
				else
				{
					Matrix[Ofsset+count][8]=0;
				}
				count++;
			}
		}
		
	}
	
	//Place Version Bit
	public static void PlaceVersionBit(int [][] Matrix,int Version)
	{
		
		int Ofsset=Matrix.length-11,count=0;
		//Get The VALUE OF Version Bit
		int VersiontBit=VersionInfo.getVersionInfoValue(Version);
		//Then Place This Value in Module Matrix
		for(int i=0;i<=5;i++)
		{
			for(int j=0;j<=2;j++)
			{
				if((VersiontBit &(1 << count))!=0)
				{
					Matrix[j+Ofsset][i]=1;
					Matrix[i][j+Ofsset]=1;
				}
				else
				{
					Matrix[j+Ofsset][i]=0;
					Matrix[i][j+Ofsset]=0;
				}
				
				count++;
			}
		}
	}
}
