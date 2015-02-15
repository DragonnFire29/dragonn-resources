package dragonn.resources.gui;

import dragonn.resources.GVars;
import dragonn.resources.logging.LPSCounter;

public class VisThread implements Runnable
{
	private VisPanel	vp					= new VisPanel();
	private VisFrame	vf					= new VisFrame(vp);
	private LPSCounter	VisualLoopCounter	= new LPSCounter();
	private int			sleepTimeMillis;

	public VisThread(int sleepTime)
	{
		sleepTimeMillis = sleepTime;
	}

	@Override
	public void run()
	{
		System.out.println("Starting VisThread (VIS) " + this.toString());
		do
		{
			try
			{
				Thread.sleep(sleepTimeMillis);
			} catch (Exception e)
			{
				System.out.println("VISUAL INTERRUPTED");
			}
			vp.repaint();
			VisualLoopCounter.tick();
		} while (GVars.gameRunning == true);

		System.out.println("VISUAL " + this.toString() + "TERMINATED");
	}

	public int getLPS()
	{
		return VisualLoopCounter.getLPSCount();
	}

	public void runComponentLogic()
	{
		vp.runComponents();
	}
}
