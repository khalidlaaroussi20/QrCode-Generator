package DataAnalyse;

public class DataAnalyse 
{
	private static String  MatchingNumericMode = "\\d+";
	private static String MatchingAlphaNumericMode = "^[A-Z0-9[$%*+-./ ]]+$";
	private static String MatchKanjyMode="^([\\x00-\\x7F]|[\\xC2-\\xDF][\\x80-\\xBF]|\\xE0[\\xA0-\\xBF][\\x80-\\xBF]|[\\xE1-\\xEC][\\x80-\\xBF]{2}|\\xED[\\x80-\\x9F][\\x80-\\xBF]|[\\xEE-\\xEF][\\x80-\\xBF]{2}|\\xF0[\\x90-\\xBF][\\x80-\\xBF]{2}|[\\xF1-\\xF3][\\x80-\\xBF]{3}|\\xF4[\\x80-\\x8F][\\x80-\\xBF]{2})+$";
	
	
	//Chose Mode Encoding
	public  static int Mode_Encoding(String Content)
	{
		 if(Content.matches(MatchingNumericMode))
			 return Mode_Encoding.Numeric_Mode;
		 else if(Content.matches(MatchingAlphaNumericMode))
			 return Mode_Encoding.Alphanumeric_Mode;
		 else if(!Content.matches(MatchKanjyMode))
			 throw new IllegalArgumentException("This Mode Encoding Not Supported"); 
		 else
			 return Mode_Encoding.Byte_Mode;
	}
}
