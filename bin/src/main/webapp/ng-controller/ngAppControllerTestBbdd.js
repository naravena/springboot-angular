app.controller('ngAppControllerTestBbdd',
['$scope', '$http', '$timeout', 'utilFactory',
  function ($scope, $http, $timeout, utilFactory)
  {

    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/




    /**************************************************************************
     * 
     * INI
     * 
     **************************************************************************/

    $scope.testOk = false;




    /**************************************************************************
     * 
     * FUNCTIONS MODEL
     * 
     **************************************************************************/

    $scope.test = function ()
    {
      utilFactory.setContTestBBDD(utilFactory.getContTestBBDD() + 1);

      $http.post('/test',
      {
        table: 'valor enviado por POST utilizando el modelo TESTMODEL'
      })
      .then(function (response)
      {
        scopeTest(response.data);
      });
    };


    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/

    /**
     * MUESTRA LOS RESULTADOS DEL TEST.
     * 
     * @param {array} data Datos obtenidos del test.
     */
    function scopeTest(data)
    {
      $scope.testOk = true;
      $scope.bbdd = data;

      $timeout(function ()
      {
        $scope.testOk = false;
      }, 8000);
    }

  }]);