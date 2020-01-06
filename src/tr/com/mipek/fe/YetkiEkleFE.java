package tr.com.mipek.fe;

import tr.com.mipek.dal.YetkilerDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YetkiEkleFE extends JDialog implements FeInterfaces {


    public YetkiEkleFE (){
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
        add(panel);
        setTitle("Yetki Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(2,2));
        JLabel adiLabel= new JLabel("Yetki Adı:",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField= new JTextField(10);
        panel.add(adiField);

        JButton kaydetButon= new JButton("Kaydet");
        panel.add(kaydetButon);

        JButton iptalButon = new JButton("İptal");
        panel.add(iptalButon);

        kaydetButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YetkilerContract contract=new YetkilerContract();
                contract.setAdi(adiField.getText());
                new YetkilerDAL().Insert(contract);
                JOptionPane.showMessageDialog(null, contract.getAdi()+" adlı yetki eklenmiştir.");

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
