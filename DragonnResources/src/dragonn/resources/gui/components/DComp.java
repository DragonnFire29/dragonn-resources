package dragonn.resources.gui.components;

import java.awt.image.BufferedImage;

import dragonn.resources.input.InKeyListener;
import dragonn.resources.input.InputObj;

public class DComp
{
	//Component info
	private int compLocX;
	private int compLocY;
	private int compBoundsX;
	private int compBoundsY;

	//Mouse info
	private boolean		compIsClickable;
	private int			compMouseX;
	private int			compMouseY;
	private boolean		compMousePresent;
	private int			compMouseButtonClicked;

	//Text info
	private boolean		compHasText;
	private String		compText;

	//Interaction info
	public static final int BLOCK_ALL = 0;
	public static final int BLOCK_MOUSE = 1;
	public static final int BLOCK_KEY = 2;
	public static final int BLOCK_NONE = 4;
	private int interactionBlocking;

	public DComp()
	{
		//TODO: Write in the defaults
	}

	public DComp(boolean compIsClickable, boolean compHasText, int interactionBlocking,
			int compLocX, int compLocY, int compBoundsX, int compBoundsY)
	{
		this.compIsClickable = compIsClickable;
		this.compHasText = compHasText;
		this.interactionBlocking = interactionBlocking;
	}

	public BufferedImage paint()
	{
		BufferedImage bImage = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

		return bImage;
	}

	//Mouse Methods
	public void mouseUpdate(int mouseScreenX, int mouseScreenY, int mouseButtonClicked)
	{
		if(this.compLocX < mouseScreenX && mouseScreenX > this.compBoundsX + this.compLocX &&
				this.compLocY < mouseScreenY && mouseScreenY > this.compBoundsY + this.compLocX)
		{
			this.compMouseX = mouseScreenX - this.compLocX;
			this.compMouseY = mouseScreenY - this.compLocY;
			if(this.compIsClickable)
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
		return false;
	}

	public boolean isClickable()
	{
		return this.compIsClickable;
	}

	public int getMouseXR()
	{
		if(this.isClickable() && this.compMousePresent)
		{
			return this.compMouseX;
		}

		return -1;
	}

	public int getMouseYR()
	{
		if(this.isClickable() && this.compMousePresent)
		{
			return this.compMouseY;
		}

		return -1;
	}
}
