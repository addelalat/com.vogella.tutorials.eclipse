package com.vogella.saneclipse.test.tools.handlers;

import java.io.ByteArrayInputStream;
import java.util.Random;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class CreateLargeTestProject {

	private final Random random = new Random();

	private static final String chars = "abcdefghijklmnopqrstuvwxyz";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell s) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject("performancetest");
		try {
			project.create(new NullProgressMonitor());
			project.open(null);
			for (int i = 0; i < 30; i++) {
				IFolder folder = project.getFolder("test" + i);
				folder.create(true, true, null);
				for (int j = 0; j < 3000; j++) {
					IFile file = folder.getFile(createString(10));
					file.create(new ByteArrayInputStream(createBytes(5000)), IResource.NONE, null);
				}
			}
		} catch (CoreException e) {
			System.out.println(e);
		}


	}

	private byte[] createBytes(int length) {
		byte[] bytes = new byte[length];
		random.nextBytes(bytes);
		return bytes;
	}

	private String createString(int length) {
		StringBuffer buf = new StringBuffer(length);
		// fill the string with random characters up to the desired length
		for (int i = 0; i < length; i++) {
			buf.append(chars.charAt(random.nextInt(chars.length())));
		}
		return buf.toString();
	}
}
