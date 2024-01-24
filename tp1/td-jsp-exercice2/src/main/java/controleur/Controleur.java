package controleur;

import facade.FacadeParis;
import facade.exceptions.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Match;
import modele.Pari;
import modele.Utilisateur;

import java.io.IOException;
import java.util.Collection;

public class Controleur extends HttpServlet {
    //    private FacadeParis facadeParis = new FacadeParisStaticImpl();
//    private FacadeParis facadeParis;
    private Utilisateur utilisateur;

/*    public Controleur() {
        this.facadeParis = new FacadeParisStaticImpl();
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);

    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] path = request.getRequestURI().split("/");
        FacadeParis facadeParis = (FacadeParis) request.getServletContext().getAttribute("facade");
        String cleNavigation = path[path.length - 1];
        String destination = "/WEB-INF/pages/notFound.jsp";
        switch (cleNavigation) {
            case ("home"): {
                destination = "/WEB-INF/pages/home.jsp";
                break;
            }
            case ("parisouverts"): {
                request.getSession().setAttribute("parisOuverts", facadeParis.getMatchsPasCommences());
                destination = "/WEB-INF/pages/parisOuverts.jsp";
                break;
            }
          /*  case ("affichermesparis"): {
                String idLogin = this.utilisateur.getLogin();
                Pari mesparis = (Pari) facadeParis.getMesParis(idLogin);
                request.getSession().setAttribute("mesparis",mesparis);
                destination = "/WEB-INF/pages/affichermesparis.jsp";
                break;
            }*/

            case ("deconnexion"): {
                destination = "/WEB-INF/pages/deconnexion.jsp";
                break;
            }
            case ("connexion"): {
                String email = request.getParameter("username");
                String password = request.getParameter("password");
                try {
                    this.utilisateur = facadeParis.connexion(email, password);
                    request.getSession().setAttribute("utilisateur", utilisateur);
                    destination = "/WEB-INF/pages/menu.jsp";
                } catch (UtilisateurDejaConnecteException | InformationsSaisiesIncoherentesException e) {
//                    throw new RuntimeException(e);
                    destination = "/WEB-INF/pages/notFound.jsp";
                }
                break;
            }
            case ("confirmationPari"): {
                long idMatch = Long.parseLong(request.getParameter("id"));
                Pari pari = facadeParis.getPari(idMatch);
                Match match = facadeParis.getMatch(idMatch);
                request.getSession().setAttribute("match", match);
                request.getSession().setAttribute("pari", pari);
                destination = "/WEB-INF/pages/parierMatch.jsp";
                break;
            }
            case ("affichermesparis"): {
//                String l = (Utilisateur)request.getSession().getAttribute("utilisateur")).getLogin()
//                FacadeParis mesParis = (FacadeParis) facadeParis.getMesParis(login);
                Collection<Pari> mesParis = facadeParis.getMesParis(((Utilisateur) request.getSession().getAttribute("utilisateur")).getLogin());
//                request.getSession().setAttribute("mesParis",facadeParis.getMesParis(((Utilisateur)request.getSession().getAttribute("utilisateur")).getLogin()));
                request.getSession().setAttribute("mesparis", mesParis);
                destination = "/WEB-INF/pages/affichermesparis.jsp";
            }
            case ("annulerpari"): {
//                long idParis = Long.parseLong(request.getParameter("id"));
                long idParis = Long.parseLong(request.getParameter("id"));
//                long idParis = 100;

//                String loginUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getLogin();
                try {
                    Pari pari = facadeParis.getPari(idParis);
                    request.getSession().setAttribute("pari",pari);
                    facadeParis.annulerPari(((Utilisateur)request.getSession().getAttribute("utilisateur")).getLogin(),idParis);


                   /* facadeParis.annulerPari(loginUtilisateur, idParis);
                    Collection<Pari> mesParis = facadeParis.getMesParis(((Utilisateur) request.getSession().getAttribute("utilisateur")).getLogin());
                    request.getSession().setAttribute("mesParis", mesParis);
                    request.getSession().setAttribute("idParis", idParis);
                    destination = "/WEB-INF/pages/annulerParis.jsp";*/
                } catch (OperationNonAuthoriseeException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        request.getServletContext().getRequestDispatcher(destination).forward(request, response);
    }
}