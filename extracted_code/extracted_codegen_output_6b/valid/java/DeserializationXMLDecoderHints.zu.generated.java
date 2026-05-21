public class ConfigurationLoaderService {

    /**
     * Fetches the user configuration from the specified file.
     *
     * @param file the configuration file
     * @return UserPreferences object
     */
    public UserPreferences loadConfiguration(File file) {
        if (!file.exists()) {
            throw new RuntimeException("Given file does not exist: " + file.getAbsolutePath());
        }

        try (
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        ) {

            Object object = inputStream.readObject();
            if (object instanceof UserPreferences) {
                return (UserPreferences) object;
            }

            throw new RuntimeException("Could not find configuration file");
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}