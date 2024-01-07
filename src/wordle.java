import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class wordle extends JFrame implements ActionListener {
    JPanel p1,main;
   static ArrayList<JTextField> tf = new ArrayList<>();
   boolean[] flag=new boolean[wordle_logic.wordSize];
    JLabel chances;
    int chance = 5;

    JButton check,clear;

    Font f1=new Font("Tahome", Font.BOLD,20);
    wordle()
    {
        setSize(500,500);


        main=new JPanel();
        setContentPane(main);
        main.setBackground(Color.decode("#1a1918"));



        p1= new JPanel();
        p1.setBounds(100,80,300,60);
        p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
        add(p1);
        generateTxtField();

        chances= new JLabel("Chances Remaining: "+ chance);
        chances.setBounds(100,250,300,50);
        chances.setForeground(Color.WHITE);
        chances.setFont(f1);
        chances.setHorizontalAlignment(JLabel.CENTER);
        add(chances);


        check = new JButton("Check");
        check.setBounds(80,350,150,50);
        check.setFont(f1);
        check.addActionListener(this);
        add(check);


        clear = new JButton("Clear");
        clear.setBounds(300,350,150,50);
        clear.setFont(f1);
        clear.addActionListener(this);
        add(clear);

        setTitle("WORDLE GAME");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void generateTxtField()
    {

        for (int i = 0; i< wordle_logic.wordSize; i++)
        {
            tf.add(new JTextField());
            tf.get(i).setFont(new Font("Tahoma",Font.BOLD, 32));
            tf.get(i).setBackground(Color.decode("#3b3a39"));
            tf.get(i).setForeground(Color.WHITE);
            tf.get(i).setHorizontalAlignment(JTextField.CENTER);
        }
        for (int i = 0; i< wordle_logic.wordSize; i++){
            p1.add(tf.get(i));
        }
    }


    public void actionPerformed(ActionEvent ae)
    {
         UIManager.put("OptionPane.messageFont",f1);
        if(ae.getSource()==check)
        {
            if (chance>1)
            {
                for(int i=0; i<wordle_logic.wordSize; i++)
                {
                    if(wordle_logic.matchExactLetter(i))
                    {

                        tf.get(i).setBackground(Color.decode("#2fa84f"));
                        flag[i]=true;
                    }
                    else if(wordle_logic.containsLetter(i))
                    {
                        tf.get(i).setBackground(Color.YELLOW);
                    }
                }

                for (int i=0; i<wordle_logic.wordSize; i++)
                {
                    if(flag[i]==false)
                    {
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Winner Winner Chicken Dinner");
                        System.exit(0);
                    }
                }
                chance--;
                chances.setText("Chances Remaining: "+chance);
            }
            else {
                JOptionPane.showMessageDialog(null,"You couldn't make it NOOB");
                System.exit(0);
            }

        }
        if(ae.getSource()==clear)
        {
             for(int i=0; i<wordle_logic.wordSize; i++)
             {
                 tf.get(i).setText("");
                 tf.get(i).setBackground(Color.decode("#3b3a39"));
                 


             }
        }
    }


    public static void main(String[] args) {

        new wordle_logic();
        new wordle();
    }
}

