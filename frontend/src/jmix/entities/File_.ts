export class File {
  static NAME = "File_";
  id?: string;
  csv?: any | null;
}
export type FileViewName =
  | "_base"
  | "_instance_name"
  | "_local"
  | "file-fetch-plan";
export type FileView<V extends FileViewName> = V extends "_base"
  ? Pick<File, "id" | "csv">
  : V extends "_local"
  ? Pick<File, "id" | "csv">
  : V extends "file-fetch-plan"
  ? Pick<File, "id" | "csv">
  : never;
