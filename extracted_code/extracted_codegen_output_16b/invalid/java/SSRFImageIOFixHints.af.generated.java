<h2>Toepassing naar ImageService.java</h2>
            private ImageService() {
                throw new Error("Util class: " + this.getClass().getSimpleName() + " should not be instantiated.");
            }