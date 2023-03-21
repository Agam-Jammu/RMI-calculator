import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements ServerInterface {
    public Server() throws RemoteException {
        super();
    }

    public String[] getFunctionList() throws RemoteException {
        return new String[] {"+", "-", "*", "/", "%"};
    }

    public int calculate(String operation, int operand1, int operand2) throws RemoteException {
        int result = 0;
        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            case "%":
                result = operand1 % operand2;
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            Naming.rebind("Server", server);
            System.out.println("Server ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
