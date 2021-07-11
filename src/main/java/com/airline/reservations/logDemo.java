package com.airline.reservations;


import org.owasp.esapi.Logger;
import org.owasp.esapi.logging.java.JavaLogFactory;
import org.owasp.esapi.logging.java.JavaLogger;


public class logDemo
{
    //private static Log logger = JavaLogFactory.getLog(logDemo.class);
    private static Logger logger = (Logger) new JavaLogFactory();
    public static void main(String[] args)
    {
    }
}