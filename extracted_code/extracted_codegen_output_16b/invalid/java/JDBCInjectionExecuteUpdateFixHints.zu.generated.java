<bean id="configuration.code" class="org.apache.camel.component.xmlsecurity.api.XmlSignatureConfiguration">
        <property name="propagateSignatureConfirmation" value="false" />
        <property name="signatureId" value="${property.signatureId}" />
        <property name="omitXmlDeclaration" value="${property.omitXmlDeclaration}" />
        <property name="outputXmlEncoding" value="${property.outputXmlEncoding}" />
        <property name="inputXmlEncoding" value="${property.inputXmlEncoding}" />
        <property name="parentLocalName" value="${property.parentLocalName}" />
        <property name="parentNamespace" value="${property.parentNamespace}" />
        <property name="xpathsToIdAttributes" value="${property.xpathsToIdAttributes}" />
        <property name="objectFactory" ref="objectFactory" />
        <property name="outputNodeSearch" value="${property.outputNodeSearch}" />
        <property name="schemaResourceUri" value="${property.schemaResourceUri}" />
        <property name="signatureAlgorithm" value="${property.signatureAlgorithm}" />
        <property name="digestAlgorithm" value="${property.digestAlgorithm}" />
        <property name="signatureId" value="${property.signatureId}" />
        <property name="digestValue" value="${property.digestValue}" />
        <property name="namespaces" value="${property.namespaces}" />
        <property name="keyAccessor" ref="keyAccessor" />
        <property name="canonicalizationMethod" ref="canonicalizationMethod" />
        <property name="prefixForXmlSignatureNamespace" value="${property.prefixForXmlSignatureNamespace}" />
        <property name="parentLocalName" value="${property.parentLocalName}" />
        <property name="parentNamespace" value="${property.parentNamespace}" />
        <property name="algorithm" value="${property.algorithm}"