app.controller('ng-app-controller-edit', ['$scope', '$http', 'serviceBD', function ($scope,
            $http, serviceBD)
    {
	
	var tablaBuscador = document.querySelector('#tablaBuscador');
	
	//Esconder botton editar
	$scope.editButton = true;
    
	console.log("Contenido tabla buscador:" + tablaBuscador);
	 //Peticion ajax, nombre del controlador test, + el objeto
    $http.post('/getTableName',
            {
                tablaBuscador: tablaBuscador.value
            })
            //Respuesta, siempre es response.data
            .then(function (response)
            {
                console.log('Contenido response.data (test) ' + JSON.stringify(response.data));

               // $scope.mensaje = JSON.stringify(response.data);
                var datos = (response.data);
                
    $scope.bbdd = function () {
    	
                //Esconde botón
               $scope.mostrar = true;
               //Muestra edit
               $scope.editButton = false;
               
               
               //Recorre la base de datos, devuelve el nombre de las tablas.
                for (var i = 0, max = datos.length; i < max; i++) {
                    $scope.mensaje = (datos[i].table);
                    $scope.datos = datos;
                }
                $scope.data = response.data;  
                serviceBD.setTestModel(serviceBD.getTestModel()+1);
            
                };

            });
    
    /**
     * Peticion ajax, que envia un string, que es el nombre de la tabla elegida, 
     * y devuelve los contenidos de esa tabla.
     */
    $scope.editbbdd = function () {
    	
    	
    	$http.post('/getAllItemsFromTable',
                {
                    table: tablaBuscador.value
                })
                .then(function (response)
                {  
                    var items = (response.data);
                    $scope.items = items;
                    console.log("CONTENIDO DE ITEMS:" + JSON.stringify(items))
                    console.log(tablaBuscador)
                });    			
    		};
    		
    
    }]);