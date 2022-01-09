import { registerModules } from "./module-registerer";
import NewsDataModule from "./news-data";
import Navigator from "./navigator";

const modules = {
  newsData: NewsDataModule,
  navigator: Navigator,
};

// eslint-disable-next-line
export default () => {
  registerModules(modules);
};
