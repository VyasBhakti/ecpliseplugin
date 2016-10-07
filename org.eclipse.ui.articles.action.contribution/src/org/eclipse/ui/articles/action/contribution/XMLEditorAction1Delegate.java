package org.eclipse.ui.articles.action.contribution;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

public class XMLEditorAction1Delegate extends ActionDelegate implements
		IEditorActionDelegate {

	public XMLEditorAction1Delegate() {
	}

	/**
	 * @see ActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		MessageBox box = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		box.setMessage("Executing: " + getClass());
		box.open();
	}
	
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {

	}

}
