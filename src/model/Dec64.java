package model;

public class Dec64 {
    
    //Base-10 representation of the decimal value
    private Integer base10;

    public Dec64() {
        this.base10 = null;
    }

    public void setBase10(Integer n) {
        this.base10 = n;
    }

    public Integer getBase10() {
        return base10;
    }
}
