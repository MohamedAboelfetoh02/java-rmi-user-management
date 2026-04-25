import java.rmi.*;
import java.util.List;

public interface HelloInterface extends Remote {
    String say() throws RemoteException;
    int addNumbers(int a, int b) throws RemoteException;
    int calculateVolume(MyObject o) throws RemoteException;

    void addUser(User user) throws RemoteException;
    boolean deleteUser(String name) throws RemoteException;
    User getUserDetails(String name) throws RemoteException;
    List<User> getAllUsers() throws RemoteException;
    boolean modifyUser(String name, User updatedUser) throws RemoteException;

    void shutdown() throws RemoteException;
}