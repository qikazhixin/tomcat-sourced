package org.bcde.chapter5.startup;

import org.apache.catalina.Pipeline;
import org.apache.catalina.connector.http.HttpConnector;
import org.bcde.chapter5.core.SimpleLoader;
import org.bcde.chapter5.core.SimpleWrapper;
import org.bcde.chapter5.valves.ClientIPLoggerValve;
import org.bcde.chapter5.valves.HeaderLoggerValve;

public class Bootstrap1 {

    public static void main(String[] args) {

        /* call by using http://localhost:8080/ModernServlet,
   but could be invoked by any name */

        HttpConnector connector = new HttpConnector();
        SimpleWrapper wrapper = new SimpleWrapper();
        wrapper.setServletClass("ModernServlet");
        SimpleLoader loader = new SimpleLoader();
        HeaderLoggerValve valve1 = new HeaderLoggerValve();
        ClientIPLoggerValve valve2 = new ClientIPLoggerValve();
        wrapper.setLoader(loader);
        ((Pipeline)wrapper).addValve(valve1);
        ((Pipeline)wrapper).addValve(valve2);

        connector.setContainer(wrapper);
        try {
            connector.initialize();
            connector.start();

            // make the application wait until we press a key.
            System.in.read();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
