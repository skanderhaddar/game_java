
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Button;

public class Final implements ActionListener {
    JPanel pan_final ; 
    JLabel l5 , scorLabel ; 
    Button exit ;
    joueur j1 , j2 ;
    Interface_qst Int ; 
public Final(joueur j1 , joueur j2) {
    pan_final = new JPanel();
    l5 = new JLabel() ; 
    scorLabel = new JLabel() ;
    exit = new Button(); 
    Int = new Interface_qst(j1 ,j2) ;
    pan_final.setBackground(Color.CYAN) ;
    if (Int.qst_epuise())
    {
    l5.setText("les questions sont finis, aucun joueur a gagné") ;
    scorLabel.setText("le score de "+ String.valueOf(j1.getName()) + " = " + String.valueOf(j1.getScore())) ;
    }

    if (j1.getScore() == 10 )
    {
        l5.setText("le joueur " + String.valueOf(j1.getName()) +" est gagnant ") ;
        scorLabel.setText("le score de "+ String.valueOf(j1.getName()) + " = " + String.valueOf(j1.getScore())) ;
    }
    
    if (j2.getScore() == 10 )
    {
        l5.setText("le joueur " + String.valueOf(j2.getName()) +" est gagnant ") ;
        scorLabel.setText("le score de "+ String.valueOf(j1.getName()) + " = " + String.valueOf(j1.getScore())) ;
    }

    pan_final.add(l5);
    pan_final.add(scorLabel);


    
}
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == exit) {
        System.exit(0);
    }}
public JPanel getPanel(){
    return( pan_final );


}}
