package org.learning.foundation.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RPCImporter<S> {
    public S importer(Class<?> serviceClass, InetSocketAddress address) {
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[]{serviceClass.getInterfaces()[0]}, (proxy, method, args) -> {
            try (Socket socket = new Socket()) {
                socket.connect(address);
                try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
                    out.writeUTF(serviceClass.getName());
                    out.writeUTF(method.getName());
                    out.writeObject(method.getGenericParameterTypes());
                    out.writeObject(args);
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        return in.readObject();
                    }
                }
            }
        });
    }
}
