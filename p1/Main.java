package p1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i;
        String[] str = new String[4];
        int[] bin = new int[32];
        int[] networkAddr = new int[32];
        int[] broadcastAddr = new int[32];
        int n1 = Integer.parseInt(str[1]);
        int n2 = 32 - n1;


        Scanner input =  new Scanner(System.in);
        System.out.println("Please enter an IP Address.");
        String givenIp = input.next();
        IPV4 ip = new IPV4(givenIp);

        str =  givenIp.split("\\.");
        bin = IPV4.convertToBinary(str);

        //Getting the network address by going through the binary number.
        for (i = 0; i <= (31 - n2); i++) {

            networkAddr[i] = bin[i];
            broadcastAddr[i] = bin[i];
        }

        // Set 32-n bits to 0
        for (i = 31; i > (31 - n2); i--) {

            networkAddr[i] = 0;
        }

        // Setting the broadcast address, setting 32-n bits to 1
        for (i = 31; i > (31 - n2); i--) {

            broadcastAddr[i] = 0;
        }



        System.out.println(IPV4.findClass(givenIp));
        //System.out.println(Arrays.toString(bin));

        System.out.println("Network Address : " + networkAddr[0]
                + "." + networkAddr[1] + "." + networkAddr[2] + "." + networkAddr[3]);

        System.out.println("Broadcast Address : "
                + broadcastAddr[0] + "." + broadcastAddr[1] + "." + broadcastAddr[2] + "." + broadcastAddr[3]);
    }

}
