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
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				System.out.println("VISUAL INTERRUPTED");
			}
			vp.repaint();
			VisualLoopCounter.tick();
		}
		while(GVars.gameRunning == true);

		System.out.println("VISUAL " + this.toString() + "TERMINATED");
	}

}
