public Function<String, Void> deserializeFunction() {
    return new Function<String, Void>() {
        @Override
        public Void apply(String from) {
            System.out.println(from);
            return null;
        }
    };
}

public static void main(String[] args) {
    try {
        Function<String, Void> deserializeFunction = deserializeFunction();
        deserializeFunction.apply("test");
    } catch (NullPointerException e) {
        System.out.println("Niekulawe");
    }
}