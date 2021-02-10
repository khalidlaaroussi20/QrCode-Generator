package QrCode.Contstants;

//Get Number Modules
public class Modules {

	    public static int getNumModulesPerSide(int version) {
	        return  (version-1) * 4 + 21;
	    }
}
