package com.prueba.zabudbackend.service;

import com.prueba.zabudbackend.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService{
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
