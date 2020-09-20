package BuildHelp;

import Components.page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import Index.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Index {

    public static void main(String[] args){
        JFrame WS = new JFrame();
        try {
            FileOutputStream abc = new FileOutputStream("abc.json");
            String x = "{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"flutter-builder\",\n" +
                    "  \"private_key_id\": \"74805c9e02ce87f5062633f264f41387833880f1\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCsY5OVXUZQBT8V\\nd3FcrFqqa5qVTBpJXKjQaO97T7C1jRJVpyaOMSzv3oNzi+jNBY6YGKDFPjW2C9jy\\nABgdGI4Mem69TcbtYtID3KFifxOfc6UT5AdDyWXTftHNQfD37EzxiU3udB5EuIMp\\npzKDAh5lmH3puqs+atuG+5+s60N7l3FK835SCsIYEr1kdUDRIWnaW8OEzf9fWk/B\\nVgQ4A+7dalCYr+KiHJcM6hv9qFuWkJviTigoS9Fx77+o+gFFIEGQEUr3tXCZcZZp\\nFslYYp0PZyg9MWFXRldm2SKq57LbdJ7jyuvEMcNtV4ZZx6fA0xuv7J0GRYdS5xst\\n16Gb1v89AgMBAAECggEACO550YXNJE05SP/wwCfv5J+BmVWhkQZ7epzNN5rX4Xgn\\nKIfp//j9RopFTkHD9IdirW+tOLrx5nYzrcoidbN1fKEFRsqWUWtKzUdrlyJVXnAL\\n7/1jAPiYzX3nGdbeSMIV9He0MXQTs2TJ6ukOPWppL8NYVrlEsQ2xRQuZaMihrPAE\\nSJl/M8h2xRFJRyEr4O3z8T0lnYjxLOK6lQHAIzFIDo2/5XbosaWx2n4WVc+5VDXb\\nt9NuGa2/Wua9LUrbTbUhSoIs+eq6OU884ti39K+XaC3yHzGz+U4pQYNKQgIrZRcX\\nGDHkdvYOTvZ+pumF9YfG2i0fCqthJvnzC6TtNCvugQKBgQDwG66jtv/FIrVBtWKO\\nq7lJx1DNWDF29PVy0W+uIviwIfOGoNmhwGK67dpW9WZKjn89NCMh+oGbFA4rczLK\\nazoDZpkTusS2+/05f+pxZ1TLpyeq8HfVHkFFBq6IcDYEvUdTMPi8u15x97EolKoC\\nNXZax24xOu7XEo0Ltpd/cWTy/QKBgQC3zHtXSTpehAs9c9rdt1gmxR3SMpnXLXH7\\n5/76q+AjfWRIk3bxkCiAFsXSO9xZfXEpxxMXli8pid3NqGl+Dk2bo9YeumFkAKNb\\nNUaFJcAxZqNdGJC/OeBs/Gq0XlK6k3QJ+KMDR4ORnk1RQvkD0ga86nTBFKCgKmeN\\n5PNk2CSRQQKBgGMh6r6pJXyM0e0pKGHjQILXieLeEL4ecOBQ3B03TxnZSqRA8Nm5\\nhonK/iR8+Ri7MIliZ0b2GGCgrSD/VO8BylfxGi5tJB6wd2IwD+l2Uioq/1OyKKeS\\n8DvBgHnQal0WkMYmJ+w0J9BCBaDNkEuNKypbwIEO5eFiRV2aq33woU85AoGBAKYQ\\n3Yh6I4DucXFu0lvtono1M8KN8a4X45slfJ5k2Tl3vDpO8vNDuzQwX0Ca0XcR/kMv\\nGbMAAVDYvk1pUxeQONLdb0OIRyKh6Pcp5bO77jE0eXpODcqZsosGbirV5o2pWPkB\\na9g0r03M6DL5/iBTjb73X9JsnszYQ4RTTw7YtAGBAoGAcBhCLYNxPIOUyZE2VECN\\nIis2wsKo0bLsqfmE/SGUuZQkVvfVkCTCc6y9LCd/vxuNUU/KdgFw2R9vOYZwla1E\\n2H3f0NYH0rJEGoT+LNdluZaDnpkV6sPDSnIInM+jfB98A0WDr4vTTEDAT4RHHqPQ\\nAIoU6ylMpSJRNqDXG46BWKI=\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-4ympb@flutter-builder.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"103278038781226813056\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-4ympb%40flutter-builder.iam.gserviceaccount.com\"\n" +
                    "}\n";
            abc.write(x.getBytes());
            abc.close();
            FileInputStream serviceAccount = new FileInputStream("./abc.json");
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://flutter-builder.firebaseio.com").build();
            FirebaseApp.initializeApp(options);
            WS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            WS.setLayout(new BorderLayout());
            WS.setMinimumSize(new Dimension(400,550));
            WS.setResizable(false);
            WS.getContentPane().setBackground(Color.DARK_GRAY);
            //new page("s0bYTvclMaOmRMMu2crH5ODFbyF2", 1, 1);
            //new signin(WS);
            new PageEdit(WS, "s0bYTvclMaOmRMMu2crH5ODFbyF2", "Atishay Jain", 2, 1, "Hello ATISHAY", 1);
            WS.setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(WS,"Cannot run, Internet not accessible");
        }


    }
}
