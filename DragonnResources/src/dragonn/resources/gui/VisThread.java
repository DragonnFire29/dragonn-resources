package dragonn.resources.gui;

import dragonn.resources.GVars;
import dragonn.resources.logging.LPSCounter;

public class VisThread implements Runnable
{
	public static VisPanel vp = new VisPanel();
	public static VisFrame vf = new VisFrame(vp);
	public static LPSCounter VisualLoopCounter = new LPSCounter();

	@Override
	public void run()
	{
		System.out.println("Starting VisThread (VIS) " + this.toString());
		do
		{
			vp.repaint();
			VisualLoopCounter.tick();

			try
			{
				Thread.sleep(50);
			}
			catch (InterruptedException e)
			{
				System.out.println("[VIS] INTERRUPTED MID-LOOP SLEEP");
			}
		}
		while(GVars.gameRunning == true);
		System.exit(0);
	}

}
