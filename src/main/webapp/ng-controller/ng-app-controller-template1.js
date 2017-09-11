app.controller('ng-app-controller-template1', ['$scope', '$http', function ($scope,
            $http)
    {
        console.log('Controler pagina 1');
        $scope.mensaje = 'Texto cargado desde el controlador Pagina1Controller ';
       
       
        //Peticion ajax, nombre del controlador test, + el objeto
        $http.post('/test',
                {
                    text: 'hello'
                })
                //Respuesta, siempre es response.data
                .then(function (response)
                {
                    console.log('Contenido response.data ' + JSON.stringify(response.data));

                    //$scope.mensaje = JSON.stringify(response.data);
                    var datos = (response.data);

                    for (var i = 0, max = datos.length; i < max; i++) {
                        $scope.mensaje += (datos[i].table);
                    }
                    $scope.mensaje += ' ajax completado ';

                });

    }]);