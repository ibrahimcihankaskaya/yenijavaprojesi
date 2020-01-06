package tr.com.mipek.fe;

import com.toedter.calendar.JDateChooser;
import tr.com.mipek.dal.KategoriDAL;
import tr.com.mipek.dal.UrunlerDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.KategoriContract;
import tr.com.mipek.types.PersonelContract;
import tr.com.mipek.types.UrunlerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class UrunEkleFE extends JDialog implements FeInterfaces {
    public UrunEkleFE(){
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel=initPanel();
        add(panel);

        setTitle("Ürün Ekleyin");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


    }

    @Override
    public JPanel initPanel() {
        JPanel panel= new JPanel(new GridLayout(5,2));
        JLabel adiLabel= new JLabel("Ürün Adı",JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField= new JTextField(10);
        panel.add(adiField);
        JLabel KategoriLabel= new JLabel("Kategori Seç",JLabel.RIGHT);
        panel.add(KategoriLabel);
        JComboBox KategoriBox= new JComboBox(new KategoriDAL().GetAllParentId().toArray());
        panel.add(KategoriBox);
        JLabel fiyatLabel=new JLabel("Fiyat Gir",JLabel.RIGHT);
        panel.add(fiyatLabel);
        JTextField fiyatField=new JTextField(10);
        panel.add(fiyatField);
        JLabel urunTarih= new JLabel("Tarih",JLabel.RIGHT);
        panel.add(urunTarih);
        JDateChooser urunTarihi= new JDateChooser();
        panel.add(urunTarihi);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrunlerContract contract= new UrunlerContract();
                KategoriContract casContract=(KategoriContract) KategoriBox.getSelectedItem();

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String date=format.format(urunTarihi.getDate());

                contract.setAdi(adiField.getText());
                contract.setKategoriId(casContract.getId());
                contract.setTarih(date.toString());
                contract.setFiyat(Float.parseFloat(fiyatField.getText()));
                new UrunlerDAL().Insert(contract);
                JOptionPane.showMessageDialog(null,contract.getAdi()+" adlı ürün eklendi");
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
