import { CustumerGrade } from "../enums/enums";
export class Discounts {
  static NAME = "Discounts";
  id?: string;
  grade?: CustumerGrade | null;
  value?: any | null;
}
export type DiscountsViewName = "_base" | "_instance_name" | "_local";
export type DiscountsView<V extends DiscountsViewName> = V extends "_base"
  ? Pick<Discounts, "id" | "grade" | "value">
  : V extends "_local"
  ? Pick<Discounts, "id" | "grade" | "value">
  : never;
