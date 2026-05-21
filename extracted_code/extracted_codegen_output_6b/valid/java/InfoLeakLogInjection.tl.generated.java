public class UserProfileService {
            public void processUserProfile(String userId) {
                UserProfile userProfile = new UserProfile(userId, username, idCard, phoneNumber);
                logger.info(userProfile.toString());
            }
        }