package dragonn.resources.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;

import dragonn.resources.GVars;
import dragonn.resources.logging.LPSCounter;

public class InThread
{
	public static LPSCounter InputLoopCounter = new LPSCounter();

	public static void run()
	{
		InKeyListener kl = new InKeyListener();
		Toolkit.getDefaultToolkit().addAWTEventListener(kl, AWTEvent.KEY_EVENT_MASK);
		Toolkit.getDefaultToolkit().addAWTEventListener(kl, AWTEvent.MOUSE_EVENT_MASK);
		Toolkit.getDefaultToolkit().addAWTEventListener(kl, AWTEvent.MOUSE_MOTION_EVENT_MASK);
		Toolkit.getDefaultToolkit().addAWTEventListener(kl, AWTEvent.MOUSE_WHEEL_EVENT_MASK);
		System.out.println("Starting InThread (INP)");
		for(int x = 0; x < GVars.keyBacklog; x++)
		{
			InKeyListener.inputList[0] = new InputObj();
		}
	}
}