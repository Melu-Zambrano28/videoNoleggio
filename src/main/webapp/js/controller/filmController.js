app.controller("filmController", function($scope, $rootScope, $location, $http , $timeout) {

    var film ;
    $scope.messaggio = "";
    $scope.showAlert = false;
    $scope.error = false;
    $scope.close = false; 
    $scope.class = '';
    $scope.vm = this;

    
    var url = "/VideoNoleggio/controller/film/listaFilm";
    var eliminaUrl="/VideoNoleggio/controller/film/eliminaFilm?id=";
    var modificaFilmUrl = "/VideoNoleggio/controller/film/aggiornaFilm?id=";
    var trovaFilmByIdUrl="/VideoNoleggio/controller/film/trova-film-by-id?id=";
    $scope.click = false;
    $scope.listaFilm = [];
    $scope.filmId;
    $scope.showAlert = false;
    $rootScope.enable = false;

    

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
 
     $scope.resetData = function(){
         $scope.showAlert = false;
         $scope.error = false;
         $scope.nome = "";
         $scope.descrizione="";
         $scope.prezzo="";
         $scope.tipo="";
         $scope.quantita="";
 
     }
 

     
    //metodo http prende due funzioni per le richiete , una per gestire i successi e i ko
    $scope.getListFilm =  function(){
        $http.get(url).then(function(response){
            $scope.listaFilm = response.data;
            console.log($scope.listaFilm);
           

        },
        
        function(response){
            $scope.getResponseMessage();
          
        });

    }


    $scope.trovaFilmById=  function(){
        
        $http.get(trovaFilmByIdUrl+$scope.filmId).then(function(response){
                $scope.nomeFilmPrimaModifica = response.data.nome;
                $scope.descrizioneFilmPrimaModifica = response.data.descrizione;
                $scope.prezzoFilmPrimaModifica = response.data.prezzo;
                $scope.tipoFilmPrimaModifica = response.data.tipo;
                $scope.quantitaFilmPrimaModifica = response.data.quantita;
        
            
            console.log("TrovaFilByID: "+response);
           

        },
        
        function(response){
            console.log("TrovaFilByID: Film non trovato");
          
        });

    }


    //carica quando carica il controller, quindi anche la pagina
    $scope.getListFilm();

  


    $scope.eliminaFilm = function(){

        $http.get(eliminaUrl+$scope.filmId).then(function(response){
            console.log(response.data);
            $scope.getResponseMessage();
            location.reload();

        },
        
        function(response){
            $scope.getResponseMessage();
            
            console.log("Non eliminato");
          
        });

        

    }

    $scope.setFilmId = function(id){
        $scope.filmId = id;
    
    }

    
    $scope.aggiornaFilm =  function(){
        filmCampiModificati = {
            nome: $scope.nomeFilmPrimaModifica,
            descrizione : $scope.modificaDescrizione,
            prezzo : $scope.modificaPrezzo,
            tipo : $scope.modificaTipo,
            quantita: $scope.modificaQuantita
    
        }
        $http.post((modificaFilmUrl+$scope.filmId), filmCampiModificati).then(function(response){
            $scope.getResponseMessage(response.status);
            $scope.resetDataModificata();
            location.reload();
            
        },
        
        function(response){
            $scope.getResponseMessage(response.status);
          
            console.log("No");

          
        });

        //fa sparire i possibili messaggi di risposta
        $scope.mostraMessaggio = $timeout(function() {
            $scope.showAlert = false;
            $scope.error = false;
            $scope.enable = true;
        }, 3000);

    }

   
    


    $scope.getResponseMessage = function(response){

        if(response == 200){
            $scope.showAlert = true; 
            $scope.class = 'alert alert-success alert-dismissible';
            $scope.messaggio = "Dati modificati con successo";
           
        }else{
            $scope.error = true;
            $scope.class = 'alert alert-danger';
            $scope.messaggio = "Operazione non eseguita!";
        }

    }



    $scope.resetDataModificata =  function(){
        
        $scope.modificaDescrizione = "";
        $scope.modificaPrezzo = "";
        $scope.modificaTipo = "";
        $scope.modificaQuantita = "";
    }

    







});