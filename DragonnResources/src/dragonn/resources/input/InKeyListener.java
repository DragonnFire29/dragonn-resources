package dragonn.resources.input;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import dragonn.resources.GVars;
import dragonn.resources.misc.DProperties;

public class InKeyListener implements AWTEventListener
{
	public static InputObj[] inputList = {new InputObj(), new InputObj(), new InputObj(), new InputObj(), new InputObj()};

	public static DProperties propertyParser = new DProperties(',', ',', '=', '/');

	public static void addEvent(InputObj newEvent) throws ArrayIndexOutOfBoundsException
	{
		boolean spotFound = false;
		for(int x = 0; x < GVars.keyBacklog; x++)
		{
			if(inputList[x].getDevice() == "NONE" && spotFound == false)
			{
				inputList[x] = newEvent;
				spotFound = true;
			}
		}
	}

	public static void removeFirstEvent() throws ArrayIndexOutOfBoundsException
	{
		InputObj[] newInputList = new InputObj[GVars.keyBacklog];
		for(int x = 1; x < GVars.keyBacklog; x++)
		{
			newInputList[x - 1] = inputList[x];
		}
		newInputList[GVars.keyBacklog - 1] = new InputObj();
		inputList = newInputList;
	}

	public static InputObj getNextEvent()
	{
		InputObj nextEvent = new InputObj();

		if (inputList.length > 0)
		{
			nextEvent = inputList[0];
			removeFirstEvent();
		}

		return nextEvent;
	}

    public void eventDispatched(AWTEvent event)
    {
    	InputObj input = new InputObj();

    	//Event
    	int evID = event.getID();
    	String evString = event.toString();

    	//Key events
    	if (evID == 400 || evID == 401 || evID == 402)
    	{
    		//400 == KEY_TYPED
    		//401 == KEY_PRESSED
    		//402 == KEY_RELEASED
    		KeyEvent kEvent = (KeyEvent)event;

    		input = new InputObj(evID, "KEYBOARD", GVars.lastScreenX, GVars.lastScreenY, kEvent.getKeyCode(), KeyEvent.getKeyText(kEvent.getKeyCode()), kEvent.getModifiers(), KeyEvent.getModifiersExText(kEvent.getModifiers()));

    		if (evID == 401)
    		{
    			if(kEvent.isAltDown() && kEvent.getKeyCode() == KeyEvent.VK_D)
    			{
    				GVars.toggleDebugVisible();
    			}
    			else if(kEvent.isAltDown() && kEvent.getKeyCode() == KeyEvent.VK_R)
    			{
    				GVars.reloadAllResources();
    			}
    		}
    	}
    	//Mouse events
    	else if (evID == 500 || evID == 501 || evID == 502 || evID == 503 || evID == 504 || evID == 505)
    	{
    		//500 == MOUSE_CLICKED
    		//501 == MOUSE_PRESSED
    		//502 == MOUSE_RELEASED
    		//503 == MOUSE_MOVED
    		//504 == MOUSE_ENTERED
    		//505 == MOUSE_EXITED
    		MouseEvent mEvent = (MouseEvent)event;

    		GVars.lastScreenX = mEvent.getX();
    		GVars.lastScreenY = mEvent.getY() - 23;

    		input = new InputObj(evID, "MOUSE", mEvent.getX(), mEvent.getY() - 23, mEvent.getButton(), "MOUSE" + mEvent.getButton(), mEvent.getModifiers(), MouseEvent.getMouseModifiersText(mEvent.getModifiers()));
    	}
    	//Mouse Drag event
    	else if(evID == 506)
    	{
    		//TODO: Make this mouse drag specific.
    		//506 == MOUSE_WHEEL
    		MouseEvent mEvent = (MouseEvent)event;

    		input = new InputObj(evID, "MOUSEDRAG", mEvent.getX(), mEvent.getY() - 23, mEvent.getButton(), "MOUSE" + mEvent.getButton(), mEvent.getModifiers(), MouseEvent.getMouseModifiersText(mEvent.getModifiers()));
    	}
    	//Mouse Wheel event
    	else if(evID == 507)
    	{
    		//TODO: Make this mouse wheel specific.
    		//507 == MOUSE_WHEEL
    		MouseEvent mEvent = (MouseEvent)event;

    		input = new InputObj(evID, "MOUSEWHEEL", mEvent.getX(), mEvent.getY() - 23, mEvent.getButton(), "MOUSE" + mEvent.getButton(), mEvent.getModifiers(), MouseEvent.getMouseModifiersText(mEvent.getModifiers()));
    	}
    	else
    	{
    		if(GVars.debugEnabled)
        	{
        		System.out.println("[INP] UNKNOWN EVID: ID: " + evID);
        		System.out.println("                    STRING: " + evString);
        	}
    	}

    	addEvent(input);
    }
}