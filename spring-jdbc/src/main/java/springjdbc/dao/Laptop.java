package springjdbc.dao;

public class Laptop {

    private int lId;
    private String brand;
    private int ram;

    public int getLId() {
        return lId;
    }

    public void setLId(int lId) {
        this.lId = lId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return lId + " | " + brand + " | " + ram + " GB";
    }
}