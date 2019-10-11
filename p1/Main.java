package p1;

import java.util.Scanner;
/*
This is the main class for the subnet calculator.
This class is responsible for getting console input, sending information to the IPV4 class,
Determining the CIDR notation, the Subnet, the bits in the host portion of the address and the bits in the network portion of
the address.
 */


public class Main {

    public static void main(String[] args) {
        String[] str = new String[4];

        int[] bin = new int[32];
        int[] networkAddr = new int[32];
        int[] broadcastAddr = new int[32];

        int bitsInHost = 0;
        int bitsInNetwork = 0;

        double hostsPerSubnet = 0;

        String subnet = "";
        String CIDR = "";

        //Getting console input.
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an IP Address.");
        String givenIp = input.next();

        //Splitting each portion of the address into the octets, and storing that in an String array.
        str = givenIp.split("\\.");
        //The array of each octet is converted to binary
        bin = IPV4.convertToBinary(str);
        String[] str1 = givenIp.split("/");

        //The class of the address is found and stored.
        String IPClass = IPV4.findClass(givenIp);

        //This switch statement determines the properties of the address from whichever class it is in.
        switch (IPClass) {
            case "A": {
                CIDR = "/8";
                subnet = "255.0.0.0";
                hostsPerSubnet = Math.pow(2, 24) - 2;
                bitsInNetwork = 8;
                bitsInHost = 24;

                //Since this is class A, Bits 1-8 are kept protected (Network portion). This is what this for loop does,
                //Stores the first byte in the the first 8 elements of the array.
                for (int i = 0; i < 7; i++) {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];

                }

                //This for loop is setting the rest the host bytes to 0 or 1, for the network and broadcast address.
                for (int i = 8; i < bin.length; i++) {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }
                break;
            }
            case "B": {
                CIDR = "/16";
                subnet = "255.255.0.0";
                hostsPerSubnet = Math.pow(2, 16) - 2;
                bitsInNetwork = 16;
                bitsInHost = 16;

                //Protecting the first two network bytes.
                for (int i = 0; i < 15; i++) {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];

                }

                //Changing the rest of the host bits to zero or one.
                for (int i = 16; i < bin.length; i++) {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }
                break;
            }
            case "C": {
                CIDR = "/24";
                subnet = "255.255.255.0";
                hostsPerSubnet = Math.pow(2, 8) - 2;
                bitsInNetwork = 24;
                bitsInHost = 8;

                //Protecting the first 3 network.
                for (int i = 0; i < 23; i++) {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];

                }

                //Setting the last host byte to zero or one.
                for (int i = 24; i < bin.length; i++) {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }
                break;
            }

            default: {
                hostsPerSubnet = Math.pow(2, 8) - 2;
                CIDR = "/24";
                subnet = "255.255.255.0";
                bitsInNetwork = 24;
                bitsInHost = 8;

                for (int i = 0; i < 23; i++) {
                    networkAddr[i] = bin[i];
                    broadcastAddr[i] = bin[i];
                }

                for (int i = 24; i < bin.length; i++) {
                    networkAddr[i] = 0;
                    broadcastAddr[i] = 1;
                }
                break;
            }
        }

        //Converting the network address to decimal
        int[] decimalNetworkAddr = IPV4.convertToDecimal(networkAddr);

        //Converting the broadcast address to decimal
        int[] decimalBroadcastAddr = IPV4.convertToDecimal(broadcastAddr);


        //Console Output:
        System.out.println("Network Class: " + IPClass);

        System.out.println("Subnet Mask: " + subnet);

        System.out.println("CIDR : " + CIDR);

        System.out.println("Hosts Per Subnet: " + (int) hostsPerSubnet);

        System.out.println("Network Address : " + decimalNetworkAddr[0]
                + "." + decimalNetworkAddr[1] + "." + decimalNetworkAddr[2] + "." + decimalNetworkAddr[3]);

        System.out.println("Broadcast Address : "
                + decimalBroadcastAddr[0] + "." + decimalBroadcastAddr[1] + "." + decimalBroadcastAddr[2] + "." + decimalBroadcastAddr[3]);

        System.out.println("Bits in Network: " + bitsInNetwork);

        System.out.println("Bits in Host: " + bitsInHost);


    }

}
