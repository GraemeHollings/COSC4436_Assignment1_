package p1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i;
        String[] str = new String[4];
        int[] bin = new int[32];

        Scanner input =  new Scanner(System.in);
        System.out.println("Please enter an IP Address.");
        String givenIp = input.next();

        str =  givenIp.split("\\.");
        bin = IPV4.convertToBinary(str);
        String[] str1 = givenIp.split("/");

        String IPClass = IPV4.findClass(givenIp);

        switch (IPClass) {
            case "A": {
                int[] hostPortion = Arrays.copyOfRange(bin, 9, 32);

                break;
            }
            case "B": {
                int[] hostPortion = Arrays.copyOfRange(bin, 17, 32);

                break;
            }
            case "C": {
                int[] hostPortion = Arrays.copyOfRange(bin, 25, 32);
                break;
            }

            default: {
                break;
            }
        }

        //Getting the network address by going through the binary number.
        for (i = 0; i < 32; i++) {

            
        }



        // Set 32-n bits to 0
        for (i = 31; i <= 31; i--) {

            networkAddr[i] = 0;

            if(i == 0) break;
        }

        // Setting the broadcast address, setting 32-n bits to 1
        for (i = 31; i <= 31; i--) {

            broadcastAddr[i] = 1;
            if(i == 0) break;
        }

        //Calculating the subnet
        int [] subnet = IPV4.convertToDecimal(bin);

        //Converting the network address to decimal
        int[] decimalNetworkAddr = IPV4.convertToDecimal(networkAddr);

        //Converting the broadcast address to decimal
        int[] decimalBroadcastAddr = IPV4.convertToDecimal(broadcastAddr);




        System.out.println("IP Class: " + IPClass);
        //System.out.println(Arrays.toString(bin));


        System.out.println("Subnet: " + subnet[0] + "." + subnet[1] + "." + subnet[2] + "." + subnet[3] );

        System.out.println("Network Address : " + decimalNetworkAddr[0]
                + "." + decimalNetworkAddr[1] + "." + decimalNetworkAddr[2] + "." + decimalNetworkAddr[3]);

        System.out.println("Broadcast Address : "
                + decimalBroadcastAddr[0] + "." + decimalBroadcastAddr[1] + "." + decimalBroadcastAddr[2] + "." + decimalBroadcastAddr[3]);



    }

}
