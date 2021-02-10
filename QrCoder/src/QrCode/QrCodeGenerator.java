package QrCode;
import java.io.IOException;


import DateEncoder.QrEncoder;
import QrCode.Contstants.Modules;
import QrCode.Contstants.Values;
import QrCodeConstants.ErrorCorrectionLevel;

public class QrCodeGenerator {
	
	/*
	 * Parameter 1 is Data 
	 * Parameter 2 Name  Result Image 
	 */
	
	public static void QrCodeGenerat(String Data,String ImageName) throws IOException
	{
		
		QrEncoder QR=QrEncoder.createEncoder(Data);
		//Encode Data
		String EncodingData=QR.Encode();
		//Get Version and Put Default Error Correction Level
		int Version=QrEncoder._Version,ErrorCrLevel=ErrorCorrectionLevel.M;
		
		
		//Create New Object For this Version and Error Correction Level
		ErrorCorrection ErrorC=new ErrorCorrection(Version,ErrorCrLevel);
		
		//BLock Encoding Data and Error Correction 
		Blocks block=new Blocks(EncodingData,ErrorC);
		
		
		
		//Get size QrCode  From Version
		int NumberModules=Modules.getNumModulesPerSide(Version);
		
		//Create New Matrix  with Size that we Get already
    	int [][] moduleMatrix= new int[NumberModules][NumberModules];
    	
    	//Place Finders Pattern in  Matrix
    	FinderPattern.placeInMatrix(moduleMatrix);
    	
    	//Place Separators Pattern in  Matrix
    	Separators.placeInMatrix(moduleMatrix);
    	
    	//Place Alignment Patterns  in  Matrix if Version>=2
    	if(Version>=2)
    		AlignmentPatterns.placeInMatrix(moduleMatrix, Version);	
    	
    	//Place Format Area    in  Matrix 
    	FormatArea.placeInMatrix(moduleMatrix);
    	
    	//Place Timing Patterns    in  Matrix 
    	TimingPatterns.placeInMatrix(moduleMatrix);
    	
    	//Reverse  Reversed Area in Dark Module in Matrix
    	DarkModule_ReservedAreas.placeInMatrix(moduleMatrix, Version);
    	
    	//Place the Final Message to The Matrix
    	PlaceDataBits pb=new PlaceDataBits(block.FinalMessage);
    	pb.PlaceDataBitsInMatrix(moduleMatrix);
    	
    	//Create New Object DataMasking
    	DataMasking dt = new DataMasking(moduleMatrix,ErrorCrLevel,Version);
    	//Chose  Best Mask Patterns 
    	moduleMatrix=dt.BestMaskPattern();
    	
    	//Get  Index Best Mask
    	int indexMask=dt.GetIndexBestMask();
    	
    	//place Format Bit In Matrix
    	FormatInformation.PlaceFormBit(moduleMatrix, ErrorCrLevel,indexMask);    	
    	
    	//place Version Bit In Matrix if Version >=7
		if(Version>=7)
    		FormatInformation.PlaceVersionBit(moduleMatrix, Version);
		//place Dark Module In Matrix 
    	DarkModule_ReservedAreas.PlaceDarkModuleInMatrix(moduleMatrix, Version,Values.DARK);
    	
    	//Finally  Draw Image  
    	/*
    	 * Parameter  1 is The Module Matrix
    	 * Parameter  2 is The Name Image
    	 */
    	DrawImage.DrawQr(moduleMatrix,ImageName);
	}
}
