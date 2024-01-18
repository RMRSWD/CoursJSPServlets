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
    private Utilisateur utilisateur;

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
                destination = "/WEB-INF/pages/parisOuverts.jsp";
                break;
            }
            case ("afficherlesparis"): {
                String idLogin = this.utilisateur.getLogin();
                Pari mesparis = (Pari) this.facadeParis.getMesParis(idLogin);
                request.getSession().setAttribute("mesparis",mesparis);
                destination = "/WEB-INF/pages/affichermesparis.jsp";
                break;
            }

            case ("deconnexion"): {
                destination = "/WEB-INF/pages/deconnexion.jsp";
                break;
            }
            case ("connexion"): {
                String email = request.getParameter("username");
                String password = request.getParameter("password");
                try {
                     this.utilisateur = this.facadeParis.connexion(email, password);
                    request.getSession().setAttribute("utilisateur",utilisateur);
                    destination = "/WEB-INF/pages/menu.jsp";
                } catch (UtilisateurDejaConnecteException | InformationsSaisiesIncoherentesException e) {
//                    throw new RuntimeException(e);
                    destination = "/WEB-INF/pages/notFound.jsp";
                }
                break;
            }
            case("confirmationPari"):{
                long idMatch = Long.parseLong(request.getParameter("id"));
                Pari pari = this.facadeParis.getPari(idMatch);
                Match match = this.facadeParis.getMatch(idMatch);
                request.getSession().setAttribute("match",match);
                request.getSession().setAttribute("pari",pari);
                destination = "/WEB-INF/pages/parierMatch.jsp";
                break;
            }
        }
        request.getServletContext().getRequestDispatcher(destination).forward(request, response);
    }
}