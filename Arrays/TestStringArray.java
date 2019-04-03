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


public class TestStringArray
{
    public static void main(String args[])
    {
        String[] ldapServerUrls = new String[2];
        ldapServerUrls[0] = "LDAP://ip-01/DC=cn,DC=complany,DC=net";
        ldapServerUrls[1] = "LDAP://ip-02/OU=Staff,OU=Resources,DC=china,DC=complany,DC=net";
        
        int retryCount = 0;
        do {
                Hashtable<String,String> env = new Hashtable<String,String>();
                env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
                env.put(Context.PROVIDER_URL, ldapServerUrls[retryCount]);
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL, username+"@complany.com");
                env.put(Context.SECURITY_CREDENTIALS, password);
                env.put("com.sun.jndi.ldap.connect.timeout", "5000");
                String baseDN = "";
            try {
                System.out.println("authenticating to " + ldapServerUrls[retryCount]);
                DirContext ctx = new InitialDirContext(env);
                System.out.println("authenticating to LDAP " + ldapServerUrls[retryCount] + " Successfully with:" + username+"@complany.com");
                break;
            } catch (javax.naming.AuthenticationException e) {
                System.out.println("authenticating failure");
            } catch (Exception e) {
                System.out.println("authenticating error" + e);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("authenticating error");
            }
            retryCount++;
        } while (retryCount<2);

    }
}
