import java.io.Console;

public class Session {

    public void start() {
        Console cons = System.console();
        String request = cons.readLine(">");
        double ans = 0;

        while(!request.equals("exit")) {
            String[] requestArray = request.split(" ");

            if(requestArray[0].equals("$last")) {
                requestArray[0] = Double.toString(ans);
            } else if (requestArray[2].equals("$last")) {
                requestArray[2] = Double.toString(ans);
            }

            if(requestArray[1].equals("+")) {
                ans = Double.parseDouble(requestArray[0]) + Double.parseDouble(requestArray[2]);
                System.out.println(ans);
            } else if(requestArray[1].equals("-")) {
                ans = Double.parseDouble(requestArray[0]) - Double.parseDouble(requestArray[2]);
                System.out.println(ans);
            } else if(requestArray[1].equals("*")) {
                ans = Double.parseDouble(requestArray[0]) * Double.parseDouble(requestArray[2]);
                System.out.println(ans);
            } else if(requestArray[1].equals("/")) {
                ans = Double.parseDouble(requestArray[0]) / Double.parseDouble(requestArray[2]);
                System.out.println(ans);
            } else {
                System.err.println("Wrong operator detected. Please only input + - * /");
            }

            request = cons.readLine(">");
        }
        
        System.out.println("Bye bye");

        
    }
    
}
