@Path("hello")
@GET
public String hello() {
    return "Hello, World!";
}

@Path("bye")
@GET
public String bye() {
    return "Bye, World!";
}