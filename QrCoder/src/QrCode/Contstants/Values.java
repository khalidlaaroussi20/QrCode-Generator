package QrCode.Contstants;

public class Values {
	public static final int BLANK      = 0;
	public static final int DARK       = 1;
	public static final int FINDER     = 2;
	public static final int SEPARATOR  = 3;
	public static final int ALIGNMENT  = 4;
    public static final int TIMING     = 5;
    public static final int DarkMODE   = 6;
    public static final int FORMAT     = 7;
    public static final int VERSION    = 8;

    public static Boolean isDark(int value) {
        return value > BLANK;
    }
    public static Boolean IsBlank(int value) {
        return value==BLANK;
    }
    public static Boolean IsDataBit(int value) {
    	if(value==BLANK || value==1)
    		return true;
    	return false;
    }

}
