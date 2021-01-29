package model;

public class Dec64 {

    // Base-10 representation of the decimal value
    private String base10;
    private Integer exponent;
    private String signBit;
    private String combiField;
    private String expoContinuation;
    private String coefContinuation;
    private String hexValue;

    public Dec64() {
        this.base10 = null;
    }

    public void setBase10(String n) {
        char sign = n.charAt(0);
        if (sign == '-') {
            signBit = "1";
            n = n.substring(1);
        } else {
            signBit = "0";
        }

        this.base10 = n;
    }

    public String getBase10() {
        return base10;
    }

    public Integer getExponent() {
        return exponent;
    }

    public void setExponent(Integer n) {
        this.exponent = n;
    }

    public void isNaN(String input) {
        base10 = input + " (NaN)";
        signBit = "0";
        combiField = "11110";
        expoContinuation = "--";
        coefContinuation = "-----";
        hexValue = "NaN";
    }

    public void isInfinity(String input) {
        base10 = input + " (Infinity)";
        if(Integer.parseInt(input) < 0) {
            signBit = "1";
        }
        else {
            signBit = "0";
        }
        combiField = "11110";
        expoContinuation = "--";
        coefContinuation = "-----";
        hexValue = "Infinity";
    }

    public void fixInput() {
        String temp = base10;
        int pos = temp.indexOf('.');

        if (pos >= 0 && Integer.parseInt(temp.substring(pos + 1, temp.length())) > 0) {
            exponent = exponent - temp.substring(pos + 1, temp.length()).length();
            temp = temp.substring(0, pos) + temp.substring(pos + 1, temp.length());
        }

        base10 = temp;
        normalize();
    }

    private void normalize() {
        String temp = base10;

        for (int i = temp.length(); i < 16; i++) {
            temp = "0" + temp;
        }

        int mostSignificant = Integer.valueOf(temp.substring(0, 1));

        // -> mostSig to bcd

        String exponentRep = binaryConvert(exponent + 398);

        for (int i = exponentRep.length(); i < 10; i++) {
            exponentRep = "0" + exponentRep;
        }

        combiField = combiField(mostSignificant, exponentRep);

        expoContinuation = getExpContinuation(exponentRep);

        temp = temp.substring(1);

        coefContinuation = DBCD(Integer.valueOf(temp.substring(0, 3)));
        temp = temp.substring(3);

        while(temp.length() > 0) {
            coefContinuation += DBCD(Integer.valueOf(temp.substring(0, 3)));
            temp = temp.substring(3);
        }
        coefContinuation = coefContinuation.trim();

        hexValue = convertHex().toUpperCase();
    }

    private String binaryConvert(int n) {
        String temp = "";

        do {
            temp = String.valueOf(n % 2) + temp;
            n /= 2;
        } while (n > 0);
        return String.valueOf(temp);
    }

    private String bcd(int num) {
        switch(num){
            case 0: return "0000"; 
            case 1: return "0001";
            case 2: return "0010";
            case 3: return "0011";
            case 4: return "0100";
            case 5: return "0101";
            case 6: return "0110";
            case 7: return "0111";
            case 8: return "1000";
            case 9: return "1001";
        }
        return "";
    }

    private String DBCD(int num){
        int hundreds, tens, ones;
        String hdString, tnString, onString, numString;
        char[] dbcdString = new char[10];
        char a, e, i;

        hundreds =  num/100;
        num =  num - hundreds * 100;
        tens = num/10;
        ones = num - tens *10;

        hdString = this.bcd(hundreds);
        tnString = this.bcd(tens);
        onString = this.bcd(ones);

        numString = hdString  + tnString + onString;

        a = numString.charAt(0);
        e = numString.charAt(4);
        i = numString.charAt(8);
        switch(a){
            case '0': 
                switch(e){
                    case '0':
                        switch(i){
                            case '0': 
                            dbcdString[0] = numString.charAt(1); 
                            dbcdString[1] = numString.charAt(2);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = numString.charAt(5); 
                            dbcdString[4] = numString.charAt(6); 
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '0';
                            dbcdString[7] = numString.charAt(9);
                            dbcdString[8] = numString.charAt(10);
                            dbcdString[9] = numString.charAt(11);
                            break;

                            case '1':
                            dbcdString[0] = numString.charAt(1); 
                            dbcdString[1] = numString.charAt(2);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = numString.charAt(5); 
                            dbcdString[4] = numString.charAt(6); 
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '1';
                            dbcdString[7] = '0';
                            dbcdString[8] = '0';
                            dbcdString[9] = numString.charAt(11);
                            break;                            
                        };
                        break;
                        
                    case '1': 
                        switch(i){
                            case '0': 
                            dbcdString[0] = numString.charAt(1); 
                            dbcdString[1] = numString.charAt(2);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = numString.charAt(9); 
                            dbcdString[4] = numString.charAt(10); 
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '1';
                            dbcdString[7] = '0';
                            dbcdString[8] = '1';
                            dbcdString[9] = numString.charAt(11);
                            break;

                            case '1':
                            dbcdString[0] = numString.charAt(1); 
                            dbcdString[1] = numString.charAt(2);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = '1';
                            dbcdString[4] = '0';
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] ='1';
                            dbcdString[7] = '1';
                            dbcdString[8] = '1';
                            dbcdString[9] = numString.charAt(11);
                            break;                            
                        };
                        break;
                }; break;
            case '1': 
                switch(e){
                    case '0':
                        switch(i){
                            case '0':
                            dbcdString[0] = numString.charAt(9); 
                            dbcdString[1] = numString.charAt(10);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = numString.charAt(5); 
                            dbcdString[4] = numString.charAt(6); 
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '1';
                            dbcdString[7] = '1';
                            dbcdString[8] = '0';
                            dbcdString[9] = numString.charAt(11);
                            break;
                            case '1':
                            dbcdString[0] = numString.charAt(5); 
                            dbcdString[1] = numString.charAt(6);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = '0';
                            dbcdString[4] = '1';
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '1';
                            dbcdString[7] = '1';
                            dbcdString[8] = '1';
                            dbcdString[9] = numString.charAt(11);
                            break;
                        };
                    case '1': 
                        switch(i){
                            case '0': 
                            dbcdString[0] = numString.charAt(9); 
                            dbcdString[1] = numString.charAt(10);
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = '0';
                            dbcdString[4] = '0';
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '1';
                            dbcdString[7] = '1';
                            dbcdString[8] = '1';
                            dbcdString[9] = numString.charAt(11);
                            break;

                            case '1':
                            dbcdString[0] = '0';
                            dbcdString[1] = '0';
                            dbcdString[2] = numString.charAt(3);
                            dbcdString[3] = '1';
                            dbcdString[4] = '1';
                            dbcdString[5] = numString.charAt(7); 
                            dbcdString[6] = '1';
                            dbcdString[7] = '1';
                            dbcdString[8] = '1';
                            dbcdString[9] = numString.charAt(11);
                            break;
                        };
                    break;
                }; break;
        }
        
        return String.valueOf(dbcdString);
    }

    private String combiField(int mostSignificant, String exponentRep) {

        String binaryExpoRep = binaryConvert(mostSignificant);
        String expMSB = exponentRep.substring(0, 2);
        String msbSubstring = "";
        String combination = "";
        for (int i = binaryExpoRep.length(); i < 4; i++) {
            binaryExpoRep = "0" + binaryExpoRep;
        }

        if (mostSignificant >= 0 && mostSignificant <= 7) {
            msbSubstring = binaryExpoRep.substring(1);
            combination = expMSB.concat(msbSubstring);

        } else if (mostSignificant >= 8 && mostSignificant <= 9) {
            msbSubstring = binaryExpoRep.substring(3);
            combination = combination.concat("11");
            combination = combination.concat(expMSB);
            combination = combination.concat(msbSubstring);
        }

        return combination;
    }

    // exponent continuation
    private String getExpContinuation(String exponentRep) {
        return exponentRep.substring(2);
    }

    private String convertHex() {
        String binary = signBit + combiField + expoContinuation + coefContinuation;
        
        String hex = "";
        while(binary.length() > 0) {
            String subBin = binary.substring(0, 4);
            int decimal = Integer.parseInt(subBin, 2);
            
            hex = hex + Integer.toString(decimal, 16);

            binary = binary.substring(4);
            
        }
        

        return hex;
    }

    @Override
    public String toString() {
        String output = "Input: " + base10 + "x10 ^ " + String.valueOf(exponent) + "\n" +
                        "Sign: " + signBit + "\n" + 
                        "Combination Field:" + combiField + "\n" + 
                        "Exponent Continuation: " + expoContinuation + "\n" +
                        "Coefficient Continuation: " + coefContinuation + "\n" +
                        "HEXADECIMAL: " + hexValue + "\n";

        return output;
    }
}
