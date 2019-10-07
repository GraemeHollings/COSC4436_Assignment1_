package p1;

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

    public static int[] convertToBinary(String[] givenIP)
    {
        int address[] = new int[32];
        int oct1, oct2, oct3, oct4, x, remainder;



    }



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
