/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.yekolab.lab.interceptor;

import cg.yekolab.lab.model.Livre;
import cg.yekolab.lab.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author HP Notebook
 */
@ApplicationScoped
public class UserBean implements Serializable{

    private HashMap<Integer, User> maps;
    
    public UserBean() {
    }
    
    @PostConstruct
    public void init(){
        maps = new HashMap<>();
    }
    
    
    /**
     * Ajouter utilisateur
     * @return 
     */
    public void addUser(User user){
        maps.put(user.getId(), user);
    }
    
    /**
     * Supprimer utilisateur
     * @return 
     */
    public void deleteUser(User user){
        maps.remove(user.getId());
    }
    
    /**
     * Récupérer la Map des utilisateur
     * @return 
     */
    public HashMap<Integer, User>  allUsersMap(){
        return maps;
    }
    
    /**
     * Récupérer la list des utilisateur
     * @return 
     */
    public List<User> allUsersList(){
        List<User> u = new ArrayList<>();
        maps.entrySet().forEach((entry) -> {
            u.add(entry.getValue());
        });
        return u;
    }
    
    /**
     * Récupérer les livres de l'utilisateur
     * @param user
     * @return 
     */
    public List<Livre> getUserLivres(User user){
        return user.getLivres();
    }
    
    /**
     * Supprimer le livre d'un utilisateur
     * @param user
     * @param livre 
     */
    public void deleteUserLivre(User user, Livre livre){
        user.getLivres().remove(livre);
    }
    
    /**
     * Vider les livres de l'utilisateur
     * @param user 
     */
    public void deleteAllUserLivre(User user){
        user.getLivres().clear();
    }
}
