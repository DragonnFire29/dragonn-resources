package dragonn.resources.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import dragonn.resources.GVars;

@SuppressWarnings("serial")
public class VisPanel extends JPanel
{
	public static Color BGC = Color.white;

	public VisPanel()
	{
		this.setFocusTraversalKeysEnabled(true);
	}

	public void paint(Graphics g)
	{
		g.setColor(BGC);
		g.fillRect(0, 0, 800, 600);

		if(GVars.debugVisible)
		{
			Debug.drawDebugInfo(g);
		}
	}
}
