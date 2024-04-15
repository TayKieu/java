package bai11JavaCollectionFramework.ArrayList;

public class Product {
    private String name, id;
    private double cost;

    public Product() {
    }

    public Product(String name, String id, double cost) {
        this.name = name;
        this.id = id;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cost=" + cost +
                '}';
    }
}
