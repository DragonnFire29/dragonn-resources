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

	}

	@Override
	public BufferedImage paint()
	{
		BufferedImage bImage =
				new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

		for (int x = 0; x < componentArray.length; x++)
		{

		}

		return bImage;
	}
}
