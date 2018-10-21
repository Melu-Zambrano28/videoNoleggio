
app.controller("addFilmController", function($scope, $rootScope, $location, $http , $timeout) {
    var film ;
    $scope.messaggio = "";
    $scope.showAlert = false;
    $scope.error = false;
    $scope.close = false; 
    $scope.class = '';
    $scope.vm = this;
    
    


   $scope.salvaFilm = function(){
       var url = "/VideoNoleggio/controller/film/aggiungiFilm";
        film = {
            nome: $scope.nome,
            descrizione : $scope.descrizione,
            prezzo : $scope.prezzo,
            tipo : $scope.tipo,
            quantita: $scope.quantita


        }

        $http.post(url,film)
            
        .then(function(response) {
            $response = response;


                if(response.status == 200){


                    //messagio di successo
                    if(response.data.status ===  false){
                        $scope.showAlert = true; 
                        $scope.class = 'alert alert-success alert-dismissible';
                        $scope.messaggio = response.data.message;
                        console.log($response.data);

                    }

                    if(response.data.status){
                        $scope.error = true;
                        $scope.class = 'alert alert-danger';
                        $scope.messaggio = response.data.message;
                    }
                   

                }

          
        }  , 
        function(response) {
            $scope.error = true;
            $scope.class = 'alert alert-danger';
            $scope.messaggio = "Operazione non eseguita!";
        });

        $scope.getAlertClass = function() {
            return 'alert-success';
        }


        $scope.mostraMessaggio = $timeout(function() {
            $scope.showAlert = false;
            $scope.error = false;
        }, 5000);

      
    }

    $scope.restData = function(){
        $scope.showAlert = false;
        $scope.error = false;
        $scope.nome = "";
        $scope.descrizione="";
        $scope.prezzo="";
        $scope.tipo="";
        $scope.quantita="";

    }

    

  

   

});