<template>
  <div class="bg-blue-50 w-full h-screen p-10">
    <div
      v-for="app in apps"
      :key="app.name"
      class="w-64 h-64 bg-white shadow-xl rounded-lg p-4"
    >
      <div
        class="
          text-md
          font-semibold font-sans
          uppercase
          flex
          justify-center
          bg-indigo-700
          rounded-full
          text-white
          p-2
          shadow-lg
        "
      >
        {{ app.name }}
      </div>
      <div class="text-lg font-mono text-justify mt-4">
        {{ app.description }}
      </div>
      <button
        class="
          w-32
          h-10
          text-white
          bg-green-500
          rounded-lg
          uppercase
          mt-4
          hover:bg-green-600 hover:translate-y-0.5 hover:shadow-lg
          transform
        "
        @click="gotoApp(app.url)"
      >
        Open App
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import INavigationOptionModel from "./INavigatorOptionModel";
import router from "../router";

export default {
  name: "Navigator",
  data() {
    return {
      apps: [
        {
          name: "News Data Storage",
          description:
            "Scraper news data and store it on this webpage using selenium",
          url: "/news-data/news-dashboard",
        },
      ] as Array<INavigationOptionModel>,
    };
  },
  methods: {
    gotoApp(url: string) {
      router.push(url);
    },
  },
};
</script>