package dragonn.resources.misc;

import dragonn.resources.GVars;

public class DProperties
{
	//TODO: Throw this out a window. Then get it to work. No pay, because fuck string parsing.
	private char markerStart;
	private char markerEnd;
	private char markerEquals;
	private char markerLineComment;
	private boolean startEqualsEnd;

	public DProperties()
	{
		markerStart = '#';
		markerEnd = ';';
		markerEquals = '=';
		markerLineComment = '/';
		startEqualsEnd = false;
	}

	public DProperties(char propertyStartChar, char propertyEndChar, char propertyEqualsChar, char propertyCommentChar)
	{
		markerStart = propertyStartChar;
		markerEnd = propertyEndChar;
		markerEquals = propertyEqualsChar;
		markerLineComment = propertyCommentChar;
		startEqualsEnd = (markerStart == markerEnd);
	}

	public int getPropertyInt (String propertyLine, String propertyName)
	{
		int propertyVal = -1;
		int propertyStart = 9;
		int propertyEquals = 17;
		int propertyEnd = 19;
		int[] potentialPropertyStarts = new int[1];
		int[] potentialPropertyEquals = new int[1];
		int[] potentialPropertyEnds = new int[2];

		if(GVars.debugEnabled)
		{
			System.out.println("PROPERTY (INT): Getting property " + propertyName + " from line '" + propertyLine +"'");
		}

		for(int x = 0; x < propertyLine.length(); x++)
		{
			if(propertyLine.charAt(x) == markerStart)
			{
				System.out.println("Start marker found! @ " + x);
				int[] temp = potentialPropertyStarts;
				potentialPropertyStarts = new int[potentialPropertyStarts.length + 1];
				for(int i = 0; i < temp.length; i++)
				{
					potentialPropertyStarts[i] = temp[i];
				}
				potentialPropertyStarts[temp.length - 1] = x + 1;
			}
		}

		for(int x = 0; x < propertyLine.length(); x++)
		{
			if(propertyLine.charAt(x) == markerEquals)
			{
				System.out.println("Equals marker found! @ " + x);
				int[] temp = potentialPropertyEquals;
				potentialPropertyEquals = new int[potentialPropertyEquals.length + 1];
				for(int i = 0; i < temp.length; i++)
				{
					potentialPropertyEquals[i] = temp[i];
				}
				potentialPropertyEquals[temp.length - 1] = x + 1;
			}
		}

		for(int x = 0; x < propertyLine.length(); x++)
		{
			if(propertyLine.charAt(x) == markerEnd)
			{
				System.out.println("End marker found! @ " + x);
				int[] temp = potentialPropertyEnds;
				potentialPropertyEnds = new int[potentialPropertyEnds.length + 1];
				for(int i = 0; i < temp.length; i++)
				{
					potentialPropertyEnds[i] = temp[i];
				}
				potentialPropertyEnds[temp.length - 1] = x + 1;
			}
		}

		for(int x = 0; x < potentialPropertyStarts.length; x++)
		{
			if(startEqualsEnd)
			{
				System.out.println("Testing property name @ " + potentialPropertyStarts[x] + ", " + potentialPropertyEquals[x] + ", " + potentialPropertyEnds[x + 1]);
				System.out.println("Resulting line: " + propertyLine.substring(potentialPropertyStarts[x], potentialPropertyEquals[x]));
				if(propertyName == (String)propertyLine.substring(potentialPropertyStarts[x], potentialPropertyEquals[x]))
				{
					propertyStart = potentialPropertyStarts[x];
					propertyEquals = potentialPropertyEquals[x];
					propertyEnd = potentialPropertyEnds[x + 1];
				}
			}
			else
			{
				System.out.println("Testing property name @ " + potentialPropertyStarts[x] + ", " + potentialPropertyEquals[x] + ", " + potentialPropertyEnds[x]);
				System.out.println("Resulting line: " + propertyLine.substring(potentialPropertyStarts[x], potentialPropertyEquals[x]));
				if(propertyName == (String)propertyLine.substring(potentialPropertyStarts[x], potentialPropertyEquals[x]))
				{
					propertyStart = potentialPropertyStarts[x];
					propertyEquals = potentialPropertyEquals[x];
					propertyEnd = potentialPropertyEnds[x];
				}
			}
		}

		System.out.println("Getting final property val @ " + propertyStart + ", " + propertyEquals + ", " + propertyEnd);
		System.out.println("Resulting property: " + propertyLine.substring(propertyEquals, propertyEnd));
		propertyVal = Integer.getInteger(propertyLine.substring(propertyEquals, propertyEnd));

		return propertyVal;
	}

	public String getPropertyString (String propertyLine, String propertyName)
	{
		String propertyVal = "null";
		int propertyStart = -1;
		int propertyEnd = -1;

		if(GVars.debugEnabled)
		{
			System.out.println("PROPERTY (INT): Getting property " + propertyName + " from line " + propertyLine);
		}

		for(int x = 0; x < propertyLine.length() - propertyName.length(); x++)
		{
			if(propertyLine.charAt(x) == markerStart)
			{
				if(propertyLine.substring(x, x + (propertyName + markerEquals).length()) == markerStart + propertyName + markerEquals)
				{
					propertyStart = x + (propertyName + markerEquals).length();
					for(int y = propertyStart; y < propertyLine.length(); y++)
					{
						if(propertyLine.charAt(y) == markerEnd)
						{
							propertyEnd = y;
							break;
						}
					}
					break;
				}
			}
		}

		propertyVal = propertyLine.substring(propertyStart, propertyEnd);

		return propertyVal;
	}
}
