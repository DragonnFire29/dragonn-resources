package dragonn.resources.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import dragonn.resources.GVars;



@SuppressWarnings("serial")
public class VisPanel extends JPanel
{
	public VisPanel()
	{
		this.setFocusTraversalKeysEnabled(true);
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);

		if(GVars.debugVisible)
		{
			Debug.drawDebugInfo(g);
		}
	}
}
