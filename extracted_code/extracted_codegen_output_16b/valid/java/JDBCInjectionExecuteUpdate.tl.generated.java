package com.example.service;

            public class ProductService {

                private String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
                private String username = "root";
                private String password = "@#Heydg_3^53s";
                private Connection connection;

                public ProductService() {
                    try {
                        connection = DriverManager.getConnection(url, username, password);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }