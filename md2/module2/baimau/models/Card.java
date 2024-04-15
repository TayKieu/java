package baimau.models;

public class Card {
    private String sothe;
    private String name;
    private String CCCD;
    private String address;

    public Card(String sothe, String name, String CCCD, String address) {
        this.sothe = sothe;
        this.name = name;
        this.CCCD = CCCD;
        this.address = address;
    }
    public Card(){}

    public String getSothe() {
        return sothe;
    }

    public void setSothe(String sothe) {
        this.sothe = sothe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "sothe='" + sothe + '\'' +
                ", name='" + name + '\'' +
                ", CCCD='" + CCCD + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
