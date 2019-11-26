package org.bcde.chapter6.core;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import org.apache.catalina.Container;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Loader;

public class SimpleLoader implements Loader, Lifecycle {

    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator  + "webroot";

    ClassLoader classLoader = null;
    Container container = null;

    public SimpleLoader() {
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
            urls[0] = new URL(null, repository, streamHandler);
            classLoader = new URLClassLoader(urls);
        }
        catch (IOException e) {
            System.out.println(e.toString() );
        }
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public boolean getDelegate() {
        return false;
    }

    public void setDelegate(boolean b) {

    }

    public String getInfo() {
        return "A simple loader";
    }

    public boolean getReloadable() {
        return false;
    }

    public void setReloadable(boolean b) {

    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }

    public void addRepository(String s) {

    }

    public String[] findRepositories() {
        return new String[0];
    }

    public boolean modified() {
        return false;
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {

    }

    public LifecycleListener[] findLifecycleListeners() {
        return null;
    }

    public void removeLifecycleListener(LifecycleListener lifecycleListener) {

    }

    public void start() throws LifecycleException {
        System.out.println("Starting SimpleLoader");
    }

    public void stop() throws LifecycleException {

    }
}
