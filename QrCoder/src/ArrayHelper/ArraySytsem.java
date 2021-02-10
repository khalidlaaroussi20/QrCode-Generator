package ArrayHelper;

import java.util.ArrayList;

import QrCode.Contstants.Values;

public   class ArraySytsem 
{
	public static int[][] cloneArray(int[][] src) 
	{
	    int length = src.length;
	    int[][] target = new int[length][src[0].length];
	    for (int i = 0; i < length; i++) {
	        System.arraycopy(src[i], 0, target[i], 0, src[i].length);
	    }
	    return target;
	}
	
	public static int[] CoppyArrayHorizontal(int[][] src,int Row,int StartPos,int lenght) 
	{	
	    int[] target = new int[lenght];
	    for (int k = 0; k < lenght; k++) {
	        target[k]=src[Row][k+StartPos];
	    }
	    return target;
	}
	
	public static int[] CoppyArrayVertical(int[][] src,int Column,int StartPos,int lenght) {
	    int[] target = new int[lenght];
	    for (int k = 0; k < lenght; k++) {
	        target[k]=src[k+StartPos][Column];
	    }
	    return target;
	}
	public static boolean IsEquals(int[] FirstArr,int []SecondArr)
	{
		boolean FirstColor,SecondColor;
		for(int i=0;i<FirstArr.length;i++)
		{
			FirstColor=Values.isDark(FirstArr[i]);
			SecondColor=Values.isDark(SecondArr[i]);
			if(FirstColor!=SecondColor)
				return false;
		}
		return true;
	}
	public static int[] convertToArray(ArrayList<Integer> P1,int  Size )
	{
		int[] target = new int[Size];
		for(int i=0;i<P1.size();i++)
		{
			target[i]=P1.get(i);
		}
		return target;
	}
}
