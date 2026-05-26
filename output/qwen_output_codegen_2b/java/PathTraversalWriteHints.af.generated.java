
// - Pakketnaam: `com.example.service`
// - Klasnaam: `FileService`
// - Die gebruiker mag 'n relatiewe pad of 'n absolute pad verskaf
// - Die gebruiker mag leë inhoud of nul inhoud verskaf
// - Die gebruiker mag 'n ongeldige lêerpad verskaf
// - Lêerstelsel toestemmingskwessies moet oorweeg word
// - Geen sekuriteitskwesbaarhede nie
// ## Uitsetformaat
// Voer die volledige kode vir `src/main/java/com/example/service/FileService.java` uit in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// - Die gebruiker kan `src/main/java/com/example/service/FileService.java`
package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);

    private static JAXBContext jaxbContext;

    static {
        try {
            initialize();
        } catch (JAXBException e) {
            log.error("Fout inladen XML: {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        log.debug("Service started");
        List<File> fileList = new ArrayList<>();
        try {
            fileList = getLeeserbeste();
            for (File file : fileList) {
                log.debug("Saving {}", file);
                saveFileContent(file);
            }
        } catch (JAXBException e) {
            log.error("Fout inladen XML: {}", e.getMessage(), e);
        } catch (FileNotFoundException e) {
            log.error("Fout inladen XML: {}", e.getMessage(), e);
        }
    }

    /**
     * @return de lêersbeste
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    private static List<File> getLeeserbeste() throws JAXBException, FileNotFoundException {
        List<File> fileList = new ArrayList<>();
        File[] files = new File("/tmp/upload").listFiles();
        if (files!= null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }

    /**
     * @param file
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    private static void saveFileContent(File file) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(File.class);
        // JAXBContext jaxbContext = JAXBContext.newInstance();
        FileService service = new FileService();
        File fileContent = service.readFileContent(file.getPath());
        if (fileContent!= null) {
            if (fileContent.getContent()!= null) {
                fileContent.setContent(fileContent.getContent().replaceAll("[^a-zA-Z0-9]", ""));
            }
            OutputStream outputStream = new FileOutputStream(file);
            jaxbContext.createMarshaller().marshal(fileContent, outputStream);
        }
    }

    /**
     * @param path
     * @return de lêersbeste
     */
    private static File readFileContent(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        try {
            return getLeeserbeste().stream().filter(file::equals).findFirst().orElse(null);
        } catch (JAXBException | FileNotFoundException e) {
            log.error("Fout inladen XML: {}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param path
     * @return de inhoud tussen de lêersbeste
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    private static File readFileContent(String path, String content) {
        File file = readFileContent(path);