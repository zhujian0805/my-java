import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;


public class TestLdapAuth
{
    public static void main(String args[])
    {
        String[] ldapServerUrls = new String[2];
        ldapServerUrls[0] = "LDAP://ad01/DC=cn,DC=company,DC=net";
        ldapServerUrls[1] = "LDAP://ad02/OU=Staff,OU=Resources,DC=corp,DC=company,DC=net";
        String username = "username";
        String password = "Supersecurepassword"

        int retryCount = 10;
        do {
                int index = retryCount % 2;
                Hashtable<String,String> env = new Hashtable<String,String>();
                env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
                env.put(Context.PROVIDER_URL, ldapServerUrls[index]);
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL, username+"@company.com");
                env.put(Context.SECURITY_CREDENTIALS, password);
                env.put("com.sun.jndi.ldap.connect.timeout", "2000");
                String baseDN = "";
            try {
                System.out.println("authenticating to " + ldapServerUrls[index]);
                DirContext ctx = new InitialDirContext(env);
                System.out.println("authenticating to LDAP " + ldapServerUrls[index] + " Successfully with:" + username+"@company.com");
                break;
            } catch (javax.naming.AuthenticationException e) {
                System.out.println("authenticating failure");
            } catch (Exception e) {
                System.out.println("authenticating error" + e);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("authenticating error");
            }
            retryCount--;
        } while (retryCount>0);

    }
}
