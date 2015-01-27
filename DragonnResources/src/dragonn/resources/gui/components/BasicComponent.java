package dragonn.resources.gui.components;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class BasicComponent extends DComp
{
	public BasicComponent(int coordX, int coordY)
	{
		super.compIsClickable = true;
		super.interactionBlocking = DComp.BLOCK_ALL;
		super.compLocX = coordX;
		super.compLocY = coordY;
		super.compBoundsX = 100;
		super.compBoundsY = 100;
	}

	@Override
	public BufferedImage paint()
	{
		BufferedImage bImage =
				new BufferedImage(super.compBoundsX, super.compBoundsY, BufferedImage.TYPE_4BYTE_ABGR);

		for(int x = 0; x < bImage.getWidth(); x++)
		{
			for(int y = 0; y < bImage.getHeight(); y++)
			{
				bImage.setRGB(x, y, 255);
			}
		}

		return bImage;
	}
}
