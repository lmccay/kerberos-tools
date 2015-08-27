package com.ecosystemsoftware.security.kerberos;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.security.auth.Subject;

import com.sun.security.auth.module.Krb5LoginModule;

/**
 * This is simple Java program that tests ability to authenticate 
 * with Kerberos using the JDK implementation.
 * 
 * The program uses no libraries but JDK itself.
 */
public class KeyTabCheck {

  private void loginImpl(final String propertiesFileName) throws Exception {
    System.out.println(System.getProperty("java.version"));
    System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");
    System.setProperty("sun.security.krb5.debug", "true");

    final Subject subject = new Subject();

    final Krb5LoginModule krb5LoginModule = new Krb5LoginModule();
    final Map<String,String> optionMap = new HashMap<String,String>();

    File f = new File(propertiesFileName);
    System.out.println("======= property file ["+f.getAbsolutePath()+"]");
    Properties p = new Properties();
    InputStream is = new FileInputStream(f);
    try {
      p.load(is);
    } finally {
      is.close();
    }
    optionMap.putAll((Map)p);
    optionMap.put("debug", "true"); // switch on debug of the Java implementation

    krb5LoginModule.initialize(subject, null, new HashMap<String,String>(), optionMap);

    System.out.println("======= starting JAAS login...");
    boolean loginOk = krb5LoginModule.login();
    System.out.println("======= login:  " + loginOk);

    boolean commitOk = krb5LoginModule.commit();
    System.out.println("======= commit: " + commitOk);

    System.out.println("======= Subject: " + subject);
  }

  public static void main(String[] args) throws Exception {
    final KeyTabCheck ktchk = new KeyTabCheck();
    // propsfile
    if (args.length == 0) {
      ktchk.loginImpl("./krb.properties");
    }
    else {
      ktchk.loginImpl(args[0]);
    }
  }
}