package dragonn.resources.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import dragonn.resources.GVars;
import dragonn.resources.gui.components.BasicComponent;
import dragonn.resources.gui.components.DComp;

@SuppressWarnings("serial")
public class VisPanel extends JPanel
{
	public Color BGC = Color.white;
	public DComp baseComponent = new BasicComponent(300,300);

	public VisPanel()
	{
		this.setFocusTraversalKeysEnabled(true);
	}

	public VisPanel(DComp component)
	{
		this.setFocusTraversalKeysEnabled(true);
		baseComponent = component;
	}

	public VisPanel(Color BGColor)
	{
		this.setFocusTraversalKeysEnabled(true);
		BGC = BGColor;
	}

	public VisPanel(DComp component, Color BGColor)
	{
		this.setFocusTraversalKeysEnabled(true);
		baseComponent = component;
		BGC = BGColor;
	}

	public void paint(Graphics g)
	{
		g.setColor(BGC);
		g.fillRect(0, 0, 800, 600);

		g.drawImage(baseComponent.paint(), baseComponent.getComponentX(), baseComponent.getComponentY(), null);

		if(GVars.debugVisible)
		{
			Debug.drawDebugInfo(g);
		}
	}

	public DComp getComponent()
	{
		return baseComponent;
	}

	public void setComponent(DComp component)
	{
		baseComponent = component;
	}

	public Color getBGColor()
	{
		return BGC;
	}

	public void setBGColor(Color newBGC)
	{
		BGC = newBGC;
	}
}
