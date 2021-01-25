package model;

import java.io.Console;

public class Dec64 {
    
    //Base-10 representation of the decimal value
    private String base10;
    private Integer exponent;
    private String binaryBase10;
    private String signBit;
    private String combiField;
    private String expoContinuation;
    private String coefContinuation;

    public Dec64() {
        this.base10 = null;
    }

    public void setBase10(String n) {
        char sign = n.charAt(0);
        if(sign == '-') {
            signBit = "1";
            n = n.substring(1);
        }else {
            signBit = "0";
        }

        this.base10 = n;
    }

    public String getBase10() {
        return base10;
    }

    public void setExponent(Integer n) {
        this.exponent = n;
    }

    public Integer getExponent() {
        return exponent;
    }
    
    public void fixInput() {
        String temp = base10;
        int pos = temp.indexOf('.');

        if(pos >= 0 && Integer.parseInt(temp.substring(pos + 1, temp.length())) > 0) {
            exponent = exponent - temp.substring(pos + 1, temp.length()).length();
            temp = temp.substring(0, pos) + temp.substring(pos + 1, temp.length());
        }
         
        base10 = temp;
        normalize();
    }

    private void normalize() {
        String temp = base10;

        for(int i = temp.length(); i < 16; i++ ) {
            temp = "0" + temp;
        }

        int mostSignificant = Integer.valueOf(temp.substring(0, 1));
        System.out.println("MostSig: " + mostSignificant + " binary: " + binaryConvert(mostSignificant));

        //-> mostSig to bcd
    
        String exponentRep = binaryConvert(exponent + 398);


    }

    private String binaryConvert(int n) {
        String temp = "";

        do {
            temp = String.valueOf(n%2) + temp;  
            n /= 2;
        }while(n > 0);
        return String.valueOf(temp);
    }

    private String bcd(String bin) {
        return "";
    }

    private String combiField(/**most significant and exponent rep pass**/) {
        return "";
    }

    //exponent continuation
    private String getExpContinuation() {
        return "";
    }

    private String getCoefContinuation() {
        return "";
    }

    @Override
    public String toString() {
        return "Input: " + base10 + "x10 ^ " + String.valueOf(exponent) + "\n";
    }
}
