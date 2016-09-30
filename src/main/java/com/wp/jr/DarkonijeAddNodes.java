package com.wp.jr;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;

import org.apache.jackrabbit.commons.JcrUtils;

public class DarkonijeAddNodes {
	public static void main(String[] args) throws Exception {
		Repository repository = JcrUtils.getRepository();
        Session session = repository.login( 
        new SimpleCredentials("admin", "admin".toCharArray()), "darkonije");
        
        try {
        	Workspace workspace = session.getWorkspace();
        	System.out.println(workspace.getName());
        	
        	Node root = session.getRootNode();
        	Node home = root.addNode("home");
        	Node knowledge = home.addNode("knowledge");
        	Node users = home.addNode("users");
        	Node subjects = home.addNode("subjects");
        	Node interest = home.addNode("interest");
        	Node tools = home.addNode("tools");
        	
        	session.save();
        } finally { 
            session.logout();
        }
	 
	}
}
