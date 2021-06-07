import { Waybill } from "./Waybill";
export class WaybillItem {
  static NAME = "WaybillItem";
  id?: string;
  number?: number | null;
  name?: string | null;
  weight?: any | null;
  dim?: any | null;
  waybill?: Waybill | null;
  charge?: any | null;
}
export type WaybillItemViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "waybillItem-fetch-plan"
  | "waybillItem-fetch-plan_1"
  | "waybillItem-fetch-plan_2"
  | "waybillItem-fetch-plan_3"
  | "waybillItem-fetch-plan_4";
export type WaybillItemView<V extends WaybillItemViewName> = V extends "_base"
  ? Pick<WaybillItem, "id" | "name" | "number" | "weight" | "charge">
  : V extends "_instance_name"
  ? Pick<WaybillItem, "id" | "name">
  : V extends "_local"
  ? Pick<WaybillItem, "id" | "number" | "name" | "weight" | "charge">
  : V extends "waybillItem-fetch-plan"
  ? Pick<WaybillItem, "id" | "name" | "number" | "weight" | "dim" | "charge">
  : V extends "waybillItem-fetch-plan_1"
  ? Pick<WaybillItem, "id" | "name" | "number" | "weight" | "charge" | "dim">
  : V extends "waybillItem-fetch-plan_2"
  ? Pick<WaybillItem, "id" | "name" | "number" | "weight" | "dim" | "charge">
  : V extends "waybillItem-fetch-plan_3"
  ? Pick<WaybillItem, "id" | "number" | "name" | "weight" | "charge" | "dim">
  : V extends "waybillItem-fetch-plan_4"
  ? Pick<WaybillItem, "id" | "name" | "weight" | "dim" | "charge">
  : never;
