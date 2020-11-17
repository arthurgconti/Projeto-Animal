/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoanimalarthur;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author Arthur Conti
 */
public class Splash {
    
    private final int larguraImg=800;
    private final int alturaImg=600;
    private final int tempoDeSplash=3000;
    private final String caminhoImagem = "/imagens/taco-preloader.gif";
    
    
    public Splash(){
        JWindow janelaSplash = new JWindow();
        
        janelaSplash.getContentPane().add(
                new JLabel("",new ImageIcon(getClass().getResource(caminhoImagem)),SwingConstants.CENTER)
        );
        
        
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimensao = toolkit.getScreenSize();
        
        janelaSplash.setBounds((dimensao.width - larguraImg)/2,
                                (dimensao.height - alturaImg)/2,
                                larguraImg,
                                alturaImg
        );
        
        janelaSplash.setVisible(true);
        
        try{
            Thread.sleep(tempoDeSplash);
        }catch(InterruptedException e){
        }
        janelaSplash.dispose();
        
        
    }
    
}
