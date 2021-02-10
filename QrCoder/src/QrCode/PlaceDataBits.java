package QrCode;
import QrCode.Contstants.Values;

public class PlaceDataBits 
{
	String _DataBit;
	
	public PlaceDataBits(String _DataBit)
	{
		this._DataBit=_DataBit;
	}
	/*
	 * 	Place FinalMessage in The Module Matrix in zigzag  
	 * starting at the bottom-right of the matrix 

	 */
	public  void  PlaceDataBitsInMatrix(int[][] moduleMatrix)
	{
		int LenMatrix=moduleMatrix.length,i=LenMatrix-1,j=i,k=0,count=1;
		boolean StartFromBotom=true;
		while (k<this._DataBit.length())
		{
			
			if(j==6)
			{
				j--;
			}
			else if(j==-1)
			{
				j=0;
			}
			count++;
			if(Values.IsBlank(moduleMatrix[i][j]))
			{
				moduleMatrix[i][j]=this._DataBit.charAt(k)-'0';
				k++;
			}
			if(StartFromBotom)
			{
				if(count%3==0)
				{
					if(i==0)
					{
						StartFromBotom=false;
						 j--;
					}
					else
					{
						j=j+1;
						i=i-1;
					}
					count=1;
				}
				else
				{
					j=j-1;
				}
			}
			else
			{
				if(count%3==0)
				{
					if(i==LenMatrix-1)
					{
						 StartFromBotom=true;
						 j--;
					}
					else
					{
						j++;
						i=i+1;
					}
					count=1;
				}
				else
				{
					j=j-1;
				}
			}
			
		}
	}
}
