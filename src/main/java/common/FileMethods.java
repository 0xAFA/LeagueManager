package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Métodos auxiliares para pasar los repositorios de memoria a archivo y viceversa.
 * @param <T> Tipo.
 */
public class FileMethods<T> {

    /**
     * Guarda el repositorio en un archivo.
     * @param repo Repositorio.
     * @param path Ruta del archivo.
     */
    public void writeMapToFile(HashMap<String, T> repo, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(repo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga un repositorio almacenado en archivo en un HashMap.
     * @param path Ruta del archivo.
     * @return HashMap
     */
    //En esta situación es obligatorio hacer un unchecked cast, por lo que silencio la advertencia
    @SuppressWarnings("unchecked")
    public HashMap<String, T> readMapFromFile(String path) {
        HashMap<String, T> rHashmap = null;
        try {
            FileInputStream fos = new FileInputStream(path);
            ObjectInputStream oos = new ObjectInputStream(fos);
            rHashmap = (HashMap<String,T>) oos.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rHashmap;
    }
}
