package org.example;

import com.keepersecurity.secretsManager.core.KeeperSecrets;
import com.keepersecurity.secretsManager.core.KeyValueStorage;
import com.keepersecurity.secretsManager.core.LocalConfigStorage;
import com.keepersecurity.secretsManager.core.SecretsManager;
import com.keepersecurity.secretsManager.core.SecretsManagerOptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static com.keepersecurity.secretsManager.core.SecretsManager.initializeStorage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        KeyValueStorage storage = new LocalConfigStorage("ksm-config.json");
        try {
            SecretsManagerOptions options = new SecretsManagerOptions(storage);

            // get all available secrets
            KeeperSecrets secrets = SecretsManager.getSecrets(options);

            // print out record details
            System.out.println(secrets.getRecords().size());
            System.out.println(secrets.getRecords().get(0).getPassword());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        String publicKeyPath = "path/to/your/public_key.pem";
//
//        try {
//            // Read the public key from the file
//            String publicKeyContent = new String(Files.readAllBytes(Paths.get(publicKeyPath)))
//                    .replaceAll("\\n", "")
//                    .replace("-----BEGIN PUBLIC KEY-----", "")
//                    .replace("-----END PUBLIC KEY-----", "");
//
//            // Decode the public key
//            byte[] decodedKey = Base64.getDecoder().decode(publicKeyContent);
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PublicKey publicKey = keyFactory.generatePublic(keySpec);
//
//            // Store the public key in the Keeper storage
//            KeyValueStorage storage = new LocalConfigStorage("ksm-config.json");
//            storage.saveBytes("publicKey", publicKey.getEncoded());
//
//            // Configure SecretsManagerOptions with the storage
//            SecretsManagerOptions options = new SecretsManagerOptions(storage);
//
//            // Get all available secrets
//            KeeperSecrets secrets = SecretsManager.getSecrets(options);
//
//            // Print out record details
//            System.out.println(secrets.getRecords());
//        } catch (Exception e) {
//            System.out.println("Error connecting to Keeper: " + e.getMessage());
//            e.printStackTrace();
//        }


//        KeyValueStorage storage = new LocalConfigStorage("ksm-config.json");
//        try {
//            String onetime= "US:-NjBqdwOYbyo1d4x-O5PfyRZHO254S79D3hnWjrMX6c";
//            // after the first run, this line can be removed
////            initializeStorage(storage, onetime);
////
////            SecretsManagerOptions options = new SecretsManagerOptions(storage);
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////        }
//            SecretsManager.initializeStorage(storage, onetime);
//
//            System.out.println("Storage initialized successfully.");
//        } catch (Exception e) {
//            System.out.println("Error initializing storage: " + e.getMessage());
//        }

    }
}