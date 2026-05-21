// Valideer sorteerrigting
        String direction = sortDirection.trim().toUpperCase();
        if (!"ASC".equals(direction) &&!"DESC".equals(direction)) {
            throw new IllegalArgumentException("Ongeldige sorteerrigting: " + sortDirection + ". Ondersteun slegs ASC of DESC");
        }
        
        // Valideer sorteerveld teen toegelate velde om SQL-inspuiting te voorkom
        String validOrderBy = validateOrderByField(orderBy.trim());
        
        return userMapper.getUsersByOrder(validOrderBy, direction);
    }
    
    /**
     * Valideer die sorteerveld om teen toegelate velde
     * @param orderBy Die sorteerveld om te valideer
     * @return Die gevalideerde sorteerveld
     * @throws IllegalArgumentException As die veld ongeldig is
     */
    private String validateOrderByField(String orderBy) {
        // Lys van toegelate velde
        String[] allowedFields = {"id", "username", "email", "phone", "address", "create_time", "update_time", "status"};
        
        for (String field : allowedFields) {
            if (field.equalsIgnoreCase(orderBy)) {
                return field;
            }
        }
        
        throw new IllegalArgumentException("Ongeldige sorteerveld: " + orderBy + ". Toegelate velde: id, username, email, phone, address, create_time, update_time, status");
    }
    
    /**
     * Kry alle gebruikers
     * @return Gebruikerslys
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}