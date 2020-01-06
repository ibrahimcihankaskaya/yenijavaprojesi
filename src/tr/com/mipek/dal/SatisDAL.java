package tr.com.mipek.dal;

import tr.com.mipek.complex.types.SatisContractComplex;
import tr.com.mipek.core.ObjectHelper;
import tr.com.mipek.interfaces.DALInterfaces;
import tr.com.mipek.types.SatisContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SatisDAL extends ObjectHelper implements DALInterfaces<SatisContract>{

    @Override
    public void Insert(SatisContract entity) {
        Connection connection= getConnection();

        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("insert into satis (urunid,musteriid,tarih,adet,personelid) values ("+entity.getUrunId()+","+entity.getMusteriId()+",'"+entity.getTarih()+"',"+entity.getAdet()+","+entity.getPersonelId()+")");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SatisContractComplex> GetAllSatis(){

        List<SatisContractComplex> dataContract=new ArrayList<SatisContractComplex>();
        Connection connection=getConnection();
        SatisContractComplex contract;

        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select satis.id, personel2.adisoyadi, musteri.adi,  urunler.adi, satıs.adet, satis.tarih from satıs left joın musterı on satıs.musterııd=musterı.ıd left joın urunler on satıs.urunıd=urunler.ıd left joın personel2 on satıs.personelıd=personel2.ıd order by satıs.ıd desc");
            while (resultSet.next()){
                contract = new SatisContractComplex();
                contract.setId(resultSet.getInt("id"));
                contract.setPersonelAdi(resultSet.getString("Adisoyadi"));
                contract.setMusteriAdi(resultSet.getString("Adi"));
                contract.setUrunAdi(resultSet.getString("Adi"));
                contract.setAdet(resultSet.getInt("adet"));
                contract.setTarih(resultSet.getString("tarih"));
                dataContract.add(contract);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataContract;

    }

    @Override
    public List<SatisContract> GetAll() {
        return null;
    }

    @Override
    public void Delete(SatisContract entity) {

    }

    @Override
    public void Update(SatisContract entity) {

    }

    @Override
    public List<SatisContract> GetById(int id) {
        return null;
    }
}
