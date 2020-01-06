package tr.com.mipek.fe;

import tr.com.mipek.dal.KategoriDAL;
import tr.com.mipek.interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KategoriDuzenleFE extends JDialog implements FeInterfaces {
    public KategoriDuzenleFE(){
        initPencere();

    }


    @Override
    public void initPencere() {
        JPanel panel=initPanel();
        add(panel);
        panel.setBorder(BorderFactory.createTitledBorder("Kategori Düzenle"));

        setTitle("Kategori Düzenle");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel=new JPanel(new BorderLayout());
        JPanel ustpanel= new JPanel(new GridLayout(3,2));
        JLabel kategoriAdiLabel= new JLabel("Kategori Adı",JLabel.RIGHT);
        ustpanel.add(kategoriAdiLabel);
        JTextField kategoriAdiField= new JTextField(10);
        ustpanel.add(kategoriAdiField);
        JLabel ustkategoriLabel=new JLabel("Üst Kategorisi: ",JLabel.RIGHT);
        ustpanel.add(ustkategoriLabel);
        JComboBox ustkategoriBox= new JComboBox(new KategoriDAL().GetAllParentId().toArray());
        ustpanel.add(ustkategoriBox);
        JList kategoriList= new JList();
        kategoriList.setListData(new KategoriDAL().GetAll().toArray());
        JScrollPane pane= new JScrollPane(kategoriList);
        panel.add(ustpanel,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.CENTER);

        kategoriList.setSelectedIndex(0);
        kategoriAdiField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                kategoriList.setListData(new KategoriDAL().GetAraKategori(kategoriAdiField.getText()).toArray());
                kategoriList.setSelectedIndex(0);

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
