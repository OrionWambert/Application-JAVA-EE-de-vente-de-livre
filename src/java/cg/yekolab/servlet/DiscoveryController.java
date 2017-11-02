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
@WebServlet(value = "/discovery")
public class DiscoveryController extends HttpServlet {

    @Inject
    private UserBean userbean;
    /**
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     * 
     * Renvoie vers la page Jsp DiscoveryJsp.jsp
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/DiscoveryJsp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * Recuperation de la session de l'utilisateur
         */
        HttpSession session = req.getSession();

        session.setAttribute("nombresDesLivres", req.getParameter("nombres"));
        
        /**
         * Recuperer de l'utilisateur en cours 
         * et Mise en place de l'achat d'un livre
         */
        User user = userbean.allUsersList().get(0);
        Livre livreAchete = userbean.getUserLivres(user).get(Integer.parseInt(req.getParameter("item")));
        session.setAttribute("livreAdd", livreAchete);
        /**
         * renvoie de l'attribut message vers la page JSP DiscoveryJsp.jsp
         */
        req.setAttribute("message", "<a href=\"#\" class=\"btn btn-link\">"
                + "vous venez d'ajouter " + req.getParameter("nombres") + " exemplaires du livre " + livreAchete.getNom()
                
                + " dans votre panier</a>");
        this.getServletContext().getRequestDispatcher("/DiscoveryJsp.jsp").forward(req, resp);

    }

}
