package tr.com.mipek.fe;

import tr.com.mipek.dal.KategoriDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.KategoriContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KategoriEkleFE extends JDialog implements FeInterfaces {
    public KategoriEkleFE(){
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel=initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
        add(panel);

        setTitle("Kategori Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel=new JPanel(new GridLayout(4,2));
        JLabel adiLabel=new JLabel("Kategori Ekle",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField =new JTextField(10);
        panel.add(adiField);
        JLabel KategoriLabel=new JLabel("Kategori Seç", JLabel.RIGHT);
        panel.add(KategoriLabel);
        JComboBox KategoriBox =new JComboBox(new KategoriDAL().GetAllParentId().toArray());
        panel.add(KategoriBox);
        KategoriBox.insertItemAt("--Kategori Seçiniz--",0);
        KategoriBox.setSelectedIndex(0);

        JButton kaydetButton=new JButton("Kaydet");
        panel.add(kaydetButton);
        JButton iptalButton =new JButton("İptal");
        panel.add(iptalButton);
        JButton silButton =new JButton("Sil");
        panel.add(silButton);

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KategoriContract contract = new KategoriContract();
                if (KategoriBox.getSelectedIndex() != 0) {
                    KategoriContract cascontract = (KategoriContract) KategoriBox.getSelectedItem();
                    contract.setAdi(adiField.getText());
                    contract.setParentId(cascontract.getId());
                    new KategoriDAL().Insert(contract);
                    JOptionPane.showMessageDialog(null, contract.getAdi() + " adlı Kategori Eklenmiştir.");
                } else {
                    contract.setAdi(adiField.getText());
                    contract.setParentId(KategoriBox.getSelectedIndex());
                    new KategoriDAL().Insert(contract);
                    JOptionPane.showMessageDialog(null, contract.getAdi() + " adlı Kategori Eklenmiştir.");
                }
            }
        });
        iptalButton.addActionListener(new ActionListener() {
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
