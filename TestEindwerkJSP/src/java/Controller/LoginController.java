/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.Account;
import services.Find;

/**
 *
 * @author Jo
 */
public class LoginController {
    public boolean Login(String naam , String wachtwoord)
    {
        Account user = new Find().findAccountByName(naam);
        if(user.getId() == 0)return false;
        if(user.getWachtwoord().equals(wachtwoord))return true;
        else return false;
    }
}
