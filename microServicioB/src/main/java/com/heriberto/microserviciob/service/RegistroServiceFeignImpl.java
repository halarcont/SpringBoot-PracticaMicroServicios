package com.heriberto.microserviciob.service;

import com.heriberto.microserviciob.clienteFeign.FrutaClienteFeign;
import com.heriberto.microserviciob.models.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class RegistroServiceFeignImpl implements RegistroServiceFeign {

    @Autowired
    private FrutaClienteFeign clienteFeign;

    @Override
    public List<Registro> findAll() {
        return clienteFeign.listar().stream().map(p -> new Registro(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Registro findById(Long id, Integer cantidad) {
        return new Registro(clienteFeign.detalle(id), cantidad);
    }
}
