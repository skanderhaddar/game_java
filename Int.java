import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Int  extends JFrame{
    JPanel pan ;
    public Int() {
        pan = new JPanel() ; 
        pan.setBackground(Color.RED);
        this.setContentPane(pan);
        this.setVisible(true);
    }
}
