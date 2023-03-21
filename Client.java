import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            ServerInterface server = (ServerInterface) Naming.lookup("Server");

            String[] functionList = server.getFunctionList();
            System.out.println("Available functions:");
            for (int i = 0; i < functionList.length; i++) {
                System.out.println((i+1) + ". " + functionList[i]);
            }

            int choice = -1;
            while (choice < 1 || choice > functionList.length) {
                System.out.print("Enter the number of the function you want to use: ");
                choice = Integer.parseInt(System.console().readLine());
            }

            String operation = functionList[choice-1];

            System.out.print("Enter the first operand: ");
            int operand1 = Integer.parseInt(System.console().readLine());

            System.out.print("Enter the second operand: ");
            int operand2 = Integer.parseInt(System.console().readLine());

            int result = server.calculate(operation, operand1, operand2);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
