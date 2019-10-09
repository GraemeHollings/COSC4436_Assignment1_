package p1;

import java.util.Stack;

public class IPV4 {

    private String givenIP;
    private String netmask;

    public IPV4(String givenIP, String netmask) {

        this.givenIP = givenIP;
        this.netmask = netmask;

    }

    public IPV4(String givenIP) {

        this.givenIP = givenIP;
    }

    //This method converts the address to binary
    public static int[] convertToBinary(String[] givenIP)
    {
        int[] address = new int[32];
        int oct1, oct2, oct3, oct4, remainder;
        oct1 = oct2 = oct3 = oct4 = 1;
        Stack<Integer> stack = new Stack<Integer>();

        //Splitting up each of the given octets into variables.
        //When we receive the string array of the given ip, it should be the 4 octets
        //split up into an array of size 4, where each element is an octet.
        if (givenIP != null)
        {
            oct1 = Integer.parseInt(givenIP[0]);
            oct2 = Integer.parseInt(givenIP[1]);
            oct3 = Integer.parseInt(givenIP[2]);
            oct4 = Integer.parseInt(givenIP[3]);
        }

        // convert first octet to binary
        for (int i = 0; i <= 7; i++)
        {
            //Each digit is pushed onto the stack
            remainder = oct1 % 2;
            stack.push(remainder);
            oct1 = oct1 / 2;
        }

        //Acquire that first octet out of the stack and store it.
        for (int i = 0; i <= 7; i++) {
            address[i] = stack.pop();
        }

        //Convert the second octet to binary.
        for(int i = 8; i <= 15; i++)
        {
            remainder = oct2 % 2;
            stack.push(remainder);
            oct2 = oct2 / 2;
        }

        //Get the second octet out of the stack and store it
        for (int i = 8; i <= 15; i++) {
            address[i] = stack.pop();
        }

        //Convert the third octet to binary.
        for(int i = 16; i <= 23; i++)
        {
            remainder = oct3 % 2;
            stack.push(remainder);
            oct3 = oct3 / 2;
        }

        //Get the third octet out of the stack and store it.
        for (int i = 16; i <= 23; i++) {
            address[i] = stack.pop();
        }

        //Convert the fourth octet to binary.
        for(int i = 24; i <= 31; i++)
        {
            remainder = oct4 % 2;
            stack.push(remainder);
            oct4 = oct4 / 2;
        }

        //Get the fourth octet out of the stack and store it.
        for (int i = 24; i <= 31; i++) {
            address[i] = stack.pop();
        }

        return (address);
    }

    //This method takes an array that is intended to be the binary array,
    //and converts it back to decimal. This is used for the network and broadcast addr.
    public static int[] convertToDecimal (int[] binary)
    {

        int[] decimalAddr = new int[4];
        int set1, set2, set3, set4, exponent;
        set1 = set2 = set3 = set4 = 0;
        exponent = 7;

        //Converting the first octet of binary digits to decimal.
        for (int i = 0; i < 8; i++) {

            set1 = set1 + (int)(Math.pow(2, exponent)) * binary[i];
            exponent--;
        }
            exponent = 7;

        //Converting the second octet of binary digits to decimal.
        for (int i = 8; i < 16; i++) {

            set2 = set2 + (int)(Math.pow(2, exponent)) * binary[i];
            exponent--;
        }

        exponent = 7;


        //Converting the third octet of binary digits to decimal.
        for (int i = 16; i < 24; i++) {

            set3 = set3 + (int)(Math.pow(2, exponent)) * binary[i];
            exponent--;
        }

        exponent = 7;

        //Converting the fourth octet of binary digits to decimal.
        for (int i = 24; i < 32; i++) {

            set4 = set4 + (int)(Math.pow(2, exponent)) * binary[i];
            exponent--;
        }

        exponent = 7;

        decimalAddr[0] = set1;
        decimalAddr[1] = set2;
        decimalAddr[2] = set3;
        decimalAddr[3] = set4;

        return(decimalAddr);

    }




    //This method finds that class of a given IP Address.
    public static String findClass(String givenIP)
    {
       int index = givenIP.indexOf(".");
       String tempOct = givenIP.substring(0,index);
        int firstOct = Integer.parseInt(tempOct);

        if (firstOct >= 1 && firstOct <= 127)
            return "A";

        else if (firstOct >= 128 && firstOct <= 191)
            return "B";

        else if (firstOct >= 192 && firstOct <= 223)
            return "C";

        else if (firstOct >= 224 && firstOct <= 239)
            return "D";

        else {
                return "E";
            }

    }

}
