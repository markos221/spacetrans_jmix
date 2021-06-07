import { AstronomicalBody } from "./AstronomicalBody";
import { Planet } from "./Planet";
import { Atmosphere } from "./Atmosphere";
export class Moon extends AstronomicalBody {
  static NAME = "Moon";
  id?: string;
  planet?: Planet | null;
  atmosphere?: Atmosphere | null;
}
export type MoonViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "moon-fetch-plan";
export type MoonView<V extends MoonViewName> = V extends "_base"
  ? Pick<Moon, "id" | "name" | "mass" | "picture">
  : V extends "_instance_name"
  ? Pick<Moon, "id" | "name">
  : V extends "_local"
  ? Pick<Moon, "id" | "name" | "mass" | "picture">
  : V extends "moon-fetch-plan"
  ? Pick<Moon, "id" | "name" | "planet" | "mass" | "picture">
  : never;
