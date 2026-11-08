//Polymorphism - method overloading, same method name but different parameters
public class ServiceBill {
    double total;

    void computeBill(double price){
        total = total + price;
    }

    double computeBill(){
        return total;
    }
}
