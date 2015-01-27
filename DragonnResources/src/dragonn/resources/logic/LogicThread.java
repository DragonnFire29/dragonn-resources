 package dragonn.resources.logic;

import dragonn.resources.GVars;
import dragonn.resources.logging.LPSCounter;
import dragonn.resources.logic.blocks.BasicLogicBlock;

public class LogicThread implements Runnable
{
	public static LPSCounter LogicLoopCounter = new LPSCounter();
	public static BasicLogicBlock startingLogicBlock = new BasicLogicBlock();

	@Override
	public void run()
	{
		System.out.println("Starting LogicThread (LOG) " + this.toString());
		do
		{
			startingLogicBlock.run();
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				System.out.println("LOGIC INTERRUPTED");
			}
			LogicLoopCounter.tick();
		}
		while(GVars.gameRunning);

		System.out.println("LOGIC " + this.toString() + "TERMINATED");
	}

}
