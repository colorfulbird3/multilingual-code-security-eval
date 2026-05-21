
     */
    @Override
    public void postProcessResponse(HttpResponse response) {
        response.getWriter().write("<pre>" + response.getContentAsString() + "</pre>");
    }
}
