package com.prueba.zabudbackend.repository;

import com.prueba.zabudbackend.domain.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
    @Modifying
    @Query( value = "DELETE FROM detalle_factura WHERE id_factura = :idFactura", nativeQuery = true)
    void deleteByIdFactura(@Param("idFactura") Long idFactura);
    @Query(value = "SELECT * FROM detalle_factura WHERE id_factura = :idFactura", nativeQuery = true)
    List<DetalleFactura> findByIdFactura(@Param("idFactura") Long idFactura);
}
