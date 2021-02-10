package QrCode;

import java.util.Arrays;

import ArrayHelper.ArraySytsem;
import QrCode.Contstants.Values;
public class DataMasking 
{
	public int[][]MaskPattern0;
	private int[][]MaskPattern1;
	private int[][]MaskPattern2;
	public int[][]MaskPattern3;
	private int[][]MaskPattern4;
	private int[][]MaskPattern5;
	private int[][]MaskPattern6;
	private int[][]MaskPattern7;
	public int IndexBestMasking=0, ErCrLevel, Version;
	
	//Do not mask function patterns (finder patterns, timing patterns, separators, alignment patterns)
	//Do not mask reserved areas (format information area, version information area)
	
	public DataMasking(int[][] moduleMatrix,int ErCrLevel,int Version)
	{
		MaskPattern0=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern1=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern2=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern3=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern4=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern5=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern6=ArraySytsem.cloneArray(moduleMatrix);
		MaskPattern7=ArraySytsem.cloneArray(moduleMatrix);
		this.ErCrLevel=ErCrLevel;
		this.Version=Version;
		MaskPatterns(moduleMatrix);
	}
	private  void MaskPatterns(int[][] moduleMatrix)
	{
		for(int row=0;row<moduleMatrix.length;row++)
		 {
			 for(int column=0;column<moduleMatrix.length;column++)
			 {
				 if(Values.IsDataBit(moduleMatrix[row][column]))
				 {
					 if((row+column)%2==0)
					 {
						 MaskPattern0[row][column]^=1;
					 }
					 if(row%2==0)
					 {
						 MaskPattern1[row][column]^=1;
					 }
					 if(column % 3 == 0)
					 {
						 MaskPattern2[row][column]^=1;
					 }
					 if((row+column)%3==0)
					 {
						 MaskPattern3[row][column]^=1;
					 }
					 if((Math.floor(row / 2) + Math.floor(column / 3) ) % 2 == 0)
					 {
						 MaskPattern4[row][column]^=1;
					 }
					 if(((row * column) % 2) + ((row * column) % 3) == 0)
					 {
						 MaskPattern5[row][column]^=1;
					 }
					 if((((row * column) % 2) + ((row * column) % 3))%2 == 0)
					 {
						 MaskPattern6[row][column]^=1;
					 }
					 if((((row + column) % 2) + ((row * column) % 3))%2 == 0)
					 {
						 MaskPattern7[row][column]^=1;
					 }
				 }
				 else
				 {
					 MaskPattern0[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern1[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern2[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern3[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern4[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern5[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern6[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
					 MaskPattern7[row][column]= (Values.isDark(moduleMatrix[row][column])) ? 1 : 0;
				 }
			 }
		 }
	}
	
	public int GetIndexBestMask()
	{
		return this.IndexBestMasking;
	}
	private int TotalPenaltyOneTwoFour(int[][] MaskMatrix)
	{
		int PenaltyVertical=0,PenaltyHorizontal=0,CountVertical=0, CountHorizontal,CountArea=0,Len=MaskMatrix.length;
		float CountDarkModules=0;
		for(int i=0;i<Len;i++)
		{
			CountVertical=1;
			CountHorizontal=1;
			for(int j=0;j<Len-1;j++)
			{
				CountDarkModules+=MaskMatrix[i][j];
				//Count PenaltyHorizontal
				if(MaskMatrix[i][j]==MaskMatrix[i][j+1])
				{
					CountHorizontal++;
					if(i!=Len-1 && MaskMatrix[i+1][j]==MaskMatrix[i][j] && MaskMatrix[i][j]==MaskMatrix[i+1][j+1])
					{
						CountArea+=3;
					}
				}
				else
				{
					if(CountHorizontal>=5)
					{
						PenaltyHorizontal+=3+(CountHorizontal-5);
		
					}
					CountHorizontal=1;
				}
				
				//Calcule Penalty Vertical
				if(MaskMatrix[j][i]==MaskMatrix[j+1][i])
				{
					CountVertical++;
				}
				else
				{
					if(CountVertical>=5)
					{
						PenaltyVertical+=3+(CountVertical-5);
					}
					CountVertical=1;
				}
			}
			if(CountHorizontal>=5)
			{
				PenaltyHorizontal+=3+(CountHorizontal-5);
			}
			if(CountVertical>=5)
			{
				PenaltyVertical+=3+(CountVertical-5);
			}
		}
		for(int i=0;i<Len;i++)
		{
			CountDarkModules+=MaskMatrix[i][Len-1];
		}
		int totalPenaltyOne=PenaltyVertical+PenaltyHorizontal;
		int TotalPenalty4=TotalPenaltyFour(CountDarkModules,MaskMatrix);
		return totalPenaltyOne+CountArea+TotalPenalty4;
	}
	private  int TotalPenaltyScore(int [][] Mask)
	{
		return TotalPenaltyOneTwoFour(Mask)+TotalPenaltyThree(Mask);
	}
	
	private  int TotalPenaltyThree(int[][] MaskMatrix)
	{
		int BLACK=1,WHITE=0;
		int [] Pattern0=new int[] {BLACK,WHITE,BLACK,BLACK,BLACK,WHITE,BLACK,WHITE,WHITE,WHITE,WHITE};
		int [] Pattern1=new int[] {WHITE,WHITE,WHITE,WHITE,BLACK,WHITE,BLACK,BLACK,BLACK,WHITE,BLACK};
	
		int LenMatrix=MaskMatrix.length,CountPatterns=0,LenPatterns=Pattern0.length,i=0;
		
		
		int [] CurrentPatternHorizontal=new int[LenPatterns];
		int []CurrentPatternVertical=new int[LenPatterns];
		for(;i<=LenMatrix-LenPatterns;i++)
		{
			for(int j=0;j<=LenMatrix-LenPatterns;j++)
			{
				CurrentPatternVertical=ArraySytsem.CoppyArrayVertical(MaskMatrix, j, i, LenPatterns);
				CurrentPatternHorizontal=ArraySytsem.CoppyArrayHorizontal(MaskMatrix, i, j, LenPatterns);
				//Compare Horizontal
				if(Arrays.equals(CurrentPatternHorizontal,Pattern0) || Arrays.equals(CurrentPatternHorizontal,Pattern1))
				{
					CountPatterns+=40;
				}
				//Compare Vertical
				if(Arrays.equals(CurrentPatternVertical,Pattern0) || Arrays.equals(CurrentPatternVertical,Pattern1))
				{
					CountPatterns+=40;
				}
			}
		}
		for(;i<LenMatrix;i++)
		{
			for(int j=0;j<LenMatrix-LenPatterns;j++)
			{
					CurrentPatternHorizontal=ArraySytsem.CoppyArrayHorizontal(MaskMatrix, i, j, LenPatterns);
					//Compare Horizontal
					if(Arrays.equals(CurrentPatternHorizontal,Pattern0) || Arrays.equals(CurrentPatternHorizontal,Pattern1))
					{
						CountPatterns+=40;
					}
			}
		}
		return CountPatterns;
	}
	private  int TotalPenaltyFour(float NumberDarkModules,int [][]Matrix)
	{
		int Len=Matrix.length,totalmodules=Len*Len,PreviousMultiple,NextMultiple;
		int PercentModules=(int)((NumberDarkModules/totalmodules)*100);
		if(PercentModules%5==0)
		{
			PreviousMultiple=PercentModules-5;
			NextMultiple=PercentModules+5;
		}
		else
		{
			while(PercentModules%5!=0)
			{
				PercentModules++;
			}
			PreviousMultiple=PercentModules-5;
			NextMultiple=PercentModules;
		}
		return Math.min(Math.abs(PreviousMultiple-50)/5, Math.abs(NextMultiple-50)/5)*10;
	}
	public  int [][] BestMaskPattern()
	{
		int [] TotalPenaltyMaks=new int[8];
		
		TotalPenaltyMaks[0]=TotalPenaltyScore(MaskPattern0);
		TotalPenaltyMaks[1]=TotalPenaltyScore(MaskPattern1);
		TotalPenaltyMaks[2]=TotalPenaltyScore(MaskPattern2);
		TotalPenaltyMaks[3]=TotalPenaltyScore(MaskPattern3);
		TotalPenaltyMaks[4]=TotalPenaltyScore(MaskPattern4);
		TotalPenaltyMaks[5]=TotalPenaltyScore(MaskPattern5);
		TotalPenaltyMaks[6]=TotalPenaltyScore(MaskPattern6);
		TotalPenaltyMaks[7]=TotalPenaltyScore(MaskPattern7);
		int Min=TotalPenaltyMaks[0],IndexMin=0;
		for(int i=1;i<8;i++)
		{
			if(Min>TotalPenaltyMaks[i])
			{
				Min=TotalPenaltyMaks[i];
				IndexMin=i;
			}
		}
		this.IndexBestMasking=IndexMin;
		switch (IndexMin)
		{
			case 1:
				return MaskPattern1;
			case 2:
				return MaskPattern2;
			case 3:
				return MaskPattern3;
			case 4:
				return MaskPattern4;
			case 5:
				return MaskPattern5;
			case 6:
				return MaskPattern6;
			case 7:
				return MaskPattern7;	
			default:
				return MaskPattern0;
		}
	}
}