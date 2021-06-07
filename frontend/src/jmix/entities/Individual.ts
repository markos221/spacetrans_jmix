import { Customer } from "./Customer";
export class Individual extends Customer {
  static NAME = "Individual";
  firstName?: string | null;
  lastName?: string | null;
}
export type IndividualViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "individual-fetch-plan";
export type IndividualView<V extends IndividualViewName> = V extends "_base"
  ? Pick<
      Individual,
      "id" | "firstName" | "lastName" | "name" | "email" | "grade"
    >
  : V extends "_instance_name"
  ? Pick<Individual, "id" | "firstName">
  : V extends "_local"
  ? Pick<
      Individual,
      "id" | "firstName" | "lastName" | "name" | "email" | "grade"
    >
  : V extends "individual-fetch-plan"
  ? Pick<
      Individual,
      "id" | "firstName" | "lastName" | "name" | "email" | "grade"
    >
  : never;
