
app.controller("addFilmController", function($scope, $rootScope, $location, $http , $timeout) {
    $scope.messaggio = "";
    $scope.showAlert = false;
    $scope.error = false;
    $scope.close = false; 
    $scope.class = '';
    
    


   $scope.salvaFilm = function(){
       var url = "/VideoNoleggio/controller/film/aggiungiFilm";
        var film = {
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
                    $scope.showAlert = true;
                    $scope.class = 'alert alert-success alert-dismissible';
                    $scope.messaggio = "Operazione eseguita!";

                }

          
        }   
        
        ).catch(function(error){
            $scope.error = true;
            $scope.class = 'alert alert-danger';
            $scope.messaggio = "Operazione non eseguita controlla i campi";
        });

        $scope.getAlertClass = function() {
            return 'alert-success';
        }


        $scope.mostraMessaggio = $timeout(function() {
            $scope.showAlert = false;
            $scope.error = false;
        }, 3000);

      
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