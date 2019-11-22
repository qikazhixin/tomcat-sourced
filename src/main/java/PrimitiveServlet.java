import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("--init");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("--from service");
        PrintWriter writer = res.getWriter();
        writer.println("Hello, woows");
        writer.print("Wulala");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("--destroy");
    }
}
