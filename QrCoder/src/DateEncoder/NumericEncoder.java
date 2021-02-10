package DateEncoder;

import BitHelper.BitConverter;
import DataAnalyse.Mode_Encoding;
import EncoderConstants.CharCountIndicator;
import EncoderConstants.ModeIndicator;

public class NumericEncoder extends QrEncoder 
{
	
	public NumericEncoder(String data)
	{
		this._Data=data;
	}
	
	
	//get Encoding Mode
	@Override
	public int getEncodingMode() {
		return Mode_Encoding.Numeric_Mode;
	}

	//Get Mode Indicator
	@Override
	public int getModeIndicator() {
		
		return ModeIndicator.NUMERIC_VALUE;
	}
	
	//Get Count Indicator
	@Override
	public int getCountIndicator() 
	{
		return CharCountIndicator.getLength(_Version, Mode_Encoding.Numeric_Mode);
	}
	
	//Encode Data
	@Override
	public String Encode()
	{
		this._codeWords+=BitConverter.append(this.getModeIndicator(), 4);
		this._codeWords+=BitConverter.append(_Data.length(), getCountIndicator());
		this._codeWords+=ConvertNumeric();
		this.AddTerminator();
		this.MakeLenghtMultiple();
		this.FullCapacityQr();
		return this._codeWords.toString();
		
	}
	
	 
	//Encode  Mode Numeric
	private String ConvertNumeric()
	{
		String _DataEncoding="",CurrentGrp;
		int Len=_Data.length(),i,Number=0,CountZero;
		
		if(Len==0)
			return null;
		for(i=0;i<=Len-3;i+=3)
		{
			CountZero=0;
			CurrentGrp=this._Data.substring(i, i+3);
			if(CurrentGrp.charAt(0)==0)
			{
				CountZero++;
				if(CurrentGrp.charAt(1)==0)
					CountZero++;
			}
			Number=Integer.parseInt(CurrentGrp);
			if(CountZero==0)
				_DataEncoding+=BitConverter.append(Number,10);
			else if(CountZero==1)
				_DataEncoding+=BitConverter.append(Number,7);
			else
				_DataEncoding+=BitConverter.append(Number,4);
		    
		}
		int Rest=Len%3,NumberBit;
		if(Rest!=0)
		{
			if(Rest==1)
			{
				CurrentGrp=this._Data.substring(i, i+1);
				
				NumberBit=4;
			}
			else
			{
				CurrentGrp=this._Data.substring(i, i+2);
				NumberBit=7;
				
			}
			Number=	Integer.parseInt(CurrentGrp);
			_DataEncoding+=BitConverter.append(Number,NumberBit);
		}
		return _DataEncoding;
	}
}
