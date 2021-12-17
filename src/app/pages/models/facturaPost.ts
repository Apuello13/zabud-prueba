export interface FacturaForm{
    id: number,
    idCliente: number,
    idCajero: number,
    productos: number[],
    metodoPago: string
}