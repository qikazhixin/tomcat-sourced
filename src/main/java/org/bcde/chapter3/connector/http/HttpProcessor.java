package org.bcde.chapter3.connector.http;

import java.net.Socket;

public class HttpProcessor {

    private HttpConnector connector;
    private HttpRequest request;
    private HttpRequestLine requestLine = new HttpRequestLine();
    private HttpResponse response;

//    protected

    public HttpProcessor(HttpConnector httpConnector) {
        this.connector = httpConnector;
    }

    public void process(Socket socket) {

    }
}
