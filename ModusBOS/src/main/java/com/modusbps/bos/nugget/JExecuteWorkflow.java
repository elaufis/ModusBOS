package com.modusbps.bos.nugget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JExecuteWorkflow {
	private String launcherPath;
	private String workflowPath;
	
	public JExecuteWorkflow(String launcherPath, String workflowPath){
		this.launcherPath = launcherPath;
		this.workflowPath = workflowPath;
	}

	public void executeWorkFlow(){
		try
		{
			// Launch the workflow.
			Process myProcess = new ProcessBuilder(launcherPath, workflowPath).start();
			myProcess.waitFor();

			// Get the output of the workflow.
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(myProcess.getInputStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
		}
		catch (IOException ex)
		{
		}
		catch (InterruptedException ex)
		{
		}
	}

}
