package p1;

public class IPV4 {

    public IPV4(String givenIP, String netmask) {
        /*
        Checking the classful IP address
        We do this by converting the number to binary, then checking to see if that number is in range of
        the class.
         */

        String tempOctet = givenIP.substring(0, 3);
        int firstOctet = Integer.parseInt(tempOctet);

        
    }
}
