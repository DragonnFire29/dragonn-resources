package dragonn.resources;

import java.io.IOException;

import dragonn.resources.files.DebugStream;
import dragonn.resources.files.ManagedFile;
import dragonn.resources.gui.Debug;
import dragonn.resources.gui.VisThread;
import dragonn.resources.input.InThread;
import dragonn.resources.logic.LogicThread;

public class GVars
{
	//TODO: Get an initializer + getters and setters going. Really, too many public statics that the program relies on. Unsafe. Fix it.
	//System
	public static boolean gameRunning = false;
	private static ManagedFile configurationPath;
	public static String windowTitle = "DragonnResources: By the power of Greyskull!";

	//Threads
	public static VisThread vis = new VisThread();
	public static LogicThread log = new LogicThread();

	//Input
	public static int lastScreenX;
	public static int lastScreenY;
	public static int keyBacklog = 5;

	//Debug Flags
	public static boolean debugEnabled = false;
	public static boolean debugVisible = false;

	public static void runFlags(String[] args)
	{
		for(int x = 0; x < args.length; x++)
		{
			switch(args[x])
			{
			case "-debug": GVars.debugEnabled = true;
			break;
			default: System.out.println("ERROR: INVALID ARGUMENT " + args[x]);
			}

			if(debugEnabled)
			{
				String temp = "--==DBG==-- " + windowTitle;
				windowTitle = temp;
			}
		}
	}

	//Global Functions
	public static void reloadAllResources()
	{
		System.out.println("[RES]GVARS - RELOADING RESOURCES");
		Debug.dbgBuilt = false;
	}

	public static void loadConfiguration()
	{
		configurationPath = new ManagedFile("system/config/", "DRCONFIG.CFG");
	}

	/**
	 * WARNING: DOES NOT WORK! DO NOT USE!
	 */
	public static void overrideSysout()
	{
		System.setOut(new DebugStream());
	}

	public static void launchGame()
	{
		new Thread(vis).run();
		new Thread(log).run();
		InThread.run();
	}

	public static void toggleDebugVisible()
	{
		if(debugVisible)
		{
			debugVisible = false;
		}
		else
		{
			debugVisible = true;
		}
		System.out.println("[RES]GVARS - DEBUGVISIBLE=" + Boolean.toString(debugVisible).toUpperCase());
	}
}
