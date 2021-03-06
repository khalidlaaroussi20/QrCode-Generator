package DataAnalyse;

public class CharactereCapacity {
	//Table Character Capacity jUST for M Error Correction Level
	public static int[][] CapaciteTable=
		{
			//version 1,2,3,....40	
			new int[]
			{
					//Numeric Mode CAPACITY fOR each Level
					-1,
					34,63,101,149,202,255,293,365,432,513,
					604,691,796,871,991,1082,1212,1346,1500,1600,
					1708,1872,2059,2188,2395,2544,2701,2857,3035,3289,
					3486,3693,3909,4134,4343,4588,4775,5039,5313,5596
			}
			,
			new int[]
			{
				//AlphaNumeric Mode CAPACITY fOR each Level
				-1,
				20,38,61,90,122,154,178,221,262,311,
				366,419,483,528,600,656,734,816,909,970,
				1035,1134,1248,1326,1451,1542,1637,1732,1839,1994,
				2113,2238,2369,2506,2632,2780,2894,3054,3220,3391
			}
			,
			new int[]
			{
				//byte Mode CAPACITY fOR each Level
				-1,
				14,26,42,62,84,106,122,152,180,213,
				251,287,331,362,412,450,504,560,624,666,
				711,779,857,911,997,1059,1125,1190,1264,1370,
				1452,1538,1628,1722,1809,1911,1989,2099,2213,2331
				
			}
		};
}
