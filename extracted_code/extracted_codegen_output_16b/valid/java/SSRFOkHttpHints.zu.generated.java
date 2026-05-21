public class WebContentService {
        @GET
        @Path("/{uri}")
        public String fetchUrlContent(@PathParam("uri") String uri) throws IOException {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(uri).build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }