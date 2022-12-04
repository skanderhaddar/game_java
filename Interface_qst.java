import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Interface_qst implements ActionListener {
    ArrayList<String> questions, reponses, les_reponse;
    HashMap<String, String> M1;
    Button repButton;
    JLabel qst_label, pre, scorLabel;
    JPanel principal_pan, pre_joueur, qst_pre, scorPanel;
    JTextField reponsTextField;
    joueur j1, j2, j_actuelle;
    Interface Interface;
    joueur[] J;
    joueur j11 , j22 ;
    int i, randomNum;
    String reponse, qst;
    JPanel pan_final;
    JLabel l1, scorLabel1, l5;
    Button exit, getscore;
    Interface_qst Int;

    public Interface_qst(joueur j1, joueur j2) {
        // Interface = new Interface() ;
        pan_final = new JPanel();
        l5 = new JLabel();
        scorLabel1 = new JLabel();
        exit = new Button();
        getscore = new Button();
        J = new joueur[2];
        J[0] = j1;
        J[1] = j2;
        j11 = j1 ;
        j22 = j2 ;
        j1.setScore(0);
        j2.setScore(0);
        i = 0;
        pre = new JLabel();
        pre.setText(J[i].getName());

        M1 = new HashMap<>();
        try {
            readFile();

        } catch (Exception e) {
            // TODO: handle exception
        }
        // initialisation des panels //

        principal_pan = new JPanel();
        pre_joueur = new JPanel();
        qst_pre = new JPanel();
        scorPanel = new JPanel();

        // initialisation des buttons//
        repButton = new Button("repondre ");

        // initialisation de textfields//
        reponsTextField = new JTextField(40);

        // initialisation de label//
        scorLabel = new JLabel();
        questions = new ArrayList(M1.keySet());
        reponses = new ArrayList<>(M1.values());
        randomNum = ThreadLocalRandom.current().nextInt(0, questions.size() + 1);
        qst = questions.get(randomNum);
        questions.remove(randomNum);
        qst_label = new JLabel(qst);

        qst_pre.setBackground(Color.CYAN);

        pre_joueur.setOpaque(false);
        qst_label.setOpaque(false);
        scorPanel.setOpaque(false);
        qst_pre.setOpaque(false);
        principal_pan.setLayout(new GridLayout(7, 1, 50, 50));
        principal_pan.setBackground(Color.CYAN);

        pan_final = new JPanel();
        l5 = new JLabel();
        scorLabel1 = new JLabel();
        exit = new Button();
        pan_final.setBackground(Color.CYAN);

        pan_final.add(l5);
        pan_final.add(scorLabel1);
        pan_final.setBackground(Color.CYAN);

        // java 8
        // System.out.println(Keys.stream().findFirst().get());
        pre_joueur.add(pre);
        qst_pre.add(qst_label);
        qst_pre.add(reponsTextField);
        qst_pre.add(repButton);

        principal_pan.add(pre_joueur);
        principal_pan.add(qst_pre);
        scorLabel.setText(String.valueOf(J[i].getName()) + "votre score est = " + String.valueOf(J[i].getScore()));
        scorPanel.add(scorLabel);
        principal_pan.add(scorPanel);
        principal_pan.add(getscore);

        scorLabel.setText(String.valueOf(J[i].getName()) + "votre score est = " + String.valueOf(J[i].getScore()));
        System.out.println(String.valueOf(J[i].getName()) + " " + String.valueOf(J[i].getScore()));

        repButton.addActionListener(this);
        getscore.addActionListener(this);
        j11.setScore(j11.getScore() + 1);
        

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive

    }

    // questions = new ArrayList(M1.Keys()) ;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == repButton) {
            // if (questions.size()==1)
            // {
            // l5.setText("les questions sont finis, aucun joueur a gagné") ;
            // scorLabel1.setText("le score de "+ String.valueOf(J[0].getName()) + " = " +
            // String.valueOf(J[1].getScore())) ;
            // }

            // if (J[0].getScore() == 5 )
            // {
            // l5.setText("le joueur " + String.valueOf(J[1].getName()) +" est gagnant ") ;
            // scorLabel1.setText("le score de "+ String.valueOf(J[0].getName()) + " = " +
            // String.valueOf(J[0].getScore())) ;
            // }

            // if (J[1].getScore() == 5 )
            // {
            // l5.setText("le joueur " + String.valueOf(j2.getName()) +" est gagnant ") ;
            // scorLabel1.setText("le score de "+ String.valueOf(J[1].getName()) + " = " +
            // String.valueOf(J[1].getScore())) ;
            // }

            // randomNum = ThreadLocalRandom.current().nextInt(0, questions.size() + 1);
            // les_reponse = new ArrayList<>();
            // les_reponse.add(qst);
            // qst = questions.get(randomNum);
            // qst_label.setText(qst);
            // questions.remove(randomNum);
            // if (i == 0) {
            // if (reponse.equals(M1.get(les_reponse.get(les_reponse.size() - 1)))) {
            // J[0].setScore(J[0].getScore() + 1);
            // }
            // }

            // if (i == 1) {
            // if (reponse.equals(M1.get(les_reponse.get(les_reponse.size() - 1)))) {
            // J[1].setScore(J[1].getScore() + 1);
            // }
            // }

            // reponsTextField.setText("");
            // scorLabel.setText(String.valueOf(J[i].getName()) + "votre score est = " +
            // String.valueOf(J[i].getScore()));
            // System.out.println(String.valueOf(J[i].getName()) + " " +
            // String.valueOf(J[i].getScore()));
            // pre.setText(J[i].getName());
            // if (gagner() || qst_epuise()){
            // principal_pan.setLayout(new GridLayout(1, 1));
            // principal_pan.remove(scorPanel);
            // principal_pan.remove(qst_label);
            // principal_pan.remove(qst_pre);
            // principal_pan.add(pan_final);
            // }

            reponse = reponsTextField.getText();
            if (reponse.equals(M1.get(qst))) {
                J[i].setScore(J[i].getScore() + 1);
                System.out.println("true" + J[i].getName());
                System.out.println(reponse + "////" + M1.get(qst));
            } else {
                System.out.println(reponse + "////" + M1.get(qst));
            }
            reponse = " ";
            reponsTextField.setText("");
            randomNum = ThreadLocalRandom.current().nextInt(0, questions.size() + 1);
            qst = questions.get(randomNum);
            qst_label.setText(qst);
            questions.remove(randomNum);
            i = 1 - i;
            pre.setText(J[i].getName());

        }

        if (e.getSource() == getscore) {
            System.out.println(String.valueOf(j11.getName()) + " " + String.valueOf(j11.getScore()));
            System.out.println(String.valueOf(j22.getName()) + " " + String.valueOf(j22.getScore()));

        }

    }

    public boolean gagner() {
        if (J[0].getScore() == 10 || J[1].getScore() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean qst_epuise() {
        if (questions.size() == 0)
            return (true);
        else {
            return false;
        }
    }

    public void readFile() throws ParserConfigurationException, SAXException, IOException {
        File file = new File("Question.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("item");
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                M1.put(eElement.getElementsByTagName("quest").item(0).getTextContent(),
                        eElement.getElementsByTagName("answer").item(0).getTextContent());
            }

        }
    }

    public JPanel getPanel() {
        return (principal_pan);
    }

}
