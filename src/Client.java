
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client {

    public static void main(String[] args) throws IOException {
        try {
            DictionaryService dictionaryService = (DictionaryService) Naming.lookup("rmi://172.26.211.85:1098/DictionaryService");
            System.out.println("hi");  
            new mainUI(dictionaryService);
                   
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }    	
}
