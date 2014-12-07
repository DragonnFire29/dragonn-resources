package dragonn.resources.logic;

import dragonn.resources.GVars;
import dragonn.resources.logging.LPSCounter;

public class LogicThread implements Runnable
{
	public static LPSCounter LogicLoopCounter = new LPSCounter();

	@Override
	public void run()
	{
		System.out.println("Starting LogicThread (LOG) " + this.toString());
		do
		{
			LogicLoopCounter.tick();
		}
		while(GVars.gameRunning);
	}

}
