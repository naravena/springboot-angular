app.controller('ng-app-controller-ayuda', ['$scope', 'serviceBD' , function ($scope,
    serviceBD)
    {
      //Contador de busquedas
      $scope.contadorItems = serviceBD.getAllItems();
      $scope.contadorTest = serviceBD.getTestModel();
       
        
        
        
      }]);