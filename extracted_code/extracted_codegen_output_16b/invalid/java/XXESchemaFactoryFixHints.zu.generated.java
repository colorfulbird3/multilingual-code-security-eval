<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="result">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="code">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="path">
                                <xs:complexType>
                                    <xs:sequence>
                                        <xs:element minOccurs="0" name="size" type="xs:int"/>
                                        <xs:element name="content" type="xs:string"/>
                                    </xs:sequence>
                                </xs:complexType>
                            </xs:element>
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>