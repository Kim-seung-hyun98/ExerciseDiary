package handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface CommandHandler {
    String handlerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException;
}
