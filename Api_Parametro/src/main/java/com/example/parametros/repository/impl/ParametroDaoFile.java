package com.example.parametros.repository.impl;


import com.example.parametros.model.ParametroSaab;
import com.example.parametros.repository.IDao;
import org.apache.log4j.Logger;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ParametroDaoFile implements IDao<ParametroSaab> {


    private static Logger logger= Logger.getLogger(ParametroDaoFile.class);
    static RandomAccessFile fichero = null;



  @Override
   public ParametroSaab guardar(ParametroSaab parametroSaab) {

     	 int id=(parametroSaab.getId()-1)*2;
         int valor=parametroSaab.getValor();

		try {
			//se abre el fichero para lectura y escritura
			fichero = new RandomAccessFile("E:/Trabajo_2021/I+D/Desarrollo/ARCHIVOS/datos.dat", "rw");
			fichero.seek(id); //nos situamos en la posición id para guardar el dato del archivo
			fichero.write(valor);       //se escribe en el archivo
		} catch (FileNotFoundException ex) {
			//System.out.println(ex.getMessage());
            logger.info("error1" + ex.getMessage());
		} catch (IOException ex) {
			//System.out.println(ex.getMessage());
            logger.info("error2" + ex.getMessage());
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
			} catch (IOException e) {
                logger.info("error3" + e.getMessage());
				//System.out.println(e.getMessage());
			}
		}
      return parametroSaab;
  }

///////////////////listo///////////////////
    @Override
    public ParametroSaab buscar(Integer id) {
        ParametroSaab p= new ParametroSaab();
        int numero=(id-1)*2;
        int n = 0;
             try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile("E:/Trabajo_2021/I+D/Desarrollo/ARCHIVOS/datos.dat", "rw");
            fichero.seek(numero); //nos situamos en posición id para obtener el valor.
            p.setId(id);
            p.setValor( fichero.read());

        } catch (FileNotFoundException ex) {
                 logger.info("error1" + ex.getMessage());
        } catch (IOException ex) {
                 logger.info("error2" + ex.getMessage());
            //System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                logger.info("error3" + e.getMessage());
                //System.out.println(e.getMessage());
            }
        }
        return p;
    }


    public static void mostrarFichero() {
        int n;
        try {
            fichero.seek(1); //nos situamos al principio
            n = fichero.read();
            System.out.println(n);
			/*while (true) {
                n = fichero.readInt();  //se lee  un entero del fichero
                System.out.println(n);  //se muestra en pantalla
            }*/
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    /*
    @Override
    public List<Parametro> buscarTodos() {
        return null;
    }
   }*/
}
