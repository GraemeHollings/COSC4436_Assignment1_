package p1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] str = new String[4];
        int[] bin = new int[32];

        Scanner input =  new Scanner(System.in);
        System.out.println("Please enter an IP Address.");
        String givenIp = input.next();

        str =  givenIp.split("\\.");
        bin = IPV4.convertToBinary(str);
        String[] str1 = givenIp.split("/");

        String IPClass = IPV4.findClass(givenIp);
        int[] hostPortion = new int[32];
        int[] networkAddr = new int[32];
        int[] broadcastAddr = new int[32];

        switch (IPClass) {
            case "A": {
                hostPortion = Arrays.copyOfRange(bin, 9, 32);

                break;
            }
            case "B": {
                hostPortion = Arrays.copyOfRange(bin, 17, 32);

                break;
            }
            case "C": {
                hostPortion = Arrays.copyOfRange(bin, 25, 32);
                break;
            }

            default: {
                break;
            }
        }

        //Copying the host portion into another array, so the host portion array is protected.
        for(int i  = 0; i < hostPortion.length; i++)
        {
            networkAddr[i] = hostPortion[i];
            broadcastAddr[i] = hostPortion[i];

        }

       //Setting the digits of the host portion to 1 for the network address
        for(int i = 0; i < networkAddr.length; i++)
        {
            networkAddr[i] = 0;
        }

        //Calculating the subnet
        int [] subnet = IPV4.convertToDecimal(bin);

        //Converting the network address to decimal
        int[] decimalNetworkAddr = IPV4.convertToDecimal(networkAddr);

        //Converting the broadcast address to decimal
        int[] decimalBroadcastAddr = IPV4.convertToDecimal(broadcastAddr);




        System.out.println("IP Class: " + IPClass);
        //System.out.println(Arrays.toString(bin));


        //ystem.out.println("Subnet: " + subnet[0] + "." + subnet[1] + "." + subnet[2] + "." + subnet[3] );

        System.out.println("Network Address : " + decimalNetworkAddr[0]
                + "." + decimalNetworkAddr[1] + "." + decimalNetworkAddr[2] + "." + decimalNetworkAddr[3]);

        System.out.println("Broadcast Address : "
                + decimalBroadcastAddr[0] + "." + decimalBroadcastAddr[1] + "." + decimalBroadcastAddr[2] + "." + decimalBroadcastAddr[3]);



    }

}
