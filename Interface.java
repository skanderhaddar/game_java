import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener ;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Interface implements ActionListener {
    
    joueur[] J;
    JFrame f1;
    Button b1, b2 ,ok ,repButton;
    JLabel l1, l2 , vide1 , vide2 , vide11 , vide22 ;
    JPanel pan_principal  , pan1, pan2, pan11, pan22 , panVide , hello , panOk ,pan_qst , panel_qst;
    HashMap<String,String> M1 ;
    JTextField nom1, nom2 ;
     joueur j1 , j2 ; 
    Interface_qst Int ;
    public Interface() {
        //initialisation des joueurs //
        j1 = new joueur() ;
        j2 = new joueur() ;
        //initialisation de dictionnaire des qst/reponses //
        M1 = new HashMap<>() ;
        //initialisation de frame //
        f1 = new JFrame("quiz");
        //initialisation des buttons//
        b1 = new Button("ajouter 1e nom de 1er joueur");
        b2 = new Button("ajouter 1e nom de 2eme joueur");
        ok= new Button("okay") ;
        //initialisation des panels //
        hello = new JPanel();
        pan_principal = new JPanel() ; 
        pan1 = new JPanel();
        pan11 = new JPanel();
        pan2 = new JPanel();
        pan22 = new JPanel();
        panVide = new JPanel();
        panOk = new JPanel();
        pan_qst = new JPanel() ;

        
        //initialisation de textfields//
        nom1 = new JTextField(20);
        nom2 = new JTextField(20);
        //initialisation des labels //
        l1 = new JLabel("nom de 1er joueur");
        l2 = new JLabel("nom de 2eme joueur");
        vide1 = new JLabel("   ") ; 
        vide2 = new JLabel("   ");
        vide11= new JLabel("   "); ;
        vide22= new JLabel("   "); ;
    
        
        //**********//
        pan_principal.setBackground(Color.CYAN);
        panVide.setBackground(Color.CYAN);
        pan11.setBackground(Color.CYAN);

        b1.addActionListener(this);
        b2.addActionListener(this);
        ok.addActionListener(this);
        
        pan1.setOpaque(false);
        pan11.setOpaque(false);
        pan2.setOpaque(false);
        pan22.setOpaque(false);
        l1.setOpaque(false);
        hello.setOpaque(false);
        panOk.setOpaque(false);
        

        f1.setSize(500, 500);
        pan_principal.setLayout(new GridLayout(7,1 , 50 , 50));
        
        hello.add(new JLabel("Bienvenue dans votre jeu !"));
        hello.add(new JLabel("  donner vos noms s'il vous plait"));
        
        
        pan1.add(vide1);
        pan1.add(l1);
        pan1.add(nom1);
        pan1.add(vide11) ;
        pan11.add(b1);

        pan2.add(vide2);
        pan2.add(l2);
        pan2.add(nom2);
        pan2.add(vide22);
        pan22.add(b2);
        panOk.add(ok) ;

        pan_principal.add(panVide) ;
        pan_principal.add(hello) ;
        pan_principal.add(pan1) ;
        pan_principal.add(pan11) ;
        pan_principal.add(pan2 );
        pan_principal.add(pan22);
        pan_principal.add(panOk);
        
        f1.setContentPane(pan_principal);
       // pan.setVisible(false);

        f1.setVisible(true);
    }
        

   // @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){ 
            j1.setName(nom1.getText()) ;
            nom1.setText("");
        }
        if(e.getSource()==b2){
            j2.setName(nom2.getText()) ;
            nom2.setText("");
            
        }
        if(e.getSource()==ok){
             pan_principal.setVisible(false);
             Interface_qst Int = new Interface_qst(j1 ,j2);
             panel_qst = Int.getPanel() ;
             f1.setContentPane(panel_qst);}

    }
    //  public static joueur getJoueur(int num) {
      //  if (num == 1) {
         //   return (j1);
        }
       // else if (num ==2) {
        //    return (j2);
        //}
    
    

    
