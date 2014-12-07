package dragonn.resources.files;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TextFile
{
	//TODO: Get this to work. I need to load config files with this, then save my savefiles.
	public static void createFile(String file)
	{
		Writer writer = null;

		try
		{
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(file), "utf-8"));
		    writer.write("Created: " + System.currentTimeMillis());
		}
		catch (IOException ex)
		{
		  ex.printStackTrace();
		}
		finally{try {writer.close();} catch (Exception ex) {}}
	}
}
