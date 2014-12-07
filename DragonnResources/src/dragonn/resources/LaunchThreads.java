package dragonn.resources;

import dragonn.resources.gui.VisThread;
import dragonn.resources.input.InThread;
import dragonn.resources.logic.LogicThread;

public class LaunchThreads
{
	public static VisThread vt = new VisThread();		//Start visuals
	public static LogicThread lt = new LogicThread();	//Start logistics
	public static void Launch()
	{
		new Thread(vt).start();
		new Thread(lt).start();
		InThread.run();
	}
}
