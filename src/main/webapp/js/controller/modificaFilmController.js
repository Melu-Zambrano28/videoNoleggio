app.controller("modificaFilmController", function($scope, $rootScope, $location, $http , $timeout) {

    var url = "/VideoNoleggio/controller/film/listaFilm";
    $scope.click = false;
    $scope.listaFilm = [];


    //metodo http prende due funzioni per le richiete , una per gestire i successi e i ko
    $scope.getListFilm =  function(){
        $http.get(url).then(function(response){
            $scope.listaFilm = response.data;
            console.log($scope.listaFilm);

        },
        
        function(response){
            console.log("ciao");
        });
    }


    //carica quando carica il controller, quindi anche la pagina
    $scope.getListFilm();

    $scope.mostra = function(){
        $scope.click = true;
    }

});