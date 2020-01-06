package tr.com.mipek.interfaces;

import tr.com.mipek.types.KategoriContract;

import java.util.List;

public interface DALInterfaces<KategoriContract>
{
    void Insert (KategoriContract entity);
    List<KategoriContract> GetAll();
    void Delete(KategoriContract entity);
    void Update(KategoriContract entity);
    List<KategoriContract> GetById(int id);



}