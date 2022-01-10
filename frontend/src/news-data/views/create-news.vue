<template>
  <div class="w-full h-screen bg-blue-50 flex justify-center items-center">
    <div class="w-4/12 p-4 bg-white shadow-lg rounded-lg">
      <div class="uppercase text-2xl font-extrabold w-full flex justify-center">
        Create new news
      </div>
      <div class="h-0.5 bg-gray-300 mt-4"></div>
      <div class="flex flex-col mt-10">
        <label for="newsUrl" class="font-mono">News Url</label>
        <input
          class="
            p-1
            rounded-sm
            border-b-2 border-gray-200
            focus:outline-none focus:border-green-400
          "
          type="text"
          placeholder="http://example.com/news/123/"
          v-model="newsData.newsUrl"
          id="newsUrl"
        />
      </div>
      <div class="flex flex-col mt-2">
        <label for="newsTitle" class="font-mono">News Title</label>
        <input
          class="
            p-1
            rounded-sm
            border-b-2 border-gray-200
            focus:outline-none focus:border-green-400
          "
          type="text"
          placeholder="some news happened"
          v-model="newsData.newsTitle"
          id="newsTitle"
        />
      </div>
      <div class="flex flex-col mt-2">
        <label for="newsContent">News Content</label>
        <textarea
          class="
            p-1
            rounded-sm
            border-b-2 border-gray-200
            focus:outline-none focus:border-green-400
          "
          style="min-height: 100px"
          type="text"
          placeholder="News Content .............."
          v-model="newsData.newsContent"
          id="newsContent"
        />
      </div>
      <div class="mt-4 w-full flex justify-end gap-2">
        <button
          class="rounded-full uppercase bg-gray-400 px-4 text-white shadow-lg"
          @click="goBackToNewsDashboard"
        >
          Go Back
        </button>
        <button
          class="
            shadow-lg
            uppercase
            bg-green-500
            rounded-full
            h-8
            text-white
            w-24
            px-2
            font-extrabold
            focus:outline-none
            focus:ring-2
            focus:bg-green-400
            focus:ring-gray-400
          "
          @click="submitNewsData"
        >
          Submit
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import router from "../../router";
import apiHelper from "../api-helper";
export default {
  data() {
    return {
      newsData: {
        newsUrl: "",
        newsTitle: "",
        newsContent: "",
      },
    };
  },
  methods: {
    submitNewsData() {
      apiHelper
        .createNews(
          this.newsData.newsTitle,
          this.newsData.newsUrl,
          this.newsData.newsContent
        )
        .then((response) => response.json())
        .then((data) => {
          console.log("Created news: ", data);
        })
        .catch((e) => e);
      this.newsData.newsUrl = "";
      this.newsData.newsTitle = "";
      this.newsData.newsContent = "";
    },
    goBackToNewsDashboard() {
      router.push("/news-data/news-dashboard");
    },
  },
};
</script>

<style>
</style>