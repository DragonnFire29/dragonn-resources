package dragonn.resources.gui;

import java.awt.Color;
import java.awt.Graphics;

import dragonn.resources.GVars;
import dragonn.resources.input.InKeyListener;
import dragonn.resources.input.InputObj;

public class Debug
{
	public static boolean	dbgBuilt;

	public static DBGCUSTOM	custDebugInfo	= new DBGCUSTOM();

	static void build()
	{

	}

	public static void drawDebugInfo(Graphics g)
	{
		if (dbgBuilt == false)
		{
			build();
			dbgBuilt = true;
		}

		// TODO: Make this thing fun. I
		// dunno, throw in some cool
		// sine and cosine stuff.
		// Debug Background
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 800, 50 + (10 * GVars.keyBacklog));

		// Basic Debug Notice
		g.setColor(Color.gray);
		g.fillRect(0, 0, 800, 15);
		g.setColor(Color.black);
		g.drawString("DEBUG ENABLED", 10, 10);
		g.drawString("LAST KNOWN MOUSEPOS: X=" + GVars.lastScreenX + " Y="
				+ GVars.lastScreenY, 150, 10);

		// Loop Count
		g.setColor(Color.black);
		g.drawString("THREADS", 10, 30);
		g.drawString("VIS: " + GVars.vis.getLPS(), 10, 50);
		g.drawString("LOG: " + GVars.log.getLPS(), 10, 60);

		// Input
		g.setColor(Color.black);
		g.drawString("INPUT STACK", 100, 30);
		InputObj[] stInputList = InKeyListener.inputList;
		for (int x = 0; x < GVars.keyBacklog; x++)
		{
			g.drawString("INEVENT: " + stInputList[x].getDevice(), 100,
					50 + (x * 10));
			if (stInputList[x].getDevice() == "MOUSE"
					|| stInputList[x].getDevice() == "MOUSEDRAG")
			{
				g.setColor(Color.yellow);
				g.fillRect(stInputList[x].getX() - 10,
						stInputList[x].getY() - 15, 100, 20);
				g.setColor(Color.black);
				g.drawString(x + ": (" + stInputList[x].getX() + ","
						+ stInputList[x].getY() + ")", stInputList[x].getX(),
						stInputList[x].getY());
			}
		}
		g.setColor(Color.yellow);
		g.fillRect(GVars.lastScreenX - 10, GVars.lastScreenY - 15, 100, 20);
		g.setColor(Color.black);
		g.drawString(
				"L: (" + GVars.lastScreenX + "," + GVars.lastScreenY + ")",
				GVars.lastScreenX, GVars.lastScreenY);

		// Custom
		custDebugInfo.draw(g);

		// TODO: Remove this when
		// something starts using input
		// InKeyListener.removeFirstEvent();
	}

	public static void drawInputDebugInfo(Graphics g)
	{

	}
}
