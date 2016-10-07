package org.eclipse.articles.xmleditor.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class XMLEditor extends TextEditor {

	/** The ID of this editor as defined in plugin.xml */
	public static final String EDITOR_ID = "org.eclipse.articles.xmleditor.editors.XMLEditor";

	/** The ID of the editor context menu */
	public static final String EDITOR_CONTEXT = EDITOR_ID + ".context";

	/** The ID of the editor ruler context menu */
	public static final String RULER_CONTEXT = EDITOR_CONTEXT + ".ruler";

	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
		setRulerContextMenuId(RULER_CONTEXT);
	}

	private ColorManager colorManager;

	public XMLEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
