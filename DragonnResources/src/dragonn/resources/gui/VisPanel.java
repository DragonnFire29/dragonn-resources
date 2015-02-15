package dragonn.resources.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import dragonn.resources.GVars;
import dragonn.resources.gui.components.BasicComponent;
import dragonn.resources.gui.components.Container;
import dragonn.resources.gui.components.DComp;

@SuppressWarnings("serial")
public class VisPanel extends JPanel
{
	public Color	BGC				= Color.white;
	public DComp	baseComponent;

	public VisPanel()
	{
		this.setFocusTraversalKeysEnabled(true);
		//TODO: This is temporary.
		baseComponent = new Container(0, 0,500, 500, Color.green);
		((Container) baseComponent).addComponent(new BasicComponent(450, 450, 100, 100, Color.black));
		((Container) baseComponent).addComponent(new BasicComponent(300, 300, 100, 100, Color.blue));
		((Container) baseComponent).addComponent(new BasicComponent(450, 450, 10, 10, Color.red));
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

		g.drawImage(baseComponent.paint(), baseComponent.getLocX(),
				baseComponent.getLocY(), null);

		if (GVars.debugVisible)
		{
			Debug.drawDebugInfo(g);
		}
	}

	public void runComponents()
	{
		baseComponent.update();
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
