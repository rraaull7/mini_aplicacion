package es.fplumara.dam1.textapp.config;

import es.fplumara.dam1.textapp.exceptions.ConfigException;
import es.fplumara.dam1.textapp.files.StoreType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppConfig {

    private String storeType;
    private String messagesFile;
    private int maxLength;

    public String getStoreType() {
        return storeType;
    }

    public String getMessagesFile() {
        return messagesFile;
    }

    public int getMaxLength() {
        return maxLength;
    }
    public StoreType AppConfig() throws IOException {

        Path path = Path.of("C:\\Users\\RaúlDeMiguelJuan\\aplicacionmini\\data\\config.properties");
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(path)) {
            properties.load(in);
        } catch (IOException e) {
            throw new ConfigException(" NO SE HA PODIDO LEER CONFIG.PROPERTIES");
        }



        storeType = properties.getProperty("store.type");
        messagesFile = properties.getProperty("messages.file");
        maxLength = Integer.parseInt(properties.getProperty("messages.MaxLenght"));


        public StoreType getStoreType() {
            try {
                return StoreType.valueOf(storeType);
            }catch (IllegalArgumentException e){
                throw new ConfigException("Tipo NO VAlido" + storeType);
            }

        }
    }



}

