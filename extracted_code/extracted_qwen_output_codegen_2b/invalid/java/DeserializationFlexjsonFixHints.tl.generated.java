```java
@Override
public String toString() {
    return "UserPreferences{" +
            "theme='" + theme + '\'' +
            ", language='" + language + '\'' +
            ", notificationLevel=" + notificationLevel +
            '}';
}

public String getTheme() {
    return theme;
}

public String getLanguage() {
    return language;
}

public int getNotificationLevel() {
    return notificationLevel;
}

@Override
public int hashCode() {
    int result = theme != null ? theme.hashCode() : 0;
    result = 31 * result + (language != null ? language.hashCode() : 0);
    result = 31 * result + notificationLevel;
    return result;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserPreferences that = (UserPreferences) o;
    return notificationLevel == that.notificationLevel &&
            Objects.equals(theme, that.theme) &&
            Objects.equals(language, that.language);
}
```