import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {

    JLabel piclabel;
    JLabel title;
    ImageIcon img=new ImageIcon("images/binar.jpg");

    TextField bina=new TextField();
    TextField hexa=new TextField();
    TextField deci=new TextField();
    JButton binar;
    JButton decim;
    JButton hexad;

    JButton conver,clear,exite;
    int countbin=0;
    int counthex=0;
    int countdec=0;




    MyFrame(){


        bina.setBounds(520,150,200,25);
        bina.setEnabled(false);
        bina.setText("");
        hexa.setBounds(520,220,200,25);
        hexa.setEnabled(false);
        hexa.setText("");
        deci.setBounds(520,290,200,25);
        deci.setEnabled(false);
        deci.setText("");

        binar=new JButton();
        decim=new JButton();
        hexad=new JButton();

        conver=new JButton();
        clear=new JButton();
        exite=new JButton();

        conver.setBounds(30,400,150,27);
        conver.setText("CONVERT");
        clear.setBounds(200,400,150,27);
        clear.setText("CLEAR");
        exite.setBounds(370,400,150,27);
        exite.setText("EXIT");





        clear.addActionListener(this);
        exite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==exite)

                {
                    int op= JOptionPane.showInternalConfirmDialog(null,"Are you sure you want to exit?","Numbering System Converter",JOptionPane.YES_NO_OPTION);
                    if (op==0)
                    {
                        System.exit(0);

                    }
                }

            }
        });
        conver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==conver){
                   if(countbin !=0 ){
                            String binaryval=bina.getText();
                            int numb = Integer.parseInt(binaryval, 2);
                            String hexadec=Integer.toHexString(numb);
                            hexa.setText(hexadec);
                            deci.setText(Integer.toString(numb));



                    }

                      else if (counthex!=0 ){
                        int numb=Integer.parseInt(hexa.getText(),16);
                        String binary=Integer.toBinaryString(numb);
                        bina.setText(binary);
                        deci.setText(Integer.toString(numb));

                    }
                     else if (countdec!=0) {
                        int numb=Integer.parseInt(deci.getText());
                        String binary=Integer.toBinaryString(numb);
                        String hexad=Integer.toHexString(numb);
                        bina.setText(binary);
                        hexa.setText(hexad);


                    }
                }

            }
        });

        bina.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {

                    String text = bina.getText();
                    bina.setBackground(Color.WHITE);
                    conver.setEnabled(true);
                    for (int i = 0; i < text.length(); i++) {
                        int tempB = text.charAt(i);
                        if (tempB == '0' || tempB == '1' || tempB==' ') {
                            continue;
                        } else {
                            bina.setBackground(Color.RED);
                            conver.setEnabled(false);
                        }
                    }

            }
        });
        hexa.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = hexa.getText();
                hexa.setBackground(Color.WHITE);
                conver.setEnabled(true);
                for (int i = 0; i < text.length(); i++) {
                    int tempB = text.charAt(i);
                    if (tempB == '0' || tempB == '1' || tempB=='2' || tempB=='3' || tempB=='4' || tempB=='5' || tempB=='6' || tempB=='7' || tempB=='8' || tempB=='9' || tempB=='A'
                            || tempB=='B' || tempB=='C' || tempB=='D' || tempB=='E' || tempB=='F' || tempB=='a' || tempB=='b' || tempB=='c' || tempB=='d' || tempB=='e' || tempB=='f') {
                        continue;
                    } else {
                        hexa.setBackground(Color.RED);
                        conver.setEnabled(false);
                    }
                }


            }
        });
        deci.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = deci.getText();
                deci.setBackground(Color.WHITE);
                conver.setEnabled(true);
                for (int i = 0; i < text.length(); i++) {
                    int tempB = text.charAt(i);
                    if (tempB == '0' || tempB == '1' || tempB=='2' || tempB=='3' || tempB=='4' || tempB=='5' || tempB=='6' || tempB=='7' || tempB=='8' || tempB=='9' ) {
                        continue;
                    } else {
                        deci.setBackground(Color.RED);
                        conver.setEnabled(false);
                    }
                }

            }
        });















        binar.setBounds(330,150,150,27);
        binar.setText("BINARY");
        decim.setBounds(330,290,150,27);
        decim.setText("DECIMAL");
        hexad.setBounds(330,220,150,27);
        hexad.setText("HEXADECIMAL");

        binar.addActionListener(this);
        decim.addActionListener(this);
        hexad.addActionListener(this);














        title=new JLabel("NUMBER CONVERTER BY ARIA");
        title.setBounds(250,0,600,100);
        title.setFont(new Font("MV Boli",Font.BOLD,30));


        piclabel=new JLabel();
        piclabel.setIcon(img);
        piclabel.setBounds(30,100,238,250);



        this.add(bina);
        this.add(hexa);
        this.add(deci);
        this.add(binar);
        this.add(decim);
        this.add(hexad);
        this.add(conver);
        this.add(clear);
        this.add(exite);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent e) {
               int op= JOptionPane.showInternalConfirmDialog(null,"Are you sure you want to exit?","Numbering System Converter",JOptionPane.YES_NO_OPTION);
                if (op==0)
                {
                    System.exit(0);

                }

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.setLocationRelativeTo(null);
        this.setTitle("Numbering System Converter");
        this.add(piclabel);
        this.add(title);
        this.setBackground(Color.WHITE);
        this.setSize(800,500);
        this.setLayout(null);
        this.setVisible(true);









    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==binar)
        {
            bina.setEnabled(true);
            countbin++;
            decim.setEnabled(false);
            hexad.setEnabled(false);

        }
        else if(e.getSource()==decim )
        {
            deci.setEnabled(true);
            countdec++;
            binar.setEnabled(false);
            hexad.setEnabled(false);

        }
        else if(e.getSource()==hexad)
        {
            hexa.setEnabled(true);
            counthex++;
            decim.setEnabled(false);
            binar.setEnabled(false);

        }

        if(e.getSource()== clear){

            bina.setText("");
            binar.setEnabled(true);
            bina.setEnabled(false);
            deci.setText("");
            decim.setEnabled(true);
            deci.setEnabled(false);
            hexa.setText("");
            hexa.setEnabled(false);
            hexad.setEnabled(true);
            counthex=0;
            countdec=0;
            countbin=0;

        }


    }


}
