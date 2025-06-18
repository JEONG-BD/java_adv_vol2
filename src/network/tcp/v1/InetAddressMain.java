package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);
        getGoogleInformation();
    }

    private static void getGoogleInformation() throws UnknownHostException {
        InetAddress google = InetAddress.getByName("google.com");
        System.out.println("google.getAddress() = " + google.getAddress());
        System.out.println("google.getHostAddress() = " + google.getHostAddress());
        System.out.println("google.getHostName() = " + google.getHostName());
        System.out.println("google.getCanonicalHostName() = " + google.getCanonicalHostName());
    }

}
