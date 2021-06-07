import { CustumerGrade } from "../enums/enums";
export class Customer {
  static NAME = "Customer";
  id?: string;
  name?: string | null;
  email?: string | null;
  grade?: CustumerGrade | null;
}
export type CustomerViewName = "_base" | "_instance_name" | "_local";
export type CustomerView<V extends CustomerViewName> = V extends "_base"
  ? Pick<Customer, "id" | "name" | "email" | "grade">
  : V extends "_instance_name"
  ? Pick<Customer, "id" | "name">
  : V extends "_local"
  ? Pick<Customer, "id" | "name" | "email" | "grade">
  : never;
