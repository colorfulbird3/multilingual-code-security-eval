```xml
<select id="getUsersByOrder" resultType="User">
    SELECT * FROM users
    <where>
        <if test="orderBy != null and orderBy != ''">
            ORDER BY #{orderBy} #{sortDirection}
        </if>
    </where>
</select>
```