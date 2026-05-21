<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="result">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="code">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="path" type="xs:string"/>
                            <xs:element name="content">
                                <xs:simpleType>
                                    <xs:restriction base="xs:string">
                                        <xs:pattern value=".*"/>
                                    </xs:restriction>
                                </xs:simpleType>
                            </xs:element>
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>