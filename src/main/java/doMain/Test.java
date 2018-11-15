package doMain;

import serverCentre.ServerCentreAble;
import serverCentre.impI.ServerCentreImpI;
import service.impI.HelloServiceImpl;
import service.openAble.HelloServiceAble;
import service.openAble.RPCClient;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Test {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ServerCentreAble serviceServer = new ServerCentreImpI(8088);
                    serviceServer.register(HelloServiceAble.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloServiceAble service = RPCClient.getRemoteProxyObj(HelloServiceAble.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }



}
