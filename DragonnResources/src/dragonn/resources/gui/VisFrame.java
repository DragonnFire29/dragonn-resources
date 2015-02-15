package dragonn.resources.gui;

import java.awt.Component;

import javax.swing.JFrame;

import dragonn.resources.GVars;

public class VisFrame extends JFrame
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public VisFrame(Component comp)
	{
		setSize(800, 600);
		setVisible(true);
		add(comp);
		setTitle(GVars.windowTitle);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GVars.gameRunning = true;
	}
}
