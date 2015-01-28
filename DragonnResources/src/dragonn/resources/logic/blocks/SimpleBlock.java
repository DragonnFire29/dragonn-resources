package dragonn.resources.logic.blocks;

import java.awt.image.BufferedImage;

import dragonn.resources.input.InKeyListener;
import dragonn.resources.input.InputObj;

public class SimpleBlock implements LogicBlock
{
	private InputObj lastObj = new InputObj();

	//Basic variables
	int	displayX;
	int	displayY;
	int	displayWidth;
	int	displayHeight;

	public SimpleBlock()
	{
		displayX = 0;
		displayY = 0;
		displayWidth = 300;
		displayHeight = 20;
	}

	public SimpleBlock(int displayX, int displayY, int displayWidth, int displayHeight)
	{
		this.displayX = displayX;
		this.displayY = displayY;
		this.displayWidth = displayWidth;
		this.displayHeight = displayHeight;
	}

	@Override
	public void run()
	{
		InKeyListener.getNextEvent();
	}

	@Override
	public BufferedImage paint()
	{
		BufferedImage bImg = new BufferedImage(displayHeight, displayWidth, BufferedImage.TYPE_4BYTE_ABGR);
		return bImg;
	}

	@Override
	public int getDisplayX()
	{
		return displayX;
	}

	@Override
	public int getDisplayY()
	{
		return displayY;
	}

	@Override
	public int getDisplayWidth()
	{
		return displayWidth;
	}

	@Override
	public int getDisplayHeight()
	{
		return displayHeight;
	}
}
