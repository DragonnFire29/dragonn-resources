package dragonn.resources.input;

import dragonn.resources.GVars;

public class InputObj
{
	private int		inType;
	private String	inDevice;
	private int		screenX;
	private int		screenY;
	private int		keyNo;
	private String	keyString;
	private int		modNo;
	private String	modString;

	public InputObj()
	{
		inType = 0;
		inDevice = "NONE";
		screenX = GVars.lastScreenX;
		screenY = GVars.lastScreenY;
		keyNo = -1;
		keyString = "null";
		modNo = -1;
		modString = "null";

	}

	public InputObj(int inType, String inDevice, int screenX, int screenY, int keyNo, String keyString, int modNo, String modString)
	{
		this.inType = inType;
		this.inDevice = inDevice;
		this.screenX = screenX;
		this.screenY = screenY;
		this.keyNo = keyNo;
		this.keyString = keyString;
		this.modNo = modNo;
		this.modString = modString;
	}

	public int getType()
	{
		return inType;
	}

	public String getDevice()
	{
		return inDevice;
	}

	public int getX()
	{
		return screenX;
	}

	public int getY()
	{
		return screenY;
	}
}
