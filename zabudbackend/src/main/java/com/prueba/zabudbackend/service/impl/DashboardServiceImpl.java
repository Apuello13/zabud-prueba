package com.prueba.zabudbackend.service.impl;

import com.prueba.zabudbackend.dto.DashboardDTO;
import com.prueba.zabudbackend.service.ClienteService;
import com.prueba.zabudbackend.service.DashboardService;
import com.prueba.zabudbackend.service.FacturaService;
import com.prueba.zabudbackend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private FacturaService facturaService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ClienteService clienteService;

    @Override
    public DashboardDTO getDashboard() {
        DashboardDTO dashboardDTO = new DashboardDTO();
        try{
            dashboardDTO.setFacturas(facturaService.findAll().size());
            dashboardDTO.setClientes(clienteService.findAll().size());
            dashboardDTO.setProductos(productoService.findAll().size());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return dashboardDTO;
    }
}
