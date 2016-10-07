package org.eclipse.ui.articles.action.contribution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

public class DeleteActionDelegate extends ActionDelegate implements IViewActionDelegate {
	public void run(IAction action) {
		String buildCommand = "java -jar jenkins-cli.jar -s http://127.0.0.1:8085/jenkins/ build sample_cli_job";
		
		try {
	    	
	    	ProcessBuilder builder = new ProcessBuilder(
	    			"cmd.exe", "/c", "cd \"C:\\opt\\isv\\tomcat-7.0\\grid\\webapps\\jenkins\" && " + buildCommand );
	        builder.redirectErrorStream(true);
	        Process p = builder.start();
	                
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        StringBuilder line= new StringBuilder();
	        
	        while (!line.toString().contains("null")) {
	           line.append( r.readLine() +"\n");
	           if (line == null) { break; }
	        }
	        
	        MessageBox box = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
			box.setMessage( line.toString().replace("null", "Build created Sucessfully!"));
			box.open();
		
		} catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public void init(IViewPart view) {
	}
}
