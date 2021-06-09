package edu.uw.exchange;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import edu.uw.ext.framework.exchange.StockExchange;

public class SimpleCommandListener implements Runnable {

    private int commandPort;

    private ServerSocket servSock;

    private StockExchange realExchange;

    private ExecutorService requestExecutor = Executors.newCachedThreadPool();

    public SimpleCommandListener(int commandPort, StockExchange realExchange) {
        this.commandPort = commandPort;
        this.realExchange = realExchange;
    }

    @Override
    public void run() {
        try (ServerSocket localServSock = new ServerSocket(commandPort)) {
            servSock = localServSock;
            while (!servSock.isClosed()) {
                Socket sock = null;

                try {
                    sock = servSock.accept();
                } catch (SocketException exc) {
                }

                if (sock == null) {
                    continue;
                }

                requestExecutor
                    .execute(new SimpleCommandHandler(sock, realExchange));
            }

        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            terminate();
        }
        ;
    }

    public void terminate() {
        try {
            if (servSock != null && !servSock.isClosed()) {
                servSock.close();
            }
            if (!requestExecutor.isShutdown()) {
                requestExecutor.shutdown();
                requestExecutor.awaitTermination(1L, TimeUnit.SECONDS);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

}
