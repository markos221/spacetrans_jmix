import { WaybillManagement } from "./app/screen/WaybillManagement";
import { WaybillItemManagement } from "./app/wil/WaybillItemManagement";
import { SpaceportManagement } from "./app/SpaceportManagement";
import { PlanetManagement } from "./app/PlanetManagement";
import { IndividualManagement } from "./app/IndividualManagement";
import { CompanyManagement } from "./app/screen/CompanyManagement";
import { CarrierManagement } from "./app/screen/CarrierManagement";
import { MoonManagement } from "./app/screen/MoonManagement";
import { UserManagement } from "./app/screen/UserManagement";
import { getMenuItems } from "@haulmont/jmix-react-core";

export const menuItems = getMenuItems();

// Code below demonstrates how we can create SubMenu section
// Remove '/*' '*/' comments and restart app to get this block in menu

/*
// This is RouteItem object that we want to see in User Settings sub menu
const backToHomeRouteItem = {
  pathPattern: "/backToHome",
  menuLink: "/",
  component: null,
  caption: "home"
};
// SubMenu object
const userSettingsSubMenu = {
  caption: 'UserSettings', // add router.UserSettings key to src/i18n/en.json for valid caption
  items: [backToHomeRouteItem]};
// Add sub menu item to menu config
menuItems.push(userSettingsSubMenu);
*/

menuItems.push({
  pathPattern: "/userManagement/:entityId?",
  menuLink: "/userManagement",
  component: UserManagement,
  caption: "UserManagement"
});

menuItems.push({
  pathPattern: "/spaceportManagement/:entityId?",
  menuLink: "/spaceportManagement",
  component: SpaceportManagement,
  caption: "SpaceportManagement"
});

menuItems.push({
  pathPattern: "/moonManagement/:entityId?",
  menuLink: "/moonManagement",
  component: MoonManagement,
  caption: "MoonManagement"
});

menuItems.push({
  pathPattern: "/carrierManagement/:entityId?",
  menuLink: "/carrierManagement",
  component: CarrierManagement,
  caption: "CarrierManagement"
});

menuItems.push({
  pathPattern: "/companyManagement/:entityId?",
  menuLink: "/companyManagement",
  component: CompanyManagement,
  caption: "CompanyManagement"
});

menuItems.push({
  pathPattern: "/individualManagement/:entityId?",
  menuLink: "/individualManagement",
  component: IndividualManagement,
  caption: "IndividualManagement"
});

menuItems.push({
  pathPattern: "/planetManagement/:entityId?",
  menuLink: "/planetManagement",
  component: PlanetManagement,
  caption: "PlanetManagement"
});

menuItems.push({
  pathPattern: "/waybillItemManagement/:entityId?",
  menuLink: "/waybillItemManagement",
  component: WaybillItemManagement,
  caption: "WaybillItemManagement"
});

menuItems.push({
  pathPattern: "/waybillManagement/:entityId?",
  menuLink: "/waybillManagement",
  component: WaybillManagement,
  caption: "WaybillManagement"
});
