package dragonn.resources.logging;

import java.io.FileWriter;
import java.io.IOException;

import dragonn.resources.files.TextFile;

public class PrintLog
{
	//TODO: Get this to work right. Console is wonderful, but worthless without a logfile. I did it once, I can do it again.
	public static String logPath;

	public static void setLogPath(String path)
	{
		logPath = path;
		TextFile.createFile(logPath);
	}

	public static void println(String var)
	{
		try
		{
			FileWriter file = new FileWriter(logPath, true);
			file.write(var);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(var);
	}
}
