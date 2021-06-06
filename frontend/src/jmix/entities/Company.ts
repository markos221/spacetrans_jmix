import { Customer } from "./Customer";
export class Company extends Customer {
  static NAME = "Company";
  registrationId?: string | null;
  companyType?: string | null;
}
export type CompanyViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "company-fetch-plan";
export type CompanyView<V extends CompanyViewName> = V extends "_base"
  ? Pick<
      Company,
      "id" | "name" | "registrationId" | "companyType" | "email" | "grade"
    >
  : V extends "_instance_name"
  ? Pick<Company, "id" | "name">
  : V extends "_local"
  ? Pick<
      Company,
      "id" | "registrationId" | "companyType" | "name" | "email" | "grade"
    >
  : V extends "company-fetch-plan"
  ? Pick<
      Company,
      "id" | "name" | "registrationId" | "companyType" | "email" | "grade"
    >
  : never;
