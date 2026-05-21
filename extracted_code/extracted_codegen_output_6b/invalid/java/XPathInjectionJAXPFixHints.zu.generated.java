String role = "";
        try {
            // Yakha isisho se-XPath ukuze uthole indima yomsebenzisi.
            String expression = "//user[name='" + username + "']/role/text()";

            // Isebenzisa isisho se-XPath esakhiwe ngokuguquguqukayo.
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            // Lokhu kungenzeka nge-syntax ye-XPath engavumelekile
            // Ukuze kube lula, sibuyisela i-null.
            return null;
        }
        return role;
    }
}