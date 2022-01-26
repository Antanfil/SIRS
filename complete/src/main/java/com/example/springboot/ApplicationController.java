package com.example.springboot;

import com.example.springboot.user.Association;
import com.example.springboot.user.User;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

@CrossOrigin( origins = {  "http://127.0.0.1:3000", "http://localhost:3000" })
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService AppService;

    @PostMapping(value="/test", consumes = "application/json")
    public String RegisterMobile(@RequestBody Map<String, Object> body) throws SQLException, ClassNotFoundException, NoSuchProviderException, NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(body.get("randomCode"));
        return "olá";
    }

    @PostMapping(value="/RegisterMobile")
    public ResponseEntity<String> RegisterMobile(@RequestBody String code, @RequestBody String sharedSecret) throws SQLException, ClassNotFoundException, NoSuchProviderException, NoSuchAlgorithmException {
        //return value is code to insert in
        return AppService.RegisterMobile(code,sharedSecret);
    }

    @PostMapping(value="/RegisterUser")
    public ResponseEntity<String> RegisterUser(@RequestBody Map<String , Object> payload) throws SQLException, ClassNotFoundException {
        //return value is code to insert in
        String username = payload.get("var1").toString() ;
        String password = payload.get("var2").toString() ;
        String code = payload.get("var3").toString() ;

        User userRegistration = new User( username  , password );

        return AppService.RegisterUser(userRegistration, code);
    }

    @PostMapping(value="/LogIn")
    public ResponseEntity<String> UserLogIn(@RequestBody Map<String , Object> payload) throws SQLException, ClassNotFoundException {
        String username = payload.get("var1").toString() ;
        String code = payload.get("var2").toString() ;

        User dummy = new User( "fake"  , "fake" );
        return AppService.RegisterUser(dummy, "pass");
    }
/*
    public ResponseEntity<ArrayList<Integer>> LoginMobile(@RequestBody String username, @RequestBody String passcode) throws SQLException, ClassNotFoundException, NoSuchProviderException, NoSuchAlgorithmException {
        //return value is code to insert in
        return AppService.LoginMobile(username, passcode);
    }*/

    /*@PostMapping(value="/SuccessRegisterMobile")
    public ResponseEntity<String> SuccessRegisterMobile(@RequestBody int mobile, int key) throws SQLException, ClassNotFoundException, NoSuchProviderException, NoSuchAlgorithmException {
        //return value is code to insert in
        return AppService.SuccessRegisterMobile(mobile, key);
    }*/

    /*@PostMapping(value="/RegisterWorker")
    public String RegisterWorker(@RequestBody User userRegistration, @RequestBody String code ) throws SQLException, ClassNotFoundException {
        return AppService.RegisterWorker(userRegistration, code);
    }*/
}