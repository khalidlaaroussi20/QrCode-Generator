package StringHelper;

public class StringHelper {
	public static String SplitWithPoint(String File)
	{
		String FileName="";
		char CurrentChar;
		for(int i=0;i<File.length();i++)
		{
			CurrentChar=File.charAt(i);
			if(CurrentChar=='.')
				break;
			FileName+=CurrentChar;
		}
		return FileName;
	}

}
