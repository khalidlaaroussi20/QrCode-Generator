package QrCode;

import ArrayHelper.ArraySytsem;
import BitHelper.BitConverter;
import QrCodeConstants.ErrorCorrectionTable;

public class Blocks {
	int Version;
	String _codeWords;
	 ErrorCorrectionTable ErrorCorrectionTable=new ErrorCorrectionTable();
	 private int [][] DataCWord;
	 private int [][] ErrorCorrect;
	 public String FinalMessage;
	  
	 ErrorCorrection  _ErrorC;
	 public Blocks(String  _codeWords,ErrorCorrection _ErrorC)
	 {
		 FinalMessage="";
		 this._codeWords=_codeWords;
		 this.Version=_ErrorC._Version;
		 this._ErrorC=_ErrorC;
		 //Get  Block
		 GetBblocks();
	 }
	 private void GetBblocks()
	 {
		 //Get Error Correction Level
		 int ErrorCorLevel=_ErrorC._Error_Correction_Level;
		 
		 //Get Number Block  First Group
		 int NumberBlockFG= ErrorCorrectionTable.GetNumberBlocksFirstGroup(Version,ErrorCorLevel);
		 
		 //Get Number Data Codewords  First Group
		 int NumberDataCWFG=ErrorCorrectionTable.GetNumberDataCodewordSFirstGroup(Version, ErrorCorLevel); 
		 
		 //Get Number Block  Second Group
		 int NumberBlockSG= ErrorCorrectionTable.GetNumberBlocksSecondGroup(Version,ErrorCorLevel);
		 
		//Get Number Data Codewords  Second Group
		 int NumberDataCWSG=ErrorCorrectionTable.GetNumberDataCodewordSecondGroup(Version,ErrorCorLevel);	
		 
		 int TotalNumberBlock=NumberBlockFG+NumberBlockSG,NumberBlock=NumberBlockFG,NumberDataCW=NumberDataCWFG,Count=0;
		 this.DataCWord= new int[TotalNumberBlock][];
		 this.ErrorCorrect= new int[TotalNumberBlock][];
		 int [] CuurentInt,temp;
		 String CurrentCodeWord;
		 
		 for(int i=0;i<TotalNumberBlock;i++)
		 {
			 if(i==NumberBlock)
			 {
				 NumberBlock=NumberBlockSG;
				 NumberDataCW=NumberDataCWSG;
			 }
			
			 CuurentInt =new int[NumberDataCW];
			 temp=new int[NumberDataCW];
			 for(int j=0;j<NumberDataCW;j++)
			 {
				 	CurrentCodeWord=this._codeWords.substring(Count, Count+8);					
				 	CuurentInt[j]=Integer.parseInt(CurrentCodeWord, 2);
					Count+=8;
			 }
			 //Put Block Of DataCoode Word in DataCWord
			 DataCWord[i]=CuurentInt;
			 System.arraycopy(CuurentInt, 0, temp, 0,NumberDataCW);
			 Polynomial Poly1=new Polynomial(temp,temp.length-1);
			 //Get Error COrrection For this Data CodeWord
			 Polynomial Res=_ErrorC.Divide(Poly1);
			 
			 //Then Put this ResulT Error Correction in ErrorCorrect
			 ErrorCorrect[i]=ArraySytsem.convertToArray(Res.C,_ErrorC.NumberErrorCorrection);
		 }
		 //First Interval Data CodeWord 
		 IntervalBlocks(this.DataCWord,NumberDataCWFG,NumberDataCWSG,NumberBlockFG);
		 int NumberEc=ErrorCorrectionTable.GetECCodewordsPerBlock(Version, ErrorCorLevel);
		 //Then Interval ErrrorCorrection
		 IntervalBlocks(this.ErrorCorrect,NumberEc,NumberEc,NumberBlockFG);

	 }
	 
	 //Interval Blocks
	 private void IntervalBlocks(int [][] Data,int NumberDataCWFG, int NumberDataCWSG,int NumberBlockFG)
	 {
		 int NumberData=Math.min(NumberDataCWFG, NumberDataCWSG),k=0;
		 for(;k<NumberData;k++)
		 {
			 for(int i=0;i<Data.length;i++)
			 {
				 this.FinalMessage+=BitConverter.append(Data[i][k],8);
			 }
		 }
		 for(;k<NumberDataCWFG;k++)
		 {
			 for(int i=0;i<NumberBlockFG;i++)
			 {
				 this.FinalMessage+=BitConverter.append(Data[i][k],8);
			 }
		 }
		 if(k<NumberDataCWSG)
		 {
			 for(;k<NumberDataCWSG;k++)
			 {
				 for(int i=NumberBlockFG;i<Data.length;i++)
				 {
					 this.FinalMessage+= BitConverter.append(Data[i][k],8);
				 }
			 }
		 }
	 }
}
