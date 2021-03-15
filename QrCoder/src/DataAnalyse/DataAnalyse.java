package DataAnalyse;

public class DataAnalyse 
{
	private static String  MatchingNumericMode = "\\d+";
	private static String MatchingAlphaNumericMode = "^[A-Z0-9[$%*+-./ ]]+$";
	
	
	//Chose Mode Encoding
	public  static int Mode_Encoding(String Content)
	{
		 if(Content.matches(MatchingNumericMode))
			 return Mode_Encoding.Numeric_Mode;
		 else if(Content.matches(MatchingAlphaNumericMode))
			 return Mode_Encoding.Alphanumeric_Mode;
		 else
			 return Mode_Encoding.Byte_Mode;
	}
}
