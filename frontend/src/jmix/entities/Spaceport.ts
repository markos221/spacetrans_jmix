import { Planet } from "./Planet";
import { Moon } from "./Moon";
import { Carrier } from "./Carrier";
export class Spaceport {
  static NAME = "Spaceport";
  id?: string;
  name?: string | null;
  planet?: Planet | null;
  moon?: Moon | null;
  coordinates?: any | null;
  isDefault?: boolean | null;
  carriers?: Carrier[] | null;
}
export type SpaceportViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "spaceport-fetch-plan";
export type SpaceportView<V extends SpaceportViewName> = V extends "_base"
  ? Pick<Spaceport, "id" | "name" | "isDefault">
  : V extends "_instance_name"
  ? Pick<Spaceport, "id" | "name">
  : V extends "_local"
  ? Pick<Spaceport, "id" | "name" | "isDefault">
  : V extends "spaceport-fetch-plan"
  ? Pick<
      Spaceport,
      "id" | "name" | "isDefault" | "planet" | "moon" | "carriers"
    >
  : never;
