export class Dimensions {
  static NAME = "Dimensions";
  length?: any | null;
  width?: any | null;
  height?: any | null;
}
export type DimensionsViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "dimensions-fetch-plan";
export type DimensionsView<V extends DimensionsViewName> = V extends "_base"
  ? Pick<Dimensions, "length" | "width" | "height">
  : V extends "_local"
  ? Pick<Dimensions, "length" | "width" | "height">
  : V extends "dimensions-fetch-plan"
  ? Pick<Dimensions, "length" | "width" | "height">
  : never;
