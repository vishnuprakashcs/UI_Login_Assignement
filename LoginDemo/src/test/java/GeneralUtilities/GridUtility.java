package GeneralUtilities;

import java.io.IOException;

public class GridUtility
{
	public static void StartDockerGrid() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(30000);
	}
	
	public static void StopDockerGrid() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(20000);
	}
}
