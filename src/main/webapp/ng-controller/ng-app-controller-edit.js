app.controller('ng-app-controller-edit', ['$scope', '$http', 'serviceBD', function ($scope,
            $http, serviceBD)
    {
	 //Peticion ajax, nombre del controlador test, + el objeto
    $http.post('/edit',
            {
                tablaBuscador: 'tablaBuscador'
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
               
               //Recorre la base de datos, devuelve el nombre de las tablas.
                for (var i = 0, max = datos.length; i < max; i++) {
                    $scope.mensaje = (datos[i].table);
                    $scope.datos = datos;
                }
                $scope.table = response.data;
                
                serviceBD.setTestModel(serviceBD.getTestModel()+1);
                
                
                
                
                
                };

            });
    }]);