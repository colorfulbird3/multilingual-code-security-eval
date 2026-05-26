.service;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class SchemaManagerService {

    private final JdbcTemplate jdbcTemplate;

    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addProductColumn(String columnName, String columnType) {
        String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add column '" + columnName + "' of type '" + columnType + "' to products table.", e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```


## Response

The successful response is a [result](#response-result) object.

## Error

If the request fails, the response is a [result](#response-result) object with an error code and an optional message.

- **code**: the error code.
    - **400**: invalid request
    - **401**: unauthorized
    - **404**: resource not found
    - **405**: resource not allowed
    - **410**: resource already exists
- **message**: the error message.
"""

from __future__ import absolute_import
from.resource import CollectionResourceBase, ResourceBase
from.. import request_parser, response_builder, error

__all__ = ['SchemaManagerService']


class SchemaManagerService(CollectionResourceBase):
    """
    This is the SchemaManager service.
    """
    def __init__(self):
        self.reqparse = request_parser()
        super(SchemaManagerService, self).__init__()

    def get(self):
        return list(self.resources())

    def post(self):
        args = self.reqparse.parse_args()

        try:
            self.resources().create(**args)
        except Exception as e:
            return error.format_exception(
                e,
                target='resource',
                action='POST'
            )

        response = {
           'result':'success'
        }
        return response_builder.build(response, 201)

    def put(self):
        args = self.reqparse.parse_args()
        return self.resources().update(**args)

    def delete(self):
        return self.resources().delete()
