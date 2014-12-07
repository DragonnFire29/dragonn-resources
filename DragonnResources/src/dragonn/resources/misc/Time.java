package dragonn.resources.misc;

public class Time
{
	public static String convTime(long millis)
	{
		//TODO: This is broken. Fixie fixie motherfucker.
		//Get seconds and remove from milliseconds
		long second = millis / 1000;
		millis = millis - second * 1000;

		//Get minutes and remove from seconds
		long minute = second / 60;
		second = second - minute * 60;

		//Get hours and remove from minutes
		long hour = minute / 60;
		minute = minute - hour * 60;

		//Remove excess hours
		hour = hour - (hour / 60) * 60;

		String time = ("H:" + hour + " M:" + minute + " S:" + second + " m:" + millis);

		return time;
	}
}
