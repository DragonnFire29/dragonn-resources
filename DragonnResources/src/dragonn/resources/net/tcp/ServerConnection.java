package dragonn.resources.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection
{
	//TODO: Make it work better.
	private static ServerSocket ssocket;
	private Socket csocket;
	private PrintWriter out;
	private BufferedReader in;

	public static void openConnection (int port) throws IOException
	{
		ssocket = new ServerSocket(port);
	}

	public void establishConnection() throws IOException
	{
		csocket = ssocket.accept();
		out = new PrintWriter(csocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
	}

	public void sendText(String text)
	{
		out.println(text);
	}

	public String recieveText() throws IOException
	{
		return in.readLine();
	}
}
