export class AstronomicalBody {
  static NAME = "AstronomicalBody";
  name?: string | null;
  mass?: any | null;
  picture?: any | null;
}
export type AstronomicalBodyViewName = "_base" | "_instance_name" | "_local";
export type AstronomicalBodyView<
  V extends AstronomicalBodyViewName
> = V extends "_base"
  ? Pick<AstronomicalBody, "name" | "mass" | "picture">
  : V extends "_instance_name"
  ? Pick<AstronomicalBody, "name">
  : V extends "_local"
  ? Pick<AstronomicalBody, "name" | "mass" | "picture">
  : never;
