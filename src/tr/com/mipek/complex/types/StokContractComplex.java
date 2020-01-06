package tr.com.mipek.complex.types;

import java.util.Date;

public class StokContractComplex {
    private int id;
    private String urunadi;
    private String personelAdi;
    private String tarih;
    private int adet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    public String getTarih(String tarih) {
        return this.tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Object[] getVeriler(){
        Object[] veriler= {id,urunadi,personelAdi,adet,tarih };
        return veriler;
    }
    @Override
    public String toString() {
        return personelAdi+ urunadi;
    }
}
