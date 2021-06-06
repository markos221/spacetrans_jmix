import { Waybill } from "./Waybill";
export class WaybillItem1 {
  static NAME = "WaybillItem1";
  id?: string;
  length?: any | null;
  width?: any | null;
  height?: any | null;
  number?: number | null;
  name?: string | null;
  weight?: any | null;
  waybill?: Waybill | null;
  charge?: any | null;
}
export type WaybillItem1ViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "waybillItem1-fetch-plan";
export type WaybillItem1View<V extends WaybillItem1ViewName> = V extends "_base"
  ? Pick<
      WaybillItem1,
      | "id"
      | "name"
      | "length"
      | "width"
      | "height"
      | "number"
      | "weight"
      | "charge"
    >
  : V extends "_instance_name"
  ? Pick<WaybillItem1, "id" | "name">
  : V extends "_local"
  ? Pick<
      WaybillItem1,
      | "id"
      | "length"
      | "width"
      | "height"
      | "number"
      | "name"
      | "weight"
      | "charge"
    >
  : V extends "waybillItem1-fetch-plan"
  ? Pick<
      WaybillItem1,
      | "id"
      | "name"
      | "length"
      | "width"
      | "height"
      | "number"
      | "weight"
      | "charge"
    >
  : never;
