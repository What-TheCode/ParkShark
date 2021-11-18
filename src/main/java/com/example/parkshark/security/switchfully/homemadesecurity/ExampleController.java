//package com.example.parkshark.security.switchfully.homemadesecurity;
//
//
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("example")
//public class ExampleController {
//    @GetMapping
//    public String getAnonymous() {
//        return "OK, anonymous";
//    }
//
//    @GetMapping("manager")
//    @com.switchsecure.SecurityGuard(com.switchsecure.SecurityGuard.ApiUserRole.MANAGER)
//    public String getSecuredAdmin() {
//        return "OK, manager";
//    }
//
//    @GetMapping("member")
//    @com.switchsecure.SecurityGuard(com.switchsecure.SecurityGuard.ApiUserRole.MEMBER)
//    public String getSecuredCustomer() {
//        return "OK, member";
//    }
//}
