package controller;

import handler.CommandHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class FrontController extends HttpServlet {
    private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        String contextConfigFile = this.getInitParameter("handlerProperties");
        Properties properties = new Properties();
        FileInputStream fis = null;
        try{
            String contextConfigFilePath = this.getServletContext().getRealPath(contextConfigFile);
            fis = new FileInputStream(contextConfigFilePath);
            properties.load(fis);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if (fis != null) {
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        Iterator<Object> propIt = properties.keySet().iterator();
        while (propIt.hasNext()) {
            String command = (String) propIt.next();
            String handlerClassName = properties.getProperty(command);
            try {
                Class<?> handlerClass = Class.forName(handlerClassName);
                commandHandlerMap.put(command, (CommandHandler) handlerClass.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI().toString();
        System.out.println("requestURI = " + requestURI);
        CommandHandler handler = null;
        String viewPage = null;
        if (requestURI.indexOf(req.getContextPath()) == 0) {
            handler = commandHandlerMap.get(requestURI);
            viewPage = handler.handlerAction(req, resp);
        }
        req.getRequestDispatcher(viewPage).forward(req, resp);
    }
}
