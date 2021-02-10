package DataAnalyse;

public class DataAnalyse 
{
	private static String  MatchingNumeric = "\\d+";
	private static String MatchingAlphaNumeric = "^[A-Z0-9[$%*+-./ ]]+$";
	
	//Chose Mode Encoding
	public  static int Mode_Encoding(String Content)
	{
		 if(Content.matches(MatchingNumeric))
			 return Mode_Encoding.Numeric_Mode;
		 else if(Content.matches(MatchingAlphaNumeric))
			 return Mode_Encoding.Alphanumeric_Mode;
		 return Mode_Encoding.Byte_Mode;
	}
}
