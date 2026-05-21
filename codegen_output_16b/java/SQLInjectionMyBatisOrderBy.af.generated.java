
 */
public interface UserService {
    /**
     * Get all users
     * @return User list
     */
    List<User> getAllUsers();
    
    /**
     * Query user list based on sorting field and direction provided by the user
     * Using MyBatis dynamic SQL to implement ORDER BY sorting functionality
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    List<User> getUsersByOrder(String orderBy, String sortDirection);
}
