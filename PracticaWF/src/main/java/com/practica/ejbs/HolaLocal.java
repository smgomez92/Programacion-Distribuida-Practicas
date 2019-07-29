package com.practica.ejbs;

import javax.ejb.Local;

@Local
public interface HolaLocal {
public String hola(String nombre);
}
