package netbean_17_buoi2_MauThietKe_Creational;

interface Ghe {
    void tao();
}

interface Ban {
    void tao();
}

enum LoaiVatLieu {
    NHUA, GO
}

class GheNhua implements Ghe {
    @Override
    public void tao() {
        System.out.println("Tao ghe nhua");
    }
}

class GheGo implements Ghe {
    @Override
    public void tao() {
        System.out.println("Tao ghe go");
    }
}
class BanNhua implements Ban {
    @Override
    public void tao() {
        System.out.println("Tao ban nhua");
    }
}

class BanGo implements Ban {
    @Override
    public void tao() {
        System.out.println("Tao ban go");
    }
}

abstract class NoiThatTruuTuongNhaMay {

    public abstract Ghe taoGhe();

    public abstract Ban taoBan();
}

class NhaMayNhua extends NoiThatTruuTuongNhaMay {

    @Override
    public Ghe taoGhe() {
        return new GheNhua();
    }

    @Override
    public Ban taoBan() {
        return new BanNhua();
    }
}

class NhaMayGo extends NoiThatTruuTuongNhaMay {

    @Override
    public Ghe taoGhe() {
        return new GheGo();
    }

    @Override
    public Ban taoBan() {
        return new BanGo();
    }
}

class NhaMayNoiThat {
    private NhaMayNoiThat() {

    }
    public static NoiThatTruuTuongNhaMay layNhaMay(LoaiVatLieu loaiVatLieu) {
        switch (loaiVatLieu) {
            case NHUA:
                return new NhaMayNhua();
            case GO:
                return new NhaMayGo();
            default:
                throw new UnsupportedOperationException("Noi that nay khong duoc ho tro");
        }
    }
}

public class b_abstractfactory {
    public static void main(String[] args) {
        NoiThatTruuTuongNhaMay nhaMay = NhaMayNoiThat.layNhaMay(LoaiVatLieu.NHUA);

        Ghe ghe = nhaMay.taoGhe();
        ghe.tao(); // Tao ghe nhua

        Ban ban = nhaMay.taoBan();
        ban.tao(); // Tao ban nhua
    }
}
