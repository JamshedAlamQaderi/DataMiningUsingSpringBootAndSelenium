<template>
  <div
    class="w-72 h-72 bg-white rounded-md p-2 hover:-translate-y-1 hover:scale-105 transform cursor-pointer"
  >
    <div class="text-md font-semibold">{{ newsData.newsTitle }}</div>
    <a class="text-xs font-thin font-mono hover:text-green-700" href="#">
      {{ newsData.newsUrl }}
    </a>
    <div class="text-md font-semibold mt-2 h-36 overflow-hidden">
      News Content: <br />
      <span class="font-sm font-thin">
        {{ newsData.newsContent }}
      </span>
    </div>
    <div class="w-full h-12 mt-4 flex justify-end">
      <button
        class="bg-green-700 rounded-lg w-24 h-10 text-white shadow-lg"
        @click="onReadMoreClicked"
      >
        Read More
      </button>
    </div>
  </div>
</template>

<script>
import router from "../../router";
export default {
  props: {
    newsData: { newsId: -1, newsUrl: "", newsTitle: "", newsContent: "" },
  },
  methods: {
    onReadMoreClicked() {
      router.push("/news-data/read-news/" + this.newsData.newsId);
    },
  },
};
</script>

<style>
</style>