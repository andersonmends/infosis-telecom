package br.jus.tjpe.infosistelecom.factory;

import java.util.List;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

/**
 * Example code for retrieving a Users Primary Group from Microsoft Active
 * Directory via. its LDAP API
 * 
 * @author Adam Retter <adam.retter@googlemail.com>
 */
public class LDAPTest {

	/**
	 * @param args
	 *            the command line arguments
	 * @throws LDAPException 
	 */
	public static void main(String[] args) throws LDAPException{

		String baseDN = "OU=TJPE,DC=tjpe,DC=gov,DC=br";
		String filter = "(objectClass=person)";

		LDAPConnection connection =  getConnection();       
		List<SearchResultEntry> results = getResults(connection, baseDN, filter);
		
	
		
//		String baseDN = "OU=Notebooks,OU=TJPE,DC=tjpe,DC=gov,DC=br";
//		String userDN = "CN=TJPE70114,OU=Notebooks, OU=TJPE,DC=tjpe,DC=gov,DC=br";
//
//		String filterFormat = "(&(objectClass=user)(distinguishedName=%s))";
//		String filter = String.format(filterFormat, userDN);
//
//		LDAPConnection connection =  LDAPTest.getConnection();
//		List<SearchResultEntry> results = getResults(connection, baseDN, filter);
		
		
		
		for (SearchResultEntry e : results) {
		    System.out.println("name: " + e.getAttributeValue("name"));
		    
		}
		
		
		
	}

	public static LDAPConnection getConnection() throws LDAPException {
		// host, port, username and password
		System.out.println("Autenticado");
		return new LDAPConnection("192.168.251.200", 389, "cursomed@tjpe.gov.br", "123456");
		
	}

	public static List<SearchResultEntry> getResults(LDAPConnection connection, String baseDN, String filter)
			throws LDAPSearchException {
		
		
		SearchResult searchResult;

		if (connection.isConnected()) {
			searchResult = connection.search(baseDN, SearchScope.SUB, filter);

			return searchResult.getSearchEntries();
		}

		return null;
	}
	
	
	
}
