package androidcndd.bkdn.cvn.a311;

/**
 * Created by PC on 15-Sep-17.
 */

public class CongViec {
    private int id;
    private String Congviec;
    private String Thoigian;
    private String Diadiem;

    public CongViec(int id, String congviec, String thoigian, String diadiem)
    {
        this.id = id;
        Congviec = congviec;
        Thoigian = thoigian;
        Diadiem = diadiem;
    }


    public String getCongviec() {
        return Congviec;
    }

    public void setCongviec(String congviec) {
        Congviec = congviec;
    }

    public String getThoigian() {
        return Thoigian;
    }

    public void setThoigian(String thoigian) {
        Thoigian = thoigian;
    }

    public String getDiadiem() {
        return Diadiem;
    }

    public void setDiadiem(String diadiem) {
        Diadiem = diadiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
