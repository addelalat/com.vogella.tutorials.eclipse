package com.vogella.swt.widgets.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SWTLayoutPositioning {

	static String newLine = System.getProperty("line.separator");
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		Label positiongLabel = new Label(shell, SWT.BORDER);
		
		int x= 60;
		int y=20;
		int width =400;
		int height=200;
	
		positiongLabel.setBounds(x, y, width, height);

		// approx. shell toolbar size
		int toolbarSize = 30;
		// initial position
		shell.setBounds(200, 400, width+2*x , height + 2*y +toolbarSize);
		shell.open();
		
		
		String s = "Bounds for Label: " + positiongLabel.getBounds() + newLine;
		s+= "Bounds for Shell: " + shell.getBounds();
		positiongLabel.setText(s);
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
