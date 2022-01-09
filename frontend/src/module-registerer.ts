import router from "./router";
import store from "./store";

function registerModule(name: string, module: any) {
  if (module.store) {
    store.registerModule(name, module.store);
  }
  if (module.router) {
    module.router(router);
  }
}

export const registerModules = (modules: any): any => {
  Object.keys(modules).forEach((key: string) => {
    const module = modules[key];
    registerModule(key, module);
  });
};
