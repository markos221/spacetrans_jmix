export class Coordinates {
  static NAME = "Coordinates";
  latitude?: any | null;
  longitude?: any | null;
}
export type CoordinatesViewName = "_base" | "_instance_name" | "_local";
export type CoordinatesView<V extends CoordinatesViewName> = V extends "_base"
  ? Pick<Coordinates, "latitude" | "longitude">
  : V extends "_local"
  ? Pick<Coordinates, "latitude" | "longitude">
  : never;
