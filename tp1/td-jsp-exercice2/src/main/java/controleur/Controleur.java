package controleur;

import facade.FacadeParis;
import facade.FacadeParisStaticImpl;
import facade.exceptions.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Match;
import modele.Pari;
import modele.Utilisateur;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

public class Controleur extends HttpServlet {
    //    private FacadeParis facadeParis = new FacadeParisStaticImpl();
    private FacadeParis facadeParis;

    public Controleur() {
        this.facadeParis = new FacadeParisStaticImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request,response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] path = request.getRequestURI().split("/");
//        this.facadeParis = (FacadeParis) request.getServletContext().getAttribute("facadeParis");
        String cleNavigation = path[path.length - 1];
        String destination = "/WEB-INF/pages/notFound.jsp";
        switch (cleNavigation) {
            case ("home"): {
                destination = "/WEB-INF/pages/home.jsp";
                break;
            }
            case ("parisouverts"): {
                request.getSession().setAttribute("parisOuverts",facadeParis.getMatchsPasCommences());
                destination = "/WEB-INF/pages/parisouverts.jsp";
                break;
            }
            case ("afficherlesparis"): {
                destination = "/WEB-INF/pages/afficherlesparis.jsp";
                break;
            }
            case ("deconnexion"): {
                destination = "/WEB-INF/pages/deconnexion";
                break;
            }
            case ("connexion"): {
                String email = request.getParameter("username");
                String password = request.getParameter("password");
                try {
                    Utilisateur utilisateur = this.facadeParis.connexion(email, password);
                    request.getSession().setAttribute("utilisateur",utilisateur);
                    destination = "/WEB-INF/pages/menu.jsp";
                } catch (UtilisateurDejaConnecteException | InformationsSaisiesIncoherentesException e) {
//                    throw new RuntimeException(e);
                    destination = "/WEB-INF/pages/notFound.jsp";
                }
            }
        }
        request.getServletContext().getRequestDispatcher(destination).forward(request, response);
    }
}