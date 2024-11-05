//Gửi "Xin chào" cho người Anh hiểu "Hello"
//Giúp 2 interface không liên quan j thao tác được với nhau 
package netbean_17_buoi3_MauThietKe_Structural;

// A chứa chức năng được sử dung bởi client 
// B chứa điều không tương thích 
// C giúp A tích hợp được với B 
// interface A , class B , class C implements A {B b}

interface VietnameseA {
    void send(String words);
}
class EGB{
    public void receive(String words) {
        System.out.println(words);
    }
}
class TranslatorC extends EGB implements VietnameseA {
    private EGB B;
    public TranslatorC(EGB B) {
        this.B = B;
    }
    private String translate(String vietnameseWords) {
        System.out.println("Translated!");
        return "Hello";
    }
    @Override
    public void send(String words) {
        String vietnameseWords = this.translate(words);
        B.receive(vietnameseWords);
    }
}
class a_adapter {
    public static void main(String[] args) {
        VietnameseA client = new TranslatorC(new EGB());
        client.send("Xin chào");
    }
}
