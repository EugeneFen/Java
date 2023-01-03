import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
/*
получает 5 сообщений от сервера
клиент отправляет сообщение серверу

 */

public class ClientDemo {

    public static void main(String[] args) {


        final String serverHost = "localhost";

        Socket socketOfClient = null; //номер порта
        BufferedWriter writer = null; //буфер отправки
        BufferedReader reader = null; //буфер принятия

        try {
            //подключение к порту 7777
            socketOfClient = new Socket(serverHost, 7777);
            writer = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return;
        }

        try {
            String responseLine;
            responseLine = reader.readLine();
            System.out.println(responseLine);
            while(true) {
                //списоб писания с консоли, но неработает как хотелось бы
                // Scanner in = new Scanner(System.in);
                // String line = in.nextLine();
                // in.close();
                String line = "Hello"; //сообщение пользователям
                System.out.println(line); //вывод сообщения на экран
                writer.write(" >>> " + line); //передача сообщения серверу
                writer.newLine();
                writer.flush(); //подтвержжение данных
                Thread.sleep(4000); //ожидание;
                String line2 = reader.readLine();
                System.out.println(line2);
            }
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}