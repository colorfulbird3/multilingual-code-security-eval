equalsIgnoreCase("DESC"))) {
            throw new IllegalArgumentException("Indlela yokuhlunga kufanele ibe ngu-ASC noma DESC");
        }
        
        // Hlanza i-orderBy ukuze ugweme ukuhlasela kwe-SQL injection
        String[] allowedFields = {"id", "username", "email", "phone", "address", "create_time", "update_time", "status"};
        boolean isValidField = false;
        for (String field : allowedFields) {
            if (field.equals(orderBy)) {
                isValidField = true;
                break;
            }
        }
        if (!isValidField) {
            throw new IllegalArgumentException("Inkampani yokuhlunga ayivumelekile: " + orderBy);
        }
        
        return userMapper.getUsersByOrder(orderBy, sortDirection.toUpperCase());
    }
    
    /**
     * Thola bonke abasebenzisi
     * @return Uhlu lwabasebenzisi
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
            ]]>
        </content>
    </code>
</result>
``` 
 */
public class UserService {
	
	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	/**
	 * Buza uhlu lwabasebenzisi ngokusekelwe enkambeni yokuhlunga nendawo yokuhlunga enikezwe umsebenzisi
	 * Kusetshenziswa i-MyBatis dynamic SQL ukusebenzisa umsebenzi wokuhlunga we-ORDER BY
	 * 
	 * @param orderBy Inkampani yokuhlunga
	 * @param sortDirection Indlela yokuhlunga
	 * @return Uhlu lwabasebenzisi
	 */
	public List<User> getUsersByOrder(String orderBy, String sortDirection) {
		if (orderBy == null || orderBy.trim().isEmpty()) {
			throw new IllegalArgumentException("Inkampani yokuhlunga ayikwazi ukuba null noma ingenalutho");
		}
		if (sortDirection == null || (!sortDirection.equalsIgnoreCase("ASC") &&!sortDirection.equalsIgnoreCase("DESC"))) {
			throw new IllegalArgumentException("Indlela yokuhlunga kufanele abi-DESC noma");
		}
		
		// Qaphela: Kufanele ukuzevke zivikelekile ukuze kugwenywe ukuhlasela kwe-ORDER BY
		String[] allowedFields = {"id", "username", "email", "phone", "address", "create_time", "update_time", "status"};
		boolean isValidField = false;
		for (String field : allowedFields) {
			if (field.equals(orderBy)) {
				isValidField = true;
				break;
			}
		}
		if (!isValidField) {
			throw new IllegalArgumentException("Inkampani yokuhlunga ayivumelekile: