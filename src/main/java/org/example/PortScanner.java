package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class PortScanner implements Task {
    private final String host;
    private final int startPort;
    private final int endPort;
    private volatile boolean running = false;

    public PortScanner(String host, int startPort, int endPort) {
        this.host = host;
        this.startPort = startPort;
        this.endPort = endPort;
    }

    @Override
    public void start() {
        running = true;
        System.out.println("Начато сканирование хоста " + host + " с портов " + startPort + " по " + endPort);

        for (int port = startPort; port <= endPort && running; port++) {
            try (Socket socket = new Socket()) {
                SocketAddress address = new InetSocketAddress(host, port);
                socket.connect(address, 200);
                System.out.println("Порт " + port + " открыт");
            } catch (IOException e) {
            }
        }

        System.out.println("Сканирование завершено.");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("Сканирование остановлено.");
    }

    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);

        System.out.print("Введите хост (localhost): ");
        String host = scannerInput.nextLine();

        System.out.print("Введите начальный порт: ");
        int startPort = scannerInput.nextInt();

        System.out.print("Введите конечный порт: ");
        int endPort = scannerInput.nextInt();

        scannerInput.nextLine();

        PortScanner scanner = new PortScanner(host, startPort, endPort);

        Thread scanThread = new Thread(scanner::start);
        scanThread.start();

        System.out.println("Нажмите Enter для остановки сканирования.");
        scannerInput.nextLine();
        scanner.stop();

        scannerInput.close();
    }
}
