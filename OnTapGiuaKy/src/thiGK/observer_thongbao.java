package thiGK;

import java.util.ArrayList;
import java.util.List;

class thanhvien{
    private String tentv;
    private int namsinhtv;
    private String thongbao;

    public void setTentv(String tentv) {
        this.tentv = tentv;
    }

    public void setNamsinhtv(int namsinhtv) {
        this.namsinhtv = namsinhtv;
    }

    public void setThongbao(String thongbao) {
        this.thongbao = thongbao;
    }

    public thanhvien(String tentv, int namsinhtv) {
        this.tentv = tentv;
        this.namsinhtv = namsinhtv;
    }
    public void nhanthongbao(){
        System.out.println(this.tentv + " sinh nam " + this.namsinhtv + " nhan thong bao " + this.thongbao);
    }
}

