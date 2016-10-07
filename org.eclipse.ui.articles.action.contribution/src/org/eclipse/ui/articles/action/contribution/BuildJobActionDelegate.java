package org.eclipse.ui.articles.action.contribution;

/*import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

public class BuildJobActionDelegate extends ActionDelegate implements IViewActionDelegate
{

	/**
	 * @see ActionDelegate#run(IAction)
	 */
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

	/**
	 * @see IViewActionDelegate#init(IViewPart)
	 */
	public void init(IViewPart view) {
		
	}

}


/*
public class BuildJobActionDelegate extends Dialog {
    	private Text txtUser;
		private Text txtPassword;
		private String user = "";
		private String password = "";
		
		public BuildJobActionDelegate(Shell parentShell) {
		        super(parentShell);
		}
		
		@Override
		protected Control createDialogArea(Composite parent) {
		        Composite container = (Composite) super.createDialogArea(parent);
		        GridLayout layout = new GridLayout(2, false);
		        layout.marginRight = 5;
		        layout.marginLeft = 10;
		        container.setLayout(layout);
		
		        Label lblUser = new Label(container, SWT.NONE);
		        lblUser.setText("User:");
		
		        txtUser = new Text(container, SWT.BORDER);
		        txtUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
		                        1, 1));
		        txtUser.setText(user);
		        txtUser.addModifyListener(new ModifyListener() {
		
		                @Override
		                public void modifyText(ModifyEvent e) {
		                        Text textWidget = (Text) e.getSource();
		                        String userText = textWidget.getText();
		                        user = userText;
		                }
		        });
		
		        Label lblPassword = new Label(container, SWT.NONE);
		        GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
		                        false, 1, 1);
		        gd_lblNewLabel.horizontalIndent = 1;
		        lblPassword.setLayoutData(gd_lblNewLabel);
		        lblPassword.setText("Password:");
		
		        txtPassword = new Text(container, SWT.BORDER| SWT.PASSWORD);
		        txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		                        false, 1, 1));
		        txtPassword.setText(password);
		        txtPassword.addModifyListener(new ModifyListener() {
		
		                @Override
		                public void modifyText(ModifyEvent e) {
		                        Text textWidget = (Text) e.getSource();
		                        String passwordText = textWidget.getText();
		                        password = passwordText;
		                }
		        });
		        return container;
		}
		
		// override method to use "Login" as label for the OK button
		@Override
		protected void createButtonsForButtonBar(Composite parent) {
		        createButton(parent, IDialogConstants.OK_ID, "Login", true);
		        createButton(parent, IDialogConstants.CANCEL_ID,
		                        IDialogConstants.CANCEL_LABEL, false);
		}
		
		@Override
		protected Point getInitialSize() {
		        return new Point(450, 300);
		}
		
		@Override
		protected void okPressed() {
		        user = txtUser.getText();
		        password = txtPassword.getText();
		        super.okPressed();
		}
		
		public String getUser() {
		        return user;
		}
		
		public void setUser(String user) {
		        this.user = user;
		}
		
		public String getPassword() {
		        return password;
		}
		
		public void setPassword(String password) {
		        this.password = password;
		}
		
}*/