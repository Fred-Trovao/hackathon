package br.com.thesharks.hanckathon.app.controllers;

//@Controller
public class HomeController {

    //@RequestMapping(value = { "/" })
    public String homePage() {
        return "/index.html";
    }
}
