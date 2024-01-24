package listeners;


import facade.FacadeParis;
import facade.FacadeParisStaticImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ListenerApplication implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("facade", new FacadeParisStaticImpl() {
        });
    }
}
