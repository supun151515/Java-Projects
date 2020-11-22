
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    public static Properties prop = new Properties();
    
    public void SaveProp(String title, String value){
        try{
            prop.setProperty(title, value);
            prop.store(new FileOutputStream(".config"), null);
            
        }catch(IOException e){
            
        }
    }
    
     public String GetProp(String title){
         String value = "";
        try{
            prop.load(new FileInputStream(".config"));
            value = prop.getProperty(title);
            
            
        }catch(IOException e){
            
        }
        return value;
    }
}
