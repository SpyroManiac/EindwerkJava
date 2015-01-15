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
        WinkelWagen w = new Find().findWinkelwagenById(151);
        System.out.println(w.getId() + " " + w.getProductId() + " " + w.getAccountId());
        w.setTotaal(50000);
        int UpdateWinkelwagen = new Update().UpdateWinkelwagen(w);
        System.out.println(UpdateWinkelwagen);
//        w.setTotaal(10);
//        int UpdateWinkelwagen = new Update().UpdateWinkelwagen(w);
//        System.out.println(w);
        
    }
}
