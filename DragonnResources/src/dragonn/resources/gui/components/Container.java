package dragonn.resources.gui.components;

import java.awt.image.BufferedImage;

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
public class Container extends DComp
{
	private DComp[]	componentArray;

	public void addComponent(DComp newComponent)
	{
		if (componentArray != null)
		{
			DComp[] tempArray = new DComp[componentArray.length + 1];
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

		if (componentArray != null)
		{
			for (int x = 0; x < componentArray.length; x++)
			{
				bImage.createGraphics().drawImage(componentArray[x].paint(),
						componentArray[x].compLocX, componentArray[x].compLocY,
						null);
			}
		}

		return bImage;
	}
}
