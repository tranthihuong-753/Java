package test;
//Gửi "Xin chào" cho người Anh hiểu "Hello"

import java.util.ArrayList;
import java.util.Iterator;


interface VietnameseTarget {
 
    void send(String words);
 
}
class JapaneseAdaptee {
 
    public void receive(String words) {
        System.out.println("...");
        System.out.println(words);
    }
}
class TranslatorAdapter implements VietnameseTarget {
 
    private JapaneseAdaptee adaptee;
 
    public TranslatorAdapter(JapaneseAdaptee adaptee) {
        this.adaptee = adaptee;
    }
 
    @Override
    public void send(String words) {
        System.out.println("Reading Words ...");
        System.out.println(words);
        String vietnameseWords = this.translate(words);
        System.out.println("Sending Words ...");
        adaptee.receive(vietnameseWords);
    }
 
    private String translate(String vietnameseWords) {
        System.out.println("Translated!");
        return "こんにちは";
    }
}
class VietnameseClient {
 
    public static void main(String[] args) {
        VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());
        client.send("Xin chào");
    }
}

public class test {
    public static void main(String[] args) {
            // Make a collection
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    // Get the iterator
    Iterator<String> it = cars.iterator();

    // Print the first item
    while(it.hasNext()) {
      System.out.println(it.next());
    }
    
    }
}
