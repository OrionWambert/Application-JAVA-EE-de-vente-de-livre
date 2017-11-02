package cg.yekolab.servlet;

import cg.yekolab.lab.interceptor.UserBean;
import cg.yekolab.lab.model.User;
import java.io.IOException;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Orion WAMBERT
 */
@WebServlet(value = "/login")
public class LoginController extends HttpServlet {

    private HttpSession session;
    @Inject
    private UserBean userBean;

    public LoginController() {
    }
    /***
     * 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     * Permet rediger l'utilisateur vers sa session
     */
    private void startSession(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        session = req.getSession();

        if (session.getAttribute("user") != null) {
            this.getServletContext().getRequestDispatcher("/ArticleJsp.jsp").forward(req, res);
        }
    }
/**
 * 
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException 
 * 
 * Mise en place de la redirection
 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        startSession(req, resp);
        this.getServletContext().getRequestDispatcher("/LoginJsp.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /**
          * Permet de connecter verifier si l'utilisateur est bien inscrit
          */
        try {
            if (req.getParameter("btn").equalsIgnoreCase("1")) {
                //click sur le bouton Connexion
                final String login = req.getParameter("login");
                final String pass = req.getParameter("mdp");
                boolean isOK = false;
                for (Map.Entry<Integer, User> u
                        : userBean.allUsersMap().entrySet()) {
                    User value = u.getValue();
                    if (value.getLogin().equals(login)
                            && value.getPass().equals(pass)) {
                        req.setAttribute("user", value);
                        session = req.getSession();
                        session.setAttribute("user", value);
                        isOK = true;
                    }
                }
                if (isOK) {
                    this.getServletContext().getRequestDispatcher("/ArticleJsp.jsp")
                            .forward(req, resp);
                } else {
                    req.setAttribute("message", "<div class=\"alert alert-danger\">Identification invalide"
                            + "<span class=\"pull-right delete\" data-dismiss=\"alert\" aria-label=\"close\">&times;</span>"
                            + "</div>");
                    this.getServletContext().getRequestDispatcher("/LoginJsp.jsp")
                            .forward(req, resp);
                }
            }
        } catch (NullPointerException e) {
            //resp.sendRedirect(req.getContextPath()+"/login.jsp");
            this.getServletContext().getRequestDispatcher("/LoginJsp.jsp")
                    .forward(req, resp);
        }
    }

}
