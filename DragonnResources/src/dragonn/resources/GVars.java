package dragonn.resources;

import dragonn.resources.gui.Debug;

public class GVars
{
	//TODO: Get an initializer going. Really, too many public statics that the program relies on. Unsafe. Fix it.
	//System
	public static boolean gameRunning = false;
	public static String windowTitle = "PlatforME: What was supposed to be a platformer, but is just a test window";

	//Input
	public static int lastScreenX;
	public static int lastScreenY;
	public static int keyBacklog = 5;

	//Debug Flags
	public static boolean debugEnabled = false;
	public static boolean debugVisible = false;

	//Global Functions
	public static void reloadAllResources()
	{
		System.out.println("[RES]GVARS - RELOADING RESOURCES");
		Debug.dbgBuilt = false;
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
