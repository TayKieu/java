package baimau.models;

public class CreditCard extends Card{
    private Integer duno;
    private Integer hanmuc;

    public Integer getDuno() {
        return duno;
    }

    public void setDuno(Integer duno) {
        this.duno = duno;
    }

    public Integer getHanmuc() {
        return hanmuc;
    }

    public void setHanmuc(Integer hanmuc) {
        this.hanmuc = hanmuc;
    }

    public CreditCard(String sothe, String name, String CCCD, String address) {
        super(sothe, name, CCCD, address);
    }

    public CreditCard(String sothe, String name, String CCCD, String address, Integer duno, Integer hanmuc) {
        super(sothe, name, CCCD, address);
        this.duno = duno;
        this.hanmuc = hanmuc;
    }
    public CreditCard(){}

    @Override
    public String toString() {
        return "CreditCard{" +
                "duno=" + duno +
                ", hanmuc=" + hanmuc +
                "} " + super.toString();
    }

    public String getInforToTXT(){
        return  getSothe() +"," + getName()+ "," + getCCCD() + "," + getAddress()+ "," + getDuno() + "," + getHanmuc() ;
    }
}
