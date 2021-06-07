import { User } from "./st_User";
import { Customer } from "./Customer";
import { Spaceport } from "./Spaceport";
import { Carrier } from "./Carrier";
import { WaybillItem } from "./WaybillItem";
export class Waybill {
  static NAME = "Waybill";
  id?: string;
  reference?: string | null;
  creator?: User | null;
  shipper?: Customer | null;
  consignee?: Customer | null;
  departurePort?: Spaceport | null;
  destinationPort?: Spaceport | null;
  carrier?: Carrier | null;
  items?: WaybillItem[] | null;
  totalWeight?: any | null;
  totalCharge?: any | null;
}
export type WaybillViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "waybill-fetch-plan";
export type WaybillView<V extends WaybillViewName> = V extends "_base"
  ? Pick<Waybill, "id" | "reference" | "totalWeight" | "totalCharge">
  : V extends "_local"
  ? Pick<Waybill, "id" | "reference" | "totalWeight" | "totalCharge">
  : V extends "waybill-fetch-plan"
  ? Pick<
      Waybill,
      | "id"
      | "reference"
      | "totalWeight"
      | "totalCharge"
      | "creator"
      | "shipper"
      | "consignee"
      | "departurePort"
      | "destinationPort"
      | "carrier"
      | "items"
    >
  : never;
