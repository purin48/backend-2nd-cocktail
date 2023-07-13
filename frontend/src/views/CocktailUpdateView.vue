<template>
  <div className="container mx-auto font-mono h-auto text-center">
    <h1 className="text-5xl text-pink-500/70 font-bold mt-32">칵테일 수정</h1>
    <form
      className="bg-white shadow-md px-8 pt-6 pb-8 mb-5 mt-5 rounded-xl"
      v-on:submit.prevent="submitForm"
    >
      <h3 className="text-3xl text-gray-500/70 block font-bold mb-5">
        당신이 사랑하는 칵테일을 수정해 주세요
      </h3>
      <div id="file_input">
        <!-- <input type="file" accept="image/*" /><br> -->
      </div>
      <span className="text-base text-black-500/100 block font-bold mb-5">
        이름 :
        <input
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="cName"
          type="text"
          placeholder="칵테일 이름"
          v-model="insertData.name"
        /><br />
      </span>

      <span className="text-base text-black-500/100 block font-bold mb-5">
        설명 :
        <input
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="cDesc"
          type="text"
          placeholder="술에 대해 설명해주세요 :)"
          v-model="insertData.description"
        /><br />
      </span>

      <span className="text-base text-black-500/100 block font-bold mb-5">
        도수 :
        <input
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="cAl"
          type="text"
          placeholder="도수는 몇 도?"
          v-model="insertData.alchol"
        /><br />
      </span>

      <span className="text-base text-black-500/100 block font-bold mb-5">
        타입 :
        {{ insertData.cocktailTypeId }}
        <!-- <input id="cType" type="text" v-model ="insertData.cocktailTypeId"> -->
        <!-- <select id="cType" v-model ="cType">
                <option v-bind:class = "cocktailType" v-for="(item, index) in listData" :key="index" :value="item.id">
                  {{ item.name }}
                </option>
              </select> -->
        <br />
      </span>

      <button
        className="font-mono bg-pink-500 hover:bg-pink-700 text-white font-bold py-2 px-4 rounded-full"
        type="submit"
      >
        수정
      </button>
    </form>
  </div>
</template>

<script setup>
import axios from 'axios'
import { watchEffect, ref, computed } from 'vue'

const listData = ref([])
let pathUrl

// GET
const insertData = computed(() => {
  return {
    name: listData.value[0].name,
    description: listData.value[0].description,
    alchol: listData.value[0].alchol,
    cocktailTypeId: listData.value[0].cocktailType.name
  }
})

// POST
const formData = computed(() => {
  return {
    name: insertData.value.name,
    description: insertData.value.description,
    alchol: insertData.value.alchol,
    cocktailTypeId: insertData.value.cocktailTypeId
  }
})

watchEffect(() => {
  pathUrl = window.location.pathname

  axios.get(`/cocktail${pathUrl}`).then((res) => {
    listData.value.push(res.data)
  })
})

const submitForm = () => {
  axios.post(`/cocktail${pathUrl}`, formData.value).then((res) => {
    console.log(res.data)
    alert('수정되었습니다!!!!!')
    window.location.href = '/list'
  })
}
</script>

<style scoped></style>
