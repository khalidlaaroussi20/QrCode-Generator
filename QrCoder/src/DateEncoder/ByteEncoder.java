package DateEncoder;

import BitHelper.BitConverter;
import DataAnalyse.Mode_Encoding;
import EncoderConstants.CharCountIndicator;
import EncoderConstants.ModeIndicator;

public class ByteEncoder extends QrEncoder 
{
	
	public ByteEncoder(String Data)
	{
		this._Data=Data;
	}
	
	// get Encoding Mode
	@Override
	public int getEncodingMode() {
		return Mode_Encoding.Byte_Mode;
	}

	// get Encoding Mode
	@Override
	public int getModeIndicator() {
		return ModeIndicator.BYTE_VALUE;
	}

	
	//get Count Indicator
	@Override
	public int getCountIndicator() {
		return CharCountIndicator.getLength(_Version, Mode_Encoding.Byte_Mode);
	}
	
	//Encode DATA
	@Override
	public String Encode()
	{
		this._codeWords+=BitConverter.append(this.getModeIndicator(), 4);
		this._codeWords+=BitConverter.append(_Data.length(), getCountIndicator());
		this._codeWords+=ConvertModeByte();
		this.AddTerminator();
		this.MakeLenghtMultiple();
		this.FullCapacityQr();
		return this._codeWords;
	}
	
	public String  ConvertModeByte()
	{
		String _DataEncoding="";
		int Len=_Data.length(),i,Current_Char;
		if(Len==0)
			return null;
		
		for(i=0;i<Len;i++)
		{
			Current_Char=_Data.charAt(i);
			_DataEncoding+=BitConverter.append(Current_Char, 8);
		}
		return _DataEncoding;
	}
}
