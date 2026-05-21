@Override
    public Object loadConfig(String jsonConfig) {
        final FlexjsonBinder binder = new FlexjsonBinder();
        final Configuration configuration = binder.fromJson(jsonConfig, Configuration.class);
        return configuration;
    }