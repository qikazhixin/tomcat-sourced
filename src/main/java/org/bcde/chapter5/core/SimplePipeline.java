package org.bcde.chapter5.core;

import org.apache.catalina.Contained;
import org.apache.catalina.Container;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Request;
import org.apache.catalina.Response;
import org.apache.catalina.Valve;
import org.apache.catalina.ValveContext;

import javax.servlet.ServletException;
import java.io.IOException;

public class SimplePipeline implements Pipeline {

    protected Valve basic = null;
    protected Container container = null;
    protected Valve valves[] = new Valve[0];

    public SimplePipeline(Container container) {
        setContainer(container);
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Valve getBasic() {
        return null;
    }

    public void setBasic(Valve valve) {
        this.basic = valve;
        ((Contained)valve).setContainer(container);
    }

    public void addValve(Valve valve) {
        if (valve instanceof Contained) {
            ((Contained)valve).setContainer(container);
        }
        synchronized (valves) {
            Valve[] results = new Valve[this.valves.length + 1];
            System.arraycopy(valves, 0, results, 0, valves.length);
            results[valves.length] = valve;
            valves = results;
        }
    }

    public Valve[] getValves() {
        return valves;
    }

    public void invoke(Request request, Response response) throws IOException, ServletException {
        (new SimplePipelineValveContext()).invokeNext(request, response);
    }

    public void removeValve(Valve valve) {

    }

    protected class SimplePipelineValveContext implements ValveContext {

        protected int stage = 0;

        public String getInfo() {
            return null;
        }

        public void invokeNext(Request request, Response response) throws IOException, ServletException {
            int subscript = stage;
            stage = stage + 1;
            if (subscript < valves.length) {
                valves[subscript].invoke(request, response, this);
            } else if ((subscript == valves.length) && (basic != null)) {
                basic.invoke(request, response, this);
            } else {
                throw new ServletException("No valve");
            }
        }
    }
}
