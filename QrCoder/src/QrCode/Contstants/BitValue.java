package QrCode.Contstants;

//Bit Values
public class BitValue {
	private static final int[][] _bitValues = {
	        /* Error Correction Level L */
	        new int[]{
	        		30660,   29427,   32170,   30877,  26159,  25368,  27713,  26998
	        },
	        /* Error Correction Level M */
	        new int[]{
	        		21522,   20773,   24188,   23371,   17913,  16590,  20375,  19104
	        },
	        /* Error Correction Level Q */
	        new int[]{
	        		13663,   12392,   16177,   14854,   9396,   8579,   11994,  11245
	            
	        },
	        /* Error Correction Level H */
	        new int[]{
	        		5769,   5054,   7399,   6608,   1890,   597,   3340,  2107
	        }
	    };

	    public static int getBitValue(int ErroCorrLevel,int MaskPattern) {
	        return _bitValues[ErroCorrLevel][MaskPattern];
	    }
}
