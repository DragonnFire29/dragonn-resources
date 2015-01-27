package dragonn.resources.files;

import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.text.MessageFormat;

public class DebugStream extends PrintStream
{
	private static ManagedFile logFile;
	private static Console javaConsole;

	public DebugStream()
	{
		super(System.out);
		javaConsole = System.console();
		logFile = new ManagedFile("system/log/", "log" + System.currentTimeMillis() + ".log");
	}

	@Override
	public void println(Object x)
	{
		showLocation();
		super.println(x);
	}

	@Override
	public void println(String x)
	{
		String message = showLocation() + x;
		try
		{
			javaConsole.writer().println(message);
			logFile.AppendToFile(x);
		}
		catch(Exception e)
		{
			
		}
	}

	private String showLocation()
	{
		StackTraceElement element = Thread.currentThread().getStackTrace()[3];
		return (MessageFormat.format("({0}:{1, number,#}) : ",
				element.getFileName(), element.getLineNumber()));
	}
}