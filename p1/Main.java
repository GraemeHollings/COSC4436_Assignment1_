package p1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] str = new String[4];

        int[] bin = new int[32];
        int[] hostPortion = new int[32];
        int[] networkAddr = new int[32];
        int[] broadcastAddr = new int[32];

        int bitsInHost;
        int bitsInNetwork;

        double hostsPerSubnet = 0;

        String subnet = "";
        String CIDR = "";

        Scanner input =  new Scanner(System.in);
        System.out.println("Please enter an IP Address.");
        String givenIp = input.next();

        str =  givenIp.split("\\.");
        bin = IPV4.convertToBinary(str);
        String[] str1 = givenIp.split("/");

        String IPClass = IPV4.findClass(givenIp);


        switch (IPClass) {
            case "A": {
                //hostPortion = Arrays.copyOfRange(bin, 9, 32);
                CIDR = "/8";
                subnet = "255.0.0.0";
                hostsPerSubnet = Math.pow(2, 24) - 2;

                for(int i = 0; i < 7; i++)
                {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];

                }

                for(int i = 8; i < bin.length; i++ )
                {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }

                break;
            }
            case "B": {
                hostPortion = Arrays.copyOfRange(bin, 17, 32);
                CIDR = "/16";
                subnet = "255.255.0.0";
                hostsPerSubnet = Math.pow(2, 16) - 2;

                for(int i = 0; i < 15; i++)
                {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];

                }

                for(int i = 16; i < bin.length; i++ )
                {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }


                break;
            }
            case "C": {
                hostPortion = Arrays.copyOfRange(bin, 25, 32);
                CIDR = "/24";
                subnet = "255.255.255.0";
                hostsPerSubnet = Math.pow(2, 8) - 2;

                for(int i = 0; i < 23; i++)
                {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];

                }

                for(int i = 24; i < bin.length; i++ )
                {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }

                break;
            }

            default: {
                break;
            }
        }

        bitsInHost = hostPortion.length + 1;
        bitsInNetwork = 32 - hostPortion.length - 1;

        //Converting the network address to decimal
        int[] decimalNetworkAddr = IPV4.convertToDecimal(networkAddr);

        //Converting the broadcast address to decimal
        int[] decimalBroadcastAddr = IPV4.convertToDecimal(broadcastAddr);



        System.out.println("Network Class: " + IPClass);

        System.out.println("Subnet Mask: " + subnet);

        System.out.println("CIDR : " + CIDR);

        System.out.println("Hosts Per Subnet: " + (int)hostsPerSubnet);

        System.out.println("Network Address : " + decimalNetworkAddr[0]
                + "." + decimalNetworkAddr[1] + "." + decimalNetworkAddr[2] + "." + decimalNetworkAddr[3]);

        System.out.println("Broadcast Address : "
                + decimalBroadcastAddr[0] + "." + decimalBroadcastAddr[1] + "." + decimalBroadcastAddr[2] + "." + decimalBroadcastAddr[3]);

        System.out.println("Bits in Host: " + bitsInHost);
        System.out.println("Bits in Network: " + bitsInNetwork);

    }

}
