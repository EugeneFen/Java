import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    //просто список сообщений
    //можно усовершенствовать и сделать список списков
    //типо массива динамического. первая колонка будет логин пользователя, а вторая его сообщение
    //тут главное история сообщений,так что не важно сколько раз отправит пользователь сообщение, главное, что будет сохранена последовательность
    public static List<String> messenger = new ArrayList<String>();

    //запуск сервера
    public static void main(String args[]) throws IOException {
        ServerSocket listener = null;
        messenger.add("start"); //первое сообщение в историю, чтобы было

        System.out.println("Server is waiting to accept user..."); //сообщение в консоль, о том что сервер начал работу
        int clientNumber = 0; //счетчик клиентов

        try {
            listener = new ServerSocket(7777); //открытие порта 7777
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        try {
            while (true) { //ожидание подключения пользователя
                Socket socketOfServer = listener.accept();
                new ServiceThread(socketOfServer, clientNumber++).start(); //создание нового потока пользователя
            }
        } finally {
            listener.close();
        }

    }

    private static class ServiceThread extends Thread {
        private int clientNumber; //номер клинта
        private Socket socketOfServer; //номер подключенного порта

        public ServiceThread(Socket socketOfServer, int clientNumber) {
            this.clientNumber = clientNumber; //номер клиента
            this.socketOfServer = socketOfServer; //номер порта
            System.out.println("New connection with client# " + this.clientNumber + " at " + socketOfServer);
        }

        @Override
        public void run() {

            try {
                //создание буфера для получения сообщений и отправки сообщений
                BufferedReader reader = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
                //выписывает сообщение из истории для новых пользователей
                writer.write(messenger.get(messenger.size()-1));
                writer.newLine();
                writer.flush();
                //цикл работы сервера
                while (true) {
                    System.out.println("Start session!"); //системное сообщение
                    String line = reader.readLine(); //чтение сообщения от пользователя
                    if (line.equals("QUIT")) {
                        writer.write("Exit");
                        writer.newLine();
                        writer.flush();
                        break;
                    }
                    messenger.add(line); //добавление сообщения в список
                    int size = messenger.size(); //размер списка
                    Thread.sleep(4000); //ожидание
                    if(messenger.size() != size){ //если второй пользователя написал сообщение, то передавать его первому
                        writer.write(messenger.get(messenger.size()-1));
                        writer.newLine();
                        writer.flush();
                    } else{ //иначе нет
                        writer.write("Waiting...");
                        writer.newLine();
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}