package com.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlProcessingService {

    private static final Logger logger = Logger.getLogger(XmlProcessingService.class.getName());

    public void loadSchema(String schemaContent) {
        logger.log(Level.INFO, "Load schema");
        Properties prop = new Properties();
        File file = new File("schema.properties");
        try {
            prop.load(new FileInputStream(file));
            file.delete();
            file.createNewFile();

            OutputStream output = new FileOutputStream(file);
            prop.store(output, "schema-properties");
            output.close();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    /**
     *
     * @param content
     * @throws Exception
     */
    public void loadSchema(BufferedReader content) throws Exception {
        logger.log(Level.INFO, "Load schema");
        Properties prop = new Properties();
        File file = new File("schema.properties");
        try {
            prop.load(new InputStreamReader(new FileInputStream(file)));
            file.delete();
            file.createNewFile();

            OutputStream output = new FileOutputStream(file);
            prop.store(output, "schema-properties");
            output.close();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

}