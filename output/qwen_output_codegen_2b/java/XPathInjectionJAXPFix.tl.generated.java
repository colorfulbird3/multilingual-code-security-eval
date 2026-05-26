// </user>
// </users>
// ```
// ## Sample Application
// ## Using `UserService`
// ```java
// package com.example.xpath.service;
// import com.example.xpath.service.UserService;
// import java.util.List;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.servlet.view.RedirectView;
// import org.springframework.web.util.UriComponentsBuilder;
// import org.springframework.web.util.UriUtils;
// import org.w3c.dom.Document;
// import org.w3c.dom.NodeList;
// public class UsersController {
// private final UserService userService;
// private final UriComponentsBuilder ucb;
//
// public UsersController() {
// this.userService = new UserService();
// this.ucb = UriComponentsBuilder.fromHttpUrl(UriUtils
//.toHttpURI(UriComponentsBuilder.fromHttpUrl(
// "/").path("/users").build()));
// }
//
// @RequestMapping(value = "/users", method = RequestMethod.GET)
// public ModelAndView findAllUsers() {
// ModelAndView modelAndView = new ModelAndView("users");
// modelAndView.addObject("users", this.userService.findAllUsers());
// return modelAndView;
// }
//
// @RequestMapping(value = "/users/role", method = RequestMethod.POST)
// public ModelAndView rolesOfUsers(HttpServletRequest request,
// HttpServletResponse response) {
// ModelAndView modelAndView = new ModelAndView("users");
// List<User> users = this.userService.findAllUsers();
// for (User user : users) {
// String role = this.userService.findUserRoleByUsername(request
//.getParameter("username"));
// user.setRole(role);
// }
// modelAndView.addObject("users", users);
// return modelAndView;
// }
//
// @RequestMapping(value = "/users/find-role", method = RequestMethod.POST)
// public ModelAndView findUserRole(HttpServletRequest request,
// HttpServletResponse response) {
// String username = request.getParameter("username");
// return new ModelAndView(new RedirectView(this.ucb.path("/users").build()));
// }
//
// }
// ```
package com.example.xpath;
