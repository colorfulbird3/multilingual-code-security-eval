package com.example.config.bean;
/**
* A simple data object representing user preferences.
* This class is used as a data transfer object for configuration.
*/
public class UserPreferences {
private String username;
private String theme;
private int fontSize;
/**
* Default constructor required for deserialization frameworks.
*/
public UserPreferences() {
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getTheme() {
return theme;
}
public void setTheme(String theme) {
this.theme = theme;
}
public int getFontSize() {
return fontSize;
}
public void setFontSize(int fontSize) {
this.fontSize = fontSize;
}
}