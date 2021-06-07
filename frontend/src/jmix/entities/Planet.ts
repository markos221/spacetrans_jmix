import { AstronomicalBody } from "./AstronomicalBody";
import { Atmosphere } from "./Atmosphere";
export class Planet extends AstronomicalBody {
  static NAME = "Planet";
  id?: string;
  semiMajorAxis?: any | null;
  orbitalPeriod?: any | null;
  rotationPeriod?: any | null;
  atmosphere?: Atmosphere | null;
  rings?: boolean | null;
}
export type PlanetViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "planet-fetch-plan";
export type PlanetView<V extends PlanetViewName> = V extends "_base"
  ? Pick<
      Planet,
      | "id"
      | "name"
      | "semiMajorAxis"
      | "orbitalPeriod"
      | "rotationPeriod"
      | "rings"
      | "mass"
      | "picture"
    >
  : V extends "_instance_name"
  ? Pick<Planet, "id" | "name">
  : V extends "_local"
  ? Pick<
      Planet,
      | "id"
      | "semiMajorAxis"
      | "orbitalPeriod"
      | "rotationPeriod"
      | "rings"
      | "name"
      | "mass"
      | "picture"
    >
  : V extends "planet-fetch-plan"
  ? Pick<
      Planet,
      | "id"
      | "name"
      | "semiMajorAxis"
      | "orbitalPeriod"
      | "rotationPeriod"
      | "rings"
      | "mass"
      | "picture"
    >
  : never;
