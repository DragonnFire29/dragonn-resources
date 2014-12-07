package dragonn.resources.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection
{
	//TODO: Make it work better.
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public ClientConnection(String addr, int port) throws IOException
	{
		socket = new Socket(addr, port);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
