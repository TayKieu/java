package baimau.models;

public class ATM extends Card{
    private Integer sodu ;

    public ATM(String sothe, String name, String CCCD, String address) {
        super(sothe, name, CCCD, address);
    }

    public ATM(String sothe, String name, String CCCD, String address, Integer sodu) {
        super(sothe, name, CCCD, address);
        this.sodu = sodu;
    }

    public ATM(String[] subArray) {
    }


    public Integer getSodu() {
        return sodu;
    }

    public void setSodu(Integer sodu) {
        this.sodu = sodu;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "sodu=" + sodu +
                "} " + super.toString();
    }

    public String getInforToTXT(){
        return  getSothe() +"," + getName()+ "," + getCCCD() + "," + getAddress()+ "," + getSodu();
    }
}
