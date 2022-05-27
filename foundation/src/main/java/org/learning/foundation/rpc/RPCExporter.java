package org.learning.foundation.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCExporter {
    public static void exporter(String hostName, int port) throws IOException {
        ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try (ServerSocket server = new ServerSocket()) {
            server.bind(new InetSocketAddress(hostName, port));
            while (true) {
                executors.execute(() -> {
                    try {
                        Socket client = server.accept();
                        String intferfaceName;
                        String methodName;
                        Class<?>[] paramTypes;
                        Object[] arguments;
                        try (ObjectInputStream in = new ObjectInputStream(client.getInputStream())) {
                            intferfaceName = in.readUTF();
                            methodName = in.readUTF();
                            paramTypes = (Class<?>[]) in.readObject();
                            arguments = (Object[]) in.readObject();

                            Class<?> service = Class.forName(intferfaceName);
                            Method method = service.getMethod(methodName, paramTypes);
                            Object result = method.invoke(service.newInstance(), arguments);

                            try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream())) {
                                out.writeObject(result);
                            }
                        }


                    } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException | InstantiationException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

    }
}
