isa i-UserService", e);
        }
    }

    /**
     * Ithola indima yomsebenzisi ngokusekelwe egameni lakhe lomsebenzisi.
     * Indlela ibuza isitolo sedatha se-XML ukuze ithole ulwazi lwendima.
     *
     * @param username Igama lomsebenzisi okufanele liseshwe.
     * @return Indima yomsebenzisi njenge-String, noma i-null uma umsebenzisi engatholakali.
     */
    public String findUserRoleByUsername(String username) {
        String role = "";
        try {
            // Yakha isisho se-XPath ukuze uthole indima yomsebenzisi.
            String expression = "//user[name='" + username + "']/role/text()";

            // Isebenzisa isisho se-XPath esakhiwe ngokuguquguqukayo.
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            return null;
        }
        return role;
    }
}
            ]]>
        </content>
    </code>
</result>
```
 */

package com.example.xpath;