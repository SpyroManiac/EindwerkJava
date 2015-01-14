/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindwerkjava;

import DAL.*;
import Services.*;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jo
 */
public class test {
    public static void main(String[] args) {
        Find f = new Find();
        Account account = f.findAccountByName("test");
        Product product = f.findProductByName("test");
        
        int SaveWinkelWagen = new Save().SaveWinkelWagen(account, product, 10);
        System.out.println(SaveWinkelWagen);
    }
}
