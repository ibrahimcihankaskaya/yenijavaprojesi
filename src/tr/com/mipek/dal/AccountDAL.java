package tr.com.mipek.dal;

import tr.com.mipek.core.ObjectHelper;
import tr.com.mipek.interfaces.DALInterfaces;
import tr.com.mipek.types.AccountContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AccountDAL extends ObjectHelper implements DALInterfaces <AccountContract> {

    @Override
    public void Insert(AccountContract entity) {

        Connection connection=getConnection();

        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("insert into Account (personelid,yetkiid ,sifre) values ("+entity.getPersonelId()+","+entity.getYetkiId()+","+entity.getSifre()+")" );
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public AccountContract GetPersonelIDveSifre (int PersonelId, String Sifre){

        AccountContract contract= new AccountContract();
        List<AccountContract> listele= new ArrayList<AccountContract>();
        Connection baglanti=getConnection();

        try {
            Statement sorgu= baglanti.createStatement();
            ResultSet rs= sorgu.executeQuery("select * from account where personelid="+PersonelId+" and sifre='"+Sifre+"'" );
            while (rs.next()){

                contract.setId(rs.getInt("ID"));
                contract.setPersonelId(rs.getInt("PERSONELID"));
                contract.setYetkiId(rs.getInt("YETKIID"));
                contract.setSifre(rs.getString("SIFRE"));

            }
            sorgu.close();
            baglanti.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contract ;
    }
    public AccountContract GetYetkiId (int PersonelId)
    {
        AccountContract contract= new AccountContract();
        List<AccountContract> listele= new ArrayList<AccountContract>();
        Connection baglanti=getConnection();

        try {
            Statement sorgu= baglanti.createStatement();
            ResultSet rs= sorgu.executeQuery("select * from account where personelid="+PersonelId+"" );
            while (rs.next())
            {
                contract.setId(rs.getInt("ID"));
                contract.setPersonelId(rs.getInt("PERSONELID"));
                contract.setYetkiId(rs.getInt("YETKIID"));
            }
            sorgu.close();
            baglanti.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contract ;
    }
    @Override
    public List<AccountContract> GetAll() {
        return null;
    }

    @Override
    public void Delete(AccountContract entity) {

    }

    @Override
    public void Update(AccountContract entity) {

    }

    @Override
    public List<AccountContract> GetById(int id) {
        return null;
    }
}
