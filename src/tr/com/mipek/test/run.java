package tr.com.mipek.test;

import tr.com.mipek.dal.UrunlerDAL;
import tr.com.mipek.fe.AnaPencereFE;
import tr.com.mipek.fe.LoginFE;

import javax.swing.*;

public class run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new AnaPencereFE();
                new LoginFE();
                //new UrunlerDAL().GetAll();

            }
        });
    }
}

