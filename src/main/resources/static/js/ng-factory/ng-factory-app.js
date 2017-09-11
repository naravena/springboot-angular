app.factory('serviceBD', function ()
{
    var serviceBD =
                {   
                contadorItems: 0,
                getAllItems: function () {
                    return this.contadorItems;
                },

                setAllItems: function (contadorItems) {
                    return this.contadorItems = contadorItems;
                },
                contadorTest: 0,
                getTestModel: function () {
                    return this.contadorTest;
                },

                setTestModel: function (contadorTest) {
                    return this.contadorTest = contadorTest;
                },
                /*
                 * Comprueba si el valor escrito en el buscador es de tipo numérico, 
                 * usando la funcion 'isNan'. Si es string, es TRUE, y
                 * utiliza la cadena '/item' que es el controlador string.
                 * Si es numérico devuelve FALSE, devuelve '/itemNum' que es el 
                 * controlador numérico.
                 * 
                 * @param {type} value
                 * @returns {String}
                 */
                comprobarTipo: function(value)
                     {
                      return isNaN(value) ? '/item' : '/itemNum';
                      //return ({}).toString.call(param).match(/\s([a-z|A-Z]+)/)[1].toLowerCase();
                      //console.log("Comprobar tipo: " + comprobarTipo(1));
                    }
                
            };

    return serviceBD;

});
