package br.jus.tjpe.infosistelecom.factory;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPConnectionFactory {
	static boolean  auth;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean authentication(String username, String password) {

		username = username + "@tjpe.gov.br";
		
		Hashtable authEnv = new Hashtable(11);
		authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		authEnv.put(Context.PROVIDER_URL, "ldap://192.168.251.200:389");
		authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		authEnv.put(Context.SECURITY_PRINCIPAL, username);
		authEnv.put(Context.SECURITY_CREDENTIALS, password);
		try {
			DirContext context = new InitialDirContext(authEnv);
			System.out.println("Autenticado");
			auth = true;
			return auth;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não Autenticado");
			auth = false;
			return auth;
		}

	}
}