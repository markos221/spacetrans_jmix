import { Spaceport } from "./Spaceport";
export class Carrier {
  static NAME = "Carrier";
  id?: string;
  name?: string | null;
  ports?: Spaceport[] | null;
}
export type CarrierViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "carrier-fetch-plan";
export type CarrierView<V extends CarrierViewName> = V extends "_base"
  ? Pick<Carrier, "id" | "name">
  : V extends "_instance_name"
  ? Pick<Carrier, "id" | "name">
  : V extends "_local"
  ? Pick<Carrier, "id" | "name">
  : V extends "carrier-fetch-plan"
  ? Pick<Carrier, "id" | "name" | "ports">
  : never;
