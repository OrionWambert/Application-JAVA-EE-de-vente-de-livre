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
@WebServlet(value ="/")
public class RegisterController extends HttpServlet {
    @Inject
    private UserBean userbean;
    private  HttpSession session;
    /**
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     * Permet de rediger l'utilisateur vers sa session
     */
    private void startSession(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
         session=req.getSession();
        
        if (session.getAttribute("user")!=null) {
            this.getServletContext().getRequestDispatcher("/ArticleJsp.jsp").forward(req, resp);
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
       this.getServletContext().getRequestDispatcher("/RegisterJsp.jsp").forward(req, resp);
    }
    /**
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * Permet d'inscrire un utilisateur
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("btn1").equalsIgnoreCase("1")) {
            
            List<Livre>livres=new ArrayList<>();
            
            
            User user=new User(userbean.allUsersMap().size()+1, req.getParameter("nom")
                    ,req.getParameter("prenom"),
                    req.getParameter("genre")
                    , "user"
                    , req.getParameter("login")
                    , req.getParameter("mdp"), livres);
             session=req.getSession();
             session.setAttribute("user", user);
            
            userbean.addUser(user);
            
            
            
            req.setAttribute("message","<div class=\"alert alert-success \">Vous avez bien été enrégisté "
                    
                    + "<span class=\"pull-right delete close\"  data-dismiss=\"alert\" aria-label=\"close\">&times;</span>"
                   
                    + "</div>");
            this.getServletContext().getRequestDispatcher("/RegisterJsp.jsp").forward(req, resp);
        }else{
            this.getServletContext().getRequestDispatcher("/LoginJsp.jsp").forward(req, resp);
        }
    }
    
    

        
    
}
