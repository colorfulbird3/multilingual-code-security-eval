package com.example.model;

   public class UserPreferences {
       private String theme;
       private String language;
       private int notificationLevel;

       // Default constructor is required by Flexjson
       public UserPreferences() {}

       public String getTheme() {
           return theme;
       }

       public void setTheme(String theme) {
           this.theme = theme;
       }

       public String getLanguage() {
           return language;
       }

       public void setLanguage(String language) {
           this.language = language;
       }

       public int getNotificationLevel() {
           return notificationLevel;
       }

       public void setNotificationLevel(int notificationLevel) {
           this.notificationLevel = notificationLevel;
       }

       @Override
       public String toString() {
           return "UserPreferences{" +
                   "theme='" + theme + '\'' +
                   ", language='" + language + '\'' +
                   ", notificationLevel=" + notificationLevel +
                   '}';
       }
   }