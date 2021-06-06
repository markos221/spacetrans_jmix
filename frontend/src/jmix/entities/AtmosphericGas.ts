import { Gas } from "./Gas";
import { Atmosphere } from "./Atmosphere";
export class AtmosphericGas {
  static NAME = "AtmosphericGas";
  id?: string;
  gas?: Gas | null;
  volume?: any | null;
  atmosphere?: Atmosphere | null;
}
export type AtmosphericGasViewName = "_base" | "_instance_name" | "_local";
export type AtmosphericGasView<
  V extends AtmosphericGasViewName
> = V extends "_base"
  ? Pick<AtmosphericGas, "id" | "volume">
  : V extends "_local"
  ? Pick<AtmosphericGas, "id" | "volume">
  : never;
