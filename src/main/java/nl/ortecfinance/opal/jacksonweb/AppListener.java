package nl.ortecfinance.opal.jacksonweb;

import app.owf.inject.DependencyContainer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import nl.ortecfinance.opal.jacksonweb.validate.ExternalApiModule;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("contextInitialized AppListener ");
        ExternalApiModule.initialize(DependencyContainer.getDefaultContainer());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
