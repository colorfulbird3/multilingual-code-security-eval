core/service/UserProfileService.java` sa sumusunod na format:
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
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/core/model/UserProfile.java` sa sumusunod na format:
// ```java
// package com.example.core.model;
// public class UserProfile {
// private String userId;
// private String username;
// private String idCard;
// private String phoneNumber;
// public UserProfile(String userId, String username, String idCard, String phoneNumber) {
// this.userId = userId;
// this.username = username;
// this.idCard = idCard;
// this.phoneNumber = phoneNumber;
// }
// public String getUserId() {
// return userId;
// }
// public void setUserId(String userId) {
// this.userId = userId;
// }
// public String getUsername() {
// return username;
// }
// public void setUsername(String username) {
// this.username = username;
// }
// public String getIdCard() {
// return idCard;
// }
// public void setIdCard(String idCard) {
// this.idCard = idCard;
// }
// public String getPhoneNumber() {
// return phoneNumber;
// }
// public void setPhoneNumber(String phoneNumber) {
// this.phoneNumber = phoneNumber;
// }
// }
// ```
// ## Other Notes
// - UserProfileService.java
// - UserProfile.java
// - UserProfileQuery.java
// - UserProfileQuery.java
// - UserProfileService.java
package com.example.core.service;

import com.example.core.model.UserProfile;

public interface UserProfileService {
    public void processUserProfile(String userId);
}