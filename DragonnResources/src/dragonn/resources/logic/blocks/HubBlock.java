package dragonn.resources.logic.blocks;

import java.awt.image.BufferedImage;

public class HubBlock implements LogicBlock
{
	private LogicBlock[] hubElements;

	//Basic variables
	int	displayX;
	int	displayY;
	int	displayWidth;
	int	displayHeight;

	public HubBlock()
	{
		hubElements = new LogicBlock[]{new SimpleBlock()};
		displayX = 0;
		displayY = 0;
		displayWidth = findWidestPoint();
		displayHeight = getComponentHeight();
	}

	private int findWidestPoint()
	{
		int currentWidest = 0;
		for(LogicBlock x : hubElements)
		{
			if(x.getDisplayWidth() > currentWidest)
			{
				currentWidest = x.getDisplayWidth();
			}
		}

		return currentWidest;
	}

	private int getComponentHeight()
	{
		int currentHeight = 0;
		for(LogicBlock x : hubElements)
		{
			currentHeight = currentHeight + x.getDisplayHeight();
		}
		return currentHeight;
	}

	@Override
	public void run()
	{
		for(LogicBlock x : hubElements)
		{
			x.run();
		}
	}

	@Override
	public BufferedImage paint()
	{
		BufferedImage bImg = new BufferedImage(10, 100, BufferedImage.TYPE_4BYTE_ABGR);
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
