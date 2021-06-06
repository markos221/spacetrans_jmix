import { AtmosphericGas } from "./AtmosphericGas";
export class Atmosphere {
  static NAME = "Atmosphere";
  id?: string;
  description?: string | null;
  pressure?: any | null;
  gases?: AtmosphericGas[] | null;
}
export type AtmosphereViewName = "_base" | "_instance_name" | "_local";
export type AtmosphereView<V extends AtmosphereViewName> = V extends "_base"
  ? Pick<Atmosphere, "id" | "description" | "pressure">
  : V extends "_instance_name"
  ? Pick<Atmosphere, "id" | "description">
  : V extends "_local"
  ? Pick<Atmosphere, "id" | "description" | "pressure">
  : never;
