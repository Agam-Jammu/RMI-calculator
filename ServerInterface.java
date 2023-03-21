import java.rmi.*;

public interface ServerInterface extends Remote {
    public String[] getFunctionList() throws RemoteException;
    public int calculate(String operation, int operand1, int operand2) throws RemoteException;
}
