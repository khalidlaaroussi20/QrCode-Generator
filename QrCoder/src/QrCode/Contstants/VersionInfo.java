package QrCode.Contstants;



public class VersionInfo {
	
	private static final int[] _VersionValues = {
	       // 1,2,3,4,5,....40
			-1,-1,-1,-1,-1,-1,-1,31892,34236,39577,42195,48118,51042,55367,58893,63784,68472,70749,76311,79154,84390,
			87683,92361,96236,102084,102881,110507,110734,117786,119615,126325,127568,133589,136944,141498,145311,150283,
			152622,158308,161089,167017
	    };
	
		//Get Version Information Value
	    public static int getVersionInfoValue(int Version) {
	        return _VersionValues[Version];
	    }
}
