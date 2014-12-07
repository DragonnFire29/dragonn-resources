package dragonn.resources.logging;

public class LPSCounter
{
	private long lastMillis;
	private int ticks = 0;
	private int LPSCount = 0;
	public LPSCounter()
	{
		lastMillis = System.currentTimeMillis();
	}
	
	public void tick()
	{
		if(System.currentTimeMillis() - lastMillis < 1000)
		{
			ticks++;
		}
		else
		{
			LPSCount = ticks;
			ticks = 0;
			lastMillis = System.currentTimeMillis();
		}
	}
	
	public int getLPSCount()
	{
		return LPSCount;
	}
}
