package tr.com.mipek.dal;

import tr.com.mipek.core.ObjectHelper;
import tr.com.mipek.interfaces.DALInterfaces;
import tr.com.mipek.types.UrunlerContract;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UrunlerDAL extends ObjectHelper implements DALInterfaces <UrunlerContract> {

    public void Insert(UrunlerContract entity) {
        Connection connection=getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("insert into Urunler(Adi,KategoriId,Tarih,Fiyat) values ('"+entity.getAdi()+"',"+entity.getKategoriId()+",'"+entity.getTarih()+"',"+entity.getFiyat()+")");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UrunlerContract> GetAll() {

        List<UrunlerContract> datacontract =new ArrayList<UrunlerContract>();
        Connection connection=getConnection();
        UrunlerContract contract;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from urunler ");
            while (resultSet.next()){
                contract= new UrunlerContract();
                contract.setId(resultSet.getInt("id"));
                contract.setAdi(resultSet.getString("adi"));
                contract.setKategoriId(resultSet.getInt("kategoriId"));
                contract.setTarih(resultSet.getString("tarih"));
                contract.setFiyat(resultSet.getInt("fiyat"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datacontract;
    }

    @Override
    public void Delete(UrunlerContract entity) {

    }

    @Override
    public void Update(UrunlerContract entity) {

    }

    @Override
    public List<UrunlerContract> GetById(int id) {
        return null;
    }
}
