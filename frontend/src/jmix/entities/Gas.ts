export class Gas {
  static NAME = "Gas";
  id?: string;
  name?: string | null;
}
export type GasViewName = "_base" | "_instance_name" | "_local";
export type GasView<V extends GasViewName> = V extends "_base"
  ? Pick<Gas, "id" | "name">
  : V extends "_instance_name"
  ? Pick<Gas, "id" | "name">
  : V extends "_local"
  ? Pick<Gas, "id" | "name">
  : never;
