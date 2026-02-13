import { Modelo } from "./modelo";

export interface Coche {
  id?: number;
  marca: string;
  anoFabricacion: string;
  color: string;
  precio: number;
  modelos?: Modelo[];
}