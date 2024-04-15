package bai11JavaCollectionFramework.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
public class ProductManager {
    ArrayList<Product> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(Product product) {
        list.add(product);
    }
    public void edit(String id){
        id = scanner.nextLine();
        for(int i = 0; i< list.size();i++){
            if(id.equalsIgnoreCase(list.get(i).getId())){
                list.get(i).setId(scanner.nextLine());
                list.get(i).setName(scanner.nextLine());
                list.get(i).setCost(Double.parseDouble(scanner.nextLine()));
                break;
            }
        }
    }
    public void remove(String id) {
        id = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (id.equalsIgnoreCase(list.get(i).getId())) {
                list.remove(i);
                break;
            }
        }
    }
    public void search(String id) {
        id = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                System.out.println(list.get(i).toString());
                break;
            }
        }
    }

    public void display() {
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
