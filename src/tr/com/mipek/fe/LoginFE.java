package tr.com.mipek.fe;

import tr.com.mipek.dal.AccountDAL;
import tr.com.mipek.dal.PersonelDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.PersonelContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFE extends JDialog implements FeInterfaces {
    public static JComboBox emailBox;
    public LoginFE(){
        initPencere();

    }

    @Override
    public void initPencere() {

        JPanel panel= initPanel();
        add(panel);
        panel.setBorder(BorderFactory.createTitledBorder("Lütfen Giriş Bilgilerinizi Girin"));
        setTitle("Lütfen Giriş Yapınız");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3,2));
        JLabel emailLabel= new JLabel("Email",JLabel.RIGHT);
        panel.add(emailLabel);
        emailBox= new JComboBox(new PersonelDAL().GetAll().toArray());
        panel.add(emailBox);
        JLabel passwordLabel= new JLabel("Şifreniz:",JLabel.RIGHT);
        panel.add(passwordLabel);
        JPasswordField passwordField= new JPasswordField(15);
        panel.add(passwordField);

        JButton loginButon= new JButton("Giriş Yap");
        panel.add(loginButon);
        JButton iptalButon= new JButton("İptal");
        panel.add(iptalButon);

        loginButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
                String sifre=passwordField.getText();
                if (new AccountDAL().GetPersonelIDveSifre(contract.getId(),sifre).getId()!=0){

                    new AnaPencereFE();
                    dispose();



                }else {
                    JOptionPane.showMessageDialog(null,"Giriş Başarısız");
                }

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
