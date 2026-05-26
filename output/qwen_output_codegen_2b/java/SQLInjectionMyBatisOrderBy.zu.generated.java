 (field.equals(orderBy)) {
// isValidField = true;
// break;
// }
// }
// if (!isValidField) {
// throw new IllegalArgumentException("Inkampani yokuhlunga ayivumelekile: " + orderBy);
// }
// return userMapper.getUsersByOrder(orderBy, sortDirection.toUpperCase());
// }
// /**
// * Thola bonke abasebenzisi
// * @return Uhlu lwabasebenzisi
// */
// public List<User> getAllUsers() {
// return userMapper.getAllUsers();
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class UserService {

  private UserMapper userMapper;

  public UserService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  // Qaphela: Kufanele uqinisekise ukuthi i-orderBy ne-sortDirection zivikelekile ukuze kugwenywe ukuhlasela kwe-SQL injection
  @XmlElement
  public List<User> getUsersByOrder(String orderBy, String sortDirection) {
    // Qaphela: Kufanele uqinisekise ukuthi i-orderBy ne-sortDirection zivikelekile ukuze kugwenywe ukuhlasela kwe-SQL injection
    if (orderBy == null || orderBy.trim().isEmpty()) {
      throw new IllegalArgumentException("Inkampani yokuhlunga ayikwazi ukuba null noma ingenalutho");
    }
    if (sortDirection == null || (!sortDirection.equalsIgnoreCase("ASC") &&!sortDirection.equalsIgnoreCase("DESC"))) {
      throw new IllegalArgumentException("Indlela yokuhlunga kufanele ibe ngu-ASC noma DESC");
    }
    return userMapper.getUsersByOrder(orderBy, sortDirection.toUpperCase());
  }

  // Qaphela: Kisamatopeko iste ileki olekisekise ukuthi i-orderBy
  @XmlElement
  public List<User> getAllUsers() {
    return userMapper.getAllUsers();
  }

  public static void main(String[] args) throws IOException {

	  UserService userService = new UserService(new UserMapper());
	  List<User> users = userService.getAllUsers();
	  for (User user : users) {
		  System.out.println("id=" + user.getId() + ", username=" + user.getUsername() + ", email=" + user.getEmail() + ", phone=" + user.getPhone() + ", address=" + user.getAddress() + ", create_time=" + user.getCreateTime() + ", update_time=" + user.getUpdateTime() + ", status=" + user.getStatus());
	  }

  }
}
