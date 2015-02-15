package dragonn.resources.gui.components;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dragonn.resources.GVars;

/**
 * The Container object is basically a container to hold all
 * other components. We use these to group components in a
 * window or a tab. Instead of disabling and re-enabling
 * several individual components in one group, it is ideal
 * to use constant component groups to save headaches.
 *
 * @author Leo Henri
 * @version V1.0.0B 4/12/2014
 */
public class Container implements DComp
{
	//Functional info
	private Color compColor = new Color(0, 0, 0, 0);

	//Component info
	private int compLocX;
	private int compLocY;
	private int compBoundsX;
	private int compBoundsY;

	//Mouse info
	private boolean isClickable = true;

	//Text info
	private boolean compAcceptsText;
	private String compText;

	//Interaction Blocking
	private int interactionBlocking = DComp.BLOCK_ALL;

	private DComp[]	componentArray;

	public Container(int locX, int locY, int boundsX, int boundsY)
	{
		compLocX = locX;
		compLocY = locY;
		compBoundsX = boundsX;
		compBoundsY = boundsY;
	}

	public Container(int locX, int locY, int boundsX, int boundsY, Color color)
	{
		compLocX = locX;
		compLocY = locY;
		compBoundsX = boundsX;
		compBoundsY = boundsY;
		compColor = color;
	}

	public void addComponent(DComp newComponent)
	{
		if (componentArray != null)
		{
			DComp[] tempArray = new DComp[componentArray.length + 1];
			for(int x = 0; x < componentArray.length; x++)
			{
				tempArray[x] = componentArray[x];
			}
			tempArray[tempArray.length - 1] = newComponent;
			componentArray = tempArray;
		}
		else
		{
			componentArray = new DComp[]
			{ newComponent };
		}
	}

	@Override
	public BufferedImage paint()
	{
		BufferedImage bImage =
				new BufferedImage(compBoundsX, compBoundsY,
						BufferedImage.TYPE_4BYTE_ABGR);

		for(int x = 0; x < bImage.getWidth(); x++)
		{
			for(int y = 0; y < bImage.getHeight(); y++)
			{
				bImage.setRGB(x, y, compColor.getRGB());
			}
		}

		if (componentArray != null)
		{
			for (DComp x : componentArray)
			{
				bImage.createGraphics().drawImage(x.paint(), x.getLocX(),
						x.getLocY(), null);
			}
		}

		return bImage;
	}

	@Override
	public void update()
	{
		if (componentArray != null)
		{
			for (DComp x : componentArray)
			{
				x.update();
			}
		}
	}

	@Override
	public void setLocX(int newX)
	{
		compLocX = newX;
	}

	@Override
	public int getLocX()
	{
		return compLocX;
	}

	@Override
	public void setLocY(int newY)
	{
		compLocY = newY;
	}

	@Override
	public int getLocY()
	{
		return compLocY;
	}

	@Override
	public void setBoundsX(int newX)
	{
		compBoundsX = newX;
	}

	@Override
	public int getBoundsX()
	{
		return compBoundsX;
	}

	@Override
	public void setBoundsY(int newY)
	{
		compBoundsY = newY;
	}

	@Override
	public int getBoundsY()
	{
		return compBoundsY;
	}

	@Override
	public void setClickable(boolean clickable)
	{
		isClickable = clickable;
	}

	@Override
	public boolean getClickable()
	{
		return isClickable;
	}

	@Override
	public boolean mouseInBounds()
	{
		boolean isTrue = false;

		if(getMouseRelativeX() >= 0 && getMouseRelativeX() <=compBoundsX)
		{
			if(getMouseRelativeY() >= 0 && getMouseRelativeY() <=compBoundsY)
			{
				isTrue = true;
			}
		}

		return isTrue;
	}

	@Override
	public int getMouseRelativeX()
	{
		return GVars.lastScreenX - compLocX;
	}

	@Override
	public int getMouseRelativeY()
	{
		return GVars.lastScreenY - compLocY;
	}

	@Override
	public void setAcceptsText(boolean acceptsText)
	{
		compAcceptsText = acceptsText;
	}

	@Override
	public boolean getAcceptsText()
	{
		return compAcceptsText;
	}

	@Override
	public String getComponentText()
	{
		return compText;
	}

	@Override
	public int getInteractionBlocking()
	{
		return interactionBlocking;
	}
}