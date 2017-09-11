app.controller('ng-app-controller-template2', ["$scope", function ($scope)
  {
      
    console.log('Controlador página 2')
    $scope.mensaje = "Texto cargado desde el controlador Pagina2Controller";
    $scope.hola = "Primer mensajito desde controlador, hola";
    $scope.adios = "Segundo mensajito desde controlador, adios";
   
  }]);