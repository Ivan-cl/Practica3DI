package Dao;

import java.util.*;

import JardineriaTest.cliente;
import JardineriaTest.pedido;

public class pedidosDao implements Dao<pedido> {

    private List<pedido> pedidos = new ArrayList<>();

    public pedidosDao() {

        pedidos.add(new pedido(1111, 1111 - 2, new Calendar.Builder().setDate(2020, Calendar.NOVEMBER, 2).build(),
                new Calendar.Builder().setDate(2021, Calendar.NOVEMBER, 2).build(), "Va en camino", "Cuando llegara?"));
    }

    public pedidosDao(Dao<cliente> clientesDao) {
    }

    @Override
    public Optional<pedido> get(long id) {

        return Optional.ofNullable(pedidos.get((int) id));
    }

    @Override
    public List<pedido> getAll() {

        return pedidos;
    }

    @Override
    public void save(pedido t) throws Exception {
        for (pedido pedido : pedidos) {
            if (pedido.getCodigo_pedido() == t.getCodigo_pedido()) { //
                if (pedido.getCodigo_pedido_cliente() == t.getCodigo_pedido_cliente()) {

                    throw new Exception("Pedidos duplicado");
                }
                System.out.println("Pedido ya existente");

                return;
            }

        }
        pedidos.add(t);

    }

    @Override
    public void update(pedido t, String[] params) {
        Calendar mifecha = Calendar.getInstance();
        mifecha.add(Calendar.DAY_OF_MONTH, 40);

        t.setCodigo_pedido(112);
        t.setCodigo_pedido_cliente(111);
        t.setComentarios("Vamos en camino");
        t.setEstado("En espera");
        t.setFecha_entrega(Calendar.getInstance());
        t.setFecha_pedido(mifecha);

    }

    @Override
    public void delete(pedido t) {
        pedidos.remove(t);

    }

}