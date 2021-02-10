package DateEncoder;


import BitHelper.BitConverter;
import DataAnalyse.Mode_Encoding;
import EncoderConstants.CharCountIndicator;
import EncoderConstants.ModeIndicator;


public class AlphaNumericEncoder extends QrEncoder 
{
	
	public AlphaNumericEncoder(String Data)
	{
		_Data=Data;
	}
	
	//get Encoding Mode
	@Override
	public int getEncodingMode() {
		return Mode_Encoding.Alphanumeric_Mode;
	}
	
	//get Mode Indicator
	@Override
	public int getModeIndicator() {
		return ModeIndicator.ALPAHNUMERIC_VALUE;
	}
	
	//get Count Indicator
	@Override
	public int getCountIndicator() 
	{
		return CharCountIndicator.getLength(_Version, Mode_Encoding.Alphanumeric_Mode);
	}
	
	//Encoding Data
	@Override
	public String Encode()
	{
		
		this._codeWords+=BitConverter.append(this.getModeIndicator(), 4);
		this._codeWords+=BitConverter.append(_Data.length(), getCountIndicator());
		this._codeWords+=ConvertAlphaNumeric();
		this.AddTerminator();
		this.MakeLenghtMultiple();
		this.FullCapacityQr();
		return this._codeWords;
	}
	
	//EnCode AlphaNumeric 
	private String ConvertAlphaNumeric()
	{
		String _DataEncoding="",CurrentPair;
		int Len=_Data.length(),i,Number=0;
		
		if(Len==0)
			return null;
		for(i=0;i<=Len-2;i+=2)
		{
			 CurrentPair=this._Data.substring(i, i+2);
			 Number=convertCharCode(CurrentPair.charAt(0))*45+convertCharCode(CurrentPair.charAt(1));
		    _DataEncoding+=BitConverter.append(Number,11);
		}
		if(Len%2!=0)
		{
			 Number=convertCharCode(_Data.charAt(Len-1));
			_DataEncoding+=BitConverter.append(Number,6);
		}
		return _DataEncoding;
		
				 
	}
	
	//Get Value Of Table AlphaNumeric Value
	 private static int convertCharCode(char c) {
	        if (c == ' ') {
	            return 36;
	        }
	        if (c == '$' || c == '%') {
	            return c + 1;
	        }
	        if (c == '*' || c == '+') {
	            return c - 3;
	        }
	        if (c == '-' || c == '.') {
	            return c - 4;
	        }
	        if (c == '/') {
	            return 43;
	        }
	        if ('0' <= c && c <= '9') {
	            return c - 48;
	        }
	        if (c == ':') {
	            return 44;
	        }
	        if ('A' <= c && c <= 'Z') {
	            return c - 55;
	        }

	        return -1;
	    }
}
