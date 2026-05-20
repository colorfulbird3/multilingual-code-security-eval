package com.example.model;

   public class User {
       private String name;
       private String email;
       private Profile profile;

       public User(String name, String email, Profile profile) {
           this.name = name;
           this.email = email;
           this.profile = profile;
       }

       // Getters and setters
   }