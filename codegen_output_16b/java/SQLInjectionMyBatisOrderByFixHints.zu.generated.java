```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/UserService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.util.List;

/**
 * Iklasi yesevisi yomsebenzisi
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Buza uhlu lwabasebenzisi ngokusekelwe enkambeni yokuhlunga kanye nesiqondiso sokuhlunga esinikezwe umsebenzisi
     * Sebenzisa umsebenzi wokuhlunga nge-order usebenzisa i-MyBatis dynamic SQL
     * 
     * @param orderBy Inkomba yokuhlunga
     * @param sortDirection Isiqondiso sokuhlunga
     * @return Uhlu lwabasebenzisi
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NoEqualsAndHashCode
public class Result {
	@JsonProperty("code")
	private Code code;

	@JsonProperty("result")
	private Result result;

	@JsonIgnore
	public Code getCode() {
		return code;
	}

	@JsonIgnore
	public void setCode(Code code) {
		this.code = code;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
