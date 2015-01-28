package dragonn.resources.logic;

import dragonn.resources.GVars;
import dragonn.resources.logging.LPSCounter;
import dragonn.resources.logic.blocks.LogicBlock;
import dragonn.resources.logic.blocks.SimpleBlock;

public class LogicThread implements Runnable
{
	private LPSCounter	LogicLoopCounter	= new LPSCounter();
	private LogicBlock	startingLogicBlock	= new SimpleBlock();
	private int			sleepTimeMillis;

	public LogicThread(int sleepTime, LogicBlock baseBlock)
	{
		sleepTimeMillis = sleepTime;
		startingLogicBlock = baseBlock;
	}

	@Override
	public void run()
	{
		System.out.println("Starting LogicThread (LOG) " + this.toString());
		do
		{
			startingLogicBlock.run();
			try
			{
				Thread.sleep(sleepTimeMillis);
			} catch (Exception e)
			{
				System.out.println("LOGIC INTERRUPTED");
			}
			LogicLoopCounter.tick();
		} while (GVars.gameRunning);

		System.out.println("LOGIC " + this.toString() + "TERMINATED");
	}

	public int getLPS()
	{
		return LogicLoopCounter.getLPSCount();
	}
}
