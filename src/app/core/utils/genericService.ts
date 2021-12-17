import { Cliente } from "src/app/pages/models/cliente";
import { FacturaForm } from "src/app/pages/models/facturaPost";
import { Producto } from "src/app/pages/models/producto";

export interface GenericService{
    save(entity : Cliente | Producto | FacturaForm);
    getAll();
    getById(id : number);
    deleteById(id : number);
}