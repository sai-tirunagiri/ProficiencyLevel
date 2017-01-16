package com.org.Generic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;

//import com.quinnox.logging.TrnsformLogger;
public class LdapConnectivity {
	HttpServletRequest request;
	HttpSession mySession = request.getSession();
	
		//static Logger log =  TrnsformLogger.getLogObject();

		public static Map<String, String> authenticateAD(String userName, String passwordString) throws Exception {
			
			/*Map<String, String> userAttrMap = new HashMap<String, String>();
			try {
				userAttrMap.put(ConfigValues.getConfigValue("LDAP_USER_MAIL_FIELD"), "VinayS@quinnox.com");
				userAttrMap.put(ConfigValues.getConfigValue("LDAP_USER_NAME_FIELD"), "Vinay Gopal Settipalli");
				userAttrMap.put(ConfigValues.getConfigValue("LDAP_USER_ID_FIELD"), "VinayS");
			} catch (Exception ex) {  
				throw ex;
			}
			return userAttrMap;*/		

			Map<String, String> userAttrMap = null;
			LdapContext ldapContext = null;
			try {
				String ldapURL = "ldap://10.20.3.3:389";
				String searchBase = "DC=quinnox,DC=corp";
				//System.out.println("URl LDAP: "+ldapURL+"map data:");
			    //log.debug("URl LDAP: "+ldapURL+"map data:")
				String returnedAtts[] = { "sAMAccountName", "displayName", "mail","manager","employeeNumber","title","memberof" };
				String searchFilter = "("+"sAMAccountName"+"=" + userName + ")";
		         
				Hashtable<String, String> env = new Hashtable<String, String>();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
				env.put(Context.PROVIDER_URL, ldapURL);
				env.put(Context.SECURITY_AUTHENTICATION, "simple");
				env.put(Context.SECURITY_PRINCIPAL, "Quinnox" + "\\" + userName);
				env.put(Context.SECURITY_CREDENTIALS, passwordString);
			
				System.out.println("Hash table contains :" + env);
				
				SearchControls searchControls = new SearchControls();
				searchControls.setReturningAttributes(returnedAtts);
				searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
				
				System.out.println("the search controls are :" + searchControls);
				
				ldapContext = new InitialLdapContext(env, null);
				System.out.println("PASS");
				NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchControls);
				
				if (answer.hasMoreElements()) {
					SearchResult sr = (SearchResult) answer.next();
					Attributes attrs = sr.getAttributes();
					
					System.out.println("Attributes are :" + attrs);
					
					if (attrs != null) {
						userAttrMap = new HashMap<String, String>();
						NamingEnumeration<?> ne = attrs.getAll();
						while (ne.hasMore()) {
							Attribute attr = (Attribute) ne.next();
							userAttrMap.put(attr.getID(), attr.get().toString());
						}
						ne.close();
					}
					answer.close();
					System.out.println("end of code");
				}
			} catch(CommunicationException cEx) {
				throw cEx;
			} catch (AuthenticationException aEx) {
				
						System.out.println("AuthenticationException");
						return null;
			} catch (NamingException nEx) {
				System.out.println("NamingException"+nEx.getMessage());
				nEx.printStackTrace();
				return null;
			} catch (Exception ex) {  
				throw ex;
			} finally {
				try {
					if(ldapContext != null) {
						ldapContext.close();
					}
				} catch (Exception e) { }
			}
			
			return userAttrMap;
		}
		
		
	}

	
	
	
	

