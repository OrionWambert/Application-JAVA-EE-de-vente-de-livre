/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.yekolab.servlet;

import cg.yekolab.lab.interceptor.UserBean;
import cg.yekolab.lab.model.Livre;
import cg.yekolab.lab.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Orion WAMBERT
 */
@WebServlet(value = "/article")
public class ArticleController extends HttpServlet {

    @Inject
    private UserBean userbean;
    private List<Livre> list = new ArrayList<>();

    /**
     * 
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     * Renvoie vers la JSP ArticleJsp.jsp
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/ArticleJsp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * Recuperation De l'utilisateur inscrit 
         */
        User user = userbean.allUsersMap().get(1);
        if (req.getParameter("envoyer").equalsIgnoreCase("remove")) {
              /**
               * Suppression du livres passe en parametre
               */
            userbean.deleteUserLivre(user, user.getLivres().get(Integer.parseInt(req.getParameter("item"))));
            req.setAttribute("livreList", list);
            this.getServletContext().getRequestDispatcher("/ArticleJsp.jsp").forward(req, resp);
        } else {
               /**
                * Création d'un nouveau Livres
                */
            Livre livre = new Livre(userbean.getUserLivres(user).size() + 1,
                     req.getParameter("nom"),
                    req.getParameter("date"),
                     req.getParameter("auteur"),
                    req.getParameter("nombrePage"),
                    req.getParameter("editeur"));
            list.add(livre);
            user.setLivres(list);
              
            HttpSession session = req.getSession();
            /**
             * Ajout du livre dans la session de l'utilisateur
             */
            session.setAttribute("livreList", list);
            req.setAttribute("livreList", list);
            this.getServletContext().getRequestDispatcher("/ArticleJsp.jsp").forward(req, resp);

        }

    }

}
