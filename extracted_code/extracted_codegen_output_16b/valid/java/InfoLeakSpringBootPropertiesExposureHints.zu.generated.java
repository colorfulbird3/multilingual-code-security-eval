@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger log =
        LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private UserDao dao;

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        log.debug("Finding user with ID: {}", id);
        return dao.findOne(id);
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return Arrays.asList(dao.findAll());
    }
}

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private UserDao dao;

    @RequestMapping("/users")
    public List<User> getUsers() {
        return dao.findAll();
    }

    @RequestMapping("/users/