package com.springboot.app.utils;

public class UtilStr {



	  /**
	   * METODO PARA LIMPIAR UNA CADENA DE ESPACIOS EN BLANCOS, SALTOS DE CARROS Y
	   * TABULADORES.
	   *
	   * @param str Cadena a limpiar.
	   *
	   * @return Cadena formateada.
	   */
	  public static String removeSpaces(String str)
	  {
	    return str.replaceAll("\\s+", " ").trim();
	  }

	}
	

