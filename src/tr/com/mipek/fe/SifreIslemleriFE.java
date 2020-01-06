package tr.com.mipek.fe;

import tr.com.mipek.dal.AccountDAL;
import tr.com.mipek.dal.PersonelDAL;
import tr.com.mipek.dal.YetkilerDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.AccountContract;
import tr.com.mipek.types.PersonelContract;
import tr.com.mipek.types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifreIslemleriFE extends JDialog implements FeInterfaces{
    public SifreIslemleriFE() {
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Şifre Belirle İşlemleri"));
        add(panel);
        setTitle("Şifre Belirleme İşlemleri");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {

        JPanel panel= new JPanel(new GridLayout(5,2));
        JLabel personelLabel= new JLabel("Personel Seç",JLabel.RIGHT);
        panel.add(personelLabel);
        JComboBox personelBox= new JComboBox(new PersonelDAL().GetAll().toArray());
        panel.add(personelBox);
        JLabel yetkiLabel= new JLabel("Yetki Seç",JLabel.RIGHT);
        panel.add(yetkiLabel);
        JComboBox yetkiBox =new JComboBox(new YetkilerDAL().GetAll().toArray());
        panel.add(yetkiBox);
        JLabel password1Label= new JLabel("Şifre Belirle");
        panel.add(password1Label);
        JPasswordField password1Field= new JPasswordField(10);
        panel.add(password1Field);
        JLabel passtekrarLabel = new JLabel("Şifre Tekrar");
        panel.add(passtekrarLabel);
        JPasswordField passtekrar= new JPasswordField(10);
        panel.add(passtekrar);
        JButton kaydetButon = new JButton("Kaydet");
        panel.add(kaydetButon);
        JButton iptalButon= new JButton("İptal");
        panel.add(iptalButon);

        kaydetButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountContract contract= new AccountContract();
                YetkilerContract yContract=(YetkilerContract) yetkiBox.getSelectedItem();
                PersonelContract pContract=(PersonelContract) personelBox.getSelectedItem();

                if (password1Field.getText().equals(passtekrar.getText()))
                {
                    contract.setYetkiId(yContract.getId());
                    contract.setPersonelId(pContract.getId());
                    contract.setSifre(password1Field.getText());
                    new AccountDAL().Insert(contract);
                    JOptionPane.showMessageDialog(null,"Şifre Kaydedildi");
                }
                    else
                        JOptionPane.showMessageDialog(null,"Şifreler Uyuşmuyor Tekrar Kontrol Ediniz");



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


