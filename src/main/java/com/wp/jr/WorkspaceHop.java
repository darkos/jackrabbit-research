package com.wp.jr;

import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;

import org.apache.jackrabbit.commons.JcrUtils;

public class WorkspaceHop {
	public static void main(String[] args) throws Exception {
		Repository repository = JcrUtils.getRepository();
        Session session = repository.login( 
        new SimpleCredentials("admin", "admin".toCharArray()));
        
        try {
        	Workspace workspace = session.getWorkspace();
//        	workspace.createWorkspace("darkonije");
//        	System.out.println("darkonije name: " + workspace.getName());
        	String[] workspaceNames =  workspace.getAccessibleWorkspaceNames();
        	for(String wspace : workspaceNames) {
        		System.out.println(wspace);
        	}
        } finally { 
            session.logout();
        }
	 
	}
}
