package BitHelper;



public class BitConverter {
     public static String append(int value,int lenght)
	 {
		String  _DataEncoding="";
		 for(int i=lenght-1;i>=0;i--)
		 {
			 if((value &(1 << i))!=0)
				 _DataEncoding+="1";
			else
				_DataEncoding+="0";
		 }
		 return _DataEncoding;
	 }
	 public static  int RemoveLeft0(int Number,int StartPosistion)
	 {
		 int Index=StartPosistion-1;
		 for(int i=StartPosistion-1;i>=0;i--)
		 {
			 if((Number & (1 << i)) != 0)
				 return Index;
			 Index--;
			 
		 }
		 return Index;
	 }
}

	