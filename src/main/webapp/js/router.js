var app = angular.module('videoNoleggio',['ngRoute', "ngCookies"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/addFilm", {
        templateUrl : "pages/addFilm.html"
        
    })

    .when("/gestioneFilm", {
        templateUrl : "pages/gestioneFilm.html",
       
        
    })
    .when("/eliminaFilm", {
        templateUrl : "pages/eliminaFilm.html"
        
    })
    .when("/addPersona", {
        templateUrl : "pages/addPersona.html"
        
    });
    
    
});