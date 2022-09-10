package Controller;



import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/MyExceptionServlet")
public class MyExceptionServlet extends ServletException {

    public MyExceptionServlet(){
        super();
    }

    public MyExceptionServlet(String msg){
        super(msg);
    }

    public static void checkAdmin(HttpServletRequest request) throws MyExceptionServlet {
        Utente utente = (Utente) request.getSession().getAttribute("usrLog");
        if (utente == null ) {
            throw new MyExceptionServlet("Utente non autorizzato");

        }
    }
}