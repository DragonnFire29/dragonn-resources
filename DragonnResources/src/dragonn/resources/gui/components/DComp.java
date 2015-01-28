package dragonn.resources.gui.components;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class DComp
{
	// Component info
	protected int			compLocX;
	protected int			compLocY;
	protected int			compBoundsX;
	protected int			compBoundsY;
	protected Color			color;

	// Mouse info
	protected boolean		compIsClickable;
	protected int			compMouseX;
	protected int			compMouseY;
	protected boolean		compMousePresent;
	protected int			compMouseButtonClicked;

	// Text info
	protected boolean		compHasText;
	protected Color			comptextColor;
	protected String		compText;

	// Interaction info
	public static final int	BLOCK_ALL	= 0;
	public static final int	BLOCK_MOUSE	= 1;
	public static final int	BLOCK_KEY	= 2;
	public static final int	BLOCK_NONE	= 4;
	protected int			interactionBlocking;

	public DComp()
	{
		compIsClickable = true;
		interactionBlocking = DComp.BLOCK_ALL;
		compLocX = 200;
		compLocY = 200;
		compBoundsX = 100;
		compBoundsY = 100;

		color = Color.black;
	}

	public DComp(Color compColor)
	{
		compIsClickable = true;
		interactionBlocking = DComp.BLOCK_ALL;
		compLocX = 200;
		compLocY = 200;
		compBoundsX = 100;
		compBoundsY = 100;

		color = compColor;
	}

	public DComp(boolean compIsClickable, boolean compHasText,
			int interactionBlocking, int compLocX, int compLocY,
			int compBoundsX, int compBoundsY, Color color)
	{
		this.compIsClickable = compIsClickable;
		this.compHasText = compHasText;
		this.interactionBlocking = interactionBlocking;
		this.compLocX = compLocX;
		this.compLocY = compLocY;
		this.compBoundsX = compBoundsX;
		this.compBoundsY = compBoundsY;
		this.color = color;
	}

	public BufferedImage paint()
	{
		BufferedImage bImage =
				new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

		for (int x = 0; x < bImage.getWidth(); x++)
		{
			for (int y = 0; y < bImage.getHeight(); y++)
			{
				bImage.setRGB(x, y, color.getRGB());
			}
		}

		return bImage;
	}

	// Mouse Methods
	public void mouseUpdate(int mouseScreenX, int mouseScreenY,
			int mouseButtonClicked)
	{
		if (this.compLocX < mouseScreenX
				&& mouseScreenX > this.compBoundsX + this.compLocX
				&& this.compLocY < mouseScreenY
				&& mouseScreenY > this.compBoundsY + this.compLocX)
		{
			this.compMouseX = mouseScreenX - this.compLocX;
			this.compMouseY = mouseScreenY - this.compLocY;
			if (this.compIsClickable)
			{
				this.compMouseButtonClicked = mouseButtonClicked;
			}
		}
		else
		{
			this.compMouseX = -1;
			this.compMouseY = -1;
			this.compMouseButtonClicked = -1;
		}
	}

	public boolean onClick()
	{
		if(compIsClickable)
		{
			System.out.println("Component " + this.toString() + " clicked!");
		}
		return false;
	}

	public int getMouseXR()
	{
		if (compIsClickable && this.compMousePresent)
		{
			return this.compMouseX;
		}

		return -1;
	}

	public int getMouseYR()
	{
		if (compIsClickable && this.compMousePresent)
		{
			return this.compMouseY;
		}

		return -1;
	}

	// Misc getters
	public int getComponentX()
	{
		return compLocX;
	}

	public int getComponentY()
	{
		return compLocY;
	}

	public boolean getClickable()
	{
		return this.compIsClickable;
	}
}
