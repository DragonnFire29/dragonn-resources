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
	
	public static final int TYPE_KEY_TYPED = 400;
	public static final int TYPE_KEY_PRESSED = 401;
	public static final int TYPE_KEY_RELEASED = 402;
	
	public static final int TYPE_MOUSE_CLICKED = 500;
	public static final int TYPE_MOUSE_PRESSED = 501;
	public static final int TYPE_MOUSE_RELEASED = 502;
	public static final int TYPE_MOUSE_MOVED = 503;
	public static final int TYPE_MOUSE_ENTERED = 504;
	public static final int TYPE_MOUSE_EXITED = 505;
	public static final int TYPE_MOUSE_DRAGGED = 506;
	public static final int TYPE_MOUSE_WHEEL = 507;

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

	public int getKeyNo()
	{
		return keyNo;
	}

	public String getKeyString()
	{
		return keyString;
	}
}
