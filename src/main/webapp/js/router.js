var app = angular.module('videoNoleggio',['ngRoute', "ngCookies"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/addFilm", {
        templateUrl : "pages/addFilm.html"
        
    })

    .when("/modificaFilm", {
        templateUrl : "pages/modificaFilm.html"
        
    })
    .when("/eliminaFilm", {
        templateUrl : "pages/eliminaFilm.html"
        
    })
    .when("/addPersona", {
        templateUrl : "pages/addPersona.html"
        
    });
    
    
});