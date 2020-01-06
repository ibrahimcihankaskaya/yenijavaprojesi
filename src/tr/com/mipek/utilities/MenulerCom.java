package tr.com.mipek.utilities;

import tr.com.mipek.dal.AccountDAL;
import tr.com.mipek.fe.*;
import tr.com.mipek.types.PersonelContract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenulerCom {
    public static JMenuBar initBar() {

        JMenuBar bar = new JMenuBar();
// dosya menü
        JMenu dosyaMenu = new JMenu("Dosya");
        bar.add(dosyaMenu);
        JMenuItem cikisItem = new JMenuItem("Çıkış");
        dosyaMenu.add(cikisItem);
// ürünler menü
        JMenu UrunlerMenu = new JMenu("Ürünler");
        bar.add(UrunlerMenu);
        JMenuItem UrunEkleItem = new JMenuItem("Ürün Ekle");
        UrunlerMenu.add(UrunEkleItem);
        JMenuItem KategoriEkleItem = new JMenuItem("Kategori Ekle");
        UrunlerMenu.add(KategoriEkleItem);
        UrunlerMenu.addSeparator();
        JMenuItem UrunDuzenleItem = new JMenuItem("Ürün Düzenle");
        UrunlerMenu.add(UrunDuzenleItem);
        JMenuItem KategoriDuzenleItem = new JMenuItem("Kategori Düzenle");
        UrunlerMenu.add(KategoriDuzenleItem);
// personel menü
        JMenu personelMenu = new JMenu("Personel İşlemleri");
        bar.add(personelMenu);
        JMenuItem personelEkle = new JMenuItem("Personel Ekle");
        personelMenu.add(personelEkle);
        JMenuItem yetkiEkle = new JMenuItem("Yetki Ekle");
        personelMenu.add(yetkiEkle);
        JMenuItem sifreBelirle = new JMenuItem("Şifre Belirle");
        personelMenu.add(sifreBelirle);
        personelMenu.addSeparator();
        JMenuItem personelDuzenle = new JMenuItem("Personel Düzenle");
        personelMenu.add(personelDuzenle);
        JMenuItem yetkiDuzenle = new JMenuItem("Yetki Düzenle");
        personelMenu.add(yetkiDuzenle);
        JMenuItem sifreDuzenle = new JMenuItem("Şifre Düzenle");
        personelMenu.add(sifreDuzenle);
// Müşteri Menüsü
        JMenu MusterilerItem= new JMenu("Müşteri Menü");
        bar.add(MusterilerItem);
        JMenuItem MusteriEkle= new JMenuItem("Müşteri Ekle");
        MusterilerItem.add(MusteriEkle);
        JMenuItem sehirEkle= new JMenuItem("Şehir Ekle");
        MusterilerItem.add(sehirEkle);
        MusterilerItem.addSeparator();

        JMenuItem MusteriDuzenle= new JMenuItem("Müşteri Düzenle");
        MusterilerItem.add(MusteriDuzenle);
        JMenuItem sehirDuzenle= new JMenuItem("Şehir Düzenle");
        MusterilerItem.add(sehirDuzenle);
        PersonelContract contract= (PersonelContract) LoginFE.emailBox.getSelectedItem();


        if (new AccountDAL().GetYetkiId(contract.getId()).getYetkiId()==1){
             personelMenu.hide();
             UrunlerMenu.hide();

        }

        UrunEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new UrunEkleFE();

                    }
                });
            }
        });

        KategoriEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KategoriEkleFE();

            }
        });

        personelEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonelEkleFe();

            }
        });
        yetkiEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new YetkiEkleFE();

                    }
                });
            }
        });

        sifreBelirle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SifreIslemleriFE();

            }
        });

        MusteriEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MusteriEkleFe();

                    }
                });
            }
        });

        KategoriDuzenleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new KategoriDuzenleFE();
                    }
                });
            }
        });

        return bar;

    };
    };


