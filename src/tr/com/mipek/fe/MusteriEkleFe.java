package tr.com.mipek.fe;

import tr.com.mipek.dal.MusteriDAL;
import tr.com.mipek.dal.UrunlerDAL;
import tr.com.mipek.interfaces.FeInterfaces;
import tr.com.mipek.types.KategoriContract;
import tr.com.mipek.types.MusteriContract;
import tr.com.mipek.types.UrunlerContract;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class MusteriEkleFe extends JDialog implements FeInterfaces {
    public MusteriEkleFe() {
        initPencere();

    }

    @Override
    public void initPencere() {

        JPanel panel=initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Müşteri Ekle"));
        add(panel);
        setTitle("Müşteri Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

        @Override
    public JPanel initPanel() {
        JPanel panel= new JPanel(new BorderLayout());
        JPanel FieldPanel= new JPanel(new GridLayout(4,2));
        JPanel butonpanel= new JPanel(new GridLayout(1,2));

        JLabel adiLabel=new JLabel("Adı Soyadı",JLabel.RIGHT);
        FieldPanel.add(adiLabel);

        JTextField adiField= new JTextField(20);
        FieldPanel.add(adiField);

        JLabel telefonLabel=new JLabel("Telefon No",JLabel.RIGHT);
        FieldPanel.add(telefonLabel);

        JTextField telefonField= new JTextField(20);
        FieldPanel.add(telefonField);

        JLabel adresLabel = new JLabel("Adres");
        FieldPanel.add(adresLabel);
        JTextArea adresArea= new JTextArea(7,1);
        JScrollPane pane = new JScrollPane(adresArea);
        pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));

        JButton kaydetButon = new JButton("Kaydet");
        butonpanel.add(kaydetButon);
        kaydetButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusteriContract contract= new MusteriContract();
                contract.setAdiSoyadi(adiField.getText());
                contract.setTelefon(telefonField.getText());
                contract.setAdres(adresArea.getText());

                new MusteriDAL().Insert(contract);
                JOptionPane.showMessageDialog(null,contract.getAdiSoyadi()+" adlı müşteri eklendi");

            }
        });
        JButton iptalButon = new JButton("İptal");
        butonpanel.add(iptalButon);
        iptalButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        panel.add(FieldPanel,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.CENTER);
        panel.add(butonpanel,BorderLayout.SOUTH) ;



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
