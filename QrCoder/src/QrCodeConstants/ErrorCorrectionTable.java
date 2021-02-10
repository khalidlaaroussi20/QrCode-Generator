package QrCodeConstants;

import java.util.HashMap;


// ************** Error Correction Table ******************
public class ErrorCorrectionTable
{
	private  static final HashMap<String , ErrorCorrectionFields> ErrorCrTable=new  HashMap<String , ErrorCorrectionFields> ();
	
	public ErrorCorrectionTable()
	{
		
		// *****	Fill Error Correction Table  *****
		
		//version 1
		ErrorCrTable.put("1-0", new ErrorCorrectionFields(19,7,1,19,19));
		ErrorCrTable.put("1-1", new ErrorCorrectionFields(16,10,1,16,16));
		ErrorCrTable.put("1-2", new ErrorCorrectionFields(13,13,1,13,13));
		ErrorCrTable.put("1-3", new ErrorCorrectionFields(9,17,1,9,9));
		
		//version 2
		
		ErrorCrTable.put("2-0", new ErrorCorrectionFields(34,10,1,34,34));
		ErrorCrTable.put("2-1", new ErrorCorrectionFields(28,16,1,28,16));
		ErrorCrTable.put("2-2", new ErrorCorrectionFields(22,22,1,22,22));
		ErrorCrTable.put("2-3", new ErrorCorrectionFields(16,28,1,16,16));
		
		//version 3
		
		ErrorCrTable.put("3-0", new ErrorCorrectionFields(55,15,1,55,55));
		ErrorCrTable.put("3-1", new ErrorCorrectionFields(44,26,1,44,44));
		ErrorCrTable.put("3-2", new ErrorCorrectionFields(34,18,2,17,34));
		ErrorCrTable.put("3-3", new ErrorCorrectionFields(26,22,2,13,26));
		
		//version 4
		
		ErrorCrTable.put("4-0", new ErrorCorrectionFields(80,20,1,80,80));
		ErrorCrTable.put("4-1", new ErrorCorrectionFields(64,18,2,32,64));
		ErrorCrTable.put("4-2", new ErrorCorrectionFields(48,26,2,24,48));
		ErrorCrTable.put("4-3", new ErrorCorrectionFields(36,16,4,9,36));
		
		//version 5
		
		ErrorCrTable.put("5-0", new ErrorCorrectionFields(108,26,1,108,108));
		ErrorCrTable.put("5-1", new ErrorCorrectionFields(86,24,2,43,86));
		ErrorCrTable.put("5-2", new ErrorCorrectionFields(62,18	,2,15,2,16,62));
		ErrorCrTable.put("5-3", new ErrorCorrectionFields(46,22	,2,11,2,12,46));
		
		
		//version 6
		
		ErrorCrTable.put("6-0", new ErrorCorrectionFields(136,18,2,68,136));
		ErrorCrTable.put("6-1", new ErrorCorrectionFields(108,16,4,27,108));
		ErrorCrTable.put("6-2", new ErrorCorrectionFields(76,24	,4,19,76));
		ErrorCrTable.put("6-3", new ErrorCorrectionFields(60,28	,4,15,60));
		
		//version 7
		
		ErrorCrTable.put("7-0", new ErrorCorrectionFields(156,20,2,78,156));
		ErrorCrTable.put("7-1", new ErrorCorrectionFields(124,18,4,31,124));
		ErrorCrTable.put("7-2", new ErrorCorrectionFields(88,18	,2,14,4,15,88));
		ErrorCrTable.put("7-3", new ErrorCorrectionFields(66,26	,4	,13,1,14,66));
		
		//version 8
		
		ErrorCrTable.put("8-0", new ErrorCorrectionFields(194,24,2,97,194));
		ErrorCrTable.put("8-1", new ErrorCorrectionFields(154,22,2,38,2,39,154));
		ErrorCrTable.put("8-2", new ErrorCorrectionFields(110,22,4,18,2,19,110));
		ErrorCrTable.put("8-3", new ErrorCorrectionFields(86,26	,4	,14,2,15,86));
		
		//version 9
		
		ErrorCrTable.put("9-0", new ErrorCorrectionFields(232,30,2,116,232));
		ErrorCrTable.put("9-1", new ErrorCorrectionFields(182,22,3,36,2,37,182));
		ErrorCrTable.put("9-2", new ErrorCorrectionFields(132,20,4,16,4,17,132));
		ErrorCrTable.put("9-3", new ErrorCorrectionFields(100,24,4,12,4,13,100));
		
		
		//version 10
		
		ErrorCrTable.put("10-0", new ErrorCorrectionFields(274,18,2,68,2,69,274));
		ErrorCrTable.put("10-1", new ErrorCorrectionFields(216,26,4,43,1,44,216));
		ErrorCrTable.put("10-2", new ErrorCorrectionFields(154,24,6,19,2,20,154));
		ErrorCrTable.put("10-3", new ErrorCorrectionFields(122,28,6,15,2,16,122));
		
		
		//version 11
		
		ErrorCrTable.put("11-0", new ErrorCorrectionFields(324,20,4,81,324));
		ErrorCrTable.put("11-1", new ErrorCorrectionFields(254,30,1,50,4,51,254));
		ErrorCrTable.put("11-2", new ErrorCorrectionFields(180,28,4,22,4,23,180));
		ErrorCrTable.put("11-3", new ErrorCorrectionFields(140,24,3,12,8,13,140));
		
		//version 12
		
		ErrorCrTable.put("12-0", new ErrorCorrectionFields(370,24,2,92,2,93,324));
		ErrorCrTable.put("12-1", new ErrorCorrectionFields(290,22,6,36,2,37,290));
		ErrorCrTable.put("12-2", new ErrorCorrectionFields(206,26,4,20,5,21,206));
		ErrorCrTable.put("13-3", new ErrorCorrectionFields(158,28,7,14,4,15,158));	
		
		//version 13
		
		ErrorCrTable.put("13-0", new ErrorCorrectionFields(428,26,4,107,428));
		ErrorCrTable.put("13-1", new ErrorCorrectionFields(334,22,8,37,1,38,334));
		ErrorCrTable.put("13-2", new ErrorCorrectionFields(244,24,8,20,4,21,244));
		ErrorCrTable.put("13-3", new ErrorCorrectionFields(180,22,12,11,4,12,180));
		
		
		//version 14
		
		ErrorCrTable.put("14-0", new ErrorCorrectionFields(461,30,3,115,1,116,461));
		ErrorCrTable.put("14-1", new ErrorCorrectionFields(365,24,4,40,5,41,365));
		ErrorCrTable.put("14-2", new ErrorCorrectionFields(261,20,11,16,5,17,261));
		ErrorCrTable.put("14-3", new ErrorCorrectionFields(197,24,11,12,5,13,197));
		//version 15
			
		ErrorCrTable.put("15-0", new ErrorCorrectionFields(523,22,5,87,1,88,523));
		ErrorCrTable.put("15-1", new ErrorCorrectionFields(415,24,5,41,5,42,415));
		ErrorCrTable.put("15-2", new ErrorCorrectionFields(295,30,5,24,7,25,295));
		ErrorCrTable.put("15-3", new ErrorCorrectionFields(223,24,11,12,7,13,223));
		
		//version 16
		
		ErrorCrTable.put("16-0", new ErrorCorrectionFields(589,25,5,98,1,99,589));
		ErrorCrTable.put("16-1", new ErrorCorrectionFields(453,28,7,45,3,46,453));
		ErrorCrTable.put("16-2", new ErrorCorrectionFields(325,24,15,19,2,20,325));
		ErrorCrTable.put("16-3", new ErrorCorrectionFields(253,30,3,15,13,16,253));
		
		//version 17
		
		ErrorCrTable.put("17-0", new ErrorCorrectionFields(647,28,1,107,5,108,647));
		ErrorCrTable.put("17-1", new ErrorCorrectionFields(507,28,10,46,1,47,507));
		ErrorCrTable.put("17-2", new ErrorCorrectionFields(367,28,1,22,15,23,367));
		ErrorCrTable.put("17-3", new ErrorCorrectionFields(283,28,2,14,17,15,283));
		
		//version 18
		
		ErrorCrTable.put("18-0", new ErrorCorrectionFields(721,30,5,120,1,121,721));
		ErrorCrTable.put("18-1", new ErrorCorrectionFields(563,26,9,43,4,44,563));
		ErrorCrTable.put("18-2", new ErrorCorrectionFields(397,28,17,22,1,23,397));
		ErrorCrTable.put("18-3", new ErrorCorrectionFields(313,28,2,14,19,15,313));
		
		
		//version 19
		
		ErrorCrTable.put("19-0", new ErrorCorrectionFields(795,28,3,113,4,114,795));
		ErrorCrTable.put("19-1", new ErrorCorrectionFields(627,26,3,44,11,45,627));
		ErrorCrTable.put("19-2", new ErrorCorrectionFields(445,28,17,21,4,22,445));
		ErrorCrTable.put("19-3", new ErrorCorrectionFields(341,26,9,13,16,14,341));
		
		
		//version 20
		
		ErrorCrTable.put("20-0", new ErrorCorrectionFields(861,28,3,107,5,108,861));
		ErrorCrTable.put("20-1", new ErrorCorrectionFields(669,26,3,41,13,42,669));
		ErrorCrTable.put("20-2", new ErrorCorrectionFields(485,30,15,24,5,25,485));
		ErrorCrTable.put("20-3", new ErrorCorrectionFields(385,28,15,15,15,16,385));
		
		//version 21
		
		ErrorCrTable.put("21-0", new ErrorCorrectionFields(932,28,4,116,4,117,932));
		ErrorCrTable.put("21-1", new ErrorCorrectionFields(714,26,17,42,714));
		ErrorCrTable.put("21-2", new ErrorCorrectionFields(512,28,17,22,6,23,512));
		ErrorCrTable.put("21-3", new ErrorCorrectionFields(406,30,19,16,6,17,406));
		
		//version 22
		
		ErrorCrTable.put("22-0", new ErrorCorrectionFields(1006,28,2,111,7,112,1006));
		ErrorCrTable.put("22-1", new ErrorCorrectionFields(782,28,17,46,782));
		ErrorCrTable.put("22-2", new ErrorCorrectionFields(568,30,7,24,16,25,568));
		ErrorCrTable.put("22-3", new ErrorCorrectionFields(442,24,34,13,442));
		
		//version 23
		
		ErrorCrTable.put("23-0", new ErrorCorrectionFields(1094,30,4,121,5,122,1094));
		ErrorCrTable.put("23-1", new ErrorCorrectionFields(860,28,4,47,14,48,860));
		ErrorCrTable.put("23-2", new ErrorCorrectionFields(614,30,11,24,14,25,614));
		ErrorCrTable.put("23-3", new ErrorCorrectionFields(464,30,16,15,14,16,464));
		
		
		//version 24
		
		ErrorCrTable.put("24-0", new ErrorCorrectionFields(1174,30,6,117,4,118,1174));
		ErrorCrTable.put("24-1", new ErrorCorrectionFields(914,28,6,45,14,46,914));
		ErrorCrTable.put("24-2", new ErrorCorrectionFields(664,30,11,24,16,25,664));
		ErrorCrTable.put("24-3", new ErrorCorrectionFields(514,30,30,16,2,17,514));
		
		//version 25
		ErrorCrTable.put("25-0", new ErrorCorrectionFields(1276,26,8,106,4,107,1276));
		ErrorCrTable.put("25-1", new ErrorCorrectionFields(1000,28,8,47,13,48,1000));
		ErrorCrTable.put("25-2", new ErrorCorrectionFields(718,30,7,24,22,25,718));
		ErrorCrTable.put("25-3", new ErrorCorrectionFields(538,30,22,15,13,16,538));
		
		//version 26
		ErrorCrTable.put("26-0", new ErrorCorrectionFields(1370,28,10,114,2,115,1370));
		ErrorCrTable.put("26-1", new ErrorCorrectionFields(1062,28,19,46,4,47,1062));
		ErrorCrTable.put("26-2", new ErrorCorrectionFields(754,28,28,22,6,23,754));
		ErrorCrTable.put("26-3", new ErrorCorrectionFields(596,30,36,16,4,17,596));
		
		//version 27
		ErrorCrTable.put("27-0", new ErrorCorrectionFields(1468,30,8,122,4,123,1468));
		ErrorCrTable.put("27-1", new ErrorCorrectionFields(1128,28,22,45,3,46,1128));
		ErrorCrTable.put("27-2", new ErrorCorrectionFields(808,30,8,23,26,24,754));
		ErrorCrTable.put("27-3", new ErrorCorrectionFields(628,30,12,15,28,16,628));
		
		//version 28
		ErrorCrTable.put("28-0", new ErrorCorrectionFields(1531,30,3,117,10,118,1531));
		ErrorCrTable.put("28-1", new ErrorCorrectionFields(1193,28,3,45,23,46,1193));
		ErrorCrTable.put("28-2", new ErrorCorrectionFields(871,30,4,24,31,25,871));
		ErrorCrTable.put("28-3", new ErrorCorrectionFields(661,30,11,15,31,16,661));
		
		//version 29
		ErrorCrTable.put("29-0", new ErrorCorrectionFields(1631,30,7,116,7,117,1631));
		ErrorCrTable.put("29-1", new ErrorCorrectionFields(1267,28,21,45,7,46,1267));
		ErrorCrTable.put("29-2", new ErrorCorrectionFields(911,30,1,23,37,24,871));
		ErrorCrTable.put("29-3", new ErrorCorrectionFields(701,30,19,15,26,16,701));
		
		//version 30
		ErrorCrTable.put("30-0", new ErrorCorrectionFields(1735,30,5,115,10,116,1735));
		ErrorCrTable.put("30-1", new ErrorCorrectionFields(1373,28,19,47,10,48,1373));
		ErrorCrTable.put("30-2", new ErrorCorrectionFields(985,30,15,24,25,25,985));
		ErrorCrTable.put("30-3", new ErrorCorrectionFields(745,30,23,15,25,16,745));
		
		//version 31
		ErrorCrTable.put("31-0", new ErrorCorrectionFields(1843	,30,13,115,3,116,1843));
		ErrorCrTable.put("31-1", new ErrorCorrectionFields(1455,28,2,46,29,47,1455));
		ErrorCrTable.put("31-2", new ErrorCorrectionFields(1033,30,42,24,1,25,1033));
		ErrorCrTable.put("31-3", new ErrorCorrectionFields(793,30,23,15,28,16,793));
		
		//version 32
		ErrorCrTable.put("32-0", new ErrorCorrectionFields(1955,30,17,115,1955));
		ErrorCrTable.put("32-1", new ErrorCorrectionFields(1541,28,10,46,23,47,1541));
		ErrorCrTable.put("32-2", new ErrorCorrectionFields(1115,30,10,24,34,25,1115));
		ErrorCrTable.put("32-3", new ErrorCorrectionFields(845,30,19,15,35,16,845));
		
		//version 33
		ErrorCrTable.put("33-0", new ErrorCorrectionFields(2071	,30,17,115,1,116,2071));
		ErrorCrTable.put("33-1", new ErrorCorrectionFields(1631,28,14,46,21,47,1631));
		ErrorCrTable.put("33-2", new ErrorCorrectionFields(1171,30,29,24,19,25,1171));
		ErrorCrTable.put("33-3", new ErrorCorrectionFields(901,30,11,15,46,16,901));
		
		
		//version 34
		ErrorCrTable.put("34-0", new ErrorCorrectionFields(2191	,30,13,115,6,116,2191));
		ErrorCrTable.put("34-1", new ErrorCorrectionFields(1725,28,14,46,23,47,1631));
		ErrorCrTable.put("34-2", new ErrorCorrectionFields(1231,30,44,24,7,25,1231));
		ErrorCrTable.put("34-3", new ErrorCorrectionFields(961,30,59,16,1,17,961));
		
		
		//version 35
		ErrorCrTable.put("35-0", new ErrorCorrectionFields(2306	,30,12,121,7,122,2306));
		ErrorCrTable.put("35-1", new ErrorCorrectionFields(1812,28,12,47,26,48,1812));
		ErrorCrTable.put("35-2", new ErrorCorrectionFields(1286,30,39,24,14,25,1286));
		ErrorCrTable.put("35-3", new ErrorCorrectionFields(986,30,22,15,41,16,986));
		
		//version 36
		ErrorCrTable.put("36-0", new ErrorCorrectionFields(2434	,30,6,121,14,122,2434));
		ErrorCrTable.put("36-1", new ErrorCorrectionFields(1914,28,6,47,34,48,1914));
		ErrorCrTable.put("36-2", new ErrorCorrectionFields(1354,30,46,24,10,25,1354));
		ErrorCrTable.put("36-3", new ErrorCorrectionFields(1054,30,2,15,64,16,1054));
		
		//version 37
		ErrorCrTable.put("37-0", new ErrorCorrectionFields(2566	,30,17,122,4,123,2566));
		ErrorCrTable.put("37-1", new ErrorCorrectionFields(1992,28,29,46,14,47,1992));
		ErrorCrTable.put("37-2", new ErrorCorrectionFields(1426,30,49,24,10,25,1426));
		ErrorCrTable.put("37-3", new ErrorCorrectionFields(1096,30,24,15,46,16,1096));
		
		//version 38
		ErrorCrTable.put("38-0", new ErrorCorrectionFields(2702	,30,4,122,18,123,2702));
		ErrorCrTable.put("38-1", new ErrorCorrectionFields(2102,28,13,46,32,47,2102));
		ErrorCrTable.put("38-2", new ErrorCorrectionFields(1502,30,48,24,14,25,1502));
		ErrorCrTable.put("38-3", new ErrorCorrectionFields(1142,30,42,15,32,16,1142));
		
		//version 39
		ErrorCrTable.put("39-0", new ErrorCorrectionFields(2812	,30,20,117,4,118,2812));
		ErrorCrTable.put("39-1", new ErrorCorrectionFields(2216,28,40,47,7,48,2216));
		ErrorCrTable.put("39-2", new ErrorCorrectionFields(1582,30,43,24,22,25,1582));
		ErrorCrTable.put("39-3", new ErrorCorrectionFields(1222,30,10,15,67,16,1222));
		
		//version 40
		ErrorCrTable.put("40-0", new ErrorCorrectionFields(2956	,30,19,118,6,119,2956));
		ErrorCrTable.put("40-1", new ErrorCorrectionFields(2334,28,18,47,31,48,2334));
		ErrorCrTable.put("40-2", new ErrorCorrectionFields(1666,30,34,24,34,25,1666));
		ErrorCrTable.put("40-3", new ErrorCorrectionFields(1276,30,20,15,61,16,1276));
	}
	
	//Generate Key Table 
	private String GetKeyTable(int Version,int ErrorCLevel)
	{
		return Version+"-"+ErrorCLevel;
	}
	
	//Get Total Number Data CodeWords
	public int GetTotalNumberDataCodewords(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc).TotalNumberDataCodewords;
		
		return -1;
	}
	
	//Get EC Codewords Per Block
	public int GetECCodewordsPerBlock(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc).ECCodewordsPerBlock;		
		return -1;
	}
	
	//Get  Number Blocks First Group
	public int GetNumberBlocksFirstGroup(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc).NumberBlocksFirstGroup;		
		return -1;
	}
	
	//Get Number Data CodewordS First Group
	public int GetNumberDataCodewordSFirstGroup(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc). NumberDataCodewordSFirstGroup;		
		return -1;
	}
	
	//Get Number Blocks Second Group
	public int GetNumberBlocksSecondGroup(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);	
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc).NumberBlocksSecondGroup;		
		return -1;
	}
	
	public int GetNumberDataCodewordSecondGroup(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc).NumberDataCodewordSecondGroup;		
		return -1;
	}
	
	//Get Total Data Codewords
	public int GetTotalDataCodewords(int Version,int ErrorCLevel)
	{
		String LevelAndEc =GetKeyTable(Version,ErrorCLevel);
		if(ErrorCrTable.containsKey(LevelAndEc))
			return ErrorCrTable.get(LevelAndEc).TotalDataCodewords;		
		return -1;
	}
	
	//Structure ErrorCorrection Table
	 private class ErrorCorrectionFields 
	{
		 private int TotalNumberDataCodewords;
		 public int ECCodewordsPerBlock;
		 public int NumberBlocksFirstGroup;
		 public int NumberDataCodewordSFirstGroup;
		 public int NumberBlocksSecondGroup=0;
		 public int NumberDataCodewordSecondGroup=0;
		 public int TotalDataCodewords;
		 
		 //For Fill Error Correction Table 
		 public ErrorCorrectionFields(int TotalNumberDataCodewords,int ECCodewordsPerBlock,int NumberBlocksFirstGroup,int NumberDataCodewordSFirstGroup, int TotalDataCodewords)
		 {
			 this.TotalNumberDataCodewords=TotalNumberDataCodewords;
			 this.ECCodewordsPerBlock=ECCodewordsPerBlock;
			 this.NumberBlocksFirstGroup=NumberBlocksFirstGroup;
			 this.NumberDataCodewordSFirstGroup=NumberDataCodewordSFirstGroup;
			 this.TotalDataCodewords=TotalDataCodewords;
		 }
		 
		 //For Fill Error Correction Table 
		 public ErrorCorrectionFields(int TotalNumberDataCodewords,int ECCodewordsPerBlock,int NumberBlocksFirstGroup,int NumberDataCodewordSFirstGroup, int NumberBlocksSecondGroup
				 ,int NumberDataCodewordSecondGroup,int TotalDataCodewords)
		 {
			 this.TotalNumberDataCodewords=TotalNumberDataCodewords;
			 this.ECCodewordsPerBlock=ECCodewordsPerBlock;
			 this.NumberBlocksFirstGroup=NumberBlocksFirstGroup;
			 this.NumberDataCodewordSFirstGroup=NumberDataCodewordSFirstGroup;
			 this.NumberBlocksSecondGroup=NumberBlocksSecondGroup;
			 this.NumberDataCodewordSecondGroup=NumberDataCodewordSecondGroup;
			 this.TotalDataCodewords=TotalDataCodewords;
		 }
	}
}


