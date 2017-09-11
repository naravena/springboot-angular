app.controller('ng-app-controller-bbdd', ['$scope', '$http', 'serviceBD', function ($scope,
            $http , serviceBD)
    {
        console.log('Controler base de datos');
        $scope.mensaje = 'Texto cargado desde el controller bbdd ';
        
        //Mostrar boton
        $scope.mostrar = false;

        //Peticion ajax, nombre del controlador test, + el objeto
        $http.post('/test',
                {
                    text: 'hello'
                })
                //Respuesta, siempre es response.data
                .then(function (response)
                {
                    console.log('Contenido response.data ' + JSON.stringify(response.data));

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
                    $scope.tabla = response.data;
                   
                    serviceBD.setTestModel(serviceBD.getTestModel()+1);
                    
                    };

                });

    }]);

