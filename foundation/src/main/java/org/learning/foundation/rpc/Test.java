package org.learning.foundation.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Test {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RPCExporter.exporter("127.0.0.1", 8088);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        RPCImporter<EchoService> rpcImporter = new RPCImporter<>();
        EchoService echoService = rpcImporter.importer(EchoServiceImpl.class, new InetSocketAddress("127.0.0.1", 8088));
        System.out.println(echoService.echo("Are you ok?"));


    }
}
