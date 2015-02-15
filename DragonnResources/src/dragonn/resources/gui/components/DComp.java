package dragonn.resources.gui.components;

import java.awt.image.BufferedImage;

public interface DComp
{
	//Functional info
	public BufferedImage paint();
	public void update();

	// Component info
	public void setLocX(int newX);
	public int getLocX();

	public void setLocY(int newY);
	public int getLocY();

	public void setBoundsX(int newX);
	public int getBoundsX();

	public void setBoundsY(int newY);
	public int getBoundsY();

	// Mouse info
	public void setClickable(boolean isClickable);
	public boolean getClickable();

	public boolean mouseInBounds();
	public int getMouseRelativeX();
	public int getMouseRelativeY();

	// Text info
	public void setAcceptsText(boolean acceptsText);
	public boolean getAcceptsText();
	public String getComponentText();

	// Interaction info
	public static final int	BLOCK_NONE	= -1;
	public static final int	BLOCK_ALL	= 0;
	public static final int	BLOCK_MOUSE	= 1;
	public static final int	BLOCK_KEY	= 2;
	public int getInteractionBlocking();
}
