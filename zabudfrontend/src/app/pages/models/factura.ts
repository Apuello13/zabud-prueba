import { Producto } from "./producto";

export interface Factura{
    id: number,
    cliente: string,
    numeroFactura: string,
    productos: Producto[]
    created: string,
    metodoPago: string
}