/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoanimalarthur;

import com.br.VIEW.frmLoginArthur;

/**
 *
 * @author Arthur Conti
 */
public class ProjetoAnimalArthur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Splash();
        frmLoginArthur frmLogin = new frmLoginArthur();
        frmLogin.setVisible(true);
    }
    
}
