package dragonn.resources.gui.components;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class BasicComponent extends DComp
{
	Color color;

	public BasicComponent(int coordX, int coordY, Color partColor)
	{
		compIsClickable = true;
		interactionBlocking = DComp.BLOCK_ALL;
		compLocX = coordX;
		compLocY = coordY;
		compBoundsX = 100;
		compBoundsY = 100;

		color = partColor;
	}

	@Override
	public BufferedImage paint()
	{
		BufferedImage bImage =
				new BufferedImage(compBoundsX, compBoundsY, BufferedImage.TYPE_4BYTE_ABGR);

		for(int x = 0; x < bImage.getWidth(); x++)
		{
			for(int y = 0; y < bImage.getHeight(); y++)
			{
				bImage.setRGB(x, y, color.getRGB());
			}
		}

		return bImage;
	}
}
