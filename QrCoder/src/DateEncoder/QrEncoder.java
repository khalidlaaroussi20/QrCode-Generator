package DateEncoder;

import BitHelper.BitConverter;
import DataAnalyse.ChoseLevel;
import DataAnalyse.DataAnalyse;
import DataAnalyse.Mode_Encoding;
import EncoderConstants.Constant;
import QrCodeConstants.ErrorCorrectionLevel;
import QrCodeConstants.ErrorCorrectionTable;


public abstract class QrEncoder {
	 public String  _codeWords="";
	 public  String _Data;
	 public static int _Version=6;
	 public int Number_Bit;
	 public int ErrorCrLevel=ErrorCorrectionLevel.M;
	 private ErrorCorrectionTable ErroCorrectionTable=new ErrorCorrectionTable();
	 
	 public abstract int getEncodingMode();
	 

	 public abstract int getModeIndicator();
	 
	 public abstract int getCountIndicator();
	 public abstract String Encode();

	 //Get Version
	 public  int getVersion()
	 {
		 
		 return _Version;
	 }
	 
	 //Get Number Bit
	 public  int GetNumberBit()
	 {
		 Number_Bit=ErroCorrectionTable.GetTotalNumberDataCodewords(_Version, ErrorCrLevel)*8;
		 return Number_Bit;
	 }
	 
	 //Add Terminator 
	 public void AddTerminator()
	 {
		 
		 int NumberZeros= GetNumberBit()-this._codeWords.length();
		 if(NumberZeros>4)
		 {
			 this._codeWords+=BitConverter.append(0, 4);
			 return;
		 }
		 this._codeWords+=BitConverter.append(0, NumberZeros);
		 
	 }
	 //append 0 till be Multiple 8
	 public void  MakeLenghtMultiple()
	 {
		 int Count_CodeWord=this._codeWords.length();
		 while(Count_CodeWord%8!=0)
		 {
			 this._codeWords+="0";
			 Count_CodeWord++;
		 }
	 }
	 //if is still COunt is short than Capacity Full It
	 public void FullCapacityQr()
	 {
		 
		int CountCodeWord=this._codeWords.length(),Current_Value;
		//Calculate  Number Of Bit That is still Empty
		int NumBitEmpty=Number_Bit-CountCodeWord;
		
		//Divide number By 8 TO Know how many 8 Bit we Need
		for(int i=0;i<NumBitEmpty/8;i++)
		{
			Current_Value=Constant.NumberForEmptyBit[i%2];
			this._codeWords+=BitConverter.append(Current_Value,8);
		}
		 
	 }
	 //Get QrEncode Object 
	 public static QrEncoder createEncoder(String DATA) 
	 {
		 
		 int encMode=DataAnalyse.Mode_Encoding(DATA);
		 _Version=ChoseLevel.ChoseBstVersion(encMode,DATA.length());
	        switch (encMode) {
	        case Mode_Encoding.Numeric_Mode:
	            return new NumericEncoder(DATA);
	        case Mode_Encoding.Alphanumeric_Mode:
	            return new AlphaNumericEncoder(DATA);
	        case Mode_Encoding.Byte_Mode:
	            return new ByteEncoder(DATA);
	        default:
	            throw new IllegalArgumentException("encMode");
	        }
	 }

}