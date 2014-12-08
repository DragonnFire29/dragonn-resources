package dragonn.resources.logic.blocks;

import dragonn.resources.input.InKeyListener;

public class BasicLogicBlock
{
	public BasicLogicBlock()
	{

	}

	public void run()
	{
		InKeyListener.removeFirstEvent();
	}
}
