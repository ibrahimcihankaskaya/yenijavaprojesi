package tr.com.mipek.dal;

import tr.com.mipek.core.ObjectHelper;
import tr.com.mipek.interfaces.DALInterfaces;
import tr.com.mipek.types.KategoriContract;
import tr.com.mipek.types.PersonelContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonelDAL extends ObjectHelper implements DALInterfaces<PersonelContract> {
    @Override
    public void Insert(PersonelContract entity) {
        Connection connection=getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("insert into  PERSONEL2 ( adiSoyadi,email) values ('"+entity.getAdiSoyadi()+"','"+entity.getEmail()+"')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PersonelContract> GetAll() {
        List<PersonelContract> datacontract =new ArrayList<PersonelContract>();
        Connection connection=getConnection();
        PersonelContract contract;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Personel2");
            while (resultSet.next()){
                contract= new PersonelContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdiSoyadi(resultSet.getString("Adisoyadi"));
                contract.setEmail(resultSet.getString("Email"));

                datacontract.add(contract);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return datacontract;
    }

    @Override
    public void Delete(PersonelContract entity) {

    }

    @Override
    public void Update(PersonelContract entity) {

    }

    @Override
    public List<PersonelContract> GetById(int id) {
        return null;
    }
}


