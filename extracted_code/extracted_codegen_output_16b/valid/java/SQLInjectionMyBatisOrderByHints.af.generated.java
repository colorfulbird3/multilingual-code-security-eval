public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String getAllUsersXml() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuilder.append("<result>");
        stringBuilder.append("<code>");
        stringBuilder.append("<path>");
        stringBuilder.append("src/main/java/com/example/service/UserService.java");
        stringBuilder.append("</path>");
        stringBuilder.append("<content>");
        stringBuilder.append("<![CDATA[");
        stringBuilder.append("package com.example.service;\n");
        stringBuilder.append("\n");
        stringBuilder.append("import com.example.mapper.UserMapper;\n");
        stringBuilder.append("import com.example.model.User;\n");
        stringBuilder.append("\n");
        stringBuilder.append("/**\n");
        stringBuilder.append(" * Gebruikersdiensklaas\n");
        stringBuilder.append(" */\n");
        stringBuilder.append("public class UserService {\n");
        stringBuilder.append("\n");
        stringBuilder.append("    private UserMapper userMapper;\n");
        stringBuilder.append("\n");
        stringBuilder.append("    public UserService(UserMapper userMapper) {\n");
        stringBuilder.append("        this.userMapper = userMapper;\n");
        stringBuilder.append("    }\n");
        stringBuilder.append("    \n");
        stringBuilder.append("    /**\n");
        stringBuilder.append("     * Navraag van gebruikerslys gebaseer op die sorteerveld en -rigting wat deur die gebruiker verskaf word\n");
        stringBuilder.append("     * Geb