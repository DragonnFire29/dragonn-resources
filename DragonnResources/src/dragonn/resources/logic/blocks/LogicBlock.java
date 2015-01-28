package dragonn.resources.logic.blocks;

import java.awt.image.BufferedImage;

public interface LogicBlock
{
	public void run();

	public BufferedImage paint();

	public int getDisplayX();

	public int getDisplayY();

	public int getDisplayWidth();

	public int getDisplayHeight();
}
