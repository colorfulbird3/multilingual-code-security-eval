 * Buza uhlu lwabasebenzisi ngokusekelwe kumkhakha wokuhlunga kanye nezinkomba zokuhlunga ezinikezwe umsebenzisi
     * Usebenzisa i-MyBatis dynamic SQL ukuze usebenzise ukuhlunga okuguqukayo
     * 
     * @param orderBy Umkhakha wokuhlunga
     * @param sortDirection Inkomba yokuhlunga
     * @return Uhlu lwabasebenzisi
     */
    List<User> getUsersByOrder(@Param("orderBy") String orderBy, @Param("sortDirection") String sortDirection);
    
    /**
     * Thola bonke abasebenzisi
     * @return Uhlu lwabasebenzisi
     */
    List<User> getAllUsers();
}
```

Ukuqaliswa kye-UserMapper.xml:
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mapper.UserMapper">

  <select id="getUsersByOrder" resultType="User">
    SELECT *
    FROM users
    ORDER BY #{orderBy} #{sortDirection}
  </select>

  <select id="getAllUsers" resultType="User">
    SELECT *
    FROM users
  </select>

</mapper>
```

Zinhulu kufanele isebenze kahle noma ngabe izinto ezifakiwe zinezinhlamvu ezikhethekile, amanothi izingafanyiso izinhuqashe ukuze ugweme imibuzo engadingekile yesizindalwazi.