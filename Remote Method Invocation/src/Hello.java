import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class Hello extends UnicastRemoteObject implements HelloInterface {
    private String message;
    private Map<String, User> users = new HashMap<>();

    public Hello(String msg) throws RemoteException {
        this.message = msg;
    }

    public String say() throws RemoteException {
        return message;
    }

    public int addNumbers(int a, int b) throws RemoteException {
        return a + b;
    }

    public int calculateVolume(MyObject o) throws RemoteException {
        return o.getLength() * o.getHeight() * o.getBreadth();
    }

    public void addUser(User user) throws RemoteException {
        users.put(user.getName(), user);
    }

    public boolean deleteUser(String name) throws RemoteException {
        return users.remove(name) != null;
    }

    public User getUserDetails(String name) throws RemoteException {
        return users.get(name);
    }

    public List<User> getAllUsers() throws RemoteException {
        return new ArrayList<>(users.values());
    }

    public boolean modifyUser(String name, User updatedUser) throws RemoteException {
        if (users.containsKey(name)) {
            users.put(name, updatedUser);
            return true;
        }
        return false;
    }

    public void shutdown() throws RemoteException {
        System.out.println("Shutdown requested remotely.");
        System.exit(0);
    }
}