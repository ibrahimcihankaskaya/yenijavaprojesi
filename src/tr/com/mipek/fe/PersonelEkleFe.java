package tr.com.mipek.fe;

import tr.com.mipek.dal.PersonelDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.PersonelContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonelEkleFe extends JDialog implements FeInterfaces {

    public PersonelEkleFe (){
    initPencere();
    }

    @Override
    public void initPencere() {

        setTitle("Personel Ekle");
        JPanel panel=initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle"));
        add(panel);
        pack();
        setVisible(true);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3,2));
        JLabel adiLabel= new JLabel("Adı Soyadı", JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField= new JTextField(15);
        panel.add(adiField);
        JLabel emailLabel= new JLabel("Email Girin",JLabel.RIGHT);
        panel.add(emailLabel);
        JTextField emailField=new JTextField(10);
        panel.add(emailField);
        JButton kaydetButon= new JButton("Kaydet");
        panel.add(kaydetButon);
        JButton iptalButon=new JButton("İptal");
        panel.add(iptalButon);

        kaydetButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PersonelContract contract= new PersonelContract();
                contract.setAdiSoyadi(adiField.getText());
                contract.setEmail(emailField.getText());
                new PersonelDAL().Insert(contract);
                JOptionPane.showMessageDialog(null,contract.getAdiSoyadi()+" adlı personel eklenmiştir.");


            }
        });
        iptalButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}
