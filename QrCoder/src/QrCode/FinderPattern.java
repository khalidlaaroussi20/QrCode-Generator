package QrCode;


import QrCode.Contstants.Values;

public class FinderPattern
{
	
	private static final int VAL = Values.FINDER;
	
	//Finder Pattern 
    private static int[][] _finderPattern = {
        new int[] {VAL,  VAL,  VAL,  VAL,  VAL,  VAL,  VAL},
        new int[] {VAL, -VAL, -VAL, -VAL, -VAL, -VAL,  VAL},
        new int[] {VAL, -VAL,  VAL,  VAL,  VAL, -VAL,  VAL},
        new int[] {VAL, -VAL,  VAL,  VAL,  VAL, -VAL,  VAL},
        new int[] {VAL, -VAL,  VAL,  VAL,  VAL, -VAL,  VAL},
        new int[] {VAL, -VAL, -VAL, -VAL, -VAL, -VAL,  VAL},
        new int[] {VAL,  VAL,  VAL,  VAL,  VAL,  VAL,  VAL}
    };

    //Place Finder Pattern in  moduleMatrix
    public static void placeInMatrix(int[][] moduleMatrix) {
    	//Calculate Offset
        int offset = moduleMatrix.length - _finderPattern.length;
        for (int i = 0; i < _finderPattern.length; i++) {
            for (int j = 0; j < _finderPattern.length; j++) {
                int v = _finderPattern[i][j];
                moduleMatrix[i][j] = v;
                moduleMatrix[i][j + offset] = v;
                moduleMatrix[i + offset][j] = v;
            }
        }
    }
    
}
