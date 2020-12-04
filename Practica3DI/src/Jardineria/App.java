package Jardineria;

import java.util.Calendar;

import JardineriaTest.cliente;
import JardineriaTest.pedido;
import Dao.Dao;
import Dao.clienteDao;
import Dao.pedidosDao;
import Builder.BuilderCliente;
import Builder.BuilderPedido;

public class App {

    private static Dao<cliente> clientesDao;
    private static Dao<pedido> pedidosDao;

    public static void main(String[] args) {
        clientesDao = new clienteDao();
        pedidosDao = new pedidosDao(clientesDao);

        try {
            clientesDao.save(new BuilderCliente(66, "Dario", "Zaragoza", 111111111, 11.11, "1111j").Buildeo());
        } catch (Exception e) {
            System.out.println("Error: el cliente ya ha sido introducido \n" + clientesDao);

        }

        try {
            Calendar llegada = Calendar.getInstance();
            llegada.add(Calendar.DAY_OF_MONTH, 40);

            pedidosDao.save(
                    new BuilderPedido(1, 12, Calendar.getInstance(), llegada, "estado", "comentarios").Buildeo());
        } catch (Exception e) {
            System.out.println("Error: el pedido ya ha sido introducido, intentalo de nuevo ");
            

        }

    }

}
