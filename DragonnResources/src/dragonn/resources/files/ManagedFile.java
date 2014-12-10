package dragonn.resources.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;

import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.APPEND;

public class ManagedFile
{
	// TODO: Get this working, I really need a way to save
	// my data and configs.
	private File	filePath;
	private File	fileName;
	private File	file;
	Charset			charset	= Charset.forName("US-ASCII");

	public ManagedFile(String path, String name)
	{
		filePath = new File(path);
		fileName = new File(name);
		file = new File(path + name);

		try
		{
			System.out.println("New file requested: " + file.getAbsolutePath());

			if (filePath.mkdirs())
			{
				System.out.println("Path created: " + filePath.getAbsolutePath());
			}

			if (file.createNewFile())
			{
				System.out.println("File created: " + file.getName());
			}
		}
		catch (IOException e)
		{
			System.out.println("ERROR: COULD NOT CREATE FILE");
		}
	}

	public boolean renameFile(String newFile)
	{
		return fileName.renameTo(new File(newFile));
	}

	public String[] readFile() throws IOException
	{
		String[] fileLineArray = new String[1];
		BufferedReader reader =
				Files.newBufferedReader(file.toPath(), charset);
		String line = null;
		int progress = 0;

		while ((line = reader.readLine()) != null)
		{
			fileLineArray[progress] = line;
			String[] tempArray = new String[fileLineArray.length + 1];
			for(int x = 0; x < fileLineArray.length; x++)
			{
				tempArray[x] = fileLineArray[x];
			}
			fileLineArray = tempArray;
			progress++;
		}
		reader.close();
		return fileLineArray;
	}

	public String readLineFromFile(int line) throws IOException
	{
		return readFile()[line];
	}

	public void WriteToFile(String[] contents) throws IOException
	{
		BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset);
		writer.write("");
		for(int x = 0; x < contents.length; x++)
		{
			writer.append(contents[x]);
			writer.newLine();
		}
		writer.close();
	}

	public void AppendToFile(String newLine)
	{
		try
		{
			BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset, new OpenOption[]{WRITE, APPEND});
			writer.append(newLine);
			writer.newLine();
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("ERROR: COULD NOT APPEND");
		}
	}
}
