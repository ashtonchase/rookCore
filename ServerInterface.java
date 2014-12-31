package rookCore;

/**
 * Created by ashton on 12/29/14.
 */

/** server should implement 4 clientHandler threads, using a thread pool
 * can be implemented with a for loop of size index size for, in which each
 *
 * for (int i = 0; i <  threadPoolSize; i++) {
24        Thread thread = new Thread() {
25          public void run() {
26            while (true) {
27              try {
28                Socket clntSock = servSock.accept(); // Wait for a connection
29                 // Please code here to handle connection
30              } catch (IOException ex) {
31                logger.log(Level.WARNING, "Client accept failed", ex);
32              }
33            }
34          }
35        };
36        thread.start();
37        logger.info("Created and started Thread = " +  thread.getName());




 Proablt could use an EXEcutor service

 0  import java.io.IOException;
 1  import java.net.ServerSocket;
 2  import java.net.Socket;
 3  import java.util.concurrent.Executor;
 4  import java.util.concurrent.Executors;
 5  import java.util.logging.Logger;
 6
 7  public class TCPEchoServerExecutor {
 8
 9    public static void main(String[] args) throws IOException {
10
11      if (args.length != 1) { // Test for correct # of args
12        throw new IllegalArgumentException("Parameter(s): <Port>");
13      }
14
15      int echoServPort = Integer.parseInt(args[0]); // Server port
16
17      // Create a server socket to accept client connection requests
18      ServerSocket servSock = new ServerSocket(echoServPort);
19
20      Logger logger = Logger.getLogger("practical");
21
22      Executor service = Executors.newCachedThreadPool();  // Dispatch svc
23
24      // Run forever, accepting and spawning a thread for each connection
25      while (true) {
26        Socket clntSock = servSock.accept(); // Block waiting for connection
27        service.execute(new EchoProtocol(clntSock, logger));
28      }
29      /* NOT REACHED
30    }
31  }









 */



public interface ServerInterface {

    /** ListenerPort will always be 5066 on the server side. This may not be the port on the client side. */
    static final int ListenerPort=5066;


    public void initializeSocket();

    public void clientListener();

    public void clientConnect();

    public void spawnClientThread();



}
