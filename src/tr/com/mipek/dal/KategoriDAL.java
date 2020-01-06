package tr.com.mipek.dal;

import tr.com.mipek.core.ObjectHelper;
import tr.com.mipek.interfaces.DALInterfaces;
import tr.com.mipek.types.KategoriContract;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategoriDAL extends ObjectHelper implements DALInterfaces<KategoriContract> {


    @Override
    public void Insert( KategoriContract entity) {

        Connection connection=getConnection();

        try
        {
           Statement statement=connection.createStatement();
           statement.executeUpdate("insert into Kategori(Adi,ParentId) values ('"+entity.getAdi()+"',"+entity.getParentId()+")");
           statement.close();
           connection.close();

        }catch (Exception ex){

        }
    }

    @Override
    public List<KategoriContract> GetAll() {
        List<KategoriContract> datacontract =new ArrayList<KategoriContract>();
        Connection connection=getConnection();
        KategoriContract contract;

            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Kategori");
                while (resultSet.next()){
                    contract= new KategoriContract();
                    contract.setId(resultSet.getInt("Id"));
                    contract.setAdi(resultSet.getString("Adi"));
                    contract.setParentId(resultSet.getInt("ParentId"));
                    datacontract.add(contract);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        return datacontract;
    }

    public List<KategoriContract> GetAllParentId() {

        List<KategoriContract> datacontract =new ArrayList<KategoriContract>();
        Connection connection=getConnection();
        tr.com.mipek.types.KategoriContract contract;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =   statement.executeQuery("select * from Kategori where parentId=0");
            while (resultSet.next()){
                contract=new   tr.com.mipek.types.KategoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));
                datacontract.add((KategoriContract) contract);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return datacontract;
    }

    @Override
    public void Delete(KategoriContract entity) {

    }

    @Override
    public void Update(KategoriContract entity) {
        Connection connection=getConnection();

        try
        {
            Statement statement=connection.createStatement();
            statement.executeUpdate("UPDATE kategori SET adi='"+entity.getAdi()+"',parentid="+entity.getParentId()+" where id="+entity.getId()+"");
            statement.close();
            connection.close();

        }catch (Exception ex){

        }

    }

    @Override
    public List<KategoriContract> GetById(int id) {
        return null;
    }


    public List<KategoriContract> GetAraKategori(String katedoriAdi){

        List<KategoriContract> dataContract= new ArrayList<KategoriContract>();

        Connection connection=getConnection();

        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from kategori where adi like '"+"%"+katedoriAdi+"%"+"'");
            while (resultSet.next()){
                KategoriContract contract=new KategoriContract();
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("Parentid"));
                dataContract.add(contract);
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataContract;
    }
}
