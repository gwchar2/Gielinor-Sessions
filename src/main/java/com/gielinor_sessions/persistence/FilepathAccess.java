
package com.gielinor_sessions.persistence;

import java.io.IOException;
import java.io.Reader;
import net.runelite.client.util.Filepath;

final class FilepathAccess
{
	static String readContents(Filepath file) throws IOException
	{
		try (Reader reader = file.openBufferedReader())
		{
			StringBuilder contents = new StringBuilder();
			char[] buffer = new char[4096];
			int count;

			while ((count = reader.read(buffer)) != -1)
			{
				contents.append(buffer, 0, count);
			}

			return contents.toString();
		}
	}

	static void writeContents(Filepath file, String contents) throws IOException
	{
		file.write(contents);
	}
}
